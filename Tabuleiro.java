public class Tabuleiro {
  private Peca matriz[][] = new Peca[8][8];
  private boolean jogador_branco = true;
  private boolean reis_vivos = true;
  private boolean apaga_passant = false;
  private Ponto ponto_passant = new Ponto();
  private Rei rei_branco = new Rei("B");
  private Rei rei_preto = new Rei("P");
  private Rainha rainha_branco = new Rainha("B");
  private Rainha rainha_preto = new Rainha("P");
  private Cavalo cavalo_preto = new Cavalo("P");
  private Cavalo cavalo_branco = new Cavalo("B");
  private Torre torre_preto_1 = new Torre("P");
  private Torre torre_branco_1 = new Torre("B");
  private Torre torre_preto_2 = new Torre("P");
  private Torre torre_branco_2 = new Torre("B");
  private Bispo bispo_preto = new Bispo("P");
  private Bispo bispo_branco = new Bispo("B");
  private Peao peao_preto_1 = new Peao("P");
  private Peao peao_preto_2 = new Peao("P");
  private Peao peao_preto_3 = new Peao("P");
  private Peao peao_preto_4 = new Peao("P");
  private Peao peao_preto_5 = new Peao("P");
  private Peao peao_preto_6 = new Peao("P");
  private Peao peao_preto_7 = new Peao("P");
  private Peao peao_preto_8 = new Peao("P");
  private Peao peao_branco_1 = new Peao("B");
  private Peao peao_branco_2 = new Peao("B");
  private Peao peao_branco_3 = new Peao("B");
  private Peao peao_branco_4 = new Peao("B");
  private Peao peao_branco_5 = new Peao("B");
  private Peao peao_branco_6 = new Peao("B");
  private Peao peao_branco_7 = new Peao("B");
  private Peao peao_branco_8 = new Peao("B");

  /*
  Construtor: Monta o tabuleiro de acordo com os Pontos no lugar inicial de cada peça.
  */
  public Tabuleiro(){
    this.matriz[0][0]=torre_preto_1;
    this.matriz[1][0]=cavalo_preto;
    this.matriz[2][0]=bispo_preto;
    this.matriz[3][0]=rei_preto;
    this.matriz[4][0]=rainha_preto;
    this.matriz[5][0]=bispo_preto;
    this.matriz[6][0]=cavalo_preto;
    this.matriz[7][0]=torre_preto_2;
    this.matriz[0][1]=peao_preto_1;
    this.matriz[1][1]=peao_preto_2;
    this.matriz[2][1]=peao_preto_3;
    this.matriz[3][1]=peao_preto_4;
    this.matriz[4][1]=peao_preto_5;
    this.matriz[5][1]=peao_preto_6;
    this.matriz[6][1]=peao_preto_7;
    this.matriz[7][1]=peao_preto_8;
    this.matriz[0][7]=torre_branco_1;
    this.matriz[1][7]=cavalo_branco;
    this.matriz[2][7]=bispo_branco;
    this.matriz[3][7]=rei_branco;
    this.matriz[4][7]=rainha_branco;
    this.matriz[5][7]=bispo_branco;
    this.matriz[6][7]=cavalo_branco;
    this.matriz[7][7]=torre_branco_2;
    this.matriz[0][6]=peao_branco_1;
    this.matriz[1][6]=peao_branco_2;
    this.matriz[2][6]=peao_branco_3;
    this.matriz[3][6]=peao_branco_4;
    this.matriz[4][6]=peao_branco_5;
    this.matriz[5][6]=peao_branco_6;
    this.matriz[6][6]=peao_branco_7;
    this.matriz[7][6]=peao_branco_8;
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
  public void jogada(Ponto partida, Ponto chegada){
    this.apaga_passant=false;
    if(this.verifica_enPassant()){
      this.apaga_passant=true;
    }
    if(this.vez_jogador(partida) && this.verifica_ponto(chegada)){
      switch (this.matriz[partida.get_x()][partida.get_y()].set_posicao(partida, chegada, this.matriz)){
        case 0:
          this.apaga_passant=false;
          break;
        case 1: //NORMAL
          if(this.matriz[chegada.get_x()][chegada.get_y()]!=null && (this.matriz[chegada.get_x()][chegada.get_y()].toString().equals("KB") || this.matriz[chegada.get_x()][chegada.get_y()].toString().equals("KP"))){
            this.reis_vivos=false;
          }
          this.matriz[chegada.get_x()][chegada.get_y()]=this.matriz[partida.get_x()][partida.get_y()];
          this.matriz[partida.get_x()][partida.get_y()]=null;
          this.jogador_branco = !this.jogador_branco;
          break;
        case 2: //ROQUE PRA ESQUERDA
          this.matriz[chegada.get_x()][chegada.get_y()]=this.matriz[partida.get_x()][partida.get_y()];
          this.matriz[partida.get_x()][partida.get_y()]=null;
          this.matriz[chegada.get_x()+1][chegada.get_y()]=this.matriz[0][chegada.get_y()];
          this.matriz[0][chegada.get_y()]=null;
          this.jogador_branco = !this.jogador_branco;
          break;
        case 3: //ROQUE PRA DIREITA
          this.matriz[chegada.get_x()][chegada.get_y()]=this.matriz[partida.get_x()][partida.get_y()];
          this.matriz[partida.get_x()][partida.get_y()]=null;
          this.matriz[chegada.get_x()-1][chegada.get_y()]=this.matriz[7][chegada.get_y()];
          this.matriz[7][chegada.get_y()]=null;
          this.jogador_branco = !this.jogador_branco;
          break;
        case 4: //EN PASSANT PEAO PRETO
          this.matriz[chegada.get_x()][chegada.get_y()]=this.matriz[partida.get_x()][partida.get_y()];
          this.matriz[partida.get_x()][partida.get_y()]=null;
          this.matriz[chegada.get_x()][chegada.get_y()-1]=null;
          this.jogador_branco = !this.jogador_branco;
          this.apaga_passant = false;
          break;
        case 5: //EN PASSANT PEAO BRANCO
          this.matriz[chegada.get_x()][chegada.get_y()]=this.matriz[partida.get_x()][partida.get_y()];
          this.matriz[partida.get_x()][partida.get_y()]=null;
          this.matriz[chegada.get_x()][chegada.get_y()+1]=null;
          this.jogador_branco = !this.jogador_branco;
          this.apaga_passant = false;
          break;
        case 6: //PEAO BRANCO NO FINAL
          //SWITCH PRA SABER QUAL OBJ VAI CRIAR E SOBREPOR PEAO.
        case 7: //PEAO PRETO NO FINAL
      }
    }
    else {
      this.apaga_passant=false;
    }
    if(this.apaga_passant){
      this.zera_enPassant();
    }
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

  private void zera_enPassant(){
    this.matriz[this.ponto_passant.get_x()][this.ponto_passant.get_y()].set_passant(false);
  }

  private boolean verifica_enPassant(){
    for(int i=0;i<8;i++){
      for(int j=0;j<8;j++){
        if(this.matriz[i][j]!=null && this.matriz[i][j].get_passant()==true){
          this.ponto_passant.set_ponto(i, j);
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

  public boolean get_reis_vivos(){
    return this.reis_vivos;
  }

  public boolean get_jogador_branco(){
    return this.jogador_branco;
  }
}
