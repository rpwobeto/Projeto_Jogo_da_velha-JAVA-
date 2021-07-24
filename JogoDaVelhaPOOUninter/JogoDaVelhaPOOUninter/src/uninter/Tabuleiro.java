package uninter;
import java.util.Iterator;

public class Tabuleiro 
{
	protected String mat[][] = new String[3][3]; /*matriz do tabuleiro para cada posi��o que e represetanda por um n�mero*/
	protected boolean jogador = true; /*atributo de controle que identifica a jogada pertence ao jogador humano ou jogador computador*/
	protected boolean fim = false; /*atributo de controle do fim do jogo*/
	protected int jogadas = 0; /*atributo que conta as jogadas e realiza a fun��o de verificar a regra e crit�rio de empate*/
	
	
	/* m�todo que imprime o tabuleiro no console e acrescenta "_" dentro de cada �ndice do array para as posi��es do tabuleiro*/
	public void visualizarTabuleiro() 
	{
		for (int i = 0; i < mat.length; i++) 
		{
			for (int j = 0; j < mat.length; j++) 
			{
				mat[i][j] = "_";
			}
		}		
	}
	
	// m�todo que imprime o tabuleiro no console e acrescenta o caractere "pipeline" para separar as posi��es do tabuleiro 
	public void atualizarTabuleiro() 
	{
		for (int i = 0; i < mat.length; i++) 
		{
			for (int j = 0; j < mat.length; j++) 
			{
				System.out.print("   " + mat[i][j]);
				if (j < 2) 
				{
					System.out.print("    | ");
				}
			}
			System.out.println();
		}
	}
	
	/*m�todo para validar a jogada realizada pelo jogador humano */
	protected boolean verificarJogada(int lin, int col) 
	{
	    /* primeiro � verificado se a posi��o escolhida j� est� sendo preenchida por alguma jogada anterior*/
		if (mat[lin - 1][col - 1].equals("X") || mat[lin - 1][col - 1].equals("O")) 
		{
			System.out.println("Posi��es inv�lidas. Escolha novas posi��es!");
			return false; /*m�todo: se a posi��o j� foi escolhida, retorna falso, e pede para o jogador repetir a jogada*/
		}
		
		mat[lin - 1][col - 1] = "X"; /*insere "X" no �ndice do array(na jogada) quando este estiver vazio*/
		
		jogadas++;
		jogador = !jogador; /*atributo que alterna a jogada dos jogadores(humano e computador)*/
		verificar(); /* chama o m�todo para verificar o fim do jogo*/
		return true;
	}
	
	
	/*m�todo de valida��o da jogada computador*/
	protected boolean verificarJogadaComputador(int lin, int col) 
	{
		
		/*verifica se a posi��o escolhida foi preenchida por jogada anterior*/
		if (!fim) 
		{
			if (mat[lin][col] != null) 
			{
				if (mat[lin][col].equals("X") || mat[lin][col].equals("O")) 
				{
					return false;
				}
			}
			
			mat[lin][col] = "O"; /*adiciona "O" no indice do array quando for concedido a permiss�o de jogada*/
			
			jogadas++;
			jogador = !jogador;
		}
		verificar();
		return true;
	}
	
	/*m�todo de an�lise de regras para os cen�rios de vit�ria, derrota e empate*/
	public void verificar() 
	{
		
		// condicional que contem todos os cen�rios poss�veis para a vit�ria do jogador humano
		if((mat[0][0] == "X" && mat[0][1] == "X" && mat[0][2] == "X") ||
		   (mat[1][0] == "X" && mat[1][1] == "X" && mat[1][2] == "X") ||
		   (mat[2][0] == "X" && mat[2][1] == "X" && mat[2][2] == "X") ||
		   (mat[0][0] == "X" && mat[1][0] == "X" && mat[2][0] == "X") ||
		   (mat[0][1] == "X" && mat[1][1] == "X" && mat[2][1] == "X") ||
		   (mat[0][0] == "X" && mat[1][1] == "X" && mat[2][2] == "X") ||
		   (mat[0][2] == "X" && mat[1][1] == "X" && mat[2][0] == "X") ||
		   (mat[0][2] == "X" && mat[1][2] == "X" && mat[2][2] == "X") )
		{
			System.out.println();
			System.out.println("Vit�ria do Jogador Humano!");
			fim = true;
		}
		
		/* condicional com cen�rios poss�veis para a vit�ria do jogador computador*/
		if((mat[0][0] == "O" && mat[0][1] == "O" && mat[0][2] == "O") ||
		   (mat[1][0] == "O" && mat[1][1] == "O" && mat[1][2] == "O") ||
		   (mat[2][0] == "O" && mat[2][1] == "O" && mat[2][2] == "O") ||
		   (mat[0][0] == "O" && mat[1][0] == "O" && mat[2][0] == "O") ||
		   (mat[0][1] == "O" && mat[1][1] == "O" && mat[2][1] == "O") ||
		   (mat[0][0] == "O" && mat[1][1] == "O" && mat[2][2] == "O") ||
		   (mat[0][2] == "O" && mat[1][1] == "O" && mat[2][0] == "O") ||
		   (mat[0][2] == "O" && mat[1][2] == "O" && mat[2][2] == "O") )
		{
			System.out.println();
			System.out.println("Vit�ria do Jogador Computador!");
		    fim = true;
		}
		
		/*condicional para verificar posi��es preenchidas para aplicar o empate do jogo*/
		if (jogadas == 9) 
		{
			System.out.println();
			System.out.println("O jogo terminou empatado!");
			fim = true;
		}
	}
	
}
