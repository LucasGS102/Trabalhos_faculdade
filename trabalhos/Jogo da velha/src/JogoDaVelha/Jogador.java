package JogoDaVelha;

import java.util.Scanner;

public class Jogador {

	private String nome;
	private int pontuacao;
	private Scanner input = new Scanner(System.in);
	
	
	Tabuleiro tabuleiro = new Tabuleiro();
	
	public Jogador(String nome, int pont)
	{
		this.nome = nome;
		this.pontuacao = pont;
	}
	
	public void setName(String name)
	{
		nome = name;
	}
	
	public String getName()
	{
		return nome;
	}
	
	/*
	*Verifica se a coordenada digitada está preenchida, se não estiver, retorna,
	*caso esteja ocupada pede uma nova coordenada e só sai do loop caso seja digitado uma coordenada correta;
	*/
	public int coord(int c)
	{
		
		while(true)
		{
			
			for (int i = 0; i < tabuleiro.getCoord().size(); i++)
			{
				if (c == tabuleiro.getCoord().get(i))
				{
					return c;
				}
			}
						
			System.out.println("Este lugar já está preenchido, escolha outro!");
			System.out.print("Digite uma coordenada: ");
			c = input.nextInt();
			
		}
	}
}
