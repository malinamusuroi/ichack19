package com.homelesshelper.service;

import com.homelesshelper.model.Donation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonationService {

    /**
     * save new donation to db
     * @param donation
     */
    void save(Donation donation);

    /**
     * get all donations
     * @return
     */
    List<Donation> getAll();
}
