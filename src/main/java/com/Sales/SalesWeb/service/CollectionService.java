package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.model.Collection;
import com.Sales.SalesWeb.model.DTO.CollectionDto;
import com.Sales.SalesWeb.repository.CollectionRepository;
import com.Sales.SalesWeb.service.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.Sales.SalesWeb.service.utils.Mapper.toCollectionDto;

@Service
public class CollectionService {
    private final CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public CollectionDto getCollect(Integer id) {
        CollectionDto collectionDto;
        try {
            Collection collection = collectionRepository.findByCollectionId(id);
            collectionDto = collection==null?null:toCollectionDto(collection);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return collectionDto;
    }

    public List<CollectionDto> getAllCollect() {
        List<CollectionDto> collections;
        try {
            List<Collection> all = collectionRepository.findAll();
            collections = all.isEmpty()?null:all.stream().map(Mapper::toCollectionDto)
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return collections;
    }
}
