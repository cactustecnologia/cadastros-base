package br.com.cactus.cadastros.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "fornecedor")
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date desde;
	private String optanteSimplesNacional;
	private String localizacao;
	private Date dataCadastro;
	private String sofreRetencao;
	private String chequeNominalA;
	private String observacao;
	private String contaCorrente;
	private Integer prazoMedioEntrega;
	private String geraFaturamento;
	private Integer numDiasPrimeiroVencimento;
	private Integer numDiasIntervalo;
	private Integer quantidadeParcelas;
	
	private ContabilConta contabilConta;
	private Pessoa pessoa;
	private AtividadeForCli atividadeForCli;
	private SituacaoForCli situacaoForCli;
	
	
	
	//getter and setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@NotNull
	public Date getDesde() {
		return desde;
	}
	
	public void setDesde(Date desde) {
		this.desde = desde;
	}
	
	@NotBlank
	@Column(nullable = false, length = 1)
	public String getOptanteSimplesNacional() {
		return optanteSimplesNacional;
	}
	
	public void setOptanteSimplesNacional(String optanteSimplesNacional) {
		this.optanteSimplesNacional = optanteSimplesNacional;
	}
	
	@NotBlank
	@Column(nullable = false, length = 1)
	public String getLocalizacao() {
		return localizacao;
	}
	
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	@NotNull
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@NotBlank
	@Column(nullable = false, length = 1)
	public String getSofreRetencao() {
		return sofreRetencao;
	}
	
	public void setSofreRetencao(String sofreRetencao) {
		this.sofreRetencao = sofreRetencao;
	}
	
	@NotBlank
	@Column(nullable = false, length = 100)
	public String getChequeNominalA() {
		return chequeNominalA;
	}
	
	public void setChequeNominalA(String chequeNominalA) {
		this.chequeNominalA = chequeNominalA;
	}
	
	@NotNull
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@NotBlank
	@Column(nullable = false, length = 30)
	public String getContaCorrente() {
		return contaCorrente;
	}
	
	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	
	@NotBlank
	@Column(nullable = false, length = 10)
	public Integer getPrazoMedioEntrega() {
		return prazoMedioEntrega;
	}
	
	public void setPrazoMedioEntrega(Integer prazoMedioEntrega) {
		this.prazoMedioEntrega = prazoMedioEntrega;
	}
	
	@NotBlank
	@Column(nullable = false, length = 1)
	public String getGeraFaturamento() {
		return geraFaturamento;
	}
	
	public void setGeraFaturamento(String geraFaturamento) {
		this.geraFaturamento = geraFaturamento;
	}
	
	@NotBlank
	@Column(nullable = false, length = 10)
	public Integer getNumDiasPrimeiroVencimento() {
		return numDiasPrimeiroVencimento;
	}
	
	public void setNumDiasPrimeiroVencimento(Integer numDiasPrimeiroVencimento) {
		this.numDiasPrimeiroVencimento = numDiasPrimeiroVencimento;
	}
	
	@NotBlank
	@Column(nullable = false, length = 10)
	public Integer getNumDiasIntervalo() {
		return numDiasIntervalo;
	}
	
	public void setNumDiasIntervalo(Integer numDiasIntervalo) {
		this.numDiasIntervalo = numDiasIntervalo;
	}
	
	@NotBlank
	@Column(nullable = false, length = 10)
	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}
	
	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}
	
	@NotNull
	public ContabilConta getContabilConta() {
		return contabilConta;
	}
	
	public void setContabilConta(ContabilConta contabilConta) {
		this.contabilConta = contabilConta;
	}
	
	@NotNull
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@NotNull
	public AtividadeForCli getAtividadeForCli() {
		return atividadeForCli;
	}
	
	public void setAtividadeForCli(AtividadeForCli atividadeForCli) {
		this.atividadeForCli = atividadeForCli;
	}
	
	@NotNull
	public SituacaoForCli getSituacaoForCli() {
		return situacaoForCli;
	}
	
	public void setSituacaoForCli(SituacaoForCli situacaoForCli) {
		this.situacaoForCli = situacaoForCli;
	}
	
}
