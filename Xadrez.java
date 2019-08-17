public class Xadrez {
  public static void main(String[] args){
    Ponto partida = new Ponto();
    Ponto chegada = new Ponto();
    Tabuleiro tabuleiro = new Tabuleiro();
    tabuleiro.mostra_tabuleiro();
    partida.set_ponto(3, 4);
    chegada.set_ponto(4, 5);
    tabuleiro.jogada(partida, chegada);
    tabuleiro.mostra_tabuleiro();
    partida.set_ponto(4, 4);
    chegada.set_ponto(5, 2);
    tabuleiro.jogada(partida, chegada);
    tabuleiro.mostra_tabuleiro();
    partida.set_ponto(3, 3);
    chegada.set_ponto(5, 5);
    tabuleiro.jogada(partida, chegada);
    tabuleiro.mostra_tabuleiro();
    partida.set_ponto(5, 2);
    chegada.set_ponto(4, 4);
    tabuleiro.jogada(partida, chegada);
    tabuleiro.mostra_tabuleiro();
    partida.set_ponto(3, 4);
    chegada.set_ponto(3, 5);
    tabuleiro.jogada(partida, chegada);
    tabuleiro.mostra_tabuleiro();
    partida.set_ponto(3, 5);
    chegada.set_ponto(3, 4);
    tabuleiro.jogada(partida, chegada);
    tabuleiro.mostra_tabuleiro();
  }
}
