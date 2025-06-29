import java.util.Arrays;

public class ComparacaoBuscas {

    public static void main(String[] args) {
        int[] vetorDesordenado = {40, 10, 70, 20, 50};
        int chave = 20;

        // Busca Linear - Funciona mesmo sem ordenação
        System.out.println("🔎 Busca Linear:");
        int resultadoLinear = buscaLinear(vetorDesordenado, chave);
        if (resultadoLinear != -1) {
            System.out.println("Valor " + chave + " encontrado na posição " + resultadoLinear);
        } else {
            System.out.println("Valor não encontrado.");
        }

        // Busca Binária SEM ordenar (⚠️ incorreto)
        System.out.println("\n🔎 Busca Binária sem ordenar (INCORRETA):");
        int resultadoIncorreto = Arrays.binarySearch(vetorDesordenado, chave);
        System.out.println("Resultado: " + resultadoIncorreto + " (posição não confiável)");

        // Agora ordenamos o vetor
        Arrays.sort(vetorDesordenado);
        System.out.println("\n📊 Vetor ordenado: " + Arrays.toString(vetorDesordenado));

        // Busca Binária após ordenar (✅ correto)
        System.out.println("\n🔎 Busca Binária com vetor ordenado (CORRETA):");
        int resultadoCorreto = Arrays.binarySearch(vetorDesordenado, chave);
        System.out.println("Valor " + chave + " encontrado na posição " + resultadoCorreto);
    }

    // Implementação de busca linear
    public static int buscaLinear(int[] vetor, int chave) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == chave) {
                return i;
            }
        }
        return -1;
    }
}

