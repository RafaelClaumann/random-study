package exemplo_1;

import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@Mapper
public abstract class MapperEX1 {

    @Mapping(target = "valor", qualifiedByName = "convertDouble")
    @Mapping(source = "valorModel", target = "valorEntity", qualifiedByName = "convertBigDecimal")
    public abstract SolicitacaoEntityEX1 toEntity(final SolicitacaoModelEX1 model);

    @Named("convertDouble")
    public String convertDouble(final BigDecimal valor) {
        return valor.toString();
    }

    @Named("convertBigDecimal")
    public String convertBigDecimal(final Double valorModel) {
        return valorModel.toString();
    }

    @BeforeMapping
    protected void beforeMapping(final SolicitacaoModelEX1 solicitacao) {
        Optional.ofNullable(solicitacao)
                .filter(obj -> Objects.nonNull(obj.getValor()))
                .filter(obj -> Objects.nonNull(obj.getValorModel()))
                .orElseThrow(() -> new IllegalArgumentException("Há um problema nos dados informados"));
    }

}
