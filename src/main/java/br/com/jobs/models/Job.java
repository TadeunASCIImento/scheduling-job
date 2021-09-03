package br.com.jobs.models;

/**
 * @author TadeunASCIImento
 *
 */
public class Job {

	private Integer id;
	private String descricao;
	private String data_maxima_execucao;
	private String tempo_estimado;

	public Job(Integer id, String descricao, String data_maxima_execucao, String tempo_estimado) {
		this.id = id;
		this.descricao = descricao;
		this.data_maxima_execucao = data_maxima_execucao;
		this.tempo_estimado = tempo_estimado;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getData_maxima_execucao() {
		return data_maxima_execucao;
	}

	public String getTempo_estimado() {
		return tempo_estimado;
	}

	@Override
	public String toString() {
		return "id:" + id + "\ndescricão:" + descricao + "\ndata máxima de execução: " + data_maxima_execucao
				+ "\ntempo estimado: " + tempo_estimado;
	}

}
