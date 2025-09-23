package aulaRecursao01;
import java.util.Scanner;

public class ContagemIterativa {

    // Função fornecida (iterativa)
    public static void contagemIterativa(int n) {
        for (int i = n; i >= 0; i--) {
            System.out.println(i);
        }
    }

    // Método principal para testar
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número para iniciar a contagem regressiva: ");
        int numero = sc.nextInt();

        System.out.println("Contagem regressiva iniciando em " + numero + ":");
        contagemIterativa(numero);

        sc.close();
    }
}
