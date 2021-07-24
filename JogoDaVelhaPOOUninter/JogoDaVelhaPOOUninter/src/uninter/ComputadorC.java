package uninter;
public class ComputadorC extends Tabuleiro implements Computador

{
	private int posicaoLin = 0;
	private int posicaoCol = 0;
	private boolean verificaJogada = false;
	
	/*método que executa a jogada do computador*/
	@Override
	public void jogar(Tabuleiro tab) 
	{
		/*Método que realiza jogadas do computador selecionando posições(top-Down)a partir da primeira posição do array*/
		/*repetição que controla a execução dos métodos*/
		do {
			/*função que analisa a validade da jogada e retorna valor booleano de controle do laço de repetição do método*/
			verificaJogada = tab.verificarJogadaComputador(posicaoLin, posicaoCol);
			
			/*condição que reinicia a posição da linha e incrementa a posição da coluna, se as jogadas anteriores forem inválidas*/
			if (posicaoLin == 2) 
			{
				/*atribui valor -1 ao final do método que incrementa um valor a mais e reinicia a posição da linha*/
				posicaoLin = -1; 
				posicaoCol++;
			}
				
			/*incrementa o valor da linha para executar a próxima jogada em posição diferente, caso a jogada anterior seja inválida*/
			posicaoLin++; 
			
		} while (!verificaJogada);
		
	}
}	
