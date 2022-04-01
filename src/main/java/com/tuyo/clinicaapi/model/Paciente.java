package com.tuyo.clinicaapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // Esse ID é um campo auto-incremento no Database. Então por isso precisamos indicar isso ao Hibernate usando o @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;                                             // Contudo, será criado no Database sem problemas. Mas o ID quando retornar ao Client (database), ele será zerado automaticamente, e o Hibernate não pegará o valor do Database.
    @Column(name = "ultimo_nome")
    private String ultimoNome;                                  // @GeneratedValue(strategy = GenerationType.IDENTITY) também precisa ser adicionado ao ClinicaData.
    @Column(name = "primeiro_nome")
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

    public List<ClinicaData> getClinicaData() {
        return clinicaData;
    }

    public void setClinicaData(List<ClinicaData> clinicaData) {
        this.clinicaData = clinicaData;
    }

}
