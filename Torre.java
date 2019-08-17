public class Torre extends Peca {
  public Torre(String cor, Ponto posicao){
    this.posicao=posicao;
    this.cor=cor;
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

  public String toString(){
    return "T"+this.cor;
  }
}
