package uninter;
public class ComputadorC extends Tabuleiro implements Computador

{
	private int posicaoLin = 0;
	private int posicaoCol = 0;
	private boolean verificaJogada = false;
	
	/*m�todo que executa a jogada do computador*/
	@Override
	public void jogar(Tabuleiro tab) 
	{
		/*M�todo que realiza jogadas do computador selecionando posi��es(top-Down)a partir da primeira posi��o do array*/
		/*repeti��o que controla a execu��o dos m�todos*/
		do {
			/*fun��o que analisa a validade da jogada e retorna valor booleano de controle do la�o de repeti��o do m�todo*/
			verificaJogada = tab.verificarJogadaComputador(posicaoLin, posicaoCol);
			
			/*condi��o que reinicia a posi��o da linha e incrementa a posi��o da coluna, se as jogadas anteriores forem inv�lidas*/
			if (posicaoLin == 2) 
			{
				/*atribui valor -1 ao final do m�todo que incrementa um valor a mais e reinicia a posi��o da linha*/
				posicaoLin = -1; 
				posicaoCol++;
			}
				
			/*incrementa o valor da linha para executar a pr�xima jogada em posi��o diferente, caso a jogada anterior seja inv�lida*/
			posicaoLin++; 
			
		} while (!verificaJogada);
		
	}
}	
