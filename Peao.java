public class Peao extends Peca {
  public Peao(String cor){
    super(cor);
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
        // EN PASSANT
        if(i+1<tabuleiro.length && tabuleiro[i+1][j]!=null && !tabuleiro[i+1][j].toString().equals("P"+this.cor) && tabuleiro[i+1][j].get_passant()){ // DA MESMA COR OU DE OUTRA COR
          this.movimentos[aux++].set_ponto(i+1, j-1);
        }
        if(i-1>=0 &&  tabuleiro[i-1][j]!=null && !tabuleiro[i-1][j].toString().equals("P"+this.cor) && tabuleiro[i-1][j].get_passant()){
          this.movimentos[aux++].set_ponto(i-1, j-1);
        }
        //DUAS CASAS A FRENTE
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
        // EN PASSANT
        if(i+1<tabuleiro.length && tabuleiro[i+1][j]!=null && !tabuleiro[i+1][j].toString().equals("P"+this.cor) && tabuleiro[i+1][j].get_passant()){
          this.movimentos[aux++].set_ponto(i+1, j+1);
        }
        if(i-1>=0 &&  tabuleiro[i-1][j]!=null && !tabuleiro[i-1][j].toString().equals("P"+this.cor) && tabuleiro[i-1][j].get_passant()){
          this.movimentos[aux++].set_ponto(i-1, j+1);
        }
        //DUAS CASAS A FRENTE
        if(!this.moved){
          if(j+2<tabuleiro.length && tabuleiro[i][j+2]==null){
            this.movimentos[aux++].set_ponto(i, j+2);
          }
        }
      }
  }

  public int set_posicao(Ponto partida, Ponto chegada, Peca[][] tabuleiro){
    this.constroi_movimentos(partida, tabuleiro);
    for(int i=0;i<this.movimentos.length;i++){
      if(chegada.get_x()==this.movimentos[i].get_x() && chegada.get_y()==this.movimentos[i].get_y()){
        int x = partida.get_x();
        int y = partida.get_y();
        if(chegada.get_y()==partida.get_y()+2 || chegada.get_y()==partida.get_y()-2){
          this.passant=true;
        }
        // PASSANT PEAO PRETO PELA DIREITA
        if(x+1<tabuleiro.length && y+1<tabuleiro.length && tabuleiro[x+1][y]!=null && tabuleiro[x+1][y].get_passant() && chegada.get_x()==x+1 && chegada.get_y()==y+1){
          return 4;
        }
        // PASSANT PEAO PRETO PELA ESQUERDA
        if(x-1>=0 && y+1<tabuleiro.length && tabuleiro[x-1][y]!=null && tabuleiro[x-1][y].get_passant() && chegada.get_x()==x-1 && chegada.get_y()==y+1){
          return 4;
        }
        // PASSANT PEAO BRANCO PELA DIREITA
        if(x+1<tabuleiro.length && y-1>=0 && tabuleiro[x+1][y]!=null && tabuleiro[x+1][y].get_passant() && chegada.get_x()==x+1 && chegada.get_y()==y-1){
          return 5;
        }
        // PASSANT PEAO BRANCO PELA DIREITA
        if(x-1>=0 && y-1>=0 && tabuleiro[x-1][y]!=null && tabuleiro[x-1][y].get_passant() && chegada.get_x()==x-1 && chegada.get_y()==y-1){
          return 5;
        }
        if(chegada.get_y()==0){
          return 6;
        }
        if(chegada.get_y()==7){
          return 7;
        }
        this.moved=true;
        return 1;
      }
    }
    return 0;
  }

  public String toString(){
    return "P"+this.cor;
  }
}
