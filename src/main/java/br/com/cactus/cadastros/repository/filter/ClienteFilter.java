package br.com.cactus.cadastros.repository.filter;

import java.math.BigDecimal;
import java.util.Date;

public class ClienteFilter {
	
	private String nome;
	private Date desde;
	private String situacaoForCli;
	private String atividadeForCli;
	private BigDecimal limiteCredito;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDesde() {
		return desde;
	}
	public void setDesde(Date desde) {
		this.desde = desde;
	}
	public String getSituacaoForCli() {
		return situacaoForCli;
	}
	public void setSituacaoForCli(String situacaoForCli) {
		this.situacaoForCli = situacaoForCli;
	}
	public String getAtividadeForCli() {
		return atividadeForCli;
	}
	public void setAtividadeForCli(String atividadeForCli) {
		this.atividadeForCli = atividadeForCli;
	}
	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}	
}
