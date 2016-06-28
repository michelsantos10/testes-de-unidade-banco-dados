package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.List;

public class Leilao {
	private List<Lance> lances;
	private String nome;
	
	public Leilao(String nome) {
		this.lances = new ArrayList<Lance>();
		this.nome = nome;
	}

	public List<Lance> getLances() {
		return this.lances;
	}

	public String getNome() {
		return nome;
	}
	
	public void propoe(Lance lance) {
		this.lances.add(lance);
	}
}
