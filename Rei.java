public class Rei extends Itens {
  public Rei(int x, int y, char cor){
    //verificação
    this.x=x;
    this.y=y;
    this.cor=cor;
  }

  /*
  Função: Verifica se o destino é válido (cor diferente/espaço vazio)
  Status: INCOMPLETED (caso cor que eu lembre agora)
  */
  private boolean verifica_movimento(int x, int y){
    if((x==this.x+1 || x==this.x-1) && y==this.y){
      return true;
    }
    if((y==this.y+1 || x==this.y-1) && x==this.x){
      return true;
    }
    return false;
  }

  /*
  Função: Se movimento é válido, return true
  Status: INCOMPLETED
  */
  public boolean set_posicao(int x, int y, char cor){
    if(this.verifica_movimento(x,y)){
      return true;
    }
    return false;
  }
}
