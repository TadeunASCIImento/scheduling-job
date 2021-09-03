package br.com.jobs.models;

/**
 * @author TadeunASCIImento
 *
 */
public class Job {

	private Integer id;
	private String descricao;
	private String dataMaximaConclusao;
	private String tempoEstimado;

	public Job(Integer id, String descricao, String dataMAximaConclusao, String tempoEstimado) {
		this.id = id;
		this.descricao = descricao;
		this.dataMaximaConclusao = dataMAximaConclusao;
		this.tempoEstimado = tempoEstimado;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getData_maxima_execucao() {
		return dataMaximaConclusao;
	}

	public String getTempo_estimado() {
		return tempoEstimado;
	}

	@Override
	public String toString() {
		return "id:" + id + "\ndescricão:" + descricao + "\ndata máxima de execução: " + dataMaximaConclusao
				+ "\ntempo estimado: " + tempoEstimado;
	}

}
