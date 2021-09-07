package br.com.jobs.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Scheduling {

	private static Integer tempoMaximoExecucao = 9;
	private static String dataInicioJanela = "2019-11-10 09:00:00";
	private static String dataFimJanela = "2019-11-11 12:00:00";

	public Integer getTempoMaximoExecucao() {
		return tempoMaximoExecucao;
	}

	// retorna a massa o objeto Json acima representando como exemplo de massa de dados.
	public List<Job> generateListJobs() {
		Job job1 = new Job(1, "Importação de arquivos de fundos", "2019-11-10 12:00:00", "2 horas");
		Job job2 = new Job(2, "Importação de dados da Base Legada", "2019-11-11 12:00:00", "6 horas");
		Job job3 = new Job(3, "Importação de dados de integração", "2019-11-11 08:00:00", "4 horas");
		Job job4 = new Job(4, "Importação de dados de integração", "2019-11-11 08:00:00", "4 horas");
		Job job5 = new Job(5, "Importação de dados de integração", "2019-11-11 08:00:00", "7 horas");
		List<Job> jobs = Arrays.asList(job1, job2, job3, job4, job5);
		return jobs;
	}

	public boolean validateTempoMaximoTotalJobs(ArrayList<Job> jobs) {
		Integer tempoMaximoCalculado = 0;
		for (int index = 0; index < jobs.size(); index++) {
			tempoMaximoCalculado += formatTempoEstimado(jobs.get(index).getTempoEstimado());
			if (tempoMaximoCalculado < tempoMaximoExecucao) {
				return true;
			}
		}
		return false;
	}

	public static boolean validateJanelaExecucao(String dataMaximaExecucao) {
		if (formatData(dataMaximaExecucao).getTime() <= formatData(dataFimJanela).getTime()
				&& formatData(dataMaximaExecucao).getTime() >= formatData(dataInicioJanela).getTime()) {
			return true;
		}
		return false;

	}

	public static Integer formatTempoEstimado(String string) {
		Integer _tempoMaximoExecucao = Integer.parseInt(string.split(" ")[0]);
		if (_tempoMaximoExecucao < tempoMaximoExecucao) {
			return _tempoMaximoExecucao;
		}
		return null;

	}

	private static Date formatData(String string) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ArrayList<Job>> escalonarJobsParaExecucao(List<Job> jobs) {
		List<ArrayList<Job>> escalonados = new ArrayList<ArrayList<Job>>();
		ArrayList<Job> auxJobs = new ArrayList<Job>();
		ArrayList<Job> _jobs = new ArrayList<Job>();
		Integer tempoTotal = 0;
		for (int index = 0, len = jobs.size(); index < len; index++) {
			if (formatTempoEstimado(jobs.get(index).getTempoEstimado()) != null) {
				tempoTotal += formatTempoEstimado(jobs.get(index).getTempoEstimado());
				if (formatTempoEstimado(jobs.get(index).getTempoEstimado()) < tempoMaximoExecucao
						&& tempoTotal < tempoMaximoExecucao
						&& validateJanelaExecucao(jobs.get(index).getDataMaximaConclusao())) {
					_jobs.add(jobs.get(index));
				} else {
					if (!auxJobs.contains(jobs.get(index))) {
						auxJobs.add(jobs.get(index));
					}
				}
			}
			if (!escalonados.contains(_jobs)) {
				escalonados.add(_jobs);
			}
		}
		if (auxJobs.size() > 0 && (!escalonados.contains(auxJobs))) {
			escalonados.addAll(escalonarJobsParaExecucao(auxJobs));
		}
		return escalonados;
	}
}
