package Executavel;

import Faturamento.CartaoDeCredito;
import Faturamento.Compra;

import java.util.Collections;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o limite do cartão");
        double limiteCartao = scanner.nextDouble();
        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(limiteCartao);

        int op = 1;
        double soma = 0;

        while(op != 0){
            System.out.println("Nome do produto: ");
            String descricao = scanner.next();

            System.out.println("Preço do produto: ");
            double preco = scanner.nextDouble();
            soma += preco;

            Compra compra = new Compra(descricao,preco);
            boolean compraRealizada = cartaoDeCredito.realizarCompra(compra);

            if(compraRealizada){
                System.out.println("Compra aprovada!");
                System.out.printf("Saldo atual: R$%.2f\n", cartaoDeCredito.getSaldo());
                System.out.println("Continuar cadastrando algum produto:\n 1-Sim" +
                        "\nQualquer outro diferente de 1 para sair ");
                op = scanner.nextInt();
            }else{
                System.out.println("limite insuficiente!");
                System.out.printf("limite solicitado: R$" + cartaoDeCredito.getLimite()
                        + ", compra deu em: R$%.2f\n", soma);
                System.out.printf("Valor ultrapassado: R$%.2f", (soma - cartaoDeCredito.getLimite()));
                op = 0;
            }
        }

        System.out.println("\n");
        Collections.sort(cartaoDeCredito.getCompras());
        for (Compra c: cartaoDeCredito.getCompras()) {
            System.out.println(c.getNome() + " - R$" + c.getValor());
        }
        System.out.println("\nSaldo do cartão anteriormente: R$" + cartaoDeCredito.getLimite());
        System.out.printf("Saldo atualmente: R$%.2f", cartaoDeCredito.getSaldo());




    }


}
