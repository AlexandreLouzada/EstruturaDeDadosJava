package projetoArray02.service;

import projetoArray02.model.Produto;

public class CatalogoService {
    private final Produto[] produtos;

    public CatalogoService(Produto[] produtos) {
        this.produtos = produtos;
    }

    public Produto[] buscarPorNome(String termo) {
        termo = termo.toLowerCase();
        int count = 0;
        for (Produto p : produtos) {
            if (p.getNome().toLowerCase().contains(termo)) count++;
        }

        Produto[] encontrados = new Produto[count];
        int idx = 0;
        for (Produto p : produtos) {
            if (p.getNome().toLowerCase().contains(termo)) {
                encontrados[idx++] = p;
            }
        }
        return encontrados;
    }

    public Produto[] filtrarPorPreco(double min, double max) {
        int count = 0;
        for (Produto p : produtos) {
            if (p.getValorUnitario() >= min && p.getValorUnitario() <= max) count++;
        }

        Produto[] filtrados = new Produto[count];
        int idx = 0;
        for (Produto p : produtos) {
            if (p.getValorUnitario() >= min && p.getValorUnitario() <= max) {
                filtrados[idx++] = p;
            }
        }
        return filtrados;
    }

    public void ordenarPorNomeAZ() {
        for (int i = 1; i < produtos.length; i++) {
            Produto chave = produtos[i];
            int j = i - 1;
            while (j >= 0 && produtos[j].getNome().compareToIgnoreCase(chave.getNome()) > 0) {
                produtos[j + 1] = produtos[j];
                j--;
            }
            produtos[j + 1] = chave;
        }
    }

    public void ordenarPorPreco() {
        for (int i = 0; i < produtos.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < produtos.length; j++) {
                if (produtos[j].getValorUnitario() < produtos[minIdx].getValorUnitario()) {
                    minIdx = j;
                }
            }
            Produto temp = produtos[i];
            produtos[i] = produtos[minIdx];
            produtos[minIdx] = temp;
        }
    }

    public void ordenarPorEstoqueDesc() {
        int n = produtos.length;
        for (int i = 0; i < n - 1; i++) {
            boolean trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (produtos[j].getQuantidade() < produtos[j + 1].getQuantidade()) {
                    Produto temp = produtos[j];
                    produtos[j] = produtos[j + 1];
                    produtos[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
    }

    public Produto[] getTodos() {
        return produtos;
    }
}

