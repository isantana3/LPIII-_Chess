public class Tabuleiro {
  private Peca matriz[][] = new Peca[8][8];
  private boolean jogador_branco = true;
  private Rei rei_branco = new Rei("B");
  private Rei rei_preto = new Rei("P");
  private Rainha rainha_branco = new Rainha("B");
  private Rainha rainha_preto = new Rainha("P");
  private Cavalo cavalo_preto = new Cavalo("P");
  private Cavalo cavalo_branco = new Cavalo("B");
  private Torre torre_preto = new Torre("P");
  private Torre torre_branco = new Torre("B");
  private Bispo bispo_preto = new Bispo("P");
  private Bispo bispo_branco = new Bispo("B");
  private Peao peao_preto = new Peao("P");
  private Peao peao_branco = new Peao("B");

  /*
  Construtor: Monta o tabuleiro de acordo com os Pontos no lugar inicial de cada peça.
  */
  public Tabuleiro(){
    this.matriz[0][0]=torre_preto;
    this.matriz[1][0]=cavalo_preto;
    this.matriz[2][0]=bispo_preto;
    this.matriz[3][0]=rei_preto;
    this.matriz[4][0]=rainha_preto;
    this.matriz[5][0]=bispo_preto;
    this.matriz[6][0]=cavalo_preto;
    this.matriz[7][0]=torre_preto;
    this.matriz[0][1]=peao_preto;
    this.matriz[1][1]=peao_preto;
    this.matriz[2][1]=peao_preto;
    this.matriz[3][1]=peao_preto;
    this.matriz[4][1]=peao_preto;
    this.matriz[5][1]=peao_preto;
    this.matriz[6][1]=peao_preto;
    this.matriz[7][1]=peao_preto;
    this.matriz[0][7]=torre_branco;
    this.matriz[1][7]=cavalo_branco;
    this.matriz[2][7]=bispo_branco;
    this.matriz[3][7]=rei_branco;
    this.matriz[4][7]=rainha_branco;
    this.matriz[5][7]=bispo_branco;
    this.matriz[6][7]=cavalo_branco;
    this.matriz[7][7]=torre_branco;
    this.matriz[0][6]=peao_branco;
    this.matriz[1][6]=peao_branco;
    this.matriz[2][6]=peao_branco;
    this.matriz[3][6]=peao_branco;
    this.matriz[4][6]=peao_branco;
    this.matriz[5][6]=peao_branco;
    this.matriz[6][6]=peao_branco;
    this.matriz[7][6]=peao_branco;
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
        if(this.matriz[partida.get_x()][partida.get_y()].set_posicao(partida, chegada, this.matriz)){
          this.matriz[chegada.get_x()][chegada.get_y()]=this.matriz[partida.get_x()][partida.get_y()];
          this.matriz[partida.get_x()][partida.get_y()]=null;
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
