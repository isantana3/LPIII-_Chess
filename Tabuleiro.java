public class Tabuleiro {
  private Peca matriz[][] = new Peca[8][8];
  private boolean jogador_branco = true;
  private Ponto rei_branco_ponto = new Ponto(1, 1);
  private Rei rei_branco = new Rei("B", rei_branco_ponto);
  private Ponto rei_preto_ponto = new Ponto(0, 0);
  private Rei rei_preto = new Rei("P", rei_preto_ponto);
  private Ponto cavalo_branco_ponto = new Ponto(4, 4);
  private Cavalo cavalo_branco = new Cavalo("B", cavalo_branco_ponto);
  private Ponto cavalo_preto_ponto = new Ponto(5, 6);
  private Cavalo cavalo_preto = new Cavalo("P", cavalo_preto_ponto);
  private Ponto torre_branco_ponto = new Ponto(3, 4);
  private Torre torre_branco = new Torre("B", torre_branco_ponto);
  private Ponto torre_preto_ponto = new Ponto(6, 6);
  private Torre torre_preto = new Torre("P", torre_preto_ponto);
  private Ponto bispo_branco_ponto = new Ponto(7, 7);
  private Bispo bispo_branco = new Bispo("B", bispo_branco_ponto);
  private Ponto bispo_preto_ponto = new Ponto(3, 3);
  private Bispo bispo_preto = new Bispo("P", bispo_preto_ponto);

  /*
  Construtor: Monta o tabuleiro de acordo com os Pontos no lugar inicial de cada peça.
  */
  public Tabuleiro(){
    matriz[rei_branco_ponto.get_x()][rei_branco_ponto.get_y()]=rei_branco;
    matriz[rei_preto_ponto.get_x()][rei_preto_ponto.get_y()]=rei_preto;
    matriz[cavalo_branco_ponto.get_x()][cavalo_branco_ponto.get_y()]=cavalo_branco;
    matriz[cavalo_preto_ponto.get_x()][cavalo_preto_ponto.get_y()]=cavalo_preto;
    matriz[torre_branco_ponto.get_x()][torre_branco_ponto.get_y()]=torre_branco;
    matriz[torre_preto_ponto.get_x()][torre_preto_ponto.get_y()]=torre_preto;
    matriz[bispo_branco_ponto.get_x()][bispo_branco_ponto.get_y()]=bispo_branco;
    matriz[bispo_preto_ponto.get_x()][bispo_preto_ponto.get_y()]=bispo_preto;
  }

  /*
  Função: Realiza uma jogada após:
  1.Verifica se o jogador da vez escolheu Peca própria.
  2.Verifica se o Ponto de chegada está contido no Tabuleiro e nos movimentos válidos da Peca de partida.
  3.Realiza a troca de posições se 1 e 2 verdadeiros.
  4.Muda a vez do jogador se 1 e 2 verdadeiros.
  Entrada: Ponto de partida e Ponto de chegada dentro do Tabuleiro.
  Saída: True se a jogada for realizada.
         False se não.
  */
  public boolean jogada(Ponto partida, Ponto chegada){
    if(this.vez_jogador(partida)){
      if(this.verifica_ponto(chegada)){
        if(matriz[partida.get_x()][partida.get_y()].set_posicao(chegada, matriz)){
          matriz[chegada.get_x()][chegada.get_y()]=matriz[partida.get_x()][partida.get_y()];
          matriz[partida.get_x()][partida.get_y()]=null;
          jogador_branco = !jogador_branco;
          return true;
        }
      }
    }
    return false;
  }

  /*
  Função: Verifica se o jogador da vez selecionou uma peça própria
  Entrada: Ponto de partida inserido pelo usuário
  Saída: True se for peça branca e vez do jogador branco ou
         peça preta e vez do jogador preto
  */
  private boolean vez_jogador(Ponto p){
    if(this.verifica_ponto(p)){
      if(this.matriz[p.get_x()][p.get_y()]!=null){
        if(this.jogador_branco==true && this.matriz[p.get_x()][p.get_y()].get_cor().equals("B") || this.jogador_branco==false && this.matriz[p.get_x()][p.get_y()].get_cor().equals("P")){
          return true;
        }
      }
    }
    return false;
  }

  /*
  Função: Verifica se valores x e y do Ponto estão nos limites do tabuleiro
  Entrada: Ponto
  Saída: True se Ponto esta no tabuleiro 8x8
         False se está fora do tabuleiro
  */
  private boolean verifica_ponto(Ponto p){
    if(p.get_x()>=0 && p.get_x()<8 && p.get_y()>=0 && p.get_y()<8){
      return true;
    }
    return false;
  }

  /*
  Função: Printa matriz de Pecas e vez do jogador.
  */
  public void mostra_tabuleiro(){
    if(this.jogador_branco)
      System.out.println("Jogador da vez: Branco");
    else
      System.out.println("Jogador da vez: Preto");
    for(int i=0;i<8;i++){
      for(int j=0;j<8;j++){
        if(this.matriz[j][i]==null){
          System.out.print("[  ]");
        }
        else
          System.out.print("["+this.matriz[j][i]+"]");
      }
      System.out.println();
    }
    System.out.println();
  }

  public Peca[][] get_matriz(){
    return this.matriz;
  }
}
