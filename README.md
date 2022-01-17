# tqi_evolution_backend_2021

## Recursos utilizados:

- Java 11
- Spring Boot
- Lombok
- Spring Security
- PostgresSQL

## Solução

A minha solução back-end para o desafio foi implementar uma API Rest que faz a comunicação entre o cliente e um database real.

O cliente pode fazer o cadastro de suas informações, "logar", efetuar pedido de emprestimo e consultar a lista de seus pedidos e os detalhes de cada emprestimo.

Para o login, utilizei o Spring Security. Tenha em mente que o bootcamp da TQI foi o meu primeiro contato com o desenvolvimento em Java. Meio por acaso enquanto pesquisava como montar a API, eu esbarrei no Spring Security e ví que poderia proteger os links com ele e retornar uma tela de Login. Então, para utilizar recursos prontos e não reinventar a roda eu escolhi utiliza-lo (além de que eu não conseguiria criar uma interface de login do zero no momento). Após aprender um pouco sobre o security, estou convicto de que deveria utiliza-lo na solução do desafio.

Se cadastrando e autenticando o Login com email (único) e senha (encriptografada, recurso do security que explorei), a minha ideia foi pegar as informações do usuario logado (principal) e já guardar na tabela de emprestimos no meu database. Então o meu JSON (request no POSTMAN) seria separado para o cadastro e para o emprestimo, e o programa salva automaticamente as informações de quem está logado e guarda no pedido.

#### POSTs

Cadastrar cliente:
~~~
http://localhost:8080/api/v2/cadastro
~~~

Pedir emprestimo:
~~~
http://localhost:8080/api/v2/solicitar-emprestimo
~~~

#### GETs

Consultar lista de emprestimos:
~~~
http://localhost:8080/api/v2/emprestimos
~~~

Consultar detalhe de um emprestimo:
~~~
http://localhost:8080/api/v2/emprestimos/id
~~~
Em id, passar o número do emprestimo que deseja ver os detalhes.
