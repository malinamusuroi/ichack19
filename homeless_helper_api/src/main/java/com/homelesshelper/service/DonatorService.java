package com.homelesshelper.service;

import com.homelesshelper.model.Donator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonatorService {

    /**
     * save new donator to db
     * @param donator
     */
    void save(Donator donator);

    /**
     * get all donators
     * @return
     */
    List<Donator> getAll();

    /**
     * find donator by id
     * @param id
     * @return
     */
    Donator findBy(Long id);
}
