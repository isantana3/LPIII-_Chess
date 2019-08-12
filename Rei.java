public class Rei extends Itens {
  public Rei(int x, int y, char cor){
    this.x=x;
    this.y=y;
    this.cor=cor;
  }

  private boolean verifica_movimento(int x, int y){
    if((x==this.x+1 || x==this.x-1) && y==this.y){
      return true;
    }
    if((y==this.y+1 || x==this.y-1) && x==this.x){
      return true;
    }
    return false;
  }

  public void set_posicao(int x, int y){
    if(this.verifica_movimento(x,y)){
      this.x=x;
      this.y=y;
    }
  }
}
