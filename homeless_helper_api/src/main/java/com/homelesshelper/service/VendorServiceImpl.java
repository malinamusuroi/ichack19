package com.homelesshelper.service;

import com.homelesshelper.model.Vendor;
import com.homelesshelper.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("vendorService")
public class VendorServiceImpl implements VendorService {

    @Autowired
    VendorRepository vendorRepository;

    @Override
    public void save(Vendor vendor) {
        vendorRepository.save(vendor);
    }

    @Override
    public List<Vendor> getAll() {
        List<Vendor> vendors = new ArrayList<>();
        vendorRepository.findAll().forEach(r -> vendors.add(r));
        return vendors;
    }
}
