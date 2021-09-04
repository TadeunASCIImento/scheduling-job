package br.com.jobs.testes.unitarios;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.jobs.models.Job;
import br.com.jobs.models.Scheduling;

public class JobTest {

	@Test
	public void deveInstanciarObjetoJobNaoNulo() {
		assertNotNull(new Job(1, "Importação de arquivos de fundo", "2019-11-10 12:00:00", "2 horas"));
	}

	@Test
	public void deveGerarListaDeJobsParaExecucao() {
		List<Job> listJobs = new Scheduling().generateListJobs();
		assertNotNull(listJobs);
		assertTrue(listJobs.size() > 0);
	}

	@Test
	public void deveValidarJanelaParaExecucaoDoJob() {
		assertFalse(new Scheduling().validateJanelaExecucao("2019-11-11 14:00:00"));
		assertTrue(new Scheduling().validateJanelaExecucao("2019-11-10 12:00:00"));
	}

}
