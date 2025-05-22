package com.deveficiente.desafiocdc.repository;

import com.deveficiente.desafiocdc.domain.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
