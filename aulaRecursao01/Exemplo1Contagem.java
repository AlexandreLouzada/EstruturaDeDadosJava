package aulaRecursao01;
import java.util.Scanner;

public class Exemplo1Contagem {

    // Versão iterativa
    public static void contagemIterativa(int n) {
        for (int i = n; i >= 0; i--) {
            System.out.println(i);
        }
    }

    // Versão recursiva
    public static void contagemRecursiva(int n) {
        if (n < 0) return; // caso base
        System.out.println(n);
        contagemRecursiva(n - 1); // passo recursivo
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número para iniciar a contagem regressiva: ");
        int numero = sc.nextInt();

        System.out.println("\nContagem Iterativa:");
        contagemIterativa(numero);

        System.out.println("\nContagem Recursiva:");
        contagemRecursiva(numero);

        sc.close();
    }
}

