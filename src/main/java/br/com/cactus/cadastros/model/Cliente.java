package br.com.cactus.cadastros.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name ="cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date desde;
	private Date dataCadastro;
	private String observacao;
	private String contaTomador;
	private String geraFinanceiro;
	private String indicadorPreco;
	private BigDecimal porcentoDesconto;
	private String formaDesconto;
	private BigDecimal limiteCredito;
	private String tipoFrete;
	private ContabilConta contabilConta;
	//tribut_operacao_fiscal
	private OperacaoFiscal operacaoFiscal;
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
	
	@NotNull
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@NotBlank
	@Column(nullable = false, length = 30)
	public String getContaTomador() {
		return contaTomador;
	}
	
	public void setContaTomador(String contaTomador) {
		this.contaTomador = contaTomador;
	}
	
	@NotBlank
	@Column(nullable = false, length = 1)
	public String getGeraFinanceiro() {
		return geraFinanceiro;
	}
	
	public void setGeraFinanceiro(String geraFinanceiro) {
		this.geraFinanceiro = geraFinanceiro;
	}
	
	@NotBlank
	@Column(nullable = false, length = 1)
	public String getIndicadorPreco() {
		return indicadorPreco;
	}
	
	public void setIndicadorPreco(String indicadorPreco) {
		this.indicadorPreco = indicadorPreco;
	}
	
	@NotBlank
	@Column(nullable = false, length = 1)
	public String getFormaDesconto() {
		return formaDesconto;
	}
	
	public void setFormaDesconto(String formaDesconto) {
		this.formaDesconto = formaDesconto;
	}
		
	@NotBlank
	@Column(nullable = false, length = 1)
	public String getTipoFrete() {
		return tipoFrete;
	}
	
	public void setTipoFrete(String tipoFrete) {
		this.tipoFrete = tipoFrete;
	}
	
	@NotNull
	public ContabilConta getContabilConta() {
		return contabilConta;
	}
	
	public void setContabilConta(ContabilConta contabilConta) {
		this.contabilConta = contabilConta;
	}
	
	@NotNull
	public OperacaoFiscal getOperacaoFiscal() {
		return operacaoFiscal;
	}
	
	public void setOperacaoFiscal(OperacaoFiscal operacaoFiscal) {
		this.operacaoFiscal = operacaoFiscal;
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

	public BigDecimal getPorcentoDesconto() {
		return porcentoDesconto;
	}

	public void setPorcentoDesconto(BigDecimal porcentoDesconto) {
		this.porcentoDesconto = porcentoDesconto;
	}

	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}	
}
