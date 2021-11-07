package exemplo_1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@Slf4j
class MapperEX1Test {

    private final MapperEX1 mapperEX1 = MapperInstance.getMapper(MapperEX1.class);

    @Test
    void deveMapearModelParaEntity() {
        SolicitacaoModelEX1 model = SolicitacaoModelEX1.builder()
                .valorModel(Double.parseDouble("500.0"))
                .valor(BigDecimal.valueOf(124.34513))
                .description("descrição da solicitação!")
                .build();

        SolicitacaoEntityEX1 entity = mapperEX1.toEntity(model);

        log.info("model: {}", model);
        log.info("entity mapped from model: {}", entity);

        Assertions.assertAll(
                () -> Assertions.assertNotNull(entity),
                () -> Assertions.assertEquals(model.getValorModel().toString(), entity.getValorEntity()),
                () -> Assertions.assertEquals(model.getValor().toString(), entity.getValor()),
                () -> Assertions.assertEquals(model.getDescription(), entity.getDescription())
        );
    }

    @Test
    void deveMapearIgnorandoDescricao() {
        SolicitacaoModelEX1 model = SolicitacaoModelEX1.builder()
                .valorModel(Double.parseDouble("500.0"))
                .valor(BigDecimal.valueOf(124.34513))
                .description(null)
                .build();

        SolicitacaoEntityEX1 entity = mapperEX1.toEntity(model);

        log.info("model: {}", model);
        log.info("entity mapped from model: {}", entity);

        Assertions.assertAll(
                () -> Assertions.assertNotNull(entity),
                () -> Assertions.assertEquals(model.getValorModel().toString(), entity.getValorEntity()),
                () -> Assertions.assertEquals(model.getValor().toString(), entity.getValor()),
                () -> Assertions.assertNull(model.getDescription()),
                () -> Assertions.assertNull(entity.getDescription())
        );
    }

    @Test
    void deveLancarExcecaoAtributoValorNull() {
        MapperEX1 mapperSpy = Mockito.spy(mapperEX1);

        SolicitacaoModelEX1 model = SolicitacaoModelEX1.builder()
                .valorModel(Double.parseDouble("500.0"))
                .valor(null)
                .description("descrição da solicitação!")
                .build();

        String expectedMessage = "Há um problema nos dados informados";

        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mapperEX1.toEntity(model)
        );

        Assertions.assertEquals(expectedMessage, exception.getMessage());
        verify(mapperSpy, Mockito.never()).toEntity(any(SolicitacaoModelEX1.class));
    }

}