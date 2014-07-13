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

@Entity
@Table(name = "contador")
public class Contador implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String inscricaoCrc;
	private String ufCrc;
	private String fone;
	private String fax;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String cep;
	private String municipioIbge;
	private String Uf;
	private String email;	
	private Pessoa pessoa;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "INSCRICAO_CRC", nullable = false, length = 15)
	public String getInscricaoCrc() {
		return inscricaoCrc;
	}

	public void setInscricaoCrc(String inscricaoCrc) {
		this.inscricaoCrc = inscricaoCrc;
	}

	@Column(name = "UF_CRC", nullable = false, length = 2)
	public String getUfCrc() {
		return ufCrc;
	}

	public void setUfCrc(String ufCrc) {
		this.ufCrc = ufCrc;
	}

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

	@Column(nullable = false, length = 100)
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Column(nullable = false, length = 10)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(nullable = false, length = 100)
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Column(nullable = false, length = 60)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(nullable = false, length = 60)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(nullable = false, length = 8)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "MUNICIPIO_IBGE", nullable = false, length = 10)
	public String getMunicipioIbge() {
		return municipioIbge;
	}

	public void setMunicipioIbge(String municipioIbge) {
		this.municipioIbge = municipioIbge;
	}

	@Column(nullable = false, length = 2)
	public String getUf() {
		return Uf;
	}

	public void setUf(String uf) {
		Uf = uf;
	}

	@Column(nullable = false, length = 250)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne
	@JoinColumn(name = "id_pessoa", nullable = false)
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contador other = (Contador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
