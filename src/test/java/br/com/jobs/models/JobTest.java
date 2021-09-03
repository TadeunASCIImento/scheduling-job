package br.com.jobs.models;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class JobTest {

	@Test
	public void deveInstanciarObjetoJob() {
		assertNotNull(new Job(1, "Importação de arquivos de fundo", "2019-11-10 12:00:00", "2 horas"));
	}

}
