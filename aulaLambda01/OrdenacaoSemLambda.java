
import java.util.*;

// Programa completo que ordena uma lista de produtos por preço sem usar lambda.
// Usamos Comparator via classe anônima (sintaxe pré-Java 8).
public class OrdenacaoSemLambda {

    // Classe de domínio simples (não pública para caber no mesmo arquivo).
    static class Produto {
        String nome;
        double preco;
        Produto(String nome, double preco) { this.nome = nome; this.preco = preco; }
        @Override public String toString() { return nome + " - R$ " + preco; }
    }

    public static void main(String[] args) {
        // 1) Criamos uma lista de produtos
        List<Produto> produtos = Arrays.asList(
            new Produto("Mouse", 79.90),
            new Produto("Teclado", 149.50),
            new Produto("Monitor", 899.00),
            new Produto("Cabo HDMI", 35.00)
        );

        // 2) Ordenamos com Collections.sort + Comparator anônimo
        //    O método compare deve retornar:
        //    - negativo se a < b; 0 se a == b; positivo se a > b.
        Collections.sort(produtos, new Comparator<Produto>() {
            @Override
            public int compare(Produto a, Produto b) {
                // Double.compare lida com casos especiais e evita erros de subtração
                return Double.compare(a.preco, b.preco);
            }
        });

        // 3) Imprimimos o resultado
        System.out.println("Ordenado (sem lambda):");
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}
