package com.homelesshelper.repository;

import com.homelesshelper.model.Donator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonatorRepository extends CrudRepository<Donator, Long> {
}