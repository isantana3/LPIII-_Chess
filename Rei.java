public class Rei extends Peca {
  public Rei(String cor){
    super(cor);
  }

  public void constroi_movimentos(Ponto partida, Peca[][] tabuleiro){
    this.zera_movimentos();
    int aux = 0;
    int i=partida.get_x();
    int j=partida.get_y();
    if(i+1<tabuleiro.length && (tabuleiro[i+1][j]==null || !tabuleiro[i+1][j].get_cor().equals(this.cor))){
      this.movimentos[aux++].set_ponto(i+1, j);
    }
    if(i-1>=0 && (tabuleiro[i-1][j]==null || !tabuleiro[i-1][j].get_cor().equals(this.cor))){
      this.movimentos[aux++].set_ponto(i-1, j);
    }
    if(j+1<tabuleiro.length && (tabuleiro[i][j+1]==null || !tabuleiro[i][j+1].get_cor().equals(this.cor))){
      this.movimentos[aux++].set_ponto(i, j+1);
    }
    if(j-1>=0 && (tabuleiro[i][j-1]==null || !tabuleiro[i][j-1].get_cor().equals(this.cor))){
      this.movimentos[aux++].set_ponto(i, j-1);
    }
    if(i+1<tabuleiro.length && j+1<tabuleiro.length && (tabuleiro[i+1][j+1]==null || !tabuleiro[i+1][j+1].get_cor().equals(this.cor))){
      this.movimentos[aux++].set_ponto(i+1, j+1);
    }
    if(i+1<tabuleiro.length && j-1>=0 && (tabuleiro[i+1][j-1]==null || !tabuleiro[i+1][j-1].get_cor().equals(this.cor))){
      this.movimentos[aux++].set_ponto(i+1, j-1);
    }
    if(i-1>=0 && j+1<tabuleiro.length && (tabuleiro[i-1][j+1]==null || !tabuleiro[i-1][j+1].get_cor().equals(this.cor))){
      this.movimentos[aux++].set_ponto(i-1, j+1);
    }
    if(i-1>=0 && j-1>=0 && (tabuleiro[i-1][j-1]==null || !tabuleiro[i-1][j-1].get_cor().equals(this.cor))){
      this.movimentos[aux++].set_ponto(i-1, j-1);
    }
    if(!this.moved){
      int k;
      for(k=i+1;k<tabuleiro.length;k++){
        if(tabuleiro[k][j]!=null){
          break;
        }
      }
      if(k==7 && tabuleiro[k][j].toString().equals("T"+this.cor) && !tabuleiro[k][j].get_moved()){
        this.movimentos[aux++].set_ponto(i+2, j);
      }
      for(k=i-1;k>=0;k--){
        if(tabuleiro[k][j]!=null){
          break;
        }
      }
      if(k==0 && tabuleiro[k][j].toString().equals("T"+this.cor) && !tabuleiro[k][j].get_moved()){
        this.movimentos[aux++].set_ponto(i-2, j);
      }
    }
  }

  public int set_posicao(Ponto partida, Ponto chegada, Peca[][] tabuleiro){
    this.constroi_movimentos(partida, tabuleiro);
    for(int i=0;i<this.movimentos.length;i++){
      if(chegada.get_x()==this.movimentos[i].get_x() && chegada.get_y()==this.movimentos[i].get_y()){
        if(chegada.get_x()==partida.get_x()+2){
          return 3;
        }
        if(chegada.get_x()==partida.get_x()-2){
          return 2;
        }
        this.moved=true;
        return 1;
      }
    }
    return 0;
  }

  public String toString(){
    return "K"+this.cor;
  }
}
