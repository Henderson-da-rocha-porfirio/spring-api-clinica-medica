package com.tuyo.clinicaapi.controllers;

import com.tuyo.clinicaapi.model.Paciente;
import com.tuyo.clinicaapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController                                                         // Isso realiza um restfull controller.
@RequestMapping("/api")                                                  // Mapear a Path URL
public class PacienteController {                                        // Isso se tornará um restfull Controller.
                                                                         // US1: 1. Mostrar em tela todos os detalhes dos pacientes com o seu id, primeiroNome, ultimoNome e idade.
    private PacienteRepository repository;                              // Este método tanto faz a lista de importação de nomes, bem como o controle de um paciente.
                                                                        // E dentro deste método, necessitamos acessar o repositório, então aperte o controle um para "adicionar" uma declaração escrita
    @Autowired                                                            // Construtor injetor
    PacienteController(PacienteRepository repository){                      // @Autowired = injeção de dependência. Essa anotação diz ao Spring que esse bean em particular tem que ser autowired (injetado ou auto-injetado) no Controller
        this.repository = repository;                                   // Dentro deste construtor, this.repository é igual ao repository que receberemos como um construtor
                                                                        // Traz a injeção a esse repositório para o nosso runtime
    }

    @RequestMapping(value = "/pacientes", method = RequestMethod.GET)
    public List<Paciente> getPacientes() {
          return repository.findAll();                                  // Nós podemos usar essa controller para buscar os dados numa única linha. findAll é tudo requerido para executar a ação.
                                                                        // O Get e o Select serão criados pelo Hibernate e serão executados no Database.
    }                                                                   // O dado buscado pelo spring nos dará o retorno destes dados numa lista.
}                                                                       // Mas para tornar isso uma RestFull End Point, é necessário marcar com uma anotação de Mapping (mapeamento): RequestMapping.
                                                                        // Quando o usuário do Client acessa nossa API Restful com "/pacientes", ele devolve todos os pacientes.
                                                                        // Nós também provemos o método "http", a fim de que esse deva ser vinculado.
                                                                        // O Request Method tem todas os valores constantes, não o método de solicitação de mapeamento .get
                                                                        // GET = é o default se não usar alguma coisa alí em method = RequestMethod.GET

                                                                        // **** O que foi feito aqui:
                                                                        // 1. Criada uma Rest Controller.
                                                                        // 2. Mapeada uma URI chamada API.
                                                                        // 3. Injetou o PacienteRepository
                                                                        // 4. Injetou com o @autowired
                                                                        // 5. Get foi implementado com getPacientes que retorna todas as informações dos pacientes