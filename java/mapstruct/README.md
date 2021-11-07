
### Exemplo 1:
```text
O contexto deste exemplo é converter um model em entity utilizando o Mapstruct.
São feitas validações e conversões de tipos nos atributos obrigatórios & não obrigatórios.
```
#### Links Mapstruct:
- [mapstruct](https://mapstruct.org/)
- [javadoc](https://mapstruct.org/documentation/stable/api/)
- [reference guide](https://mapstruct.org/documentation/dev/reference/pdf/mapstruct-reference-guide.pdf)

#### Pontos Importantes:
- Foi preciso criar um método para validar atributos nulos chamado **beforeMapping()**
  - O método criado deve ser no "máximo" `protected` e anotado com [@BeforeMapping](https://mapstruct.org/documentation/stable/reference/html/#customizing-mappings-with-before-and-after)
  - O atributo `description` é opcional
  - Os atributos `valorModel` e `valor` são obrigatórios para ***"salvar a entidade no banco de dados"***
- Atributos com nomes iguais no **model** & **entity** não precisam de `source` no **@Mapping**
``` java
    @Mapping(target = "valor") // nomes de atributo iguais no model & entity
    @Mapping(source = "valorModel", target = "valorEntity") // nomes de atributo diferentes no model & entity
    public abstract SolicitacaoEntity toEntity(final SolicitacaoModel model);
```
- É preciso criar métodos auxiliares para conversão de tipos, usar `qualifiedByName` no @Mapping e anotar o método com @Named
``` java
    @Mapping(source = "valorModel", target = "valorEntity", qualifiedByName = "convertDouble") 
    public abstract SolicitacaoEntity toEntity(final SolicitacaoModel model);
    
    @Named("convertDouble")
    public String convertDouble(final Double valorModel) {
        return valorModel.toString();
    }
```
