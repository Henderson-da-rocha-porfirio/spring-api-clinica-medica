package com.tuyo.clinicaapi.controllers;

import com.tuyo.clinicaapi.dto.ClinicaDataRequest;
import com.tuyo.clinicaapi.model.ClinicaData;
import com.tuyo.clinicaapi.model.Paciente;
import com.tuyo.clinicaapi.repository.ClinicaDataRepository;
import com.tuyo.clinicaapi.repository.PacienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicaDataController {
                                                                                        // Este método irá receber um "request" que conterá o componente_nome e componente_value. E também o paciente_id.
           private ClinicaDataRepository clinicosRepo;                                       // Busca(fetch) pelo paciente
           private PacienteRepository pacienteRepo;                                         // Injetando o PacienteRepository e também o ClinicaRepository

            ClinicaDataController(ClinicaDataRepository clinicaRepo, PacienteRepository pacienteRepo) {      // Criado o Construtor. Terá como passagem de parâmetro ClinicaDataRepository e PacienteRepository
                    this.clinicosRepo = clinicaRepo;
                    this.pacienteRepo = pacienteRepo;
            }
                                                                                   // ******  US_3 - Como uma pessoa atendente de consultório médico, eu quero acessar e salvar dados clínicos por paciente individualmente ******

        @RequestMapping(value = "/dadosclinicos", method = RequestMethod.POST)                         // Adicionando nova entrada para dados clinicos
        public ClinicaData saveClinicaData(@RequestBody ClinicaDataRequest request) {          // Este método irá receber um "request" que conterá o componente_nome e componente_value. E também o paciente_id.
                                                                                              // Busca(fetch) pelo paciente
            Paciente paciente = pacienteRepo.findById(request.getPacienteId()).get();        // Assinar como local variable com Optional. Mas com .get() não precisamos do Optional<>
            ClinicaData clinicaData = new ClinicaData();                                      // Assinar variável local
            clinicaData.setComponenteNome(request.getComponenteNome());
            clinicaData.setComponenteValue(request.getComponenteValue());
            clinicaData.setPaciente(paciente);                                                  //recuperando o paciente do database
            return clinicosRepo.save(clinicaData);                                                                        // Iremos criar um request personalizado chamado ClinicaDataRequest.
                                                                                            // Isto é um bean que estamos criando  para controlar as batidas
    }                                                                                      // @RequestBody = é necessário marcar para que o Spring não serialize a request automaticamente.
}                                                                                          // Para ClinicaDataRequest, precisamos criar uma ClinicaData Bean.
