package projetoArray03.service;

import projetoArray03.model.Vendas;

public class VendasService {
    private final Vendas vendas;

    public VendasService(Vendas vendas) {
        this.vendas = vendas;
    }

    public double[] calcularTotalPorLoja() {
        int lojas = vendas.getTotalLojas();
        int meses = vendas.getTotalMeses();
        double[] totais = new double[lojas];

        for (int i = 0; i < lojas; i++) {
            for (int j = 0; j < meses; j++) {
                totais[i] += vendas.getVenda(i, j);
            }
        }
        return totais;
    }

    public int lojaMaisVendeu() {
        double[] totais = calcularTotalPorLoja();
        double max = totais[0];
        int indice = 0;
        for (int i = 1; i < totais.length; i++) {
            if (totais[i] > max) {
                max = totais[i];
                indice = i;
            }
        }
        return indice;
    }

    public int mesPicoPorLoja(int loja) {
        int meses = vendas.getTotalMeses();
        double maior = vendas.getVenda(loja, 0);
        int mesPico = 0;

        for (int j = 1; j < meses; j++) {
            if (vendas.getVenda(loja, j) > maior) {
                maior = vendas.getVenda(loja, j);
                mesPico = j;
            }
        }
        return mesPico;
    }

    public double calcularMediaGeral() {
        int lojas = vendas.getTotalLojas();
        int meses = vendas.getTotalMeses();
        double soma = 0;

        for (int i = 0; i < lojas; i++) {
            for (int j = 0; j < meses; j++) {
                soma += vendas.getVenda(i, j);
            }
        }
        return soma / (lojas * meses);
    }

    public int[] rankingLojasPorVendaTotal() {
        double[] totais = calcularTotalPorLoja();
        int n = totais.length;
        int[] ranking = new int[n];

        for (int i = 0; i < n; i++) {
            ranking[i] = i;
        }

        // Selection sort para ordenar índices com base no total
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (totais[ranking[j]] > totais[ranking[maxIdx]]) {
                    maxIdx = j;
                }
            }
            int temp = ranking[i];
            ranking[i] = ranking[maxIdx];
            ranking[maxIdx] = temp;
        }

        return ranking;
    }
}

