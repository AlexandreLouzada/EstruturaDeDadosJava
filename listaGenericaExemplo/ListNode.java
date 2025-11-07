package listaGenericaExemplo;

/**
 * Classe ListNode: representa um nó (node) de uma lista encadeada.
 * É uma estrutura autorreferencial: contém um dado e uma referência
 * para o próximo nó da lista.
 */
public class ListNode<T> {

    // valor armazenado no nó
    private T data;

    // referência para o próximo nó
    private ListNode<T> nextNode;

    /**
     * Construtor que inicializa o nó com um valor e sem próximo.
     */
    public ListNode(T object) {
        this(object, null);
    }

    /**
     * Construtor que permite informar também o próximo nó.
     */
    public ListNode(T object, ListNode<T> node) {
        data = object;
        nextNode = node;
    }

    /**
     * Retorna o valor armazenado no nó.
     */
    public T getData() {
        return data;
    }

    /**
     * Retorna a referência para o próximo nó.
     */
    public ListNode<T> getNext() {
        return nextNode;
    }

    /**
     * Define qual será o próximo nó.
     */
    public void setNext(ListNode<T> node) {
        nextNode = node;
    }
}
