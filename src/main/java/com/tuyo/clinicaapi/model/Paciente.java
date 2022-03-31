package com.tuyo.clinicaapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Paciente {

    @Id
    private int id;
    private String ultimoNome;
    private String primeiroNome;
    private int idade;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "paciente")    // Relacionamento OneToMany.
    private List<ClinicaData> clinicaData;                      // ALL = significa que quero usar todas as possibilidades na tabela Paciente. Mas toda a ação de Paciente, impacta em ClinicaData. Se deletar o Paciente. Todos os dados da Tabela clinicadata serão apagados.
                                                                // Fetch = é o Default para o Lazy Fetch. Quando o Paciente for buscado automaticamente, clinicaldata não será apresentado imediatamente, apenas quando for usada na aplicação.
                                                                // Definir Lista privada de Clinical Data

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
