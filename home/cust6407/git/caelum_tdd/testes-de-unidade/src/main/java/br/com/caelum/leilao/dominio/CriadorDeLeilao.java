package br.com.caelum.leilao.dominio;

public class CriadorDeLeilao {
	private Leilao leilao;

	private CriadorDeLeilao() {

	}

	public CriadorDeLeilao para(String descricao) {
		this.leilao = new Leilao(descricao);
		return this;
	}

	public CriadorDeLeilao lance(Usuario usuario, double valorProposto) {
		this.leilao.propoe(new Lance(usuario, valorProposto));
		return this;
	}

	public Leilao controi() {
		return this.leilao;
	}
	
	public static CriadorDeLeilao cria(){
		return new CriadorDeLeilao();
	}
}
