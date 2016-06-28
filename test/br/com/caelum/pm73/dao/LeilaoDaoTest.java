package br.com.caelum.pm73.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.pm73.dominio.Leilao;
import br.com.caelum.pm73.dominio.Usuario;

public class LeilaoDaoTest {
	LeilaoDao leilaoDao;
	Session sessao;
	UsuarioDao usuarioDao;
	Transaction transacao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
		this.sessao = new CriadorDeSessao().getSession();
		this.leilaoDao = new LeilaoDao(this.sessao);
		this.usuarioDao = new UsuarioDao(this.sessao);
		this.transacao =  this.sessao.beginTransaction();
	}

	@After
	public void destroy() throws Exception {
		this.transacao.rollback();
		this.sessao.disconnect();
		this.sessao.close();
	}

	@Test
	public void testDeveContrarLeiloesNaoEncerrados() {
		Usuario mauricio = new Usuario("Marcio Aniche", "marcio@aniche.com.br");
		Leilao ativo = new Leilao("Geladeira", 1500.0, mauricio, false);
		Leilao encerrado = new Leilao("XBox", 700.0, mauricio, false);
		encerrado.encerra();

		this.usuarioDao.salvar(mauricio);
		this.leilaoDao.salvar(ativo);
		this.leilaoDao.salvar(encerrado);

		long total = this.leilaoDao.total();

		assertEquals(1L, total);
	}

	@Test
	public void testLeilaoDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testPorId() {
		fail("Not yet implemented");
	}

	@Test
	public void testNovos() {
		Usuario mauricio = new Usuario("Marcio Aniche", "marcio@aniche.com.br");
		Leilao ativo = new Leilao("Geladeira", 1500.0, mauricio, false);
		Leilao encerrado = new Leilao("XBox", 700.0, mauricio, false);
		encerrado.encerra();

		this.usuarioDao.salvar(mauricio);
		this.leilaoDao.salvar(ativo);
		this.leilaoDao.salvar(encerrado);

		long novos = this.leilaoDao.novos().size();

		assertEquals(1L, novos);
	}

	@Test
	public void testAntigos() {
		fail("Not yet implemented");
	}

	@Test
	public void testPorPeriodo() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisputadosEntre() {
		fail("Not yet implemented");
	}

	@Test
	public void testAtualiza() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleta() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletaEncerrados() {
		fail("Not yet implemented");
	}

	@Test
	public void testListaLeiloesDoUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetValorInicialMedioDoUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testSalvar() throws Exception {
		fail("Not yet implemented");
	}

}
