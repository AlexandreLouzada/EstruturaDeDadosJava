package projetoArray05.service;

import projetoArray05.model.Candidato;
import projetoArray05.model.Vaga;

public class MatchService {

    public int calcularPontuacao(Candidato candidato, Vaga vaga) {
        int pontos = 0;

        for (String techVaga : vaga.getTecnologiasRequeridas()) {
            for (String techCand : candidato.getTecnologias()) {
                if (techVaga.equalsIgnoreCase(techCand)) {
                    pontos++;
                    break;
                }
            }
        }

        if (candidato.getCidade().equalsIgnoreCase(vaga.getCidade())) {
            pontos += 1;
        }

        if (candidato.getAnosExperiencia() >= vaga.getExperienciaMinima()) {
            pontos += 2;
        }

        return pontos;
    }

    public void ordenarPorPontuacao(Candidato[] candidatos, int[] pontuacoes) {
        mergeSort(candidatos, pontuacoes, 0, candidatos.length - 1);
    }

    private void mergeSort(Candidato[] cands, int[] pts, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergeSort(cands, pts, esq, meio);
            mergeSort(cands, pts, meio + 1, dir);
            merge(cands, pts, esq, meio, dir);
        }
    }

    private void merge(Candidato[] cands, int[] pts, int esq, int meio, int dir) {
        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        Candidato[] Lc = new Candidato[n1];
        int[] Lp = new int[n1];
        Candidato[] Rc = new Candidato[n2];
        int[] Rp = new int[n2];

        for (int i = 0; i < n1; i++) {
            Lc[i] = cands[esq + i];
            Lp[i] = pts[esq + i];
        }

        for (int j = 0; j < n2; j++) {
            Rc[j] = cands[meio + 1 + j];
            Rp[j] = pts[meio + 1 + j];
        }

        int i = 0, j = 0, k = esq;
        while (i < n1 && j < n2) {
            if (Lp[i] >= Rp[j]) {
                cands[k] = Lc[i];
                pts[k] = Lp[i];
                i++;
            } else {
                cands[k] = Rc[j];
                pts[k] = Rp[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            cands[k] = Lc[i];
            pts[k] = Lp[i];
            i++; k++;
        }

        while (j < n2) {
            cands[k] = Rc[j];
            pts[k] = Rp[j];
            j++; k++;
        }
    }
}

