package aulaRecursao03;

import java.util.Scanner;

public class Exemplo3InverterStrings {

    // Versão iterativa
    public static String inverterIterativo(String s) {
        String invertida = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            invertida += s.charAt(i);
        }
        return invertida;
    }

    // Versão recursiva
    public static String inverterRecursivo(String s) {
        if (s.length() <= 1) return s; // caso base
        return s.charAt(s.length() - 1) + inverterRecursivo(s.substring(0, s.length() - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        String palavra = sc.nextLine();

        System.out.println("Invertida (Iterativo): " + inverterIterativo(palavra));
        System.out.println("Invertida (Recursivo): " + inverterRecursivo(palavra));

        sc.close();
    }
}

