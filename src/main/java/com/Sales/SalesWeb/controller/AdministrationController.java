package com.Sales.SalesWeb.controller;


import com.Sales.SalesWeb.controller.exception.UploadFileEmptyError;
import com.Sales.SalesWeb.service.AdministrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdministrationController {
    private final AdministrationService administrationService;

    public AdministrationController(AdministrationService administrationService) {
        this.administrationService = administrationService;
    }

    @PostMapping(value = "/addProducts", produces = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity getProductsOnCategpry(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new UploadFileEmptyError();
        }
        administrationService.saveAllProductFromFile(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
