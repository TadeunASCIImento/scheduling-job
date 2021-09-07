package br.com.jobs;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.com.jobs.models.Job;
import br.com.jobs.models.Scheduling;

public class Main {

	public static void main(String[] args) {
		List<ArrayList<Job>> agendamento = Scheduling.escalonarJobsParaExecucao(new Scheduling().generateListJobs());
		if (agendamento.equals(null)) {
			System.out.println("N�o foram encontrados jobs para execu��o");
		} else {
			System.out.println(new Gson().toJson(agendamento));
		}
	}

}
