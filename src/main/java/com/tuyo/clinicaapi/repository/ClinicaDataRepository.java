package com.tuyo.clinicaapi.repository;

import com.tuyo.clinicaapi.model.ClinicaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicaDataRepository extends JpaRepository<ClinicaData, Integer> {
}
