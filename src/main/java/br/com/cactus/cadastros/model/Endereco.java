package br.com.cactus.cadastros.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String cep;
	private Integer municipioIbge;
	private String uf;
	private String fone;
	private String fax;
	private String principal;
	private String entrega;
	private String cobranca;
	private String correspondencia;	
	private Empresa empresa;
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
	
	@NotBlank
	@Column(nullable = false, length = 60)
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	@NotBlank
	@Column(nullable = false, length = 10)
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Column(nullable = false, length = 60)
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	@NotBlank
	@Column(nullable = false, length = 60)
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	@NotBlank
	@Column(nullable = false, length = 60)
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@NotBlank
	@Column(nullable = false, length = 8)
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	@NotNull
	public Integer getMunicipioIbge() {
		return municipioIbge;
	}
	
	public void setMunicipioIbge(Integer municipioIbge) {
		this.municipioIbge = municipioIbge;
	}
	
	@NotBlank
	@Column(nullable = false, length = 2)
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@NotBlank
	@Column(nullable = false, length = 14)
	public String getFone() {
		return fone;
	}
	
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	@Column(nullable = false, length = 14)
	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@NotNull
	public String getPrincipal() {
		return principal;
	}
	
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	
	@NotNull
	public String getEntrega() {
		return entrega;
	}
	
	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}
	
	@NotNull
	public String getCobranca() {
		return cobranca;
	}
	
	public void setCobranca(String cobranca) {
		this.cobranca = cobranca;
	}
	
	@NotNull
	public String getCorrespondencia() {
		return correspondencia;
	}
	
	public void setCorrespondencia(String correspondencia) {
		this.correspondencia = correspondencia;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable = false)
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_pessoa", nullable = false)
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
