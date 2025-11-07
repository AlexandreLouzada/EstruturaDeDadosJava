package listaGenericaExemplo;

import java.util.NoSuchElementException;

public class List<T> {

    private ListNode<T> firstNode;   // primeiro nó da lista
    private ListNode<T> lastNode;    // último nó da lista
    private String name;             // nome da lista (opcional)

    /**
     * Construtor padrão - nome genérico "lista"
     */
    public List() {
        this("lista");
    }

    /**
     * Construtor que permite definir o nome da lista.
     */
    public List(String name) {
        this.name = name;
        firstNode = lastNode = null;
    }

    /**
     * Verifica se a lista está vazia.
     */
    public boolean isEmpty() {
        return firstNode == null;
    }

    /**
     * Insere um elemento no início da lista.
     */
    public void insertAtFront(T item) {
        if (isEmpty()) {
            firstNode = lastNode = new ListNode<>(item);
        } else {
            firstNode = new ListNode<>(item, firstNode);
        }
    }

    /**
     * Insere um elemento no final da lista.
     */
    public void insertAtBack(T item) {
        if (isEmpty()) {
            firstNode = lastNode = new ListNode<>(item);
        } else {
            lastNode.setNext(new ListNode<>(item));
            lastNode = lastNode.getNext();
        }
    }

    /**
     * Remove o primeiro elemento da lista.
     */
    public T removeFromFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("A lista está vazia");
        }

        T removedItem = firstNode.getData();

        // Se só existe um elemento
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            firstNode = firstNode.getNext();
        }

        return removedItem;
    }

    /**
     * Remove o último elemento da lista.
     */
    public T removeFromBack() {
        if (isEmpty()) {
            throw new NoSuchElementException("A lista está vazia");
        }

        T removedItem = lastNode.getData();

        // Se só há um elemento
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } 
        else {
            // percorre até o penúltimo
            ListNode<T> current = firstNode;

            while (current.getNext() != lastNode) {
                current = current.getNext();
            }

            lastNode = current;
            current.setNext(null);
        }

        return removedItem;
    }

    /**
     * Imprime toda a lista, do início ao fim.
     */
    public void print() {
        if (isEmpty()) {
            System.out.println(name + " está vazia.");
            return;
        }

        System.out.print("A " + name + " contém: ");

        ListNode<T> current = firstNode;

        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }

        System.out.println();
    }
}