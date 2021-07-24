package uninter;
import java.util.Scanner;
public class Jogo 

{
	public static void main(String[] args) 
	{
		/*Variavéis e instâncias do jogo declaradas para início do jogo*/
		boolean nivelDoComputadorValido;
		String opcaoDoJogador;
		Scanner teclado = new Scanner(System.in);
		
		Tabuleiro tab = new Tabuleiro();
		Jogador player = new Jogador();
		
		System.out.println("-----------------------------");
		System.out.println("Welcome to the game.");
		System.out.println("Let's Play: JOGO DA VELHA!");
		
		/*Seleciona o nível do computador e repete a seleção caso o jogador selecione uma opção inválida*/
		do 
		{
			System.out.println("-----------------------------");
			System.out.println("Digite o nível do computador.\n1 - Fácil\n2 - Médio\n3 - Difícil ");
			opcaoDoJogador = teclado.next();

			nivelDoComputadorValido = opcaoDoJogador.equals("1") || opcaoDoJogador.equals("2") || opcaoDoJogador.equals("3") ? true : false;
				
			} while (!nivelDoComputadorValido);
				
			Computador comp;
			
		/*Instancia o objeto Computador de acordo com a opção selecionada pelo usuário*/
		if (opcaoDoJogador.equals("1")) 
		{
			comp = new ComputadorA();
		} else if (opcaoDoJogador.equals("2")) 
		{
			comp = new ComputadorB();
		} else
			comp = new ComputadorC();
			
		/*chama o método que imprime o tabuleiro no console*/
		tab.visualizarTabuleiro(); 
		
		/* Laço de repetição do jogo, se repete enquanto houver jogadas possíveis. É controlada pelo atributo booleano "fim" da Classe Tabuleiro */
		do 
		{	
			System.out.println("\nDigite a sua jogada");
			player.jogar(tab); /*chama o método para o jogador humano realizar a sua jogada*/
			comp.jogar(tab); /*chama o método para o jogador computador realizar a sua jogada*/
			tab.atualizarTabuleiro(); /*chama o método que imprime o tabuleiro com as jogadas atualizadas dentro do array*/
			
		} while(!tab.fim);
	}
}

