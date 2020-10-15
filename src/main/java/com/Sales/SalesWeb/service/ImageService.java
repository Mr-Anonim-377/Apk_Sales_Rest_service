package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.model.Image;
import com.Sales.SalesWeb.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ImageService extends AbstractService {
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image getImage(UUID id) {
        CheckedErrorFunction<UUID, Image> functionSql = imageRepository::findByImageId;
        return applyHibernateQuery(id, functionSql);
    }
}