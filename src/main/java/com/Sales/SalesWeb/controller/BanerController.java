package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.model.Baner;
import com.Sales.SalesWeb.model.enums.Page;
import com.Sales.SalesWeb.service.BanerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "baners", produces = MediaType.APPLICATION_JSON_VALUE)
public class BanerController {

    private final BanerService banerService;

    public BanerController(BanerService banerService) {
        this.banerService = banerService;
    }

    @GetMapping(value = "/allByStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Baner>> getAllBanersByStatus(@RequestParam() Boolean status) {
        List<Baner> baners = banerService.getAllBanersByStatus(status);
        if (baners.isEmpty()) {
            throw new ApiException("No search baners in db by current status :(",
                    "baners.isEmpty()",
                    ExceptionType.NoSuchObjs);
        }
        return new ResponseEntity<>(baners, HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Baner>> getAllBaners() {
        List<Baner> allBaners = banerService.getAllBaners();
        if (allBaners.isEmpty()) {
            throw new ApiException("No search baners in db by current status :(",
                    "baners.isEmpty()",
                    ExceptionType.NoSuchObjs);
        }
        return new ResponseEntity<>(allBaners, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Baner> getBanerByStatus(@PathVariable Integer id,
                                                  @RequestParam Boolean status) {
        Baner banerByStatus = banerService.getBanerByStatus(id, status);
        if (banerByStatus == null) {
            throw new ApiException("No search baners in db by current status :(",
                    "baners.isEmpty()",
                    ExceptionType.NoSuchObjs);
        }
        return new ResponseEntity<>(banerByStatus, HttpStatus.OK);
    }

    @GetMapping(value = "/allByStatusByPage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Baner>> getBanersByStatus(@RequestParam Page page,
                                                         @RequestParam Boolean status) {
        List<Baner> banersByPageByStatus = banerService.getAllBanersByPageByStatus(page, status);
        if (banersByPageByStatus == null) {
            throw new ApiException("No search baners in db by current status :(",
                    "baners.isEmpty()",
                    ExceptionType.NoSuchObjs);
        }
        return new ResponseEntity<>(banersByPageByStatus, HttpStatus.OK);
    }


}


