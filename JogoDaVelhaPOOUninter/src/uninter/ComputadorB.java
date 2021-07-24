package uninter;
public class ComputadorB extends Tabuleiro implements Computador 
{
	private int posicaoLin = 2;
	private int posicaoCol = 2;
	private boolean verificaJogada = false;
	
	/*método que realiza a jogada do computador*/ 
	@Override
	public void jogar(Tabuleiro tab) 
	{
		/*Método que realiza jogadas do computador selecionando posições(Down-Top)a partir da última posição do array*/
		/*repetição que controla a execução dos métodos*/
		do {
			/*função que analisa a validade da jogada e retorna valor booleano de controle do laço de repetição do método*/	
			verificaJogada = tab.verificarJogadaComputador(posicaoLin, posicaoCol);
			
			/*condição que reinicia a posição da linha e decresce a posição da coluna, se as jogadas anteriores forem inválidas*/
			if (posicaoLin == 0) 
			{
				/*atribui valor 3 pois ao final do método decresce um valor e reinicia a posição da linha*/
				posicaoLin = 3; 
				posicaoCol--;
			}
				
			/*decresce o valor da linha para executar a próxima jogada em posição diferente, caso a jogada anterior seja inválida*/
			posicaoLin--;
			
		} while (!verificaJogada);
	}
}
