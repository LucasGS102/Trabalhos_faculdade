package JogoDaVelha;

public class ComputadorC extends Computador{

	int contador;
	int iterador = -1;
	int m = 3;
	int it = 0;
	Tabuleiro tabuleiro = new Tabuleiro();
	
	
	 //p[][] possui jogadas possíveis que o computador C pode fazer;
	 
	private int p[][] = {{7,9,3}, {9,7,3}, {9,7,1}, {7,9,1}, {1,3,9}, 
			{3,1,9}, {5,4,2}, {5,2,4}, {2,6,5}, {8,4,5}, {8,6,5}, {1,3,7} , {3,1,7}};

	
	//Mensagem de vitória do computador C;
	public void message() {
		
		System.out.println("Foi muito fácil, tente outra vez!");
	}
	
	
	/*
	*O seguinte método tem por objetivo verificar as posições, seja do jogador ou do computador, no tabuleiro
	*para verificar se está prestes a ganhar ou não e, e caso positivo, retornar a coordenana que impede a possível vitória;
	*/
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


    //metodo para retornar uma coordenada;
	
	public int coord() {

		int min = 1;
		int max = 9;	
		int k = 0;


		if (verificaPosicao("o") != -1) {
			return verificaPosicao("o");
		};

		if (verificaPosicao("x") != -1) {
			return verificaPosicao("x");
		};

		int contp = 0;
		int posp = -1;
		int f = 0;
		int contv = 0;


		// verifica se é possível uma das jogados de p[][];

		while(f != 1) {

			if (contv == 13) {
				f = 1;
			}

			for (int i = 0; i < p.length; ++i) {

				contp = 0;

				for(int j = 0; j <p[i].length; ++j) {

					for (k = 0; k < Tabuleiro.coord.size(); ++k) {

						if (p[i][j] == Tabuleiro.coord.get(k)) {

							++contp;													
						}
					}

				}

				if (contp == m) {
					--m;
					posp = i;
					

					++iterador;

					if (contador == 3) {
						f = 1;
					}
					return p[posp][iterador];

				}
				else if (contp != m) {
					m = 3;
					iterador = -1;
				}
				++contv;

			}
		}

		//Retorna uma posição aleatória caso os passos acima não sejam executados;

		int random;

		while (true) 
		{
			random = (int)Math.floor(Math.random()*(max-min+1)+min);


			for (int i = 0; i < tabuleiro.getCoord().size(); i++)
			{
				if (random == tabuleiro.getCoord().get(i))
				{

					return random;

				}
			}


		}



	}
}
