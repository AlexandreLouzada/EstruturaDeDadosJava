package arvoreGenerica;

import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

/* =======================================================
   Classe TreeNode: representa um nó da Árvore Binária
   ======================================================= */
class TreeNode<T extends Comparable<T>> {
    private T data;
    private TreeNode<T> leftNode;
    private TreeNode<T> rightNode;

    public TreeNode(T value) {
        data = value;
    }

    public void insert(T value) {
        if (value.compareTo(data) < 0) { // esquerda
            if (leftNode == null)
                leftNode = new TreeNode<>(value);
            else
                leftNode.insert(value);
        } 
        else if (value.compareTo(data) > 0) { // direita
            if (rightNode == null)
                rightNode = new TreeNode<>(value);
            else
                rightNode.insert(value);
        }
    }

    public T getData() { return data; }
    public TreeNode<T> getLeftNode() { return leftNode; }
    public TreeNode<T> getRightNode() { return rightNode; }
}

/* =======================================================
   Classe Tree: Árvore Binária de Busca (BST)
   Com todos os métodos dos exercícios
   ======================================================= */
class Tree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public void insert(T value) {
        if (root == null)
            root = new TreeNode<>(value);
        else
            root.insert(value);
    }

    public TreeNode<T> getRoot() { return root; }

    /* ===== Percursos ===== */
    public void inorder()  { inorder(root);  System.out.println(); }
    private void inorder(TreeNode<T> n) {
        if (n != null) {
            inorder(n.getLeftNode());
            System.out.print(n.getData() + " ");
            inorder(n.getRightNode());
        }
    }

    public void preorder() { preorder(root); System.out.println(); }
    private void preorder(TreeNode<T> n) {
        if (n != null) {
            System.out.print(n.getData() + " ");
            preorder(n.getLeftNode());
            preorder(n.getRightNode());
        }
    }

    public void postorder(){ postorder(root); System.out.println(); }
    private void postorder(TreeNode<T> n) {
        if (n != null) {
            postorder(n.getLeftNode());
            postorder(n.getRightNode());
            System.out.print(n.getData() + " ");
        }
    }

    /* ===== contains (Busca na BST) ===== */
    public boolean contains(T value) { return contains(root, value); }
    private boolean contains(TreeNode<T> n, T value) {
        if (n == null) return false;
        int cmp = value.compareTo(n.getData());
        if (cmp == 0) return true;
        if (cmp < 0) return contains(n.getLeftNode(), value);
        return contains(n.getRightNode(), value);
    }

    /* ===== Contar nós ===== */
    public int countNodes() { return countNodes(root); }
    private int countNodes(TreeNode<T> n) {
        return (n == null) ? 0 : 1 + countNodes(n.getLeftNode()) + countNodes(n.getRightNode());
    }

    /* ===== Menor e Maior ===== */
    public T min() {
        if (root == null) throw new NoSuchElementException("Árvore vazia");
        TreeNode<T> n = root;
        while (n.getLeftNode() != null) n = n.getLeftNode();
        return n.getData();
    }

    public T max() {
        if (root == null) throw new NoSuchElementException("Árvore vazia");
        TreeNode<T> n = root;
        while (n.getRightNode() != null) n = n.getRightNode();
        return n.getData();
    }

    /* ===== Altura da árvore ===== */
    public int height() { return height(root); }
    private int height(TreeNode<T> n) {
        if (n == null) return -1;
        return 1 + Math.max(height(n.getLeftNode()), height(n.getRightNode()));
    }

    /* ===== Verificar se é árvore cheia (full binary tree) ===== */
    public boolean isFull() { return isFull(root); }
    private boolean isFull(TreeNode<T> n) {
        if (n == null) return true;
        boolean esq = n.getLeftNode() != null;
        boolean dir = n.getRightNode() != null;
        if (esq ^ dir) return false; // XOR → só 1 filho
        return isFull(n.getLeftNode()) && isFull(n.getRightNode());
    }

    /* ===== Percurso por nível (level-order) ===== */
    public void levelOrderPrint() {
        if (root == null) { System.out.println("(vazia)"); return; }
        Queue<TreeNode<T>> fila = new LinkedList<>();
        fila.offer(root);
        while (!fila.isEmpty()) {
            TreeNode<T> n = fila.poll();
            System.out.print(n.getData() + " ");
            if (n.getLeftNode()  != null) fila.offer(n.getLeftNode());
            if (n.getRightNode() != null) fila.offer(n.getRightNode());
        }
        System.out.println();
    }

    /* ===== Impressão ASCII (Desenhar a árvore) ===== */
    public void printAscii() {
        printAscii(root, "", true);
    }
    private void printAscii(TreeNode<T> n, String prefix, boolean isTail) {
        if (n == null) return;
        System.out.println(prefix + (isTail ? "└── " : "├── ") + n.getData());
        TreeNode<T> left  = n.getLeftNode();
        TreeNode<T> right = n.getRightNode();
        if (left != null || right != null) {
            printAscii(left,  prefix + (isTail ? "    " : "│   "), right == null);
            printAscii(right, prefix + (isTail ? "    " : "│   "), true);
        }
    }
}

/* =======================================================
   Classe principal com todos os exercícios resolvidos
   ======================================================= */
public class ArvoreExercicios {

    /* ===== EXERCÍCIO 1 ===== */
    public static Tree<Integer> exercicio1() {
        System.out.println("=== EXERCÍCIO 1: Construção e Percursos ===");

        Tree<Integer> tree = new Tree<>();
        int[] valores = {8, 3, 10, 1, 6, 14, 4, 7, 13};

        for (int v : valores) tree.insert(v);

        System.out.print("In-order:   ");
        tree.inorder();

        System.out.print("Pre-order:  ");
        tree.preorder();

        System.out.print("Post-order: ");
        tree.postorder();

        System.out.println("\nDesenho da árvore:");
        tree.printAscii();
        System.out.println();

        return tree;
    }

    public static void exercicio2(Tree<Integer> tree) {
        System.out.println("=== EXERCÍCIO 2: contains ===");
        System.out.println("Contém 7?  " + tree.contains(7));
        System.out.println("Contém 99? " + tree.contains(99));
        System.out.println();
    }

    public static void exercicio3(Tree<Integer> tree) {
        System.out.println("=== EXERCÍCIO 3: Contar Nós ===");
        System.out.println("Total de nós: " + tree.countNodes());
        System.out.println();
    }

    public static void exercicio4(Tree<Integer> tree) {
        System.out.println("=== EXERCÍCIO 4: Menor e Maior ===");
        System.out.println("Menor valor: " + tree.min());
        System.out.println("Maior valor: " + tree.max());
        System.out.println();
    }

    public static void exercicio5(Tree<Integer> tree) {
        System.out.println("=== EXERCÍCIO 5: Altura da Árvore ===");
        System.out.println("Altura: " + tree.height());
        System.out.println();
    }

    public static void exercicio6(Tree<Integer> tree) {
        System.out.println("=== EXERCÍCIO 6: Árvore Cheia ===");
        System.out.println("É árvore cheia? " + tree.isFull());
        System.out.println();
    }

    public static void exercicio7(Tree<Integer> tree) {
        System.out.println("=== EXERCÍCIO 7: Percurso por Nível ===");
        tree.levelOrderPrint();
        System.out.println();
    }

    public static void main(String[] args) {
        Tree<Integer> tree = exercicio1();

        exercicio2(tree);
        exercicio3(tree);
        exercicio4(tree);
        exercicio5(tree);
        exercicio6(tree);
        exercicio7(tree);
    }
}
