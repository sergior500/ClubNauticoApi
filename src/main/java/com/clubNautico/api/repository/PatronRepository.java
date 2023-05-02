package com.clubNautico.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clubNautico.api.model.Patron;

public interface PatronRepository extends JpaRepository<Patron, Integer> {

}
