package br.com.cactus.cadastros.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "fpas")
public class Fpas implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer codigo;
	private String cnae;
	private BigDecimal aliquotaSat;
	private String descricao;
	private BigDecimal percentualInssPatronal;
	private BigDecimal codigoTerceiro;
	private BigDecimal percentualTerceiros;

	private Empresa empresa;

	
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
	@Column(nullable = false, length = 10)
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@NotBlank
	@Column(nullable = false, length = 14)
	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
	}

	public BigDecimal getAliquotaSat() {
		return aliquotaSat;
	}

	public void setAliquotaSat(BigDecimal aliquotaSat) {
		this.aliquotaSat = aliquotaSat;
	}

	@NotBlank
	@Column(nullable = false, length = 250)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPercentualInssPatronal() {
		return percentualInssPatronal;
	}

	public void setPercentualInssPatronal(BigDecimal percentualInssPatronal) {
		this.percentualInssPatronal = percentualInssPatronal;
	}

	public BigDecimal getCodigoTerceiro() {
		return codigoTerceiro;
	}

	public void setCodigoTerceiro(BigDecimal codigoTerceiro) {
		this.codigoTerceiro = codigoTerceiro;
	}

	public BigDecimal getPercentualTerceiros() {
		return percentualTerceiros;
	}

	public void setPercentualTerceiros(BigDecimal percentualTerceiros) {
		this.percentualTerceiros = percentualTerceiros;
	}

	@NotNull
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}