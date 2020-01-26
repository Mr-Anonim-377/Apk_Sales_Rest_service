package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.model.Collection;
import com.Sales.SalesWeb.repository.CollectionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CollectionService {
    private final CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public Collection getCollect(Integer id) {
        Collection byCollectionId;
        try {
            byCollectionId = collectionRepository.findByCollectionId(id);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return byCollectionId;
    }

    public ArrayList<Collection> getAllCollect() {
        ArrayList<Collection> collections;
        try {
            collections = collectionRepository.findAll();
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return collections;
    }
}
