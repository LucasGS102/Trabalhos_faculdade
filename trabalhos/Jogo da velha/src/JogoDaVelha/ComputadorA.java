package JogoDaVelha;


public class ComputadorA extends Computador{

	Tabuleiro tabuleiro = new Tabuleiro();

	//Mensagem de vit�ria do computador A;
	public void message() {
		System.out.println("Foi uma boa partida!");
	}


	public int coord() {

		int min = 1;
		int max = 9;	

		int random;

		//Retorna uma coordenada aleat�ria, desde que esta posi��o n�o esteja ocupada;




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
