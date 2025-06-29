import java.io.*;
import java.util.ArrayList;

public class Cliente {
    private int id;
    private String nome;

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Converte objeto em linha de arquivo
    public String toFileString() {
        return id + ";" + nome;
    }

    // Converte linha de arquivo em objeto
    public static Cliente fromFileString(String linha) {
        String[] partes = linha.split(";");
        int id = Integer.parseInt(partes[0]);
        String nome = partes[1];
        return new Cliente(id, nome);
    }

    public String toString() {
        return "ID: " + id + " - Nome: " + nome;
    }

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader("clientes.txt"))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                Cliente cliente = Cliente.fromFileString(linha);
                clientes.add(cliente);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        System.out.println("Clientes carregados:");
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
}

