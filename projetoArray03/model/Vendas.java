package projetoArray03.model;

public class Vendas {
    private final double[][] vendas; // lojas x meses

    public Vendas(int lojas, int meses) {
        this.vendas = new double[lojas][meses];
    }

    public void setVenda(int loja, int mes, double valor) {
        this.vendas[loja][mes] = valor;
    }

    public double getVenda(int loja, int mes) {
        return this.vendas[loja][mes];
    }

    public double[][] getMatriz() {
        return this.vendas;
    }

    public int getTotalLojas() {
        return vendas.length;
    }

    public int getTotalMeses() {
        return vendas[0].length;
    }
}

