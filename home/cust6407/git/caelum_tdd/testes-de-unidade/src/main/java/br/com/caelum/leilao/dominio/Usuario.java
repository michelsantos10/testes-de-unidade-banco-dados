package br.com.caelum.leilao.dominio;

public class Usuario {
	private Integer id;
	private String nome;

	public Usuario(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Usuario(String nome) {
		this(0, nome);
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
