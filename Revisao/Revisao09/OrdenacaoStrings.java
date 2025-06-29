import java.util.ArrayList;
import java.util.Collections;

public class OrdenacaoStrings {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Carlos");
        nomes.add("Ana");
        nomes.add("João");
        nomes.add("Beatriz");

        System.out.println("Antes da ordenação:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        // Ordenação lexicográfica usando compareTo (via Collections.sort)
        Collections.sort(nomes);

        System.out.println("\nApós a ordenação:");
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
}
