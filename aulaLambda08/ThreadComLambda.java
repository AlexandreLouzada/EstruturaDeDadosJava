package aulaLambda08;

// Mesma ideia, agora implementando Runnable com uma expressão lambda.
// Lambdas deixam callbacks/eventos/handlers muito mais concisos.
public class ThreadComLambda {
    public static void main(String[] args) {
        // Runnable possui um único método abstrato (run), então podemos usar lambda:
        Thread t = new Thread(() -> System.out.println("Rodando em outra thread (com lambda)..."));
        t.start();

        System.out.println("Thread principal continua...");
    }
}

