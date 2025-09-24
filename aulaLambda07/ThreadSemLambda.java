package aulaLambda07;

// Cria e inicia uma Thread executando um Runnable sem usar lambdas.
public class ThreadSemLambda {
    public static void main(String[] args) {
        // Runnable é uma interface funcional; aqui, implementamos via classe anônima.
        Runnable tarefa = new Runnable() {
            @Override
            public void run() {
                // Código que roda em outra thread
                System.out.println("Rodando em outra thread (sem lambda)...");
            }
        };

        // Criamos a Thread com a tarefa e iniciamos
        Thread t = new Thread(tarefa);
        t.start();

        // Mensagem na thread principal
        System.out.println("Thread principal continua...");
    }
}
