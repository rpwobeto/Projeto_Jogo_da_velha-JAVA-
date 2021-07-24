package uninter;
import java.util.Scanner;
public class Jogador extends Tabuleiro

{	
	/* atributos para validar a sele��o do jogador humano*/
	private boolean verL = false;
	private boolean verC = false;
	
	/* m�todo que realiza a jogada do jogador humano*/
	public void jogar(Tabuleiro tab) 
	{
		Scanner teclado = new Scanner(System.in);
		int lin, col;
		boolean verificaPosicao = false; /*booleano = controle do la�o de repeti��o da jogada do jogador humano*/
		
		while(!verificaPosicao) /*la�o de repeti��o que coleta a linha da jogada do jogador humano*/
		{
			do 
			{
				System.out.println("Linha(1, 2 ou 3): ");
				lin = teclado.nextInt();
				
				if (lin < 4 && lin > 0) /*condi��o que verifica se o usu�rio escolheu linha v�lida em rela��o a quantidade de �ndices no array*/
				{
					verL = true;
				}
			} while (!verL);
			
					
			/* la�o de repeti��o que coleta a coluna escolhida pelo jogador humano*/
			do 
			{
				System.out.println("Coluna(1, 2 ou 3): ");
				col = teclado.nextInt();
				/*condi��o que verifica se o usu�rio escolheu coluna v�lida em rela��o a quantidade de �ndices no array*/
				if (col < 4 && col > 0) 
				{
					verC = true;
				}
			} while (!verC);
			
			/*fun��o que analisa a validade da jogada e retorna um valor booleano que controla o la�o de repeti��o do m�todo*/
			verificaPosicao = tab.verificarJogada(lin, col); 
		}
	}		
}
