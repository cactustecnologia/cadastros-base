package br.com.cactus.cadastros.repository.filter;

import java.io.Serializable;
import java.util.Date;

import br.com.cactus.cadastros.model.EstadoCivil;
import br.com.cactus.cadastros.model.Pessoa;
import br.com.cactus.cadastros.model.TipoRaca;
import br.com.cactus.cadastros.model.TipoSangue;
import br.com.cactus.cadastros.model.TipoSexo;

public class PessoaFisicaFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;    
    private String cpf;    
    private String rg;    
    private String orgaoRg;    
    private Date dataEmissaoRg;    
    private Date dataNascimento;    
    private TipoSexo tipoSexo;    
    private String naturalidade;    
    private String nacionalidade;    
    private TipoRaca tipoRaca;    
    private TipoSangue tipoSangue;    
    private String cnhNumero;    
    private String cnhCategoria;    
    private Date cnhVencimento;    
    private String tituloEleitoralNumero;    
    private Integer tituloEleitoralZona;    
    private Integer tituloEleitoralSecao;    
    private String reservistaNumero;    
    private Integer reservistaCategoria;    
    private String nomeMae;    
    private String nomePai;        
    private EstadoCivil estadoCivil;    
    private Pessoa pessoa;
    
    
    //getter and setter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getOrgaoRg() {
		return orgaoRg;
	}
	public void setOrgaoRg(String orgaoRg) {
		this.orgaoRg = orgaoRg;
	}
	public Date getDataEmissaoRg() {
		return dataEmissaoRg;
	}
	public void setDataEmissaoRg(Date dataEmissaoRg) {
		this.dataEmissaoRg = dataEmissaoRg;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public TipoSexo getTipoSexo() {
		return tipoSexo;
	}
	public void setTipoSexo(TipoSexo tipoSexo) {
		this.tipoSexo = tipoSexo;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public TipoRaca getTipoRaca() {
		return tipoRaca;
	}
	public void setTipoRaca(TipoRaca tipoRaca) {
		this.tipoRaca = tipoRaca;
	}
	public TipoSangue getTipoSangue() {
		return tipoSangue;
	}
	public void setTipoSangue(TipoSangue tipoSangue) {
		this.tipoSangue = tipoSangue;
	}
	public String getCnhNumero() {
		return cnhNumero;
	}
	public void setCnhNumero(String cnhNumero) {
		this.cnhNumero = cnhNumero;
	}
	public String getCnhCategoria() {
		return cnhCategoria;
	}
	public void setCnhCategoria(String cnhCategoria) {
		this.cnhCategoria = cnhCategoria;
	}
	public Date getCnhVencimento() {
		return cnhVencimento;
	}
	public void setCnhVencimento(Date cnhVencimento) {
		this.cnhVencimento = cnhVencimento;
	}
	public String getTituloEleitoralNumero() {
		return tituloEleitoralNumero;
	}
	public void setTituloEleitoralNumero(String tituloEleitoralNumero) {
		this.tituloEleitoralNumero = tituloEleitoralNumero;
	}
	public Integer getTituloEleitoralZona() {
		return tituloEleitoralZona;
	}
	public void setTituloEleitoralZona(Integer tituloEleitoralZona) {
		this.tituloEleitoralZona = tituloEleitoralZona;
	}
	public Integer getTituloEleitoralSecao() {
		return tituloEleitoralSecao;
	}
	public void setTituloEleitoralSecao(Integer tituloEleitoralSecao) {
		this.tituloEleitoralSecao = tituloEleitoralSecao;
	}
	public String getReservistaNumero() {
		return reservistaNumero;
	}
	public void setReservistaNumero(String reservistaNumero) {
		this.reservistaNumero = reservistaNumero;
	}
	public Integer getReservistaCategoria() {
		return reservistaCategoria;
	}
	public void setReservistaCategoria(Integer reservistaCategoria) {
		this.reservistaCategoria = reservistaCategoria;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
