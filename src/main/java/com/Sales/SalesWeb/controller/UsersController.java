package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.controller.requestDto.OrderRequest.OrderRequest;
import com.Sales.SalesWeb.controller.requestDto.OrderRequest.OrderResponse;
import com.Sales.SalesWeb.controller.requestDto.UserRequest.*;
import com.Sales.SalesWeb.controller.requestDto.changeRequestType.RegisterCodRequest;
import com.Sales.SalesWeb.model.DTO.OrderDto;
import com.Sales.SalesWeb.service.OrderService;
import com.Sales.SalesWeb.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@ControllerAdvice
@SessionAttributes(types = UserResponse.class)
@RequestMapping(value = "user/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsersController {
    private final UserService userService;
    private final OrderService orderService;

    public UsersController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @PostMapping( value = "orders",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createOrder(@RequestBody OrderRequest orderRequest, UserResponse userResponse) {
        String cod = orderService.createOrder(orderRequest, userResponse);
        return new ResponseEntity<>(new OrderResponse(cod), HttpStatus.OK);
    }

    @GetMapping(value = "orders/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOrderByUser(UserResponse user) {
        if (user.isNull()) {
            throw new ApiException("log in to change your password",
                    "Need log in", ExceptionType.UserAlreadyLogged);
        }
        List<OrderDto> allOrderByUser = orderService.getAllOrderByUser(user);
        if (allOrderByUser.size() == 0) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        }
        return new ResponseEntity<>(allOrderByUser, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCurrentUser(UserResponse user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @Deprecated
    @PostMapping(value = "register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registration(@RequestBody UserRegistrationRequest request, UserResponse user, HttpSession httpSession) {
        if (!user.isNull()) {
            throw new ApiException("User has already logged in",
                    "User was already logged in earlier", ExceptionType.UserAlreadyLogged);
        }
        RegisterCodRequest registerCodRequest = new RegisterCodRequest();
        registerCodRequest.setCod(request.getCod());
        if ( userService.vlidationRegisterRequest(registerCodRequest,
                (RegisterCodRequest) httpSession.getAttribute("registerCodRequest"))) {
            userService.register(request, user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @Deprecated
    @PostMapping(value = "logIn", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity logIn(@RequestBody UserRequest userRequest, UserResponse user) {
        if (!user.isNull()) {
            throw new ApiException("User has already logged in",
                    "User was already logged in earlier", ExceptionType.UserAlreadyLogged);
        }
        UserResponse currentUser = userService.logIn(userRequest, user);
        if (currentUser.isNull()) {
            throw new InternalDataBaseServerExeption();
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @Deprecated
    @GetMapping(value = "logOut", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity logOut(UserResponse user) {
        if (user.isNull()) {
            return new ResponseEntity<>("You mast log in", HttpStatus.CONFLICT);
        }
        UserResponse currentUser = userService.logOut(user);
        if (currentUser.isNull()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping(value = "change/request", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createChangeRequest(UserResponse user) {
        if (user.isNull()) {
            throw new ApiException("log in to change your password",
                    "Need log in", ExceptionType.UserAlreadyLogged);
        }
        userService.createChangeRequest(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "change/password", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity changePassword(@RequestBody PasswordChangeRequest passwordChangeRequest, UserResponse user) {
        if (user.isNull()) {
            throw new ApiException("log in to change your password",
                    "Need log in", ExceptionType.UserAlreadyLogged);
        }
        userService.changePassword(user, passwordChangeRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "change/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity changeData(@RequestBody UserDataChangeRequest dataChangeRequest, UserResponse user) {
        if (user.isNull()) {
            throw new ApiException("log in to change your password",
                    "Need log in", ExceptionType.UserAlreadyLogged);
        }
        userService.changeUserData(user, dataChangeRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}