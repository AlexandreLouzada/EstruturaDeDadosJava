import controle.ControlePessoas;

public class Principal {
    public static void main(String[] args) {
        ControlePessoas controle = new ControlePessoas();
        controle.cadastrarPessoas();
        controle.exibirMenu();
    }
}
