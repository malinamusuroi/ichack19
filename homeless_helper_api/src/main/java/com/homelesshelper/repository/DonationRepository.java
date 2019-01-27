package com.homelesshelper.repository;

import com.homelesshelper.model.Donation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends CrudRepository<Donation, Long> {
}