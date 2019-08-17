public class Bispo extends Peca {
  public Bispo(String cor, Ponto posicao){
    this.posicao=posicao;
    this.cor=cor;
  }

  public void constroi_movimentos(Peca[][] tabuleiro){
    this.zera_movimentos();
    if(this.verifica_ponto(tabuleiro)){
      int aux = 0;
      int i=this.posicao.get_x();
      int j=this.posicao.get_y();
      for(int k=1;i+k<tabuleiro.length && j+k<tabuleiro.length;k++){
        if(tabuleiro[i+k][j+k]==null){
          this.movimentos[aux++].set_ponto(i+k, j+k);
        }
        else if(!tabuleiro[i+k][j+k].get_cor().equals(this.cor)){
          this.movimentos[aux++].set_ponto(i+k, j+k);
          break;
        }
        else
          break;
      }
      for(int k=1;i-k>=0 && j-k>=0;k++){
        if(tabuleiro[i-k][j-k]==null){
          this.movimentos[aux++].set_ponto(i-k, j-k);
        }
        else if(!tabuleiro[i-k][j-k].get_cor().equals(this.cor)){
          this.movimentos[aux++].set_ponto(i-k, j-k);
          break;
        }
        else
          break;
      }
      for(int k=1;i+k<tabuleiro.length && j-k>=0;k++){
        if(tabuleiro[i+k][j-k]==null){
          this.movimentos[aux++].set_ponto(i+k, j-k);
        }
        else if(!tabuleiro[i+k][j-k].get_cor().equals(this.cor)){
          this.movimentos[aux++].set_ponto(i+k, j-k);
          break;
        }
        else
          break;
      }
      for(int k=1;j+k<tabuleiro.length && i-k>=0;k++){
        if(tabuleiro[i-k][j+k]==null){
          this.movimentos[aux++].set_ponto(i-k, j+k);
        }
        else if(!tabuleiro[i-k][j+k].get_cor().equals(this.cor)){
          this.movimentos[aux++].set_ponto(i-k, j+k);
          break;
        }
        else
          break;
      }
    }
  }

  public String toString(){
    return "B"+this.cor;
  }
}
