public class Tabuleiro {
  private Itens matriz[][] = new Itens[8][8];
  private boolean jogador_branco = true; // verifica se é a vez do jogador branco

  public Tabuleiro(){
    // COLOCAR TODAS AS PEÇAS NO TABULEIRO
  }

  /*
  Função que movimenta peças (movimenta para espaço vazio, troca de lugar em casos
  específicos ou executa peça adversária) após verificar, respectivamente, se as
  posições inseridas pelo usuário estão no tabuleiro, se é a vez do jogador
  correspondente, e se o movimento é válido.
  Entrada: Parâmetros x1 e y1 (saída) e x2 e y2 (destino) inseridos pelo usuário
  Status: INCOMPLETED
  */
  private void set_movimento(int x1, int y1, int x2, int y2){
    if(this.verifica_posicao(x1, y1) && this.verifica_posicao(x2, y2)){
      if(this.vez_jogador(x1, y1)){  
		  // melhor verificação dos casos (FAZER) null e peça
          /*
		  if(matriz[x2][y2]==null) 
			if(set_posição(x2, y2, 'null de char')) // dentro de set_posicao tem que ter
		  else if(matriz[x2][y2].get_cor=='b')
			if(set_posicao(x2, y2, matrix[x2][y2].get_cor);
		  else 
			if(set_posicao(x2, y2, matrix[x2][y2].get_cor);
          OCORRER UMA TROCA DE PEÇA AQUI
          CASO 1: TROCA SIMPLES -> MOVIMENTO PARA LUGAR VAZIO/DELETAR A SI MESMO
          CASO 2: EXECUÇÃO -> SUBSTITUI PEÇA ADVERSÁRIA/DELETAR A SI MESMO
          CASO 3: TORRE COM REI (ESPECIAL)// não sei como isso vai funfa
          vou ver como isso vai funfa ainda
          */
          this.jogador_branco = false; // POR FAVOR NE CONSERTA ISSAQUI
      }
    }
  }

  /*
  Função: Verifica se o jogador da vez selecionou uma peça própria
  Entrada: Primeiros parâmetros x e y (saída) inseridos pelo usuário
  Saída: True se for peça branca e vez do jogador branco ou
         peça preta e vez do jogador preto
  */
  private boolean vez_jogador(int x, int y){
    if(this.matriz[x][y]!=null){
      if(this.jogador_branco==true && this.matriz[x][y].get_cor()=='b' || this.jogador_branco==false && this.matriz[x][y].get_cor()=='p'){
        return true;
      }
    }
    return false;
  }

  /*
  Função: Verifica se valores x e y dados estão nos limites do tabuleiro e se são objetos ou null
  Entrada: Parâmetros x e y inseridos pelo usuário
  Saída: True os parâmetros estão no tabuleiro 8x8
         False se algum está fora do tabuleiro
  */
  private boolean verifica_posicao(int x, int y){
    if(x>=0 && x<8 && y>=0 && y<8){
      return true;
    }
    return false;
  }

  /*
  Saída: Matriz com os caracteres de cada peça no caso agora null...
  Status: INCOMPLETED
  */
  public void mostra_tabuleiro(){
    for(int i=0;i<8;i++){
      for(int j=0;j<8;j++)
        if(this.matriz[j][i]==null){
          System.out.print("nulo");
        }
      System.out.println();
    }
  }
}
