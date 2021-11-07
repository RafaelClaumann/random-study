
### Exemplo 1:
```text
O contexto deste exemplo é conveter um model(SolicitacaoModel) em uma entity(SolicitacaoEntity) para
salvar a entidade no banco de dados utilizando a biblioteca MapStruct.
```
- Foi preciso criar um método para validar attributos nulos chamado **beforeMapping()**
  - O método criado deve ser no "máximo" `protected` e anotado com [@BeforeMapping](https://mapstruct.org/documentation/stable/reference/html/#customizing-mappings-with-before-and-after)
  - O atributo **description** é opcional, então não é preciso valida-lo
  - Os atributos `valorModel` e `valor` são obrigatórios para ***"salvar a entidade no banco de dados"***
- Atributos com nomes iguais no **model** & **entity** não precisam de `source` no **@Mapping**
``` java
    @Mapping(target = "valor") // nomes de atributo iguais no model & entity
    @Mapping(source = "valorModel", target = "valorEntity") // nomes de atributo diferentes no model & entity
    public abstract SolicitacaoEntity toEntity(final SolicitacaoModel model);
```
- É preciso criar métodos auxiliares para conversão de tipos, usar `qualifiedByName` no @Mapping e anotar o método com @Named
``` java
    @Mapping(source = "valorModel", target = "valorEntity", qualifiedByName = "convertBigDecimal") 
    public abstract SolicitacaoEntity toEntity(final SolicitacaoModel model);
    
    @Named("convertBigDecimal")
    public String convertBigDecimal(final Double valorModel) {
        return valorModel.toString();
    }
```
