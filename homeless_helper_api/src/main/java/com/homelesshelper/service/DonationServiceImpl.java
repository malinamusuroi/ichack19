package com.homelesshelper.service;

import com.homelesshelper.model.Donation;
import com.homelesshelper.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("donationService")
public class DonationServiceImpl implements DonationService {

    @Autowired
    DonationRepository donationRepository;

    @Override
    public void save(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public List<Donation> getAll() {
        List<Donation> donations = new ArrayList<>();
        donationRepository.findAll().forEach(d -> donations.add(d));
        return donations;
    }
}
