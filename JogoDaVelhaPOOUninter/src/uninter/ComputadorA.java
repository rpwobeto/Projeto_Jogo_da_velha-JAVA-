package uninter;
import java.util.Random;
import java.util.Scanner;

public class ComputadorA extends Tabuleiro implements Computador 
{
	private int lin, col;
	private boolean verificaJogada = false;
	private Random gerador = new Random();
	
	/*m�todo que realiza a jogada do computador*/
	@Override
	public void jogar(Tabuleiro tab) 
	{
		/* repeti��o que controla o executar dos m�todos*/
		do {
			/* gera um valor de forma aleat�ria para linha e coluna*/
			lin = gerador.nextInt(3);
			col = gerador.nextInt(3);
			
			/*fun��o que analisa se a jogada � permitida e retorna valor booleano que controla o la�o de repeti��o do m�todo*/
			verificaJogada = tab.verificarJogadaComputador(lin, col);
		} while(!verificaJogada);
	}	
}
