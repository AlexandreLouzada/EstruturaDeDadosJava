import java.util.LinkedList;
import java.util.Iterator;

public class RemovePares {
    public static void main(String[] args) {
        // Criando a LinkedList de inteiros
        LinkedList<Integer> numeros = new LinkedList<>();

        // Inserindo 10 números de 1 a 10
        for (int i = 1; i <= 10; i++) {
            numeros.add(i);
        }

        System.out.println("Lista original: " + numeros);

        // Removendo os números pares usando Iterator
        Iterator<Integer> it = numeros.iterator();
        while (it.hasNext()) {
            int valor = it.next();
            if (valor % 2 == 0) { // condição: número par
                it.remove();     // remove de forma segura durante iteração
            }
        }

        // Exibindo o resultado
        System.out.println("Após remover os pares: " + numeros);
    }
}
