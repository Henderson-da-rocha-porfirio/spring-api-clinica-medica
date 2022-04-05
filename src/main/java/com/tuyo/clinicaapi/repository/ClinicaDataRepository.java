package com.tuyo.clinicaapi.repository;

import com.tuyo.clinicaapi.model.ClinicaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicaDataRepository extends JpaRepository<ClinicaData, Integer> {

   /* List<ClinicaData> findByPacienteIdAndComponenteNomeOrderByMeasuredDateTime(int pacienteId, String componenteNome);*/
}
