public class Itens {
  protected int x;
  protected int y;
  protected char cor;

  public void set_posicao(int x, int y){
    this.x=x;
    this.y=y;
  }

  public char get_cor(){
    return this.cor;
  }

  public int get_x(){
    return this.x;
  }

  public int get_y(){
    return this.y;
  }
}
