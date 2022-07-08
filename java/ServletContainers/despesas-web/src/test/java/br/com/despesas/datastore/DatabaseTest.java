package br.com.despesas.datastore;

import br.com.despesas.model.Despesa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    private final Database database = Database.getDatabaseSingletonInstance();
    private Despesa despesa;

    @BeforeEach
    void setup() {
        this.despesa = new Despesa.DespesaBuilder()
                .descricao("despesaSetup")
                .valor(0.0D)
                .build();
        this.database.addDespesa(despesa);
    }

    @Test
    void deveRetornarTrueAoInserirUmaDespesaValida() {
        final Despesa despesa = new Despesa.DespesaBuilder()
                .descricao("deveInserirUmaDespesa")
                .valor(55.0D)
                .build();

        final Boolean isSuccess = this.database.addDespesa(despesa);
        assertTrue(isSuccess);
    }

    @Test
    void deveRetornarFalseAoInserirUmaDespesaInvalida() {
        final Boolean isSuccess = this.database.addDespesa(null);
        assertFalse(isSuccess);
    }

    @Test
    void deveRetornarOptionalEmptyAoBuscarDespesaForaDosLimitesDaLista() {
        final int indexOutOufBounds = 999;
        final Optional<Despesa> foundDespesa = this.database.findDespesa(indexOutOufBounds);

        assertEquals(Optional.empty(), foundDespesa);
    }

    @Test
    void deveEncontrarUmaDespesaPeloIndiceDaLista() {
        final int index = 1;
        final Optional<Despesa> foundDespesa = this.database.findDespesa(index);

        assertTrue(foundDespesa.isPresent());
    }

    @Test
    void deveEncontrarUmaDespesaPelaDescricao() {
        final List<Despesa> despesasList = this.database.findDespesa("despesaSetup");

        assertFalse(despesasList.isEmpty());
        assertEquals(this.despesa, despesasList.get(0));
    }

}