package com.homelesshelper.repository;

import com.homelesshelper.model.Vendor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long> {
}