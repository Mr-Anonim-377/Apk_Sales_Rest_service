package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.repository.CategoryRepository;
import com.Sales.SalesWeb.repository.CollectionRepository;
import com.Sales.SalesWeb.repository.ImageRepository;
import com.Sales.SalesWeb.repository.ProductRepository;
import com.Sales.SalesWeb.service.hadoop.ParserProducts;
import com.google.common.collect.ImmutableMap;
import org.apache.hadoop.util.ToolRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class AdministrationService extends AbstractService {
    final CategoryRepository categoryRepository;

    final ImageRepository imageRepository;

    final CollectionRepository collectionRepository;

    final ProductRepository productRepository;

    public AdministrationService(CategoryRepository categoryRepository, ImageRepository imageRepository, CollectionRepository collectionRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.imageRepository = imageRepository;
        this.collectionRepository = collectionRepository;
        this.productRepository = productRepository;
    }

    public void saveAllProductFromFile(MultipartFile multipartFile) {
        CheckedErrorConsumer<MultipartFile> function = currentMultipartFile -> {
            File file = multipartFileToFile(multipartFile, multipartFile.getOriginalFilename());
            ToolRunner.run(new ParserProducts(), new String[]{file.getAbsolutePath()});
            file.delete();
        };
        applyByException(multipartFile, function, ImmutableMap.of(
                new Exception(), new ApiException("Products Parsing Error",
                        "Parse error",
                        ExceptionType.ParseError),
                new IOException(), new ApiException("Create temp file error",
                        "Creating file error",
                        ExceptionType.CreatingFIleError)));
    }

    public static File multipartFileToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
        multipart.transferTo(convFile);
        return convFile;
    }

}