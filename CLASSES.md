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
	1.Roque
	2.Le passant
	3.Peao no fim do tabuleiro
	4.Fim de jogo
	5.Xeque e verificação(???)
	6.Interface Gráfica
	TESTAR AS CLASSES // FUNCIONAMENTO // EXCEÇÕES // POSSÍVEIS ERROS NO CÓDIGO
