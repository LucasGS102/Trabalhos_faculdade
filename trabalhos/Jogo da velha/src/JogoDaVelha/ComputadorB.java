package JogoDaVelha;

public class ComputadorB extends Computador {

	Tabuleiro tabuleiro = new Tabuleiro();
	private int coord;
	
	//Mensagem de vitória do computador B;
	public void message() {
		System.out.println("Foi um bom jogo, tente melhorar na próxima!");
	}
	
	private int verificaPosicao(String jogador) {

		int contC = 1;
		int cont = 1;
		int k = 0;
		int pos = 0;


		//Loop que verifica as colunas e as linhas para saber se o jogador ou o computador estão prestes a ganhar;
		for(int i = 0; i < Tabuleiro.tab.length;++i) {



			int contjC = 0;
			int contjL = 0;
			int contNullL = 0;
			int contNullC = 0;
			int coordL = 0;
			int coordC = 0;


			for(int j = 0; j < Tabuleiro.tab[i].length;++j) {


				if (Tabuleiro.tab[i][j] == jogador)
				{
					++contjL;

				}
				else if (Tabuleiro.tab[i][j] == " ")
				{
					++contNullL;
					coordL = cont;
				}
				if (Tabuleiro.tab[j][i] == jogador)
				{
					++contjC;

				}
				else if (Tabuleiro.tab[j][i] == " ")
				{
					++contNullC;
					coordC = contC;
				}

				contC += 3;
				++cont;

			}

			contC -= 8;

			if (contjL == 2 && contNullL == 1)
			{
				return coordL;
			}

			else if (contjC == 2 && contNullC == 1)
			{
				return coordC;
			}


		}

		// Segue o mesmo propósito do primeiro, mas verifica as diagonais;

		int coordP = 0;
		int coordS = 0;
		int contDP = 0;
		int contDS = 0;
		int contNullP = 0;
		int contNullS = 0;
		int l = 2;
		int contP = 1;
		int contS = 3;	

		for (k = 0; k <3; ++k) {


			if (Tabuleiro.tab[k][k].toLowerCase() == jogador)
			{
				++contDP;

			}
			else if (Tabuleiro.tab[k][k].toLowerCase() == " ")
			{
				++contNullP;
				coordP = contP;
			}

			if (Tabuleiro.tab[k][l].toLowerCase() == jogador)
			{
				++contDS;
			}
			else if (Tabuleiro.tab[k][l].toLowerCase() == " ")
			{
				++contNullS;
				coordS = contS;
			}



			contS += 2;
			contP += 4;
			--l;
		}



		if (contDP == 2 && contNullP == 1)
		{
			return  coordP;
		}

		else if (contDS == 2 && contNullS == 1) {
			return  coordS;
		}

		return -1;
	}
	
	public int coord() {


		int min = 1;
		int max = 9;
		
		if(verificaPosicao("o") != -1) {
			return verificaPosicao("o");
		};
		
		if(verificaPosicao("x") != -1) {
			return verificaPosicao("x");
		};
		
		int random;
		
			while (true) 
			{
				random = (int)Math.floor(Math.random()*(max-min+1)+min);
	
	
				for (int i = 0; i < tabuleiro.getCoord().size(); i++)
				{
					if (random == tabuleiro.getCoord().get(i))
					{
						
						return  random;
						
					}
				}
				
	
	
			
		}
		




	}
}

