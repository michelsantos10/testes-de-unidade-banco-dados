package br.com.caelum.pm73.dao;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ LeilaoDaoTest.class, UsuarioDaoTest.class })
public class DaoSetup {

	@BeforeClass
	public static void doYourOneTimeSetup() {
		Configuration cfg = new CriadorDeSessao().getConfig();
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}

	@AfterClass
	public static void doYourOneTimeTeardown() {

	}
}
