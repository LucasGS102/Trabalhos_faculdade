package JogoDaVelha;
import java.util.ArrayList;
import java.util.Arrays;


public class Tabuleiro {

	private int contador = 0;
	
	
	//Array com as coordenadas de 1 a 9 do tabuleiro;
	public static ArrayList<Integer> coord = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
	
	//Array de duas dimenções representando cada coordenada que é preenchida;
	public  static String tab[][] = {{" "," "," "}, {" "," "," "},{" "," "," "}};
	
	
	/*
	 O seguinte método tem por objetivo receber uma coordenada 
	 (1-9) e um símbolo (x/o) e preencher tab[][];
	 */
	public void jogada(int coo, String jogador) {
		
		++contador;
			
		switch(coo) {
		
			case 1:
				tab[0][0] = jogador;
				coord.set(coo-1, 0);
				break;
			case 2:
				tab[0][1] = jogador;
				coord.set(coo-1, 0);
				break;
			case 3:
				tab[0][2] = jogador;
				coord.set(coo-1, 0);
				break;
			case 4:
				tab[1][0] = jogador;
				coord.set(coo-1, 0);
				break;
			case 5:
				tab[1][1] = jogador;
				coord.set(coo-1, 0);
				break;
			case 6:
				tab[1][2] = jogador;
				coord.set(coo-1, 0);
				break;
			case 7:
				tab[2][0] = jogador;
				coord.set(coo-1, 0);
				break;
			case 8:
				tab[2][1] = jogador;
				coord.set(coo-1, 0);
				break;
			case 9:
				tab[2][2] = jogador;
				coord.set(coo-1, 0);
				break;
				
		}
	}
	
	//Retorna a ArrayList coord com as coordenadas disponíveis;
	
	public ArrayList<Integer> getCoord()
	{
		ArrayList<Integer> c = new ArrayList<Integer>(coord);
		
		return c;
	}
	
	//Permite a visualização do tabuleiro;
	
	public void visualizar(){
		for(int i = 0; i < tab.length; i++) {
			System.out.print(" ");
			for(int j = 0; j < tab[i].length; j++) {
				if (tab[i][j] == "x") {
					
					if (j+1< tab[i].length) {
						System.out.print("X | ");
					}
					else
					{
						System.out.println("X ");
					}
					
				}
				
				else {
					if (j+1< tab[i].length) {
						System.out.print(tab[i][j] + " | ");
					}
					else {
						System.out.println(tab[i][j]);
					}
				}
				
			}
			
			if (i+1 < tab.length)
			{
				System.out.println("------------");
			}
			
		}
	}
	
	//Retorna valores correspondentes à situação do jogo;
	public int situacao() {
		
		//Laço que verifica linhas e colunas para saber se alguém ganhou;
		
		for(int i = 0; i < tab.length;++i) {
			int contjC = 0;
			int contjL = 0;
			int contcC = 0;
			int contcL = 0;
			
			for(int j = 0; j < tab[i].length;++j) {
							
					if (tab[i][j].toLowerCase() == "x")
					{
						++contjL;
					}
					else if (tab[i][j].toLowerCase() == "o")
					{
						++contcL;
						
					}

					if (tab[j][i].toLowerCase() == "x")
					{
						++contjC;
					}
					else if (tab[j][i].toLowerCase() == "o")
					{
						++contcC;
					}
					
					
							
			}
			
			
			
			if (contcC == 3 )
			{
				return 0;
				
			}
			else if (contcL == 3)
			{
				return 0;
			}
			else if (contjC == 3)
			{
				return 1;
			}
			else if (contjL == 3)
			{
				return 1;
			}
		}
		
		
		//Verifica as diagonais do tabuleiro;
		
		if (tab[0][0]== "x" && tab[1][1] == tab[0][0] && tab[0][0] == tab[2][2]) {
			return 1;
		}
		else if (tab[0][0] == "o" && tab[1][1] == tab[0][0] && tab[0][0] == tab[2][2]) {
			return 0;
		}
		else if (tab[0][2] == "o" && tab[1][1] == tab[2][0] && tab[1][1] == tab[0][2]) {
			return 0;
		}
		else if (tab[0][2] == "x" && tab[1][1] == tab[2][0] && tab[1][1] == tab[0][2]) {
			return 1;
		}
		
		else if (contador == 9) {
			return -1;
		}
		

		return 3;
		
	}
	
	
	
}
