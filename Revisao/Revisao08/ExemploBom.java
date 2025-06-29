import java.util.*;

public class ExemploBom {
    public static void main(String[] args) {
        List<ItemEstoque> listaDeItens = new ArrayList<>();
        listaDeItens.add(new ItemEstoque(5, true));
        listaDeItens.add(new ItemEstoque(3, false));
        listaDeItens.add(new ItemEstoque(2, true));

        int totalItensValidos = 0;
        for (ItemEstoque item : listaDeItens) {
            if (item.estaValido()) {
                totalItensValidos += item.getQuantidade();
            }
        }

        System.out.println("Total de itens válidos em estoque: " + totalItensValidos);
    }
}

class ItemEstoque {
    private int quantidade;
    private boolean valido;

    public ItemEstoque(int quantidade, boolean valido) {
        this.quantidade = quantidade;
        this.valido = valido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean estaValido() {
        return valido;
    }
}
