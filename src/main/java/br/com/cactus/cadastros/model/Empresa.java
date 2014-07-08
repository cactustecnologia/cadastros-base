package br.com.cactus.cadastros.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private String inscricaoEstadual;
	private String inscricaoEstadualSt;
	private String inscricaoMunicipal;
	private String inscricaoJuntaComercial;
	private Date dataInscJuntaComercial;
	private String tipo;
	private Date dataCadastro;
	private Date dataInicioAtividades;
	private String suframa;
	private String email;
	private String imagemLogotipo;
	private String crt;
	private String tipoRegime;
	private double aliquotaPis;
	private String contato;
	private double aliquotaCofins;
	private Integer codigoIbgeCidade;
	private Integer codigoIbgeUf;
	private Integer codigoTerceiros;
	private Integer codigoGps;
	private double aliquotaSat;
	private String cei;
	private String codigoCnaePrincipal;
	
	//não sei
	private Empresa empresa;
	private SindicatoPatronal sindicatoPatronal;
	private Fpas fpas;
	private Contador contador;
	
	
	//getter and setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getInscricaoEstadualSt() {
		return inscricaoEstadualSt;
	}
	public void setInscricaoEstadualSt(String inscricaoEstadualSt) {
		this.inscricaoEstadualSt = inscricaoEstadualSt;
	}
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	public String getInscricaoJuntaComercial() {
		return inscricaoJuntaComercial;
	}
	public void setInscricaoJuntaComercial(String inscricaoJuntaComercial) {
		this.inscricaoJuntaComercial = inscricaoJuntaComercial;
	}
	public Date getDataInscJuntaComercial() {
		return dataInscJuntaComercial;
	}
	public void setDataInscJuntaComercial(Date dataInscJuntaComercial) {
		this.dataInscJuntaComercial = dataInscJuntaComercial;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getDataInicioAtividades() {
		return dataInicioAtividades;
	}
	public void setDataInicioAtividades(Date dataInicioAtividades) {
		this.dataInicioAtividades = dataInicioAtividades;
	}
	public String getSuframa() {
		return suframa;
	}
	public void setSuframa(String suframa) {
		this.suframa = suframa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImagemLogotipo() {
		return imagemLogotipo;
	}
	public void setImagemLogotipo(String imagemLogotipo) {
		this.imagemLogotipo = imagemLogotipo;
	}
	public String getCrt() {
		return crt;
	}
	public void setCrt(String crt) {
		this.crt = crt;
	}
	public String getTipoRegime() {
		return tipoRegime;
	}
	public void setTipoRegime(String tipoRegime) {
		this.tipoRegime = tipoRegime;
	}
	public double getAliquotaPis() {
		return aliquotaPis;
	}
	public void setAliquotaPis(double aliquotaPis) {
		this.aliquotaPis = aliquotaPis;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public double getAliquotaCofins() {
		return aliquotaCofins;
	}
	public void setAliquotaCofins(double aliquotaCofins) {
		this.aliquotaCofins = aliquotaCofins;
	}
	public Integer getCodigoIbgeCidade() {
		return codigoIbgeCidade;
	}
	public void setCodigoIbgeCidade(Integer codigoIbgeCidade) {
		this.codigoIbgeCidade = codigoIbgeCidade;
	}
	public Integer getCodigoIbgeUf() {
		return codigoIbgeUf;
	}
	public void setCodigoIbgeUf(Integer codigoIbgeUf) {
		this.codigoIbgeUf = codigoIbgeUf;
	}
	public Integer getCodigoTerceiros() {
		return codigoTerceiros;
	}
	public void setCodigoTerceiros(Integer codigoTerceiros) {
		this.codigoTerceiros = codigoTerceiros;
	}
	public Integer getCodigoGps() {
		return codigoGps;
	}
	public void setCodigoGps(Integer codigoGps) {
		this.codigoGps = codigoGps;
	}
	public double getAliquotaSat() {
		return aliquotaSat;
	}
	public void setAliquotaSat(double aliquotaSat) {
		this.aliquotaSat = aliquotaSat;
	}
	public String getCei() {
		return cei;
	}
	public void setCei(String cei) {
		this.cei = cei;
	}
	public String getCodigoCnaePrincipal() {
		return codigoCnaePrincipal;
	}
	public void setCodigoCnaePrincipal(String codigoCnaePrincipal) {
		this.codigoCnaePrincipal = codigoCnaePrincipal;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public SindicatoPatronal getSindicatoPatronal() {
		return sindicatoPatronal;
	}
	public void setSindicatoPatronal(SindicatoPatronal sindicatoPatronal) {
		this.sindicatoPatronal = sindicatoPatronal;
	}
	public Fpas getFpas() {
		return fpas;
	}
	public void setFpas(Fpas fpas) {
		this.fpas = fpas;
	}
	public Contador getContador() {
		return contador;
	}
	public void setContador(Contador contador) {
		this.contador = contador;
	}

}
