package JogoDaVelha;


public class ComputadorA extends Computador{

	Tabuleiro tabuleiro = new Tabuleiro();

	//Mensagem de vitória do computador A;
	public void message() {
		System.out.println("Foi uma boa partida!");
	}


	public int coord() {

		int min = 1;
		int max = 9;	

		int random;

		//Retorna uma coordenada aleatória, desde que esta posição não esteja ocupada;




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
