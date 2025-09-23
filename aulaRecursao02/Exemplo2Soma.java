package aulaRecursao02;

import java.util.Scanner;

public class Exemplo2Soma {

    // Versão iterativa
    public static int somaAteNIterativo(int n) {
        int soma = 0;
        for (int i = 1; i <= n; i++) {
            soma += i;
        }
        return soma;
    }

    // Versão recursiva
    public static int somaAteNRecursivo(int n) {
        if (n <= 0) return 0; // caso base
        return n + somaAteNRecursivo(n - 1); // passo recursivo
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int numero = sc.nextInt();

        System.out.println("Soma até N (Iterativo): " + somaAteNIterativo(numero));
        System.out.println("Soma até N (Recursivo): " + somaAteNRecursivo(numero));

        sc.close();
    }
}
