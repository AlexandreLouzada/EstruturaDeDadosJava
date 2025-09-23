package aulaRecursao02;

import java.util.Scanner;

public class ContagemRecursiva {
 // Função recursiva
    public static void contagemRecursiva(int n) {
        if (n < 0) return; // caso base
        System.out.println(n);
        contagemRecursiva(n - 1); // passo recursivo
    }

    // Método principal para testar
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número para iniciar a contagem regressiva: ");
        int numero = sc.nextInt();

        System.out.println("Contagem regressiva (recursiva) iniciando em " + numero + ":");
        contagemRecursiva(numero);

        sc.close();
    }
}
