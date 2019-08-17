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
		Ponto posicao; Ponto - qualquer, sem verificacao
		Ponto[] movimentos: (Vetor dos movimentos válidos em this.posicao)
	Métodos:
		verifica_ponto(Tabuleiro) - se o ponto posicao DESSA peca tá no tabuleiro.
		zera_movimentos() - vetor movimentos preenchido com pontos (-1, -1)
		constroi_movimentos(Tabuleiro) - zera vetor, se peca dentro do tabuleiro, constroi vetor
		mostra_movimentos() - mostra o vetor movimentos
		get_movimentos();
		set_posicao(Ponto) - se Ponto chegada em movimentos, atualiza posicao da Peca e retorna true
		get_posicao();
		set_cor(String cor);
		get_cor();
		toString();

#Obs:
	Óbvio que a peça vai estar no tabuleiro se vc escolheu ela dentro da classe Tabuleiro
	Necessidade de Ponto posicao na Peça
	Falta:
	1.Roque
	2.Le passant
	3.Peao no fim do tabuleiro
	4.Fim de jogo
	5.Xeque e verificação(???)
	6.Interface Gráfica
	TESTAR AS CLASSES // FUNCIONAMENTO // EXCEÇÕES // POSSÍVEIS ERROS NO CÓDIGO
