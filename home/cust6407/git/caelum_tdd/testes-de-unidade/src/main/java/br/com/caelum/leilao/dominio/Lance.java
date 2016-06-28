package br.com.caelum.leilao.dominio;

public class Lance {
	private Usuario usuario;
	private Double valorProposto;

	public Lance(Usuario usuario, Double valorProposto) {
		this.usuario = usuario;
		this.valorProposto = valorProposto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Double getValorProposto() {
		return valorProposto;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setValorProposto(Double valorProposto) {
		this.valorProposto = valorProposto;
	}

}
