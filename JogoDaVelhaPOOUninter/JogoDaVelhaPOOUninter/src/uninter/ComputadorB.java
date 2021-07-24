package uninter;
public class ComputadorB extends Tabuleiro implements Computador 
{
	private int posicaoLin = 2;
	private int posicaoCol = 2;
	private boolean verificaJogada = false;
	
	/*m�todo que realiza a jogada do computador*/ 
	@Override
	public void jogar(Tabuleiro tab) 
	{
		/*M�todo que realiza jogadas do computador selecionando posi��es(Down-Top)a partir da �ltima posi��o do array*/
		/*repeti��o que controla a execu��o dos m�todos*/
		do {
			/*fun��o que analisa a validade da jogada e retorna valor booleano de controle do la�o de repeti��o do m�todo*/	
			verificaJogada = tab.verificarJogadaComputador(posicaoLin, posicaoCol);
			
			/*condi��o que reinicia a posi��o da linha e decresce a posi��o da coluna, se as jogadas anteriores forem inv�lidas*/
			if (posicaoLin == 0) 
			{
				/*atribui valor 3 pois ao final do m�todo decresce um valor e reinicia a posi��o da linha*/
				posicaoLin = 3; 
				posicaoCol--;
			}
				
			/*decresce o valor da linha para executar a pr�xima jogada em posi��o diferente, caso a jogada anterior seja inv�lida*/
			posicaoLin--;
			
		} while (!verificaJogada);
	}
}
