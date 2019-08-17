# Classe Ponto:
	Atributos:
		int x, int y que podem receber qualquer valor inteiro.
	Métodos:
		set_ponto(int x, int y);
		get_x();
		get_y();

# Classe Peca:
	Atributos:
		String cor; (Só deve receber "B" ou "P" - falta fazer verificação pra isso)
		Ponto posicao; (Ponto - qualquer, sem verififacao - com a posicao da Peca na matriz se Ponto contido na matriz)
		Ponto[] movimentos: (Vetor dos movimentos válidos em this.posicao)
	Métodos:
		verifica_ponto(Ponto p) - se dentro de um tabuleiro.
		zera_movimentos() - vetor movimentos preenchido com pontos (-1, -1)
		constroi_movimentos() - zera vetor, se peca dentro do tabuleiro, constroi vetor
		mostra_movimentos() - mostra o vetor movimentos
		get_movimentos();
		set_posicao() - se Ponto chegada em movimentos, atualiza posicao da Peca e retorna true
		get_posicao();
		set_cor(String cor);
		get_cor();
		toString();
