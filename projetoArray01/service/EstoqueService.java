package projetoArray01.service;

import projetoArray01.model.Produto;

public class EstoqueService {

    private final Produto[] produtos;

    public EstoqueService(Produto[] produtos) {
        this.produtos = produtos;
    }

    public void listarTodos() {
        System.out.println("\nProdutos cadastrados:");
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    public Produto buscarPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public Produto buscarPorNome(String nome) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) return p;
        }
        return null;
    }

    public Produto[] buscarTodasOcorrenciasPorNome(String nome) {
        int cont = 0;
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) cont++;
        }

        Produto[] encontrados = new Produto[cont];
        int i = 0;
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                encontrados[i++] = p;
            }
        }
        return encontrados;
    }
}

