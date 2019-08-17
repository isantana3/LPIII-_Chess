public class Ponto {
  protected int x;
  protected int y;

  public Ponto(int x, int y){
    this.x=x;
    this.y=y;
  }

  public Ponto(){
    this.x=-1;
    this.y=-1;
  }

  public void set_ponto(int x, int y){
    this.x=x;
    this.y=y;
  }

  public int get_x(){
    return this.x;
  }

  public int get_y(){
    return this.y;
  }

  public String toString(){
    return "P:("+this.x+", "+this.y+")";
  }
}
