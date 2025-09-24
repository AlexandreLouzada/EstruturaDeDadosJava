public class TestaListaString {
    public static void main(String[] args) {
        ListaArrayString lista = new ListaArrayString(5);

        // Adicionando nomes à lista
        lista.adicionar("Ana");
        lista.adicionar("Bruno");
        lista.adicionar("Carlos");
        System.out.println("Após adicionar nomes:");
        lista.imprimirLista();

        // Removendo um nome da posição 1
        lista.remover(1);
        System.out.println("Após remover o nome da posição 1:");
        lista.imprimirLista();

        // Buscando um nome na lista
        String nomeBuscado = "Carlos";
        int posicao = lista.buscar(nomeBuscado);
        if (posicao != -1) {
            System.out.println("O nome '" + nomeBuscado + "' foi encontrado na posição " + posicao);
        } else {
            System.out.println("O nome '" + nomeBuscado + "' não foi encontrado na lista.");
        }

        // Adicionando um novo nome
        lista.adicionar("Daniela");
        System.out.println("Após adicionar o nome 'Daniela':");
        lista.imprimirLista();
    }
}

