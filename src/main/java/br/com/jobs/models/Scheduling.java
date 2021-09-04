package br.com.jobs.models;

import java.util.Arrays;
import java.util.List;

public class Scheduling {

	private List<Job> listJobs;
	private String dataInicioJanela;
	private String dataFimJanela;
	private Integer tempoMaximoExecucao;

	public List<Job> generateListJobs() {
		Job j1 = new Job(1, "Importação de arquivos de fundos", "2019-11-10 12:00:00", "2 horas");
		Job j2 = new Job(2, "Importação de dados da Base Legada", "2019-11-11 12:00:00", "4 horas");
		Job j3 = new Job(3, "Importação de dados de integração", "2019-11-10 08:00:00", "6 horas");
		listJobs = Arrays.asList(j1, j2, j3);
		return listJobs;
	}

}
