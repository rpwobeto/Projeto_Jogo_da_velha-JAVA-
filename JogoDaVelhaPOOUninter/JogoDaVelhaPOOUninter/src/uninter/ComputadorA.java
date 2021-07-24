package uninter;
import java.util.Random;
import java.util.Scanner;

public class ComputadorA extends Tabuleiro implements Computador 
{
	private int lin, col;
	private boolean verificaJogada = false;
	private Random gerador = new Random();
	
	/*método que realiza a jogada do computador*/
	@Override
	public void jogar(Tabuleiro tab) 
	{
		/* repetição que controla o executar dos métodos*/
		do {
			/* gera um valor de forma aleatória para linha e coluna*/
			lin = gerador.nextInt(3);
			col = gerador.nextInt(3);
			
			/*função que analisa se a jogada é permitida e retorna valor booleano que controla o laço de repetição do método*/
			verificaJogada = tab.verificarJogadaComputador(lin, col);
		} while(!verificaJogada);
	}	
}
