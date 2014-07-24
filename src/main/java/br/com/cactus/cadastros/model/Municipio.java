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
@Table(name = "municipio")
public class Municipio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Uf uf;
	private String nome;
	private int codigoIbge;
	private int codigoReceitaFederal;
	private int codigoEstadual;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "ID_UF", referencedColumnName = "ID")	
	public Uf getUf() {
		return uf;
	}
	
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	
	@Column(length = 100)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "CODIGO_IBGE", length = 10)
	public int getCodigoIbge() {
		return codigoIbge;
	}
	
	public void setCodigoIbge(int codigoIbge) {
		this.codigoIbge = codigoIbge;
	}
	
	@Column(name = "CODIGO_RECEITA_FEDERAL", length = 10)
	public int getCodigoReceitaFederal() {
		return codigoReceitaFederal;
	}
	
	public void setCodigoReceitaFederal(int codigoReceitaFederal) {
		this.codigoReceitaFederal = codigoReceitaFederal;
	}
	
	@Column(name = "CODIGO_ESTADUAL", length = 10)
	public int getCodigoEstadual() {
		return codigoEstadual;
	}
	
	public void setCodigoEstadual(int codigoEstadual) {
		this.codigoEstadual = codigoEstadual;
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
		Municipio other = (Municipio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
