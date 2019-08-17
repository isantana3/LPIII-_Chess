public class Cavalo extends Peca {
  public Cavalo(String cor, Ponto posicao){
    this.posicao=posicao;
    this.cor=cor;
  }

  public void constroi_movimentos(Peca[][] tabuleiro){
    this.zera_movimentos();
    if(this.verifica_ponto(tabuleiro)){
      int aux = 0;
      int i=this.posicao.get_x();
      int j=this.posicao.get_y();
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
  }

  public String toString(){
    return "C"+this.cor;
  }
}
