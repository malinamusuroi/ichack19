package com.homelesshelper.service;

import com.homelesshelper.model.Receiver;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReceiverService {

    /**
     * save new receiver use to db
     * @param receiver
     */
    void save(Receiver receiver);

    /**
     * get all receivers in arraylist
     * @return receivers
     */
    List<Receiver> getAll();

    /**
     * update the summary of a receiver
     * @param id
     * @param summary
     */
    Boolean update(Long id, String summary);

    /**
     * find receivers with given identifiers
     * @param name
     * @param dateOfBirth
     * @return
     */
    List<Receiver> findBy(String name, Long dateOfBirth);

    /**
     * find receiver by id
     * @param id
     * @return
     */
    Receiver findBy(Long id);
}
