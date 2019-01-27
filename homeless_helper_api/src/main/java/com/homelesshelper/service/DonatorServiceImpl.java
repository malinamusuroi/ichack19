package com.homelesshelper.service;

import com.homelesshelper.model.Donator;
import com.homelesshelper.repository.DonatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("donatorService")
public class DonatorServiceImpl implements DonatorService {

    @Autowired
    DonatorRepository donatorRepository;

    @Override
    public void save(Donator donator) {
        donatorRepository.save(donator);
    }

    @Override
    public List<Donator> getAll() {
        List<Donator> donators = new ArrayList<>();
        donatorRepository.findAll().forEach(d -> donators.add(d));
        return donators;
    }

    @Override
    public Donator findBy(Long id) {
        Donator donator = donatorRepository.findById(id).orElse(null);
        return donator;
    }
}
