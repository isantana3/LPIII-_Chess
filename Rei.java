public class Rei extends Peca {
  public Rei(String cor, Ponto posicao){
    this.posicao=posicao;
    this.cor=cor;
  }

  public void constroi_movimentos(Peca[][] tabuleiro){
    this.zera_movimentos();
    int aux = 0;
    int i=this.posicao.get_x();
    int j=this.posicao.get_y();
    if(this.verifica_ponto(tabuleiro)){
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
    }
  }

  public String toString(){
    return "R"+this.cor;
  }
}
