package com.Sales.SalesWeb.controller;


import com.Sales.SalesWeb.model.Sale;
import com.Sales.SalesWeb.repository.SalesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sales/")
public class SalesController extends AbstractController {
    private final SalesRepository salesRepository;

    public SalesController(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @GetMapping("all")
    public List<Sale> getSales() {
        return salesRepository.findAll();
    }

    @GetMapping("{id}")
    public Sale getSale(@PathVariable("id") Sale sale) {
        return sale;
    }

    @PostMapping("create")
    public Sale createSale(@RequestBody Sale sale) {
        return salesRepository.save(sale);
    }

    @PutMapping("{id}")
    public Sale updateSale(@PathVariable("id") Sale saleFromDb,
                           @RequestBody Sale saleFromUser) {
        BeanUtils.copyProperties(saleFromUser, saleFromDb, "id");
        return salesRepository.save(saleFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteSale(@PathVariable("id") Sale sale) {
        salesRepository.delete(sale);
    }

}