package uninter;
import java.util.Iterator;

public class Tabuleiro 
{
	protected String mat[][] = new String[3][3]; /*matriz do tabuleiro para cada posição que e represetanda por um número*/
	protected boolean jogador = true; /*atributo de controle que identifica a jogada pertence ao jogador humano ou jogador computador*/
	protected boolean fim = false; /*atributo de controle do fim do jogo*/
	protected int jogadas = 0; /*atributo que conta as jogadas e realiza a função de verificar a regra e critério de empate*/
	
	
	/* método que imprime o tabuleiro no console e acrescenta "_" dentro de cada índice do array para as posições do tabuleiro*/
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
	
	// método que imprime o tabuleiro no console e acrescenta o caractere "pipeline" para separar as posições do tabuleiro 
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
	
	/*método para validar a jogada realizada pelo jogador humano */
	protected boolean verificarJogada(int lin, int col) 
	{
	    /* primeiro é verificado se a posição escolhida já está sendo preenchida por alguma jogada anterior*/
		if (mat[lin - 1][col - 1].equals("X") || mat[lin - 1][col - 1].equals("O")) 
		{
			System.out.println("Posições inválidas. Escolha novas posições!");
			return false; /*método: se a posição já foi escolhida, retorna falso, e pede para o jogador repetir a jogada*/
		}
		
		mat[lin - 1][col - 1] = "X"; /*insere "X" no índice do array(na jogada) quando este estiver vazio*/
		
		jogadas++;
		jogador = !jogador; /*atributo que alterna a jogada dos jogadores(humano e computador)*/
		verificar(); /* chama o método para verificar o fim do jogo*/
		return true;
	}
	
	
	/*método de validação da jogada computador*/
	protected boolean verificarJogadaComputador(int lin, int col) 
	{
		
		/*verifica se a posição escolhida foi preenchida por jogada anterior*/
		if (!fim) 
		{
			if (mat[lin][col] != null) 
			{
				if (mat[lin][col].equals("X") || mat[lin][col].equals("O")) 
				{
					return false;
				}
			}
			
			mat[lin][col] = "O"; /*adiciona "O" no indice do array quando for concedido a permissão de jogada*/
			
			jogadas++;
			jogador = !jogador;
		}
		verificar();
		return true;
	}
	
	/*método de análise de regras para os cenários de vitória, derrota e empate*/
	public void verificar() 
	{
		
		// condicional que contem todos os cenários possíveis para a vitória do jogador humano
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
			System.out.println("Vitória do Jogador Humano!");
			fim = true;
		}
		
		/* condicional com cenários possíveis para a vitória do jogador computador*/
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
			System.out.println("Vitória do Jogador Computador!");
		    fim = true;
		}
		
		/*condicional para verificar posições preenchidas para aplicar o empate do jogo*/
		if (jogadas == 9) 
		{
			System.out.println();
			System.out.println("O jogo terminou empatado!");
			fim = true;
		}
	}
	
}
