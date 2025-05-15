package trabalhojokenpo;

import java.util.Random;
import java.util.Scanner;

/**
 *aluno.saolucas Davi Kleemann
 */
public class TrabalhoJokenpo {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Random gerar = new Random();
        int jogadorVitorias = 0, computadorVitorias = 0;
        System.out.println("Bem vindo ao jogo Pedra, Papel ou Tesoura!");
        System.out.println("Escolha uma das opções: ");
        System.out.println("0 → Pedra | 1 → Papel | 2 → Tesoura | 9 → Sair");

        while (true) {
            System.out.println("Sua escolha: ");
            int jogador = ler.nextInt();
            if (jogador == 9) {
                System.out.println("Obrigado por jogar, volte sempre!");
                System.out.println("Placar final: jogador " + jogadorVitorias + " x " + computadorVitorias + " computador");
                break;
            }
            if (jogador < 0 || jogador > 2) {
                System.out.println("A escolha é inválida!");
                continue;
            }
            int computador = gerar.nextInt(3);
            System.out.println("O computador escolheu: " + traduzJogada(computador));
            String resultado = definirResultado(jogador, computador);
            System.out.println("Resultado da rodada: " + resultado);
            if (resultado.equals("Vitória")) {
                jogadorVitorias++;
            }
            if (resultado.equals("Derrota")) {
                computadorVitorias++;
            }

        }

    }

    public static String traduzJogada(int escolha) {
        String resultOp;
        switch (escolha) {
            case 0:
                resultOp = "Pedra";
                break;
            case 1:
                resultOp = "Papel";
                break;
            case 2:
                resultOp = "Tesoura";
                break;
            default:
                resultOp = "A opção é inválida";
                break;
        }
        return resultOp;
    }

    public static String definirResultado(int jogador, int computador) {
        if (jogador == computador) {
            return "Empate";
        } else if ((jogador == 0 && computador == 2)
                || (jogador == 1 && computador == 0)
                || (jogador == 2 && computador == 1)) {
            return "Vitória";
        } else {
            return "Derrota";
        }
    }
}
