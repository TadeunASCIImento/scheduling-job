package br.com.jobs.testes.unitarios;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.jobs.models.Job;
import br.com.jobs.models.Scheduling;

public class JobTest {

	@Test
	public void deveValidarJanelaParaExecucaoDoJob() {
		Job job = new Job(1, "Importação de arquivos de fundo", "2019-11-10 12:00:00", "2 horas");
		assertTrue(Scheduling.validateJanelaExecucao(job.getDataMaximaConclusao()));
	}

	@Test
	public void deveInvalidarJanelaParaExecucaoJob() {
		Job job = new Job(1, "Importação de arquivos de fundo", "2019-11-08 07:00:00", "2 horas");
		assertFalse(Scheduling.validateJanelaExecucao(job.getDataMaximaConclusao()));
	}

	@Test
	public void deveValidarTempoMaximoParaExecucao() {
		ArrayList<Job> _jobs = new ArrayList<Job>();
		Integer total = 0;
		List<Job> jobs = new Scheduling().generateListJobs();
		for (int index = 0, len = jobs.size(); index < len; index++) {
			if (Scheduling.formatTempoEstimado(jobs.get(index).getTempoEstimado()) != null) {
				total += Scheduling.formatTempoEstimado(jobs.get(index).getTempoEstimado());
				if (Scheduling.formatTempoEstimado(jobs.get(index).getTempoEstimado()) < Scheduling.tempoMaximoExecucao
						&& total < Scheduling.tempoMaximoExecucao) {
					_jobs.add(jobs.get(index));
				}
			}
		}
		Integer _total = 0;
		for (int _index = 0; _index < _jobs.size(); _index++)
			_total += Scheduling.formatTempoEstimado(_jobs.get(_index).getTempoEstimado());

		assertTrue(!(_total > Scheduling.tempoMaximoExecucao));

	}

	@Test
	public void deveRetornarListaDeJobsParaExecucao() {
		ArrayList<Job> _jobs = new ArrayList<Job>();
		Integer total = 0;
		List<Job> jobs = new Scheduling().generateListJobs();
		for (int index = 0, len = jobs.size(); index < len; index++) {
			if (Scheduling.formatTempoEstimado(jobs.get(index).getTempoEstimado()) != null) {
				total += Scheduling.formatTempoEstimado(jobs.get(index).getTempoEstimado());
				if (Scheduling.formatTempoEstimado(jobs.get(index).getTempoEstimado()) < Scheduling.tempoMaximoExecucao
						&& total < Scheduling.tempoMaximoExecucao) {
					_jobs.add(jobs.get(index));
				}
			}
		}
		List<ArrayList<Job>> escalonados = new ArrayList<ArrayList<Job>>();
		escalonados.add(_jobs);

		assertTrue(escalonados.size() > 0 && !escalonados.equals(null));

	}

}
