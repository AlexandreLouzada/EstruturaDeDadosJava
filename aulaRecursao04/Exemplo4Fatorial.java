package aulaRecursao04;

import java.util.Scanner;

public class Exemplo4Fatorial {

    // Versão iterativa
    public static long fatorialIterativo(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // Versão recursiva
    public static long fatorialRecursivo(int n) {
        if (n == 0) return 1; // caso base
        return n * fatorialRecursivo(n - 1); // passo recursivo
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int numero = sc.nextInt();

        System.out.println("Fatorial (Iterativo): " + fatorialIterativo(numero));
        System.out.println("Fatorial (Recursivo): " + fatorialRecursivo(numero));

        sc.close();
    }
}
