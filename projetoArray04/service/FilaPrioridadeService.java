package projetoArray04.service;

import projetoArray04.model.Paciente;

public class FilaPrioridadeService {
    private final Paciente[] fila;
    private int tamanho;

    public FilaPrioridadeService(int capacidade) {
        this.fila = new Paciente[capacidade];
        this.tamanho = 0;
    }

    public boolean inserir(Paciente novo) {
        if (tamanho >= fila.length) return false;

        int i = tamanho - 1;
        while (i >= 0 && comparar(novo, fila[i]) > 0) {
            fila[i + 1] = fila[i];
            i--;
        }
        fila[i + 1] = novo;
        tamanho++;
        return true;
    }

    private int comparar(Paciente p1, Paciente p2) {
        if (p1.getNivelDeUrgencia() != p2.getNivelDeUrgencia()) {
            return p1.getNivelDeUrgencia() - p2.getNivelDeUrgencia();
        } else {
            return p1.getIdade() - p2.getIdade();
        }
    }

    public Paciente proximo() {
        return tamanho > 0 ? fila[0] : null;
    }

    public Paciente buscarPorNome(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (fila[i].getNome().equalsIgnoreCase(nome)) {
                return fila[i];
            }
        }
        return null;
    }

    public void exibirFila() {
        if (tamanho == 0) {
            System.out.println("Fila vazia.");
            return;
        }
        for (int i = 0; i < tamanho; i++) {
            System.out.println(fila[i]);
        }
    }

    public int getTamanho() {
        return tamanho;
    }
}

