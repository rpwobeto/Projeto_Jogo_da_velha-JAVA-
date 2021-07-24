package uninter;
import java.util.Scanner;
public class Jogador extends Tabuleiro

{	
	/* atributos para validar a seleção do jogador humano*/
	private boolean verL = false;
	private boolean verC = false;
	
	/* método que realiza a jogada do jogador humano*/
	public void jogar(Tabuleiro tab) 
	{
		Scanner teclado = new Scanner(System.in);
		int lin, col;
		boolean verificaPosicao = false; /*booleano = controle do laço de repetição da jogada do jogador humano*/
		
		while(!verificaPosicao) /*laço de repetição que coleta a linha da jogada do jogador humano*/
		{
			do 
			{
				System.out.println("Linha(1, 2 ou 3): ");
				lin = teclado.nextInt();
				
				if (lin < 4 && lin > 0) /*condição que verifica se o usuário escolheu linha válida em relação a quantidade de índices no array*/
				{
					verL = true;
				}
			} while (!verL);
			
					
			/* laço de repetição que coleta a coluna escolhida pelo jogador humano*/
			do 
			{
				System.out.println("Coluna(1, 2 ou 3): ");
				col = teclado.nextInt();
				/*condição que verifica se o usuário escolheu coluna válida em relação a quantidade de índices no array*/
				if (col < 4 && col > 0) 
				{
					verC = true;
				}
			} while (!verC);
			
			/*função que analisa a validade da jogada e retorna um valor booleano que controla o laço de repetição do método*/
			verificaPosicao = tab.verificarJogada(lin, col); 
		}
	}		
}
