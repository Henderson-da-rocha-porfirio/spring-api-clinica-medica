package com.tuyo.clinicaapi.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class ClinicaData {
    @Id
    private int id;
    private String componenteNome;
    private String componenteValue;
    private Timestamp MeasuredDateTime;

    @ManyToOne(fetch = FetchType.LAZY)                                // Estamos lendo os dados de Paciente através de ClinicaData
    @JoinColumn(name = "paciente_id",nullable = false)               // Tabela responsável pelo Join
    private Paciente paciente;                                      // Tudo isso está assegurando que quando estou salvando o dado, a validação de ClinicaData acontece corretamente no nível JPA.
                                                                    // Algumas exceções podem acontecer se eu tentar injetar clinicaldata sem o ID do Paciente.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Timestamp getMeasuredDateTime() {
        return MeasuredDateTime;
    }

    public void setMeasuredDateTime(Timestamp measuredDateTime) {
        MeasuredDateTime = measuredDateTime;
    }
}
