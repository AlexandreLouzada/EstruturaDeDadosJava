package arvoreGenericaExemplo;

public class TreeNode<T extends Comparable<T>> {
    // valor armazenado no nó
    private T data;
    // referências para subárvores esquerda e direita
    private TreeNode<T> leftNode;
    private TreeNode<T> rightNode;
    public TreeNode(T item) {
        data = item;
    }
    /**
     * Insere um novo nó na subárvore correta (esquerda ou direita).
     */
    public void insert(T value) {
        if (value.compareTo(data) < 0) { // vai para esquerda
            if (leftNode == null)
                leftNode = new TreeNode<>(value);
            else
                leftNode.insert(value);
        } else if (value.compareTo(data) > 0) { // vai para direita
            if (rightNode == null)
                rightNode = new TreeNode<>(value);
            else
                rightNode.insert(value);
        }
        // valores iguais são ignorados (opção comum em BST)
    }
    // getters
    public T getData() { return data; }
    public TreeNode<T> getLeftNode() { return leftNode; }
    public TreeNode<T> getRightNode() { return rightNode; }
}

