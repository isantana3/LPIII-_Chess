public class Tabuleiro {
  private Peca matriz[][] = new Peca[8][8];
  private boolean jogador_branco = true; // verifica se é a vez do jogador branco
  private Ponto rei_branco_ponto = new Ponto(1, 1);
  private Rei rei_branco = new Rei("B", rei_branco_ponto);
  private Ponto rei_preto_ponto = new Ponto(0, 0);
  private Rei rei_preto = new Rei("P", rei_preto_ponto);

  public void monta_tabuleiro(){
    matriz[rei_branco_ponto.get_x()][rei_branco_ponto.get_y()]=rei_branco;
    matriz[rei_preto_ponto.get_x()][rei_preto_ponto.get_y()]=rei_preto;
  }

  public boolean jogada(Ponto item, Ponto destino){
    if(vez_jogador(item)){
      if(matriz[item.get_x()][item.get_y()].set_posicao(destino, matriz)){
        matriz[destino.get_x()][destino.get_y()]=matriz[item.get_x()][item.get_y()];
        matriz[item.get_x()][item.get_y()]=null;
        jogador_branco = !jogador_branco;
        return true;
      }
    }
    return false;
  }
  
  /*
  Função: Verifica se o jogador da vez selecionou uma peça própria
  Entrada: Primeiros parâmetros x e y (saída) inseridos pelo usuário
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
  Função: Verifica se valores x e y dados estão nos limites do tabuleiro e se são objetos ou null
  Entrada: Parâmetros x e y inseridos pelo usuário
  Saída: True os parâmetros estão no tabuleiro 8x8
         False se algum está fora do tabuleiro
  */
  private boolean verifica_ponto(Ponto p){
    if(p.get_x()>=0 && p.get_x()<8 && p.get_y()>=0 && p.get_y()<8){
      return true;
    }
    return false;
  }

  /*
  Saída: Matriz com os caracteres de cada peça no caso agora null...
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
  }

  public Peca[][] get_matriz(){
    return this.matriz;
  }
}
