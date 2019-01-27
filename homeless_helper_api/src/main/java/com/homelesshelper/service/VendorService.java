package com.homelesshelper.service;

import com.homelesshelper.model.Vendor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VendorService {

    /**
     * save new vendor to db
     * @param vendor
     */
    void save(Vendor vendor);

    /**
     * get all registered vendors in db
     * @return
     */
    List<Vendor> getAll();

    /**
     * find vendor by id
     * @param id
     * @return
     */
    Vendor findBy(Long id);
}
