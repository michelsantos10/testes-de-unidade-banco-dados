package br.com.caelum.pm73.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.pm73.dominio.Usuario;

public class UsuarioDaoTest {
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
		this.transacao = this.sessao.beginTransaction();
	}

	@After
	public void destroy() throws Exception {
		this.transacao.rollback();
		this.sessao.disconnect();
		this.sessao.close();
	}

	@Test
	public void testUsuarioDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testPorId() {
		fail("Not yet implemented");
	}

	@Test
	public void testPorNomeEEmail() {
		Usuario joao = this.usuarioDao.porNomeEEmail("joao",
				"joao@caelum.com.br");
		assertNull(joao);
	}

	@Test
	public void testSalvar() {
		fail("Not yet implemented");
	}

	@Test
	public void testAtualizar() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletar() {
		fail("Not yet implemented");
	}

}
