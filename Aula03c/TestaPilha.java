public class TestePilha {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);

        // Empilhando elementos
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        System.out.println("Após empilhar elementos:");
        pilha.imprimirPilha();

        // Visualizando o topo da pilha
        System.out.println("Topo da pilha: " + pilha.peek());

        // Desempilhando um elemento
        System.out.println("Removendo elemento: " + pilha.pop());
        System.out.println("Após desempilhar um elemento:");
        pilha.imprimirPilha();

        // Testando remoção de todos os elementos
        pilha.pop();
        pilha.pop();
        System.out.println("Após esvaziar a pilha:");
        pilha.imprimirPilha();

        // Testando desempilhar com pilha vazia
        pilha.pop();
    }
}

