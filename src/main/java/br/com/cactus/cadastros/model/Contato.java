package br.com.cactus.cadastros.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "contato")
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String email;
	private String foneComercial;
	private String foneResidencial;
	private String foneCelular;
	
	private Pessoa pessoa;
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
	@Column(nullable = false, length = 100)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotBlank
	@Column(nullable = false, length = 250)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotBlank
	@Column(nullable = false, length = 14)
	public String getFoneComercial() {
		return foneComercial;
	}
	
	public void setFoneComercial(String foneComercial) {
		this.foneComercial = foneComercial;
	}
	
	@NotBlank
	@Column(nullable = false, length = 14)
	public String getFoneResidencial() {
		return foneResidencial;
	}
	
	public void setFoneResidencial(String foneResidencial) {
		this.foneResidencial = foneResidencial;
	}
	
	@NotBlank
	@Column(nullable = false, length = 14)
	public String getFoneCelular() {
		return foneCelular;
	}
	
	public void setFoneCelular(String foneCelular) {
		this.foneCelular = foneCelular;
	}
	
	@NotNull
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@NotNull
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
