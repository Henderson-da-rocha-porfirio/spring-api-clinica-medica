# Clínica App
## US = User Stories
### US_1 - Como uma pessoa atendente de consultório médico, eu quero vir todos os pacientes registrados ( /paciente )
#### * Critérios de Aceitação:
##### 1. Mostrar em tela todos os detalhes dos pacientes com o seu id, primeiroNome, ultimoNome e idade: " /pacienteDetalhes/1 ", onde 1 seria o ID correspondente.
##### 2. Mostrar em tela o Link para entrar nos dados da clínica para cada paciente.
##### 3. Mostrar em tela o Link para analisar dados para cada paciente.
##### 4. Mostrar em tela o Link para registrar novos pacientes.
### US_2 - Como uma pessoa atendente de consultório médico, eu quero registrar um novo paciente.
#### * Critérios de Aceitação:
##### 1. Ao clicar no Link "Adicionar" o usuário deveria ser levado a tela de registro do paciente.
##### 2. O usuário deveria ver um formulário que que ele possa preencher com detalhes na tela do paciente como: primeiroNome, ultimoNome e idade.
##### 3. Quando clicar no botão "Confirmar", o dado deveria ser salvo e ter uma mensagem de confirmação. E essa deveria aparecer em tela.
##### 4. O usuário deveria estar hábil para navegar de "volta" (Back) à página principal.
### US_3 - Como uma pessoa atendente de consultório médico, eu quero acessar e salvar dados clínicos por paciente individualmente
#### * Critérios de Aceitação:
##### 1. Ao clicar no Link "Adicionar" na página principal, o usuário deveria navegar no dado clínico em tela inteira.
##### 2. O usuário deveria ver um formulário que ele possa preencher com detalhes sobre o paciente como pa (pressão arterial), altura, peso e frequência cardíaca.
##### 3. Quando clicar no botão "Confirmar", o dado deveria ser salvo e apresentar uma mensagem de confirmação em tela.
##### 4. O usuário deveria estar hábil para navegar de "volta" (Back) à página principal.
### US_4 - Como uma pessoa atendente de consultório médico, eu quero analisar e ver um relatório dos últimos testes
#### * Critérios de Aceitação:
##### 1. Ao clicar no Link "Analisar" na página principal, o usuário deveria ser direcionado para a página, onde ele pode ver as últimas entradas para vários dados clínicos.
##### 2. O índice de massa corporal (IMC), deveria ser mostrado na tela se baseando na altura e peso do paciente.
##### 3. O usuário deveria ver um Link para um Gráfico que mostrará uma leitura clínica numa linha em um gráfico de linhas ao longo do tempo.
## Passos
### 1. Criar o Database, Tabelas e fazer Inserts
### 2. Criar as Entidades
### 3. Criar os Repositories para cada Entidade.
### 4. Criar a Rest Controller para expor externamente a Rest API.
