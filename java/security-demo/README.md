# Security Demo

Até o commit [1728677](https://github.com/RafaelClaumann/random-study/commit/1728677505e1ea588c093a5764376dbeb0360ced)
todo o código foi baseado na video aula [Spring Security JPA Authentication in Spring Boot](https://youtu.be/awcCiqBO36E).
O objetivo desta video aula é realizar um login com `username` e `senha` destacando o uso do Spring Security e Spring Data.


#### Informações do H2 Database
```text
Console URL:   http://localhost:8080/h2-console
Driver Class:   org.h2.Driver
JDBC URL:       jdbc:h2:mem:blog
User Name:      sa
Password:
```


#### Informações do Código
`SecurityConfig` é a classe usada para sobrescrever e personalizar as configurações de segurança **default** do Spring Security.
- A linha `httpBasic(Customizer.withDefaults())` define que o login será do modo **basic**, ou seja, um pop-up do browser será exibido solicitando usuário e senha.
- A linha `userDetailsService(this.jpaUserDetailsService)` faz com que o Spring Security use a classe `JpaUserDetailsService` para obter os detalhes do `SecurityUser`(_subclasse de UserDetails_).

`User` é a classe que representa a entidade do usuário armazenada no banco de dados.

`SecurityUser` é a classe que representa o usuário no momento da autenticação, ela implementa a interface `UserDetails` do Spring Security.

A classe `JpaUserDetailsService` é usada para realizar parte da autenticação buscando um User no banco de dados a partir do _username_. Se o usuário não for encontrado a exceção `UsernameNotFoundException` será lançada. Além disso, é nessa classe que a entidade `User` é mapeada para o POJO `SecurityUser`.
