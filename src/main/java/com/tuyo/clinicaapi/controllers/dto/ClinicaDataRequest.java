package com.tuyo.clinicaapi.controllers.dto;

public class ClinicaDataRequest {                       // DTO = DATA TRANSFER OBJECT
    private String componenteNome;                  // Este DTO deveria ter três campos:
    private String componenteValue;
    private int pacienteId;

    public String getComponenteNome() {
        return componenteNome;
    }

    public void setComponenteNome(String componenteNome) {
        this.componenteNome = componenteNome;
    }

    public String getComponenteValue() {
        return componenteValue;
    }

    public void setComponenteValue(String componenteValue) {
        this.componenteValue = componenteValue;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }
}
