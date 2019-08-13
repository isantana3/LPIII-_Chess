public class Peao extends Itens {
  private boolean moved;  //var usada para verificar se a peça já se moveu alguma VEZ.

  public Peao(int x, int y, char cor){
    this.x=x;
    this.y=y;
    this.cor=cor;
    this.moved = false;
  }

  // get 'n set
  public void setMoved(boolean tf){
    this.moved = tf;
  }
  public boolean getMoved(){
    return this.moved;
  }

  private boolean verifica_movimento(int x, int y){
    // caso seja a primerira jogada com o peão (ele pode andar até duas casas para frente)
    if(y == this.get_y()+2  &&  this.getMoved() == false  &&  x == this.get_x() ){ //add a condição do lugar estar vazio
      this.setMoved(true);
      return true;
    }

    // caso não seja a primerira jogada com o peão (só vai uma casa pra frente)
    if(y == this.get_y()+1  &&  x == this.get_x() ){   //add a condição do lugar estar vazio
      return true;
    }

    // caso o peão vá capturar uma peça (nas diagonais frontais)
    if( (x == this.get_x() +1  ||  y == this.get_x()-1)  &&  y == this.get_y()+1) {
        // add a condição	de ter uma peça no espaço para onde o peã vazio
        // por o peão no lugar da outra peça e por a outra peça em algum lugar fora da matriz
        return true;
    }

  }

  public void moveTo(int x, int y){
    if(this.verifica_movimento(x, y)) {
      // if(isEmpty(x, y) == false){     //método que ainda não existe, na teoria ele só me fala se tal lugar tem ou não uma peça
      //   // getItem(x, y).set_posicao(10, 10);
      //   // teoricamente eu estou acessando a posição para onde meu peão vai, estou tirando a peça que está lá e a mandando para um lugar fora da matrix
      //   // getItem(não tá implementado ainda) deve retornar um objeto do tipo Item (uma peça) e para isso recebe as coodenadas da Matrix como argumento
      // }
      this.set_posicao(x, y);
      if(y == 0 || y == 7){
        // this.upPeao(); // ainda n implementado, deve transformar o peão em outra peça
      }
    }

  }
}
