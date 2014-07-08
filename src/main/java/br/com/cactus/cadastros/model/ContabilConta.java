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
@Table(name = "contabil_conta")
public class ContabilConta implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String classificacao;
	private String tipo;
	private String descricao;
	private Date dataInclusao;
	private String situacao;
	private String natureza;
	private String patrimonioResultado;
	private String livroCaixa;
	private String dfc;
	private String ordem;
	private String codigoReduzido;
	private String codigoEfd;
	
	//não sei
	private ContabilConta contabilConta;
	private PlanoConta planoConta;
	private PlanoContaRefSped planoContaRefSped;
	
	
	
	//getter and setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@NotBlank
	@Column(nullable = false, length = 30)
	public String getClassificacao() {
		return classificacao;
	}
	
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	
	@NotBlank
	@Column(nullable = false, length = 1)
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@NotNull
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@NotNull
	public Date getDataInclusao() {
		return dataInclusao;
	}
	
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	
	@NotBlank
	@Column(nullable = false, length = 1)
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	@NotBlank
	@Column(nullable = false, length = 1)
	public String getNatureza() {
		return natureza;
	}
	
	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}
	
	@NotBlank
	@Column(nullable = false, length = 1)
	public String getPatrimonioResultado() {
		return patrimonioResultado;
	}
	
	public void setPatrimonioResultado(String patrimonioResultado) {
		this.patrimonioResultado = patrimonioResultado;
	}
	
	@NotBlank
	@Column(nullable = false, length = 1)
	public String getLivroCaixa() {
		return livroCaixa;
	}
	
	public void setLivroCaixa(String livroCaixa) {
		this.livroCaixa = livroCaixa;
	}
	
	@NotBlank
	@Column(nullable = false, length = 1)
	public String getDfc() {
		return dfc;
	}
	
	public void setDfc(String dfc) {
		this.dfc = dfc;
	}
	
	@NotBlank
	@Column(nullable = false, length = 20)
	public String getOrdem() {
		return ordem;
	}
	
	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}
	
	@NotBlank
	@Column(nullable = false, length = 10)
	public String getCodigoReduzido() {
		return codigoReduzido;
	}
	
	public void setCodigoReduzido(String codigoReduzido) {
		this.codigoReduzido = codigoReduzido;
	}
	
	@NotBlank
	@Column(nullable = false, length = 2)
	public String getCodigoEfd() {
		return codigoEfd;
	}
	
	public void setCodigoEfd(String codigoEfd) {
		this.codigoEfd = codigoEfd;
	}
	
	@NotNull
	public ContabilConta getContabilConta() {
		return contabilConta;
	}
	
	public void setContabilConta(ContabilConta contabilConta) {
		this.contabilConta = contabilConta;
	}
	
	@NotNull
	public PlanoConta getPlanoConta() {
		return planoConta;
	}
	
	public void setPlanoConta(PlanoConta planoConta) {
		this.planoConta = planoConta;
	}
	
	@NotNull
	public PlanoContaRefSped getPlanoContaRefSped() {
		return planoContaRefSped;
	}
	
	public void setPlanoContaRefSped(PlanoContaRefSped planoContaRefSped) {
		this.planoContaRefSped = planoContaRefSped;
	}
	
	
}
