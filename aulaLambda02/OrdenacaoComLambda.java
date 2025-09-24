package aulaLambda02;

import java.util.*;
import java.util.stream.*;

// Mesmo problema, agora usando lambdas para tornar o código mais conciso e legível.
public class OrdenacaoComLambda {

    static class Produto {
        String nome;
        double preco;
        Produto(String nome, double preco) { this.nome = nome; this.preco = preco; }
        @Override public String toString() { return nome + " - R$ " + preco; }
    }

    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
            new Produto("Mouse", 79.90),
            new Produto("Teclado", 149.50),
            new Produto("Monitor", 899.00),
            new Produto("Cabo HDMI", 35.00)
        );

        // list.sort aceita um Comparator. Usamos um "method reference" para extrair o preço.
        produtos.sort(Comparator.comparingDouble(p -> p.preco));

        // Alternativa ainda mais legível (method reference explícito):
        // produtos.sort(Comparator.comparingDouble(Produto::getPreco)); // se houvesse getPreco()

        System.out.println("Ordenado (com lambda):");
        produtos.forEach(System.out::println); // forEach com method reference
    }
}

