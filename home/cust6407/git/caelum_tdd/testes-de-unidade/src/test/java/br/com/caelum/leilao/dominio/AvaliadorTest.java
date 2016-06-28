package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;


public class AvaliadorTest {

	Avaliador avaliador = new Avaliador();

	@Test
	public void test3MaioresLances() throws Exception {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Usuario jorge = new Usuario("Jorge");
		Usuario mariana = new Usuario("Mariana");

		Leilao leilao = CriadorDeLeilao.cria().para("Playstation 3 novo")
				.lance(jorge, 500.0).lance(mariana, 400.0).lance(jose, 300.0)
				.lance(maria, 200.0).lance(joao, 100.0).controi();

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.Avalia(leilao);

		List<Double> maioresLances = leiloeiro.getTreMaioresLances();
		ArrayList<Double> valoresEsperados = new ArrayList<Double>();

		valoresEsperados.add(500.0);
		valoresEsperados.add(400.0);
		valoresEsperados.add(300.0);

		Collections.sort(maioresLances);
		Collections.sort(valoresEsperados);

		assertArrayEquals(maioresLances.toArray(), valoresEsperados.toArray());
	}

	@Test
	public void test5LancesAleatorio() throws Exception {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Usuario jorge = new Usuario("Jorge");
		Usuario mariana = new Usuario("Mariana");

		Leilao leilao = CriadorDeLeilao.cria().para("Playstation 3 novo")
				.lance(joao, 100.0).lance(jose, 300.0).lance(maria, 200.0)
				.lance(jorge, 500.0).lance(mariana, 400.0).controi();

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.Avalia(leilao);

		double maiorLanceEsperado = 500.0;
		double menorLanceEsperado = 100.0;

		assertArrayEquals(
				new Double[] { maiorLanceEsperado, menorLanceEsperado },
				new Double[] { leiloeiro.getMaiorDeTodos(),
						leiloeiro.getMenorDeTodos() });
	}

	@Test
	public void testLancesProcessadosNaOrdemCorreta() throws Exception {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Usuario jorge = new Usuario("Jorge");
		Usuario mariana = new Usuario("Mariana");

		Leilao leilao = CriadorDeLeilao.cria().para("Playstation 3 novo")
				.lance(joao, 100.0).lance(jose, 300.0).lance(maria, 200.0)
				.lance(jorge, 500.0).lance(mariana, 400.0).controi();

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.Avalia(leilao);

		ArrayList<Double> valoresEsperados = new ArrayList<Double>();

		valoresEsperados.add(100.0);
		valoresEsperados.add(300.0);
		valoresEsperados.add(200.0);
		valoresEsperados.add(500.0);
		valoresEsperados.add(400.0);

		
	}

	@Test
	public void test5LancesOrdemCrescente() throws Exception {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Usuario jorge = new Usuario("Jorge");
		Usuario mariana = new Usuario("Mariana");

		Leilao leilao = CriadorDeLeilao.cria().para("Playstation 3 novo")
				.lance(joao, 100.0).lance(maria, 200.0).lance(jose, 300.0)
				.lance(mariana, 400.0).lance(jorge, 500.0).controi();

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.Avalia(leilao);

		double maiorLanceEsperado = 500.0;
		double menorLanceEsperado = 100.0;

		assertArrayEquals(
				new Double[] { maiorLanceEsperado, menorLanceEsperado },
				new Double[] { leiloeiro.getMaiorDeTodos(),
						leiloeiro.getMenorDeTodos() });
	}

	@Test
	public void test5LancesOrdemDecrescente() throws Exception {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Usuario jorge = new Usuario("Jorge");
		Usuario mariana = new Usuario("Mariana");

		Leilao leilao = CriadorDeLeilao.cria().para("Playstation 3 novo")
				.lance(jorge, 500.0).lance(mariana, 400.0).lance(jose, 300.0)
				.lance(maria, 200.0).lance(joao, 100.0).controi();
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.Avalia(leilao);

		double maiorLanceEsperado = 500.0;
		double menorLanceEsperado = 100.0;

		assertArrayEquals(
				new Double[] { maiorLanceEsperado, menorLanceEsperado },
				new Double[] { leiloeiro.getMaiorDeTodos(),
						leiloeiro.getMenorDeTodos() });
	}

	@Test
	public void testLanceIgualAZero() {
		Usuario joao = new Usuario("João");

		Leilao leilao = new Leilao("Playstation 3 novo");
		try {
			leilao.propoe(new Lance(joao, 0.0));
			assertTrue(
					"Não pode ser aceito proposta de lance com valor igual a 0 (zero)",
					false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void testLanceNegativo() {
		Usuario joao = new Usuario("João");

		Leilao leilao = new Leilao("Playstation 3 novo");
		try {
			leilao.propoe(new Lance(joao, -300.0));
			assertTrue(
					"Não pode ser aceito proposta de lance com valor negativo",
					false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test(expected = RuntimeException.class)
	public void testLeilaoSemLance() throws Exception {
		Leilao leilao = CriadorDeLeilao.cria().para("Playstation 3 novo")
				.controi();
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.Avalia(leilao);
	}

	@Test
	public void testMaiorValorEsperado() throws Exception {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = CriadorDeLeilao.cria().para("Playstation 3 novo")
				.lance(joao, 300.0).lance(jose, 400.0).lance(maria, 250.0)
				.controi();

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.Avalia(leilao);

		double maiorEsperado = 400.0;

		assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.0001);
	}

	@Test
	public void testMenorValorEsperado() throws Exception {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = CriadorDeLeilao.cria().para("Playstation 3 novo")
				.lance(joao, 300.0).lance(jose, 400.0).lance(maria, 250.0)
				.controi();

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.Avalia(leilao);

		double menorEsperado = 250.0;

		assertEquals(menorEsperado, leiloeiro.getMenorDeTodos(), 0.0001);
	}

	@Test
	public void testTodosLancesIguais() throws Exception {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = CriadorDeLeilao.cria().para("Playstation 3 novo")
				.lance(joao, 300.0).lance(jose, 300.0).lance(maria, 300.0)
				.controi();

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.Avalia(leilao);

		double esperado = 300.0;

		assertTrue(esperado == leiloeiro.getMenorDeTodos()
				&& esperado == leiloeiro.getMaiorDeTodos());
	}

	public void SetUp() {
		System.out.println("Inicia");
		this.avaliador = new Avaliador();
	}

}
