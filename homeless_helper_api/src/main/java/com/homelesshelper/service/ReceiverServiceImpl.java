package com.homelesshelper.service;

import com.homelesshelper.model.Receiver;
import com.homelesshelper.repository.ReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("receiverService")
public class ReceiverServiceImpl implements ReceiverService {

    @Autowired
    ReceiverRepository receiverRepository;

    @Override
    public void save(Receiver receiver) {
        receiverRepository.save(receiver);
    }

    @Override
    public List<Receiver> getAll() {
        List<Receiver> receivers = new ArrayList<>();
        receiverRepository.findAll().forEach(r -> receivers.add(r));
        return receivers;
    }

    @Override
    public Boolean update(Long id, String summary) {
        Receiver r = receiverRepository.findById(id).orElse(null);
        if (r == null) {
            return false;
        } else {
            r.setSummary(summary);
            receiverRepository.save(r);
            return true;
        }
    }

    @Override
    public List<Receiver> findBy(String name, Long dateOfBirth) {
        List<Receiver> receivers = receiverRepository.findByNameAndDateOfBirth(name, dateOfBirth).orElse(null);
        return receivers;
    }

    @Override
    public Receiver findBy(Long id) {
        Receiver receiver = receiverRepository.findById(id).orElse(null);
        return receiver;
    }
}
