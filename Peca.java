public abstract class Peca{
  protected String cor;
  protected Ponto[] movimentos = new Ponto[28];

  public Peca(String cor){
    if(this.verifica_cor(cor)){
      this.cor=cor;
    }
    else{
      this.cor="B";
    }
    this.zera_movimentos();
  }

  /*
  Função:
  Verifica se o cor é B ou P
  Entrada: Tabuleiro
  */
  protected boolean verifica_cor(String cor){
    if(cor.equals("B") || cor.equals("P")){
      return true;
    }
    return false;
  }

  public void set_cor(String cor){
    this.cor=cor;
  }

  public String get_cor(){
    return this.cor;
  }

  /*
  Função:
  Constroi o vetor de movimentos válidos para esta Peca na posicao atual
  Verifica se o Ponto de chegada está dentro do vetor de movimentos válidos
  Entrada: Ponto de chegada e Tabuleiro
  */
  public boolean set_posicao(Ponto partida, Ponto chegada, Peca[][] tabuleiro){
    this.constroi_movimentos(partida, tabuleiro);
    for(int i=0;i<this.movimentos.length;i++){
      if(chegada.get_x()==this.movimentos[i].get_x() && chegada.get_y()==this.movimentos[i].get_y()){
        return true;
      }
    }
    return false;
  }

  /*
  Função:
  "Zera" o vetor de movimentos com pontos (-1,-1)
  Todos os Pontos são objetos diferentes
  */
  protected void zera_movimentos(){
    Ponto p_0 = new Ponto();
    Ponto p_1 = new Ponto();
    Ponto p_2 = new Ponto();
    Ponto p_3 = new Ponto();
    Ponto p_4 = new Ponto();
    Ponto p_5 = new Ponto();
    Ponto p_6 = new Ponto();
    Ponto p_7 = new Ponto();
    Ponto p_8 = new Ponto();
    Ponto p_9 = new Ponto();
    Ponto p_10 = new Ponto();
    Ponto p_11 = new Ponto();
    Ponto p_12 = new Ponto();
    Ponto p_13 = new Ponto();
    Ponto p_14 = new Ponto();
    Ponto p_15 = new Ponto();
    Ponto p_16 = new Ponto();
    Ponto p_17 = new Ponto();
    Ponto p_18 = new Ponto();
    Ponto p_19 = new Ponto();
    Ponto p_20 = new Ponto();
    Ponto p_21 = new Ponto();
    Ponto p_22 = new Ponto();
    Ponto p_23 = new Ponto();
    Ponto p_24 = new Ponto();
    Ponto p_25 = new Ponto();
    Ponto p_26 = new Ponto();
    Ponto p_27 = new Ponto();
    this.movimentos[0]=p_0;
    this.movimentos[1]=p_1;
    this.movimentos[2]=p_2;
    this.movimentos[3]=p_3;
    this.movimentos[4]=p_4;
    this.movimentos[5]=p_5;
    this.movimentos[6]=p_6;
    this.movimentos[7]=p_7;
    this.movimentos[8]=p_8;
    this.movimentos[9]=p_9;
    this.movimentos[10]=p_10;
    this.movimentos[11]=p_11;
    this.movimentos[12]=p_12;
    this.movimentos[13]=p_13;
    this.movimentos[14]=p_14;
    this.movimentos[15]=p_15;
    this.movimentos[16]=p_16;
    this.movimentos[16]=p_16;
    this.movimentos[17]=p_17;
    this.movimentos[18]=p_18;
    this.movimentos[19]=p_19;
    this.movimentos[20]=p_20;
    this.movimentos[21]=p_21;
    this.movimentos[22]=p_22;
    this.movimentos[23]=p_23;
    this.movimentos[24]=p_24;
    this.movimentos[25]=p_25;
    this.movimentos[26]=p_26;
    this.movimentos[27]=p_27;
  }

  /*
  Função:
  1."Zera" o vetor de movimentos válidos.
  2.Verifica se a Peca está contida em um tabuleiro.
  3.Reconstrói o vetor de acordo com a configuração do Tabuleiro e Peca correspondente se 2 é verdadeiro.
  Entrada: Tabuleiro
  */
  public abstract void constroi_movimentos(Ponto partida, Peca[][] tabuleiro);

  /*
  Função: Printa todos o vetor de movimentos válidos
  */
  public void mostra_movimentos(){
    for(int i=0;i<this.movimentos.length;i++){
      if(this.movimentos[i].get_x()!=-1){
        System.out.print(this.movimentos[i]);
      }
    }
    System.out.println();
  }

  public Ponto[] get_movimentos(){
    return this.movimentos;
  }

  public abstract String toString();
}
