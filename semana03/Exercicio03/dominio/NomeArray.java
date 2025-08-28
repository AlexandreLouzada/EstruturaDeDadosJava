public class NomeArray {
    private String[] nomes;

    public NomeArray(String[] nomes) {
        this.nomes = nomes;
    }

   public int removerNome(String nome) {
        int contador = 0;
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].equalsIgnoreCase(nome)) { // ignora maiúsc./minúsc.
                nomes[i] = "---";
                contador++;
            }
        }
        return contador;
    }

    // Exibe os nomes atuais do array
    public void imprimirArray() {
        System.out.print("Array de nomes: ");
        for (String n : nomes) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}