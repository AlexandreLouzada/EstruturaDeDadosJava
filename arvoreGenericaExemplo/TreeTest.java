package arvoreGenericaExemplo;

public class TreeTest {
    public static void main(String[] args) {
        Tree<Integer> arvore = new Tree<>();
        int[] valores = {50, 30, 20, 40, 70, 60, 80};
        for (int v : valores) arvore.insert(v);
        System.out.println("Percurso IN-ORDER (crescente):");
        arvore.inorderTraversal();
        System.out.println("\n\nPercurso PRE-ORDER:");
        arvore.preorderTraversal();
        System.out.println("\n\nPercurso POST-ORDER:");
        arvore.postorderTraversal();
    }
}

