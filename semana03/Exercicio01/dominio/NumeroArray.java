import java.util.Scanner;

class NumeroArray {
    private int[] numeros;

    // Construtor
    public NumeroArray(int[] numeros) {
        this.numeros = numeros;
    }

    // Método para contar pares e ímpares
    public void contarParesEImpares() {
        int pares = 0;
        int impares = 0;

        for (int n : numeros) {
            if (n % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }

        System.out.println("Quantidade de pares: " + pares);
        System.out.println("Quantidade de ímpares: " + impares);
    }

    // Método opcional: imprimir o array
    public void imprimirArray() {
        System.out.print("Array digitado: ");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}