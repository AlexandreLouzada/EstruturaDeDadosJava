public class NumeroArray {
    private int[] numeros;

    public NumeroArray(int[] numeros) {
        this.numeros = numeros;
    }

    public void contarFrequencia() {
        int[] valores = new int[numeros.length]; // guarda os números distintos
        int[] freq = new int[numeros.length];    // guarda a frequência correspondente
        int distintos = 0; // quantidade de números distintos já registrados

        for (int i = 0; i < numeros.length; i++) {
            int atual = numeros[i];
            boolean encontrado = false;

            // Verifica se já registramos esse número
            for (int j = 0; j < distintos; j++) {
                if (valores[j] == atual) {
                    freq[j]++;   // incrementa contagem
                    encontrado = true;
                    break;
                }
            }

            // Se não foi encontrado, registra como novo
            if (!encontrado) {
                valores[distintos] = atual;
                freq[distintos] = 1;
                distintos++;
            }
        }

        // Exibe resultado
        System.out.println("Frequência dos números no array:");
        for (int i = 0; i < distintos; i++) {
            System.out.println(valores[i] + " aparece " + freq[i] + " vez(es).");
        }
    }

    public void imprimirArray() {
        System.out.print("Array: ");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}