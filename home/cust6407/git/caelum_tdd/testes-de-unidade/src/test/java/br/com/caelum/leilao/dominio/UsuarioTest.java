package br.com.caelum.leilao.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTest {
	@Test
	public void testUsuarioComNomeEmBranco() {
		Usuario usuario = new Usuario("");
		assertNotEquals(usuario.getNome(), "");
	}

	@Test
	public void testUsuarioComNomeNulo() {
		Usuario usuario = new Usuario(null);
		assertNotEquals(usuario.getNome(), null);
	}
}
