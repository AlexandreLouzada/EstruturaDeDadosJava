package arvoreGenericaExemplo;

public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;
    public Tree() {
        root = null;
    }
    /**
     * Insere um valor na árvore.
     */
    public void insert(T value) {
        if (root == null)
            root = new TreeNode<>(value);
        else
            root.insert(value);
    }
    /**
     * Percurso IN-ORDER (ordem crescente)
     * esquerda → raiz → direita
     */
    public void inorderTraversal() {
        inorderHelper(root);
    }
    private void inorderHelper(TreeNode<T> node) {
        if (node != null) {
            inorderHelper(node.getLeftNode());
            System.out.print(node.getData() + " ");
            inorderHelper(node.getRightNode());
        }
    }
    /**
     * Percurso PRE-ORDER
     * raiz → esquerda → direita
     */
    public void preorderTraversal() {
        preorderHelper(root);
    }
    private void preorderHelper(TreeNode<T> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preorderHelper(node.getLeftNode());
            preorderHelper(node.getRightNode());
        }
    }
    /**
     * Percurso POST-ORDER
     * esquerda → direita → raiz
     */
    public void postorderTraversal() {
        postorderHelper(root);
    }
    private void postorderHelper(TreeNode<T> node) {
        if (node != null) {
            postorderHelper(node.getLeftNode());
            postorderHelper(node.getRightNode());
            System.out.print(node.getData() + " ");
        }
    }
}

