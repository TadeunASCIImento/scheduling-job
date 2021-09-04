package br.com.jobs.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Scheduling {

	private List<Job> listJobs;
	private String dataInicioJanela = "2019-11-10 09:00:00";
	private String dataFimJanela = "2019-11-11 12:00:00";
	private Integer tempoMaximoExecucao;

	public List<Job> generateListJobs() {
		Job j1 = new Job(1, "Importação de arquivos de fundos", "2019-11-10 12:00:00", "2 horas");
		Job j2 = new Job(2, "Importação de dados da Base Legada", "2019-11-11 12:00:00", "4 horas");
		Job j3 = new Job(3, "Importação de dados de integração", "2019-11-10 08:00:00", "6 horas");
		listJobs = Arrays.asList(j1, j2, j3);
		return listJobs;
	}

	public boolean validateJanelaExecucao(String dataMaximaExecucao) {
		if (formatData(dataMaximaExecucao).getTime() <= formatData(dataFimJanela).getTime()
				&& formatData(dataMaximaExecucao).getTime() >= formatData(dataInicioJanela).getTime()) {
			return true;
		}
		return false;

	}

	private Date formatData(String string) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
