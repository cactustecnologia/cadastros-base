package br.com.cactus.cadastros.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "transportadora")
public class Transportadora implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date dataCadastro;
	private String observacao;
	
	private ContabilConta contabilConta;
	private Pessoa pessoa;
	
	
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
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@NotBlank
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
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
	
}
