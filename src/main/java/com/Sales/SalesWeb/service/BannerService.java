package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.model.Banner;
import com.Sales.SalesWeb.model.dbEnums.Page;
import com.Sales.SalesWeb.repository.BanersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

@Service
public class BannerService extends AbstractService {

    private final BanersRepository banersRepository;

    public BannerService(BanersRepository banersRepository) {
        this.banersRepository = banersRepository;
    }

    public List<Banner> getAllBannersByStatus(Boolean status) {
        CheckedErrorFunction<Boolean, List<Banner>> functionSql = banersRepository::findAllByBanerUsesStatus;
        return applyHibernateQuery(status, functionSql);
    }

    public List<Banner> getAllBanners() {
        Callable<List<Banner>> functionSql = banersRepository::findAll;
        return applyHibernateQuery(functionSql);
    }

    public List<Banner> getAllBannersByPageByStatus(Page page, Boolean status) {
        CheckedErrorFunction<Boolean, List<Banner>> functionSql = aBoolean ->
                banersRepository.findAllByPageAndBannerUsesStatus(page, aBoolean);
        return applyHibernateQuery(status, functionSql);
    }

    public Banner getBannerId(Integer bannerId) {
        CheckedErrorFunction<Integer, Banner> functionSql = banersRepository::findByBanerId;
        return applyHibernateQuery(bannerId, functionSql);
    }
}
