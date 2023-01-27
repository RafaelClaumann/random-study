# Security Demo

Testando e aprendendo as funcionalidades do Spring Security através de videoaulas.

Até o commit [security - encode password antes de salvar no BD](https://github.com/RafaelClaumann/random-study/commit/1728677505e1ea588c093a5764376dbeb0360ced)
todo o código foi baseado na video aula [Spring Security JPA Authentication in Spring Boot](https://youtu.be/awcCiqBO36E).
O objetivo é realizar um login com `username` e `senha` de acordo com as informações armazendas no banco de dados H2.

#### Informações do H2 Database
```text
Console URL:   http://localhost:8080/h2-console
Driver Class:   org.h2.Driver
JDBC URL:       jdbc:h2:mem:blog
User Name:      sa
Password:
```


#### Informações do Código
`SecurityConfig` é a classe usada para sobrescrever e personalizar as configurações default de segurança do Spring Security.
- A linha`httpBasic(Customizer.withDefaults())` define que o login será do modo basic, ou seja, um pop-up do browser será exibido solicitando usuário e senha.
- A linha`userDetailsService(this.jpaUserDetailsService)` faz com que o Spring Security use a classe `JpaUserDetailsService` para
obter os detalhes do `SecurityUser`(_subclasse de UserDetails_).

`User` é a classe que representa a entidade de usuário armazenada no banco de dados.

`SecurityUser` é a classe que representa o usuário no momento da autenticação, ela implementa a interface `UserDetails` do Spring Security.

A classe `JpaUserDetailsService` foi criada para buscar um `User` no banco de dados a partir do atributo _username_. Se o usuário não for
encontrado a exceção `UsernameNotFoundException` será lançada. Além disso, é nessa classe que a entidade `User` é mapeada para
o `SecurityUser`.
