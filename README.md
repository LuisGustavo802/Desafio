# Desafio
 
Intruções para executar o desafio:
  - Backend:
    - Apontar algum banco postgres no arquivo src\main\resources\application.properties.
    - Executa o comando maven: spring-boot:run

  - Frontend:
    - Apontar o endereço onde está sendo executado o backend no arquivo web\src\services\api.js (Default localhost:8080)
    - No terminal executar o comando: yarn start ou npm start

Instruções para uso:
  - Para o primeiro acesso, pode ser utilizado username 1 e senha 1 (Administrador)
  - O usuário administrador cadastra os usuários, podendo ser Administrador, Triador ou Finalizador
  - O Triador cadastra os processos e estipula quais usuários irão dar um parecer sobre o mesmo
  - O Finalizador irá dar um parecer sobre o processo que o Triador o delegou.
