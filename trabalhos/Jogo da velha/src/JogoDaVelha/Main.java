package JogoDaVelha;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Tabuleiro tabuleiro = new Tabuleiro();
		Jogador jogador = new Jogador("Lucas", 0);
		Computador computador = null;


		Scanner input = new Scanner(System.in);


		System.out.println("###### JOGO DA VELHA ######");
		System.out.print("Digite seu nome: ");
		jogador.setName(input.nextLine());


		System.out.printf("%nEscolha a dificuldade: %n%n1. Fácil%n"
				+ "2. Médio %n3. Difícil%n");

		int difficult = input.nextInt();

		if (difficult == 1) {
			computador = new ComputadorA();
		}
		else if (difficult == 2) {
			computador = new ComputadorB();
		}
		else if (difficult == 3) {
			computador = new ComputadorC();
		}

		int cont = 0;
		
		//Loop que mantém o jogo funcionando enquanto uma das situações não ocorrer (1. Jogador venceu | 0. Computador veceu | -1. Empate);

		while (tabuleiro.situacao() != 1 && tabuleiro.situacao() != 0 && tabuleiro.situacao() != -1) {
			++cont;
			System.out.printf("Rodada %d%n#### Tabuleiro ####%n", cont);
			tabuleiro.visualizar();

			System.out.printf("%nDigite uma coordenada no intervalo 1-9: ");
			int coord = input.nextInt();

			tabuleiro.jogada(jogador.coord(coord), "x");

			System.out.println();
			tabuleiro.visualizar();
			System.out.println();

			if (tabuleiro.situacao() == 1) {
				System.out.printf("%n%nO jogador %s venceu!%n%n", jogador.getName());
				break;
			}
			else if (tabuleiro.situacao() == -1) {
				System.out.printf("%n%nEmpate!%n%n");
				break;
			}

			System.out.printf("%n%n%nVez do computador!%n");
			tabuleiro.jogada(computador.coord(), "o");
			tabuleiro.visualizar();
			System.out.println();

			if (tabuleiro.situacao() == 0) {
				System.out.printf("%n%nVocê perdeu!%n%n");
				computador.message();
				break;
			}
			else if (tabuleiro.situacao() == -1) {
				System.out.printf("%n%nEmpate!%n%n");
				break;
			}

		}



		
		
		






		input.close();
	}

}



