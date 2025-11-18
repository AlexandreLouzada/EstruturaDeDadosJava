package projetoArray03.view;

import projetoArray03.model.Vendas;
import projetoArray03.service.VendasService;

import java.util.Scanner;

public class MenuVendas {
    private final Scanner sc = new Scanner(System.in);

    public void iniciar() {
        int lojas = lerInt("Quantas lojas? ");
        int meses = lerInt("Quantos meses? ");
        Vendas vendas = new Vendas(lojas, meses);

        System.out.println("Cadastro das vendas (R$):");
        for (int i = 0; i < lojas; i++) {
            for (int j = 0; j < meses; j++) {
                double valor = lerDouble(String.format("Loja %d - Mês %d: ", i + 1, j + 1));
                vendas.setVenda(i, j, valor);
            }
        }

        VendasService service = new VendasService(vendas);

        System.out.println("\nTOTAL DE VENDAS POR LOJA:");
        double[] totais = service.calcularTotalPorLoja();
        for (int i = 0; i < totais.length; i++) {
            System.out.printf("Loja %d: R$ %.2f\n", i + 1, totais[i]);
        }

        int melhorLoja = service.lojaMaisVendeu();
        System.out.printf("\nLoja com maior venda no ano: Loja %d (R$ %.2f)\n",
                melhorLoja + 1, totais[melhorLoja]);

        System.out.println("\nMês de pico por loja:");
        for (int i = 0; i < lojas; i++) {
            int mesPico = service.mesPicoPorLoja(i);
            System.out.printf("Loja %d: Mês %d (R$ %.2f)\n",
                    i + 1, mesPico + 1, vendas.getVenda(i, mesPico));
        }

        double media = service.calcularMediaGeral();
        System.out.printf("\nMédia geral mensal: R$ %.2f\n", media);

        int[] ranking = service.rankingLojasPorVendaTotal();
        System.out.println("\nRanking de Lojas por Faturamento:");
        for (int i = 0; i < ranking.length; i++) {
            int idx = ranking[i];
            System.out.printf("%dº - Loja %d: R$ %.2f\n",
                    i + 1, idx + 1, totais[idx]);
        }
    }

    private int lerInt(String msg) {
        System.out.print(msg);
        while (!sc.hasNextInt()) {
            System.out.print("Valor inválido. " + msg);
            sc.next();
        }
        int val = sc.nextInt(); sc.nextLine();
        return val;
    }

    private double lerDouble(String msg) {
        System.out.print(msg);
        while (!sc.hasNextDouble()) {
            System.out.print("Valor inválido. " + msg);
            sc.next();
        }
        double val = sc.nextDouble(); sc.nextLine();
        return val;
    }
}
