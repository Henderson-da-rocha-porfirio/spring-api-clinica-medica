package com.tuyo.clinicaapi.controllers;

import com.tuyo.clinicaapi.dto.ClinicaDataRequest;
import com.tuyo.clinicaapi.model.ClinicaData;
import com.tuyo.clinicaapi.model.Paciente;
import com.tuyo.clinicaapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// ****** Rest Controller ******

@RestController                                                         // Isso realiza um restfull controller.
@RequestMapping("/api")                                                 // Mapear a Path URL
public class PacienteController {                                       // Isso se tornará um restfull Controller.
                                                                        // US1: 1. Mostrar em tela todos os detalhes dos pacientes com o seu id, primeiroNome, ultimoNome e idade.
    private PacienteRepository repository;                              // Este método tanto faz a lista de importação de nomes, bem como o controle de um paciente.
    Map<String, String> filters = new HashMap<>();                      // E dentro deste método, necessitamos acessar o repositório, então aperte o controle um para "adicionar" uma declaração escrita
    @Autowired                                                          // Construtor injetor
    PacienteController(PacienteRepository repository){                  // @Autowired = injeção de dependência. Essa anotação diz ao Spring que esse bean em particular tem que ser autowired (injetado ou auto-injetado) no Controller
        this.repository = repository;                                   // Dentro deste construtor, this.repository é igual ao repository que receberemos como um construtor
                                                                        // Traz a injeção a esse repositório para o nosso runtime
    }


                                                                        // ******  US_1 - Como uma pessoa atendente de consultório médico, eu quero vir todos os pacientes registrados ******

    @RequestMapping(value = "/pacientes", method = RequestMethod.GET)   // Método GET é usado no RequestMethod quando os dados já existem. Ele obtém o que já existe.
    public List<Paciente> getPacientes() {
          return repository.findAll();                                  // Nós podemos usar essa controller para buscar os dados numa única linha. findAll é tudo requerido para executar a ação.
                                                                        // O Get e o Select serão criados pelo Hibernate e serão executados no Database.
    }                                                                   // O dado buscado pelo spring nos dará o retorno destes dados numa lista.
                                                                        // Mas para tornar isso uma RestFull End Point, é necessário marcar com uma anotação de Mapping (mapeamento): RequestMapping.
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
                                                                        // TESTANDO NO POSTMAN ( LISTAR PACIENTES ): Escolher o método GET, e com o app funcionando, digitar no Postman: localhost:8080/clinicaservices/api/pacientes


                                                                        // ******  US_1 - Mostrar em tela todos os detalhes dos pacientes com o seu id, primeiroNome, ultimoNome e idade ******

    @RequestMapping(value = "/pacientes/{id}", method = RequestMethod.GET)  // Método GET é usado no RequestMethod quando os dados já existem. Ele obtém o que já existe.
    public  Paciente getPaciente(@PathVariable("id")  int id) {

        return repository.findById(id).get();                           // Agora o ID vem a URI.
                                                                        // {id} é um lugar reservado = qualquer ID de cliente que passa alí, na URL é que virá para esse ID, então, vinculará esse ID para esse valor Integer aqui.
                                                                        // @PathVariable = tem que ser usada essa anotação Spring. E dentro do brackets vai o id: ("id")
     }                                                                  // O mesmo nome usado em: "/pacientes/{id}", no caso id, tem que ser o mesmo passado em: @PathVariable("id"), também id.
                                                                        // Nesse caso, o Spring injetará isso como uma @PathVariable("id")  int id
                                                                        // TESTANDO NO POSTMAN ( LISTAR PACIENTES POR ID ): Escolher o método GET, e com o app funcionando, digitar no Postman: localhost:8080/clinicaservices/api/pacientes/1


                                                                        // ******  US_2 - Como uma pessoa atendente de consultório médico, eu quero registrar um novo paciente. ******

                                                                        // Método POST é usado no RequestMethod quando se está CRIANDO algo.
                                                                        // Esse método é usado no link: "Registrar Paciente" da primeira página
    @RequestMapping(value = "/pacientes", method = RequestMethod.POST)  // /{id} é removido daqui pela simples razão de que nós estamos adicionando um novo paciente a coleção de paciente.
    public Paciente savePaciente(@RequestBody Paciente paciente) {                  // Ele pega paciente passado no parâmetro. Salva paciente passado no parâmetro do método save. E o método save retornará novamente ao paciente salvo passado no parâmetro e terão um ID também.
                                                                        // Então, quando o paciente chega, não vai ter um ID único, ele será criado no Database. Isso é um campo de auto-incremento.
        return repository.save(paciente);                               // Mas quando o paciente, passado no parâmetro do método save, diante da resposta que retorna, qualquer uma que retornar terá um campo ID também.
    }                                                                   // @RequestBody = é necessário marcar para que o Spring não serialize a request automaticamente.
                                                                        // TESTANDO NO POSTMAN ( SALVAR PACIENTES ): Escolher o método POST, e com o app funcionando, digitar no Postman: localhost:8080/clinicaservices/api/pacientes
                                                                     // Antes de enviar, selecionar no menu: " Body " -> " raw " -> JSON (application/json)
                                                                        // {
                                                                        //    "ultimoNome": "Balman",
                                                                        //    "primeiroNome": "Sigmund",
                                                                        //    "idade": 33
                                                                        //}

