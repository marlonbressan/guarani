------------------------------------------------------------------------------------------------
Configuração de ambiente
------------------------------------------------------------------------------------------------
Instalar Java SDK 23 (instalador no projeto)
Instalar Intellij Community (instalador no projeto)
Instalar Docker
Instalar plugin lombok e docker
Baixar o projeto
Configurar e atualizar o Maven
Executar o docker-compose no docker-compose.yml (mysql e tomcat)
- host: localhost
- databasename: db_guarani_afv
- porta: 3307
- username: root
- password: guarani
- configurar drive property allowPublicKeyRetrieval = TRUE
- Importar arquivo do POSTMAN para facilitar os testes dos micro-serviços
  (Encontra-se dentro do diretório "Instruções" junto deste documento)
  Dica: configurei todos os requests para usar uma variável chamada {{token}}
  após pegar o token do usuário desejado basta preencher a variável que todos os
  requests irão pegar o valor dessa variável, para evitar ter que ficar atualizando
  todos os serviços com o novo token

- Executar o Register (para cadastrar um usuário e permissão)
- Executar o Login e pegar o token para os demais testes e passar o token no Autorization
- Lembrando que tem um exemplo de Regiter com todas as permissões (FULL GRANT)
- Para testar as demais autorizações, criar outros usuários com privilégios menores

------------------------------------------------------------------------------------------------
Utilização dos conceitos:
------------------------------------------------------------------------------------------------
- Herança e polimorfismo

- Swagger

- Lombok

- Spring boot, security, validations e roles

- Acrescentei um nível a mais de permissão, onde é possível atribuir ou retirar permissões,
  não só nos métodos do controler, mas por operação de CREATE, UPDATE, GET ou DELETE.

- Retorno dos dados utilizando paginação para aumentar a performance de uma futura chamada pelo
  front-end

- Criptografia de senhas

- Customização de Exceptions

- Comecei a criar o CI/CD com GitActions e um exemplo em Kafka mas não deu tempo de concluir

------------------------------------------------------------------------------------------------

* (Swagger) Por algum motivo que ainda não tive tempo de entender a interface do Swagger está sendo mostrada e documentada normalmente, porém em alguns métodos que requerem autenticação não
  está trazendo o token authorization no header. Porém, a chamada de teste pelo Postman está
  funcionando normalmente todas as autorizações e autenticações.

URL: http://localhost:1235/swagger-ui/index.html

------------------------------------------------------------------------------------------------
Regras de negócios
------------------------------------------------------------------------------------------------
Validação de duplicidade de usuários, produtos
Validação de usuário e senha com criptografia
Atualização (refresh) de token no caso de expirar
Logout de usuário para invalidar token e aumentar a segurança das sessões
Validação para não permitir invalidar duas vezes o mesmo token
Lista de objetos retornados por consultas, com paginação. Exemplo abaixo retorna 10 tuplas de acordo com a pagina informada:
{
"pagination": {
"pageNumber": 1,
"pageSize": 10
}
}

------------------------------------------------------------------------------------------------
Observações finais
------------------------------------------------------------------------------------------------
Devido ao prazo de 2 dias ficaram faltando algumas poucas coisas, porém acredito que terminaria
em menos de um dia, pois seriam praticamente CTRL+C CTRL+V do que já foi feito.

Como pode notar acima eu coloquei algumas coisas extras no projeto e implementei alguns CRUDs
extras também como o de CLIENTE que achei interessante colocar


- Faltou uma parte do CRUD de pedido e o CRUD dos itens do pedido que eu pretendia faze-lo
  junto do CRUD do pedido
- Faltou o relatório por dia, mês, ano e período, mas eu fiz o outro solicitado
- CI/CD e Kafka estaria na sequencia, mas eu vou dar continuidade após essa entrega por caráter de estudo e prática
