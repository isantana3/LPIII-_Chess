public class Xadrez {
  public static void main(String[] args){
    Ponto partida = new Ponto();
    Ponto chegada = new Ponto();
    partida.set_ponto(1, 1);
    chegada.set_ponto(9, 0);
    Tabuleiro tabuleiro = new Tabuleiro();
    tabuleiro.monta_tabuleiro();
    tabuleiro.mostra_tabuleiro();
    tabuleiro.jogada(partida, chegada);
    tabuleiro.mostra_tabuleiro();
  }
}
