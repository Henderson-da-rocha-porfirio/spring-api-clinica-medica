package com.tuyo.clinicaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "clinicadata")                                        // Utilizado porque o nome do objeto ClinicaData é diferente do nome da tabela clinicadata que está no database
@JsonIgnoreProperties({"paciente"})                                 // Utilizar @JsonIgnoreProperties, para que esta informação paciente seja ignorada pela serialização ocorrida em ClinicaData.
public class ClinicaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)             // Para evitar salvamentos em sequência devido não ser uma sequência mas auto-incremento. Tipo, salvar o paciente joão duas ou mais vezes no database, quando não precisa salvar um novo Id todas as vezes.
    private int id;
    private String componenteNome;
    private String componenteValue;
    private Timestamp MeasuredDateTime;

    @ManyToOne(fetch = FetchType.LAZY)                                // Estamos lendo os dados de Paciente através de ClinicaData
    @JoinColumn(name = "paciente_id",nullable = false)               // Tabela responsável pelo Join
    private Paciente paciente;                                      // Tudo isso está assegurando que quando estou salvando o dado, a validação de ClinicaData acontece corretamente no nível JPA.
                                                                    // Algumas exceções podem acontecer se eu tentar injetar clinicaldata sem o ID do Paciente.
                                                                    // Quando a serialização acontece, ela fica num loop terntando serializar o dado paciente.
                                                                    // Para resolver isso, derveríamos ignorar colocando " transient " dessa forma: private transient Paciente paciente;
    public int getId() {                                            // Mas aqui foi escolhido utilizar @JsonIgnoreProperties. Para que esta informação paciente seja ignorada. Verificar acima.
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
