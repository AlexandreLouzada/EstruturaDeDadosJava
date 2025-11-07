package listaGenericaExemplo;
import java.util.NoSuchElementException;

public class ListTeste {
    public static void main(String[] args) {
        
        List<Integer> lista = new List<>("Minha Lista");

        lista.insertAtFront(3);
        lista.insertAtFront(2);
        lista.insertAtFront(1);
        lista.insertAtBack(4);
        lista.insertAtBack(5);

        lista.print();  // esperado: 1 2 3 4 5

        System.out.println("\nRemovendo do início: " + lista.removeFromFront());
        lista.print();

        System.out.println("\nRemovendo do final: " + lista.removeFromBack());
        lista.print();
    }
}