                                                                         // ******  US_4 - Como uma pessoa atendente de consultório médico, eu quero analisar e ver um relatório dos últimos testes ******

    @RequestMapping(value = "/pacientes/analise/{id}", method = RequestMethod.GET)      // Método Analise para a URI /pacientes/analise/{id}
    public Paciente analise(@PathVariable("id")  int id) {                              // Pegando o id
        Paciente paciente = repository.findById(id).get();                              // Buscando a informação do Paciente de informação do paciente.
        List<ClinicaData> clinicaData = paciente.getClinicaData();                      // Pegando os dados da clinica.
        ArrayList<ClinicaData> duplicadaClinicaData = new ArrayList<>(clinicaData);     // Duplicando uma nova lista de arrays. Passando clinicaData como parâmetro no construtor
                                                                                        // Fazendo um loop por meio de duplicadaClinicaData e fazendo mudanças a clinicaData de List<ClinicaData...
        for(ClinicaData eachEntrada:duplicadaClinicaData) {                             // A lista duplicada onde ocorre o looping, sofre a manipulação dentro do for
            /* if(eachEntrada.getComponenteNome().equals("ap"));*/                       // Lógica de conversão BMI (IMC): ap = altura e peso ( hw = height and weight

            if (filters.containsKey(eachEntrada.getComponenteNome())) {                  // As entradas que tivermos de "ap" não serão duplicadas pela condição abaixo: introdução dessa lógica filters. Só serão adicionados na primeira vez por sofrer a filtragem.
                clinicaData.remove(eachEntrada);                                        // Inicialmente, estamos checando se filters tem "ap", os filtros ficarão vazios. E Aqui, eachEntrada.getComponenteNome(),
                continue;                                                            // Essa condição não será aceita se os filtros estiverem vazios e sendo usados a primeira vez.     // estamos checando se, por exemplo, cada ComponenteNome é "ap".
            } else {                                                                // O loop acontece aqui a primeira vez. Vamos pegar o "ap" se ele estiver aqui
                filters.put(eachEntrada.getComponenteNome(), null);                 // value pode ficar null, porque não importa qual valor irá entrar.
            }                                                                   // Ele colocará o put neste else se a condição acima não for satisfeita. Então ele porá (put will) a entrada "ap" nestes filtros de Map.
                                                                                // Se quisermos que a condição abaixo seja executada, tem que adicionar uma condição: somente se o ComponenteNome for altura e peso.
            if (eachEntrada.getComponenteNome().equals("ap"))                               {// Antes de convertermos a altura em metros aqui, daí é melhor adicionar um "if", se altura e peso for not = null ( ! ).
                String[] alturaEPeso = eachEntrada.getComponenteValue().split("/"); // Agora, "altura" tem o índex [0] e "peso" [1].
                if (alturaEPeso != null && alturaEPeso.length > 1) {
                    float alturaEmMetros = Float.parseFloat(alturaEPeso[0]) * 0.4536F;       // É preciso converter altura em metros
                    float imc = Float.parseFloat(alturaEPeso[1]) / (alturaEmMetros * alturaEmMetros);  // Calcular o IMC (BMI)
                    ClinicaData imcData = new ClinicaData();                                 // No Database, altura e peso, estão como ap = 190/80 ( 1,90 altura e 80 de peso ). Então precisamos deixá-los separados.
                    imcData.setComponenteNome("imc");                                         // Método Split para divisão de arrays: 190/90 ficando 190 e 90 separados por uma "/"
                    imcData.setComponenteValue(Float.toString(imc));                          // É necessário ainda "setar" uma nova clínica.
                    clinicaData.add(imcData);
                }                                                                          // Enquanto estiver no looping de cada entrada clínica, estaremos pegando a altura e o peso.

            }
        }
        filters.clear();                                                                    // Todas as vezes que o ponto onde estão os filtros forem invocados " filters.containsKey e etc ",
        return paciente;                                                                    // os filtros serão limpos. Então, antes de fazer o retorno, devemos fazer com que os filters de Paciente sejam limpos.
                                                                                            // O loop obtendo sucesso, o "else" nunca será executado, a fim de evitar a duplicação. Por isso que ele fará o clear alí.
                                                                                            // Chegado aqui, ainda não é o fim: é preciso adicionar o @JsonIgnore em Paciente declarado como atributo em ClinicaData.
    }


}