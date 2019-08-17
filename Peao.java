public class Peao extends Peca {
  private boolean moved;

  public Peao(String cor){
    super(cor);
    this.moved=false;
  }

  public boolean get_moved(){
    return this.moved;
  }

  public void constroi_movimentos(Ponto partida, Peca[][] tabuleiro){
    this.zera_movimentos();
      int aux = 0;
      int i=partida.get_x();
      int j=partida.get_y();
      if(this.cor.equals("B")){
        if(j-1>=0 && tabuleiro[i][j-1]==null){
          this.movimentos[aux++].set_ponto(i, j-1);
        }
        if(j-1>=0 && i+1<tabuleiro.length && tabuleiro[i+1][j-1]!=null && !tabuleiro[i+1][j-1].get_cor().equals(this.cor)){
          this.movimentos[aux++].set_ponto(i+1, j-1);
        }
        if(j-1>=0 && i-1>=0 && tabuleiro[i-1][j-1]!=null && !tabuleiro[i-1][j-1].get_cor().equals(this.cor)){
          this.movimentos[aux++].set_ponto(i-1, j-1);
        }
        if(!this.moved){
          if(j-2>=0 && tabuleiro[i][j-2]==null){
            this.movimentos[aux++].set_ponto(i, j-2);
          }
        }
      }
      else {
        if(j+1<tabuleiro.length && tabuleiro[i][j+1]==null){
          this.movimentos[aux++].set_ponto(i, j+1);
        }
        if(j+1<tabuleiro.length && i+1<tabuleiro.length && tabuleiro[i+1][j+1]!=null && !tabuleiro[i+1][j+1].get_cor().equals(this.cor)){
          this.movimentos[aux++].set_ponto(i+1, j+1);
        }
        if(j+1<tabuleiro.length && i-1>=0 && tabuleiro[i-1][j+1]!=null && !tabuleiro[i-1][j+1].get_cor().equals(this.cor)){
          this.movimentos[aux++].set_ponto(i-1, j+1);
        }
        if(!this.moved){
          if(j+2<tabuleiro.length && tabuleiro[i][j+2]==null){
            this.movimentos[aux++].set_ponto(i, j+2);
          }
        }
      }
  }

  public boolean set_posicao(Ponto partida, Ponto chegada, Peca[][] tabuleiro){
    this.constroi_movimentos(partida, tabuleiro);
    for(int i=0;i<this.movimentos.length;i++){
      if(chegada.get_x()==this.movimentos[i].get_x() && chegada.get_y()==this.movimentos[i].get_y()){
        this.moved=true;
        return true;
      }
    }
    return false;
  }

  public String toString(){
    return "P"+this.cor;
  }
}
