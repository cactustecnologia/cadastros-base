package br.com.cactus.cadastros.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String nome;
    private TipoPessoa tipo;
    private String email;
    private String site;
    private String cliente;
    private String fornecedor;
    private String colaborador;
    private String convenio;
    private String contador;
    private String transportadora;
    
    
    
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
	@Column(nullable = false, length = 150)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public TipoPessoa getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
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
	@Column(nullable = false, length = 250)
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}

	@Column(nullable = false, length = 1)
	public String getCliente() {
		return cliente;
	}
	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	@Column(nullable = false, length = 1)
	public String getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Column(nullable = false, length = 1)
	public String getColaborador() {
		return colaborador;
	}
	
	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}
	
	@Column(nullable = false, length = 1)
	public String getConvenio() {
		return convenio;
	}
	
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
	
	@Column(nullable = false, length = 1)
	public String getContador() {
		return contador;
	}
	
	public void setContador(String contador) {
		this.contador = contador;
	}
	
	@Column(nullable = false, length = 1)
	public String getTransportadora() {
		return transportadora;
	}
	
	public void setTransportadora(String transportadora) {
		this.transportadora = transportadora;
	}
	
}
