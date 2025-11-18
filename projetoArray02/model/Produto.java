package projetoArray02.model;

public class Produto {
    private int id;
    private String nome;
    private int quantidade;
    private double valorUnitario;

    public Produto(int id, String nome, int quantidade, double valorUnitario) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getQuantidade() { return quantidade; }
    public double getValorUnitario() { return valorUnitario; }

    @Override
    public String toString() {
        return String.format("Produto{id=%d, nome='%s', estoque=%d, valor=R$ %.2f}",
                id, nome, quantidade, valorUnitario);
    }
}
