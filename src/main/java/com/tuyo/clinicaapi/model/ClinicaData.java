package com.tuyo.clinicaapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class ClinicaData {
    @Id
    private int id;
    private String componenteNome;
    private String componenteValue;
    private Timestamp MeasuredDateTime;

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
