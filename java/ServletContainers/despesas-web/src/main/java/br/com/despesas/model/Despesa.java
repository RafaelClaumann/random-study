package br.com.despesas.model;

public class Despesa {

    private final String descricao;
    private final Double valor;

    public Despesa(String descricao, Double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    private Despesa(DespesaBuilder builder) {
        this.descricao = builder.descricao;
        this.valor = builder.valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public static class DespesaBuilder {
        private String descricao;
        private Double valor;

        public DespesaBuilder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public DespesaBuilder valor(Double valor) {
            this.valor = valor;
            return this;
        }

        public Despesa build() {
            return new Despesa(this);
        }
    }

    @Override
    public String toString() {
        return String.format("Despesa { descricao = %s, valor = %,.2f }", this.descricao, this.valor);
    }

}
