package com.homelesshelper.service;

import com.homelesshelper.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    /**
     * save new vendor to db
     * @param transaction
     */
    void save(Transaction transaction);

    /**
     * get all transactions
     * @return
     */
    List<Transaction> getAll();
}
