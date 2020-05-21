package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.controller.requestDto.OrderRequest.OrderRequest;
import com.Sales.SalesWeb.controller.requestDto.UserRequest.UserResponse;
import com.Sales.SalesWeb.model.*;
import com.Sales.SalesWeb.model.DTO.OrderDto;
import com.Sales.SalesWeb.model.dbEnums.OrderStatus;
import com.Sales.SalesWeb.repository.*;
import com.Sales.SalesWeb.service.utils.EmailsSendler;
import com.Sales.SalesWeb.service.utils.Mapper;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.Sales.SalesWeb.service.UserService.getHtmlContent;
import static com.Sales.SalesWeb.service.utils.Mapper.toOrderDto;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final OrderDeliveryRepository orderDeliveryRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final DeliveryRepository deliveryRepository;
    private final EmailsSendler emailsSendler = new EmailsSendler();


    public OrderService(OrderRepository orderRepository,
                        OrderProductRepository orderProductRepository,
                        OrderDeliveryRepository orderDeliveryRepository,
                        ProductRepository productRepository,
                        UserRepository userRepository,
                        DeliveryRepository deliveryRepository) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
        this.orderDeliveryRepository = orderDeliveryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.deliveryRepository = deliveryRepository;
    }

    public List<OrderDto> getAllOrderByUser(UserResponse user){
        List<OrderDto> orderDtos;
        try{
            List<Order> orders = orderRepository.findAllByUser_Email(user.getEmail());
            orderDtos = orders.size() == 0 ? new ArrayList<>():orders.stream()
                    .map(Mapper::toOrderDto)
                  .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return orderDtos;
    }


    public String createOrder(OrderRequest orderRequest, UserResponse userResponse) {
        Order order = new Order();
        try {
            UUID orderId = UUID.randomUUID();
            order.setOrderId(orderId);
            order.setIsPayment(orderRequest.getIsPayment());
            order.setPhone(orderRequest.getPhone());
            order.setEmail(orderRequest.getEmail());
            order.setFirstName(orderRequest.getFirstName());
            order.setLastName(orderRequest.getLastName());
            if (!userResponse.isNull()) {
                Optional<User> userOptional = userRepository.findByEmailOrPerson_PersonPhone(userResponse.getEmail(),
                        userResponse.getPersonPhone());
                if(!userOptional.isPresent()){
                    throw new ApiException("Find User error",
                            "Not find user in db",
                            ExceptionType.NoSuchObj);
                }
                User user = userOptional.get();
                order.setUser(user);
            }
            order.setPaymentType(orderRequest.getPaymentType());
            order.setOrderStatus(OrderStatus.creating);
            order.setCod(orderId.toString().substring(0, 8));

            orderRepository.save(order);

            OrderDelivery orderDelivery = new OrderDelivery();
            orderDelivery.setAddress(orderRequest.getAdress());
            orderDelivery.setDelivery(deliveryRepository.findById(orderRequest.getDeliveryId()).get());
            orderDelivery.setOrderDeliveryId(UUID.randomUUID());
            orderDelivery.setOrderDeliveryStatus(OrderStatus.not_delivered);
            orderDeliveryRepository.save(orderDelivery);

            order.setOrderDelivery(orderDelivery);
            orderRepository.save(order);

            orderRequest.getProductIds().forEach(product -> {
                Optional<Product> productOptional = productRepository.findById(product.getProductId());
                if (productOptional.isPresent()) {
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setOrder(order);
                    orderProduct.setOrderProductId(UUID.randomUUID());
                    orderProduct.setProduct(productOptional.get());
                    orderProduct.setCount(product.getProductCount());
                    orderProductRepository.save(orderProduct);
                } else {
                    throw new ApiException("Find product error",
                            "Not find product in db",
                            ExceptionType.NoSuchObj);
                }

            });
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        try {
            emailsSendler.sendEmail("!!Заказ принят в обработку модератором!!!",
//
                    String.format(getHtmlContent("Mail_order.html"),
                            order.getLastName() + ' ' + order.getFirstName(),order.getCod()),order.getEmail());
        } catch (MessagingException e) {
            throw new ApiException("EMAIL SERVICE ERROR", "Email service error, say admin",
                    ExceptionType.InternalServerError);
        }
        return order.getCod();
    }
}
