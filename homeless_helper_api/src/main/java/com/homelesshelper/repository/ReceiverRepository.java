package com.homelesshelper.repository;

import com.homelesshelper.model.Receiver;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReceiverRepository extends CrudRepository<Receiver, Long> {

    @Query("SELECT r FROM Receiver r where r.name = ?1 AND r.dateOfBirth = ?2")
    Optional<List<Receiver>> findByNameAndDateOfBirth(String name, Long dateOfBirth);

}