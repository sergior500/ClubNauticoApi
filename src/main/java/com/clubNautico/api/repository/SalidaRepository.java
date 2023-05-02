package com.clubNautico.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clubNautico.api.model.Salida;
import com.clubNautico.api.model.Salida_id;

public interface SalidaRepository extends JpaRepository<Salida, Salida_id> {

}
