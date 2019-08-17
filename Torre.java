public class Torre extends Peca {
  private boolean moved;

  public Torre(String cor, Ponto posicao){
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
      for(int k=i+1;k<tabuleiro.length;k++){
        if(tabuleiro[k][j]==null){
          this.movimentos[aux++].set_ponto(k, j);
        }
        else if(!tabuleiro[k][j].get_cor().equals(this.cor)){
          this.movimentos[aux++].set_ponto(k, j);
          break;
        }
        else
          break;
      }
      for(int k=i-1;k>=0;k--){
        if(tabuleiro[k][j]==null){
          this.movimentos[aux++].set_ponto(k, j);
        }
        else if(!tabuleiro[k][j].get_cor().equals(this.cor)){
          this.movimentos[aux++].set_ponto(k, j);
          break;
        }
        else
          break;
      }
      for(int k=j+1;k<tabuleiro.length;k++){
        if(tabuleiro[i][k]==null){
          this.movimentos[aux++].set_ponto(i, k);
        }
        else if(!tabuleiro[i][k].get_cor().equals(this.cor)){
          this.movimentos[aux++].set_ponto(i, k);
          break;
        }
        else
          break;
      }
      for(int k=j-1;k>=0;k--){
        if(tabuleiro[i][k]==null){
          this.movimentos[aux++].set_ponto(i, k);
        }
        else if(!tabuleiro[i][k].get_cor().equals(this.cor)){
          this.movimentos[aux++].set_ponto(i, k);
          break;
        }
        else
          break;
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
    return "T"+this.cor;
  }
}
