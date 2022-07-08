package br.com.despesas.datastore;

import br.com.despesas.model.Despesa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public final class Database {

    private static final Logger LOGGER = Logger.getLogger(Database.class.getName());
    private static final List<Despesa> despesasList = new ArrayList<>();
    private static Database databaseSingletonInstance;

    private Database() {
        Database.despesasList.add(new Despesa.DespesaBuilder()
                .descricao("uber")
                .valor(50.25D)
                .build()
        );

        Database.despesasList.add(new Despesa.DespesaBuilder()
                .descricao("mercado")
                .valor(170.0D)
                .build()
        );
    }

    public static synchronized Database getDatabaseSingletonInstance() {
        if (Objects.isNull(Database.databaseSingletonInstance))
            return new Database();
        return Database.databaseSingletonInstance;
    }

    public Boolean addDespesa(final Despesa despesa) {
        if (Objects.isNull(despesa))
            return false;
        LOGGER.info(String.format("despesa inserida no banco de dados com sucesso { %s }", despesa));
        return Database.despesasList.add(despesa);
    }

    public Optional<Despesa> findDespesa(final Integer index) {
        final int arrayLowerBound = 0;
        if (index > arrayLowerBound && index < Database.despesasList.size()) {
            final Despesa despesa = Database.despesasList.get(index);
            LOGGER.info(String.format("Retornando despesa do índice { %d }, { %s }", index, despesa));
            return Optional.ofNullable(despesa);
        }
        LOGGER.info(String.format("Não foram encontradas despesas no índice { %d }", index));
        return Optional.empty();
    }

    public List<Despesa> findDespesa(final String descricao) {
        final List<Despesa> despesas =
                Database.despesasList
                        .stream()
                        .filter(item -> item.getDescricao().equalsIgnoreCase(descricao))
                        .collect(Collectors.toList());
        LOGGER.info(String.format("Retornando a(s) despesa(s) com a descricao { %s }, { %s }", descricao, despesas));
        return despesas;
    }

}
