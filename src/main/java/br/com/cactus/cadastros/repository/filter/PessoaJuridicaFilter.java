package br.com.cactus.cadastros.repository.filter;

import java.io.Serializable;
import java.util.Date;

import br.com.cactus.cadastros.model.Pessoa;

public class PessoaJuridicaFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;    
    private String cnpj;    
    private String fantasia;    
    private String inscricaoMunicipal;    
    private String inscricaoEstadual;    
    private Date dataConstituicao;    
    private String tipoRegime;    
    private String tipoCrt;    
    private String suframa;    
    private Pessoa pessoa;
    
    
    //getter and setter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getFantasia() {
		return fantasia;
	}
	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public Date getDataConstituicao() {
		return dataConstituicao;
	}
	public void setDataConstituicao(Date dataConstituicao) {
		this.dataConstituicao = dataConstituicao;
	}
	public String getTipoRegime() {
		return tipoRegime;
	}
	public void setTipoRegime(String tipoRegime) {
		this.tipoRegime = tipoRegime;
	}
	public String getTipoCrt() {
		return tipoCrt;
	}
	public void setTipoCrt(String tipoCrt) {
		this.tipoCrt = tipoCrt;
	}
	public String getSuframa() {
		return suframa;
	}
	public void setSuframa(String suframa) {
		this.suframa = suframa;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
