public abstract class Itens {
  protected int x;
  protected int y;
  protected char cor;

  public abstract boolean set_posicao(int x, int y, char cor);

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
