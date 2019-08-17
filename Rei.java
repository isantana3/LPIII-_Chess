public class Rei extends Peca {
  private boolean moved;

  public Rei(String cor, Ponto posicao){
    this.posicao=posicao;
    this.cor=cor;
    this.moved=false;
  }

  public boolean get_moved(){
    return this.moved;
  }

  public void constroi_movimentos(Peca[][] tabuleiro){
    this.zera_movimentos();
    if(this.verifica_ponto(tabuleiro)){
      int aux = 0;
      int i=this.posicao.get_x();
      int j=this.posicao.get_y();
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

  public boolean set_posicao(Ponto chegada, Peca[][] tabuleiro){
    this.constroi_movimentos(tabuleiro);
    for(int i=0;i<this.movimentos.length;i++){
      if(chegada.get_x()==this.movimentos[i].get_x() && chegada.get_y()==this.movimentos[i].get_y()){
        this.posicao.set_ponto(chegada.get_x(), chegada.get_y());
        this.moved=true;
        return true;
      }
    }
    return false;
  }

  public String toString(){
    return "K"+this.cor;
  }
}
