package br.com.cactus.cadastros.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "ESTADO_CIVIL")
public class EstadoCivil implements Serializable {

    private static final long serialVersionUID = 1L;
    //teste de atualizacao pelo github
    //teste de atualizacao pelo notebook
    //teste notebook silvio
    private Integer id;    
    private String nome;    
    private String descricao;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
		return id;
	}
    
	public void setId(Integer id) {
		this.id = id;
	}
	
	@NotBlank
	@Column(nullable = false, length = 50)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}    
}
