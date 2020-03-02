package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.model.Baner;
import com.Sales.SalesWeb.model.dbEnums.Page;
import com.Sales.SalesWeb.repository.BanersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BanerService {

    private final BanersRepository banersRepository;

    public BanerService(BanersRepository banersRepository) {
        this.banersRepository = banersRepository;
    }

    public List<Baner> getAllBanersByStatus(Boolean status) {
        List<Baner> baners;
        try {
            baners = banersRepository.findAllByBanerUsesStatus(status);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return baners;
    }

    public List<Baner> getAllBaners() {
        List<Baner> baners;
        try {
            baners = banersRepository.findAll();
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return baners;
    }

    public List<Baner> getAllBanersByPageByStatus(Page page, Boolean status) {
        List<Baner> allByPageAndBanerStatus;
        try {
            allByPageAndBanerStatus = banersRepository.findAllByPageAndBanerUsesStatus(page, status);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return allByPageAndBanerStatus;
    }

    public Baner getBanerId(Integer banerId) {
        Baner byBanerId;
        try {
            byBanerId = banersRepository.findByBanerId(banerId);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return byBanerId;
    }


}
