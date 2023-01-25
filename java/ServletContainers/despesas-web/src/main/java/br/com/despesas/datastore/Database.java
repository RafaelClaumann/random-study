package br.com.despesas.datastore;

import br.com.despesas.model.Despesa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public final class Database {

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
        return Database.despesasList.add(despesa);
    }

    public List<Despesa> listAll() {
        return Database.despesasList;
    }

    public Optional<Despesa> findDespesa(final Integer index) {
        final int arrayLowerBound = 0;
        if (index >= arrayLowerBound && index < Database.despesasList.size()) {
            final Despesa despesa = Database.despesasList.get(index);
            return Optional.ofNullable(despesa);
        }
        return Optional.empty();
    }

    public List<Despesa> findDespesa(final String descricao) {
        final List<Despesa> despesas =
                Database.despesasList
                        .stream()
                        .filter(item -> item.getDescricao().equalsIgnoreCase(descricao))
                        .collect(Collectors.toList());
        return despesas;
    }

}
