package com.tuyo.clinicaapi.repository;

import com.tuyo.clinicaapi.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
