package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.model.Image;
import com.Sales.SalesWeb.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image getImage(UUID id) {
        Image image;
        try {
            image = imageRepository.findByImageId(id);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return image;
    }
}
