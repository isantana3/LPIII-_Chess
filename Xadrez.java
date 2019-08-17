import java.util.Scanner;

public class Xadrez {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    Ponto partida = new Ponto();
    Ponto chegada = new Ponto();
    Tabuleiro tabuleiro = new Tabuleiro();
    int x;
    int y;
    tabuleiro.mostra_tabuleiro();
    for(int i=0;i<100; i++){
      System.out.print("X1 = ");
      x = input.nextInt();
      System.out.print("Y1 = ");
      y = input.nextInt();
      partida.set_ponto(x, y);
      System.out.print("X2 = ");
      x = input.nextInt();
      System.out.print("Y2 = ");
      y = input.nextInt();
      chegada.set_ponto(x, y);
      tabuleiro.jogada(partida, chegada);
      tabuleiro.mostra_tabuleiro();
    }
  }
}
