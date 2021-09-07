package br.com.jobs;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.com.jobs.models.Job;
import br.com.jobs.models.Scheduling;

public class Main {

	public static void main(String[] args) {
		Scheduling scheduling = new Scheduling();
		List<ArrayList<Job>> escalonados = scheduling.escalonarJobsParaExecucao(new Scheduling().generateListJobs());
		System.out.println(new Gson().toJson(escalonados));
	}

}
