package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.model.Banner;
import com.Sales.SalesWeb.model.dbEnums.Page;
import com.Sales.SalesWeb.service.BannerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "banners/", produces = MediaType.APPLICATION_JSON_VALUE)
public class BannerController extends AbstractController {
    private final BannerService banerService;
    private final ApiException defaultError = new ApiException(
            "No search banners in db by current status :(",
            "banners.isEmpty()",
            ExceptionType.NoSuchObjs);

    public BannerController(BannerService banerService) {
        this.banerService = banerService;
    }

    @GetMapping(value = "all/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Banner>> getAllBannersByStatus(@RequestParam() Boolean active) {
        List<Banner> banners = banerService.getAllBannersByStatus(active);
        nullAssert(defaultError, banners);
        return new ResponseEntity<>(banners, HttpStatus.OK);
    }

    @GetMapping(value = "all/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Banner>> getBannersByStatus(@RequestParam Page page, @RequestParam Boolean status) {
        List<Banner> bannersByPageByStatus = banerService.getAllBannersByPageByStatus(page, status);
        nullAssert(defaultError, bannersByPageByStatus);
        return new ResponseEntity<>(bannersByPageByStatus, HttpStatus.OK);
    }

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Banner>> getAllBanners() {
        List<Banner> allBanners = banerService.getAllBanners();
        nullAssert(defaultError, allBanners);
        return new ResponseEntity<>(allBanners, HttpStatus.OK);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Banner> getBannerByStatus(@PathVariable Integer id) {
        Banner bannerByStatus = banerService.getBannerId(id);
        nullAssert(defaultError, bannerByStatus);
        return new ResponseEntity<>(bannerByStatus, HttpStatus.OK);
    }
}