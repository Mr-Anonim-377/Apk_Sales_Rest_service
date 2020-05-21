package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.repository.CategoryRepository;
import com.Sales.SalesWeb.repository.CollectionRepository;
import com.Sales.SalesWeb.repository.ImageRepository;
import com.Sales.SalesWeb.repository.ProductRepository;
import com.Sales.SalesWeb.service.hadoop.ParserProducts;
import org.apache.commons.text.StringTokenizer;
import org.apache.hadoop.util.ToolRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

@Service
public class AdministrationService {
    final
    CategoryRepository categoryRepository;

    final
    ImageRepository imageRepository;

    final
    CollectionRepository collectionRepository;

    final
    ProductRepository productRepository;

    public AdministrationService(CategoryRepository categoryRepository, ImageRepository imageRepository, CollectionRepository collectionRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.imageRepository = imageRepository;
        this.collectionRepository = collectionRepository;
        this.productRepository = productRepository;
    }


    public void saveAllProductFromFile(MultipartFile multipartFile) {
        File file = null;
        try {
            file = multipartToFile(multipartFile, multipartFile.getOriginalFilename());
        } catch (IOException e) {
            throw new ApiException("Create temp file error",
                    "Creating file error",
                    ExceptionType.CreatingFIleError);
        }
        try {
            ToolRunner.run(new ParserProducts(), new String[]{file.getAbsolutePath()});
        } catch (Exception e) {
            throw new ApiException("Products Parsing Error",
                    "Parse error",
                    ExceptionType.ParseError);
        }
    }

    public static File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
        multipart.transferTo(convFile);
        return convFile;
    }

}
