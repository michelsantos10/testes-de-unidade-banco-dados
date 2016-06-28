package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FiltroDeLancesTest {

	@Test
	public void testDeveSelecionarLancesEntre1000e3000() {
		Usuario joao = new Usuario("João");

		FiltroDeLances filtro = new FiltroDeLances();
		List<Lance> resultado = filtro.filtra((Arrays.asList(new Lance(joao,
				2000.00), new Lance(joao, 1000.00), new Lance(joao, 3000.00),
				new Lance(joao, 800.00))));

		assertEquals(1, resultado.size());
		assertEquals(2000, resultado.get(0).getValorProposto(), 0.0001);
	}

	@Test
	public void testDeveSelecionarLancesEntre500e700() {
		Usuario joao = new Usuario("João");

		FiltroDeLances filtro = new FiltroDeLances();
		List<Lance> resultado = filtro.filtra((Arrays.asList(new Lance(joao,
				600.00), new Lance(joao, 500.00), new Lance(joao, 700.00),
				new Lance(joao, 800.00))));

		assertEquals(1, resultado.size());
		assertEquals(600, resultado.get(0).getValorProposto(), 0.0001);
	}
}
