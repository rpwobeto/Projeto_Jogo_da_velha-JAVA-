package uninter;
import java.util.Scanner;
public class Jogo 

{
	public static void main(String[] args) 
	{
		/*Variav�is e inst�ncias do jogo declaradas para in�cio do jogo*/
		boolean nivelDoComputadorValido;
		String opcaoDoJogador;
		Scanner teclado = new Scanner(System.in);
		
		Tabuleiro tab = new Tabuleiro();
		Jogador player = new Jogador();
		
		System.out.println("-----------------------------");
		System.out.println("Welcome to the game.");
		System.out.println("Let's Play: JOGO DA VELHA!");
		
		/*Seleciona o n�vel do computador e repete a sele��o caso o jogador selecione uma op��o inv�lida*/
		do 
		{
			System.out.println("-----------------------------");
			System.out.println("Digite o n�vel do computador.\n1 - F�cil\n2 - M�dio\n3 - Dif�cil ");
			opcaoDoJogador = teclado.next();

			nivelDoComputadorValido = opcaoDoJogador.equals("1") || opcaoDoJogador.equals("2") || opcaoDoJogador.equals("3") ? true : false;
				
			} while (!nivelDoComputadorValido);
				
			Computador comp;
			
		/*Instancia o objeto Computador de acordo com a op��o selecionada pelo usu�rio*/
		if (opcaoDoJogador.equals("1")) 
		{
			comp = new ComputadorA();
		} else if (opcaoDoJogador.equals("2")) 
		{
			comp = new ComputadorB();
		} else
			comp = new ComputadorC();
			
		/*chama o m�todo que imprime o tabuleiro no console*/
		tab.visualizarTabuleiro(); 
		
		/* La�o de repeti��o do jogo, se repete enquanto houver jogadas poss�veis. � controlada pelo atributo booleano "fim" da Classe Tabuleiro */
		do 
		{	
			System.out.println("\nDigite a sua jogada");
			player.jogar(tab); /*chama o m�todo para o jogador humano realizar a sua jogada*/
			comp.jogar(tab); /*chama o m�todo para o jogador computador realizar a sua jogada*/
			tab.atualizarTabuleiro(); /*chama o m�todo que imprime o tabuleiro com as jogadas atualizadas dentro do array*/
			
		} while(!tab.fim);
	}
}

