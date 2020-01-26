package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;
@Repository
public interface ImageRepository extends JpaRepository <Image, UUID>{

    Image findByImageId(UUID ImageId);
    ArrayList<Image> findAll();
}
