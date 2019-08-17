public class Cavalo extends Peca {
  public Cavalo(String cor){
    super(cor);
  }

  public void constroi_movimentos(Ponto partida, Peca[][] tabuleiro){
    this.zera_movimentos();
      int aux = 0;
      int i=partida.get_x();
      int j=partida.get_y();
      if(i+2<tabuleiro.length && j+1<tabuleiro.length && (tabuleiro[i+2][j+1]==null || !tabuleiro[i+2][j+1].get_cor().equals(this.cor))){
        this.movimentos[aux++].set_ponto(i+2, j+1);
      }
      if(i+2<tabuleiro.length && j-1>=0 && (tabuleiro[i+2][j-1]==null || !tabuleiro[i+2][j-1].get_cor().equals(this.cor))){
        this.movimentos[aux++].set_ponto(i+2, j-1);
      }
      if(i-2>=0 && j+1<tabuleiro.length && (tabuleiro[i-2][j+1]==null || !tabuleiro[i-2][j+1].get_cor().equals(this.cor))){
        this.movimentos[aux++].set_ponto(i-2, j+1);
      }
      if(i-2>=0 && j-1>=0 && (tabuleiro[i-2][j-1]==null || !tabuleiro[i-2][j-1].get_cor().equals(this.cor))){
        this.movimentos[aux++].set_ponto(i-2, j-1);
      }
      if(j+2<tabuleiro.length && i+1<tabuleiro.length && (tabuleiro[i+1][j+2]==null || !tabuleiro[i+1][j+2].get_cor().equals(this.cor))){
        this.movimentos[aux++].set_ponto(i+1, j+2);
      }
      if(j+2<tabuleiro.length && i-1>=0 && (tabuleiro[i-1][j+2]==null || !tabuleiro[i-1][j+2].get_cor().equals(this.cor))){
        this.movimentos[aux++].set_ponto(i-1, j+2);
      }
      if(j-2>=0 && i+1<tabuleiro.length && (tabuleiro[i+1][j-2]==null || !tabuleiro[i+1][j-2].get_cor().equals(this.cor))){
        this.movimentos[aux++].set_ponto(i+1, j-2);
      }
      if(j-2>=0 && i-1>=0 && (tabuleiro[i-1][j-2]==null || !tabuleiro[i-1][j-2].get_cor().equals(this.cor))){
        this.movimentos[aux++].set_ponto(i-1, j-2);
      }
  }

  public String toString(){
    return "C"+this.cor;
  }
}
