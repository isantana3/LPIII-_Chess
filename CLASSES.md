# Classe Ponto:
	Atributos:
		int x, int y que podem receber qualquer valor inteiro.
	Métodos:
		set_ponto(int x, int y);
		get_x();
		get_y();

# Classe Peca:
	Atributos:
		String cor; "B" ou "P"
		Ponto[] movimentos: (Vetor dos movimentos válidos em this.posicao)
	Métodos:
		zera_movimentos() - vetor movimentos preenchido com pontos (-1, -1)
		constroi_movimentos(Ponto partida, Tabuleiro) - zera vetor, se peca dentro do tabuleiro, constroi vetor
		mostra_movimentos() - mostra o vetor movimentos
		get_movimentos();
		set_posicao(Ponto partida, chegada, Tabuleiro)
		set_cor(String cor);
		get_cor();
		toString();

#Obs:
	Falta:
-	1.Roque
-	2.Le passant
-	3.Peao no fim do tabuleiro
- 4.Fim de jogo (O jogo acaba agora aparentemente)
	5.Xeque e verificação(???) // rei em cheque só pode mexer o rei
	6.Interface Gráfica
	TESTAR AS CLASSES // FUNCIONAMENTO // EXCEÇÕES // POSSÍVEIS ERROS NO CÓDIGO

# LEMBRAR
1. troca normal
2. roque ESQUERDA
3. roque DIREITA
4. en passant preto
5. en passant branco
6. peao no final


public boolean jogada(Ponto partida, Ponto chegada){
	this.apaga_passant=false;
	if(this.verifica_enPassant()){
		this.apaga_passant=true;
	}

/*
if(this.xeque_branco() && !matriz[partida.get_x()][partida.get_y()].toString().equals("KB")){
	return false;
}
if(this.xeque_preto() && !matriz[partida.get_x()][partida.get_y()].toString().equals("KP")){
	return false;
}
*/
/* só tem um rei, podemos fazer métodos especificos pra cada um
	 peça rei vai ter que ter um movimento diferente com parametro diferentes (em xeque ou fora)
	 ou seja, sempre que for rei a se movimentar, tudo é diferente
	 obs: ver a vez de jogar e pa (LEMBRAR DISSO)
	 talvez tenha que fazer um constroi_mov_xeque tbm em cada Classe
	 porque nesse caso vai incluir as proprias peças no vetor de movimentos (LEMBRA DISSO) IMPORTANTE
	 e o XEQUE-MATE?

if(matriz[][] == KB){
rei_branco.set_posicao(mov_xeque, tabuleiro, partida, chegada);
return true ou false
}
if(matriz[][] == KP){
rei_preto.set_posicao(mov_xeque, tabuleiro, partida, chegada);
return true ou false
}
*/
