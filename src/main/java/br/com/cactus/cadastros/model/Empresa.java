package br.com.cactus.cadastros.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

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
	private BigDecimal aliquotaPis;
	private String contato;
	private BigDecimal aliquotaCofins;
	private Integer codigoIbgeCidade;
	private Integer codigoIbgeUf;
	private Integer codigoTerceiros;
	private Integer codigoGps;
	private BigDecimal aliquotaSat;
	private String cei;
	private String codigoCnaePrincipal;	
	private Empresa empresa;
	private SindicatoPatronal sindicatoPatronal;
	private Fpas fpas;
	private Contador contador;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@NotBlank
	@Column(name = "RAZAO_SOCIAL", nullable = false, length = 150)
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	@NotBlank
	@Column(name = "NOME_FANTASIA", nullable = false, length = 150)
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
		
	@Column(nullable = false, length = 14)
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Column(name = "INSCRICAO_ESTADUAL", nullable = false, length = 30)
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
	@Column(name = "INSCRICAO_ESTADUAL_ST", nullable = false, length = 30)
	public String getInscricaoEstadualSt() {
		return inscricaoEstadualSt;
	}
	
	public void setInscricaoEstadualSt(String inscricaoEstadualSt) {
		this.inscricaoEstadualSt = inscricaoEstadualSt;
	}
	
	@Column(name = "INSCRICAO_MUNICIPAL", nullable = false, length = 30)
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	
	@Column(name = "INSCRICAO_JUNTA_COMERCIAL", nullable = false, length = 30)
	public String getInscricaoJuntaComercial() {
		return inscricaoJuntaComercial;
	}
	
	public void setInscricaoJuntaComercial(String inscricaoJuntaComercial) {
		this.inscricaoJuntaComercial = inscricaoJuntaComercial;
	}
	
	@Column(name = "DATA_INSC_JUNTA_COMERCIAL")
	public Date getDataInscJuntaComercial() {
		return dataInscJuntaComercial;
	}
	
	public void setDataInscJuntaComercial(Date dataInscJuntaComercial) {
		this.dataInscJuntaComercial = dataInscJuntaComercial;
	}
		
	@Column(nullable = false, length = 1)
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Column(name = "DATA_CADASTRO")
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@Column(name = "DATA_INICIO_ATIVIDADES")
	public Date getDataInicioAtividades() {
		return dataInicioAtividades;
	}
	
	public void setDataInicioAtividades(Date dataInicioAtividades) {
		this.dataInicioAtividades = dataInicioAtividades;
	}
	
	@Column(nullable = false, length = 9)
	public String getSuframa() {
		return suframa;
	}
	
	public void setSuframa(String suframa) {
		this.suframa = suframa;
	}
	
	@Column(nullable = false, length = 250)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "IMAGEM_LOGOTIPO")
	public String getImagemLogotipo() {
		return imagemLogotipo;
	}
	
	public void setImagemLogotipo(String imagemLogotipo) {
		this.imagemLogotipo = imagemLogotipo;
	}
	
	@Column(nullable = false, length = 1)
	public String getCrt() {
		return crt;
	}
	
	public void setCrt(String crt) {
		this.crt = crt;
	}
	
	@Column(name = "TIPO_REGIME", nullable = false, length = 1)
	public String getTipoRegime() {
		return tipoRegime;
	}
	
	public void setTipoRegime(String tipoRegime) {
		this.tipoRegime = tipoRegime;
	}
		
	@Column(nullable = false, length = 50)
	public String getContato() {
		return contato;
	}
	
	public void setContato(String contato) {
		this.contato = contato;
	}	
	
	@Column(name = "CODIGO_IBGE_CIDADE", nullable = false, length = 10)
	public Integer getCodigoIbgeCidade() {
		return codigoIbgeCidade;
	}
	
	public void setCodigoIbgeCidade(Integer codigoIbgeCidade) {
		this.codigoIbgeCidade = codigoIbgeCidade;
	}
	
	@Column(name = "CODIGO_IBGE_UF", nullable = false, length = 10)
	public Integer getCodigoIbgeUf() {
		return codigoIbgeUf;
	}
	
	public void setCodigoIbgeUf(Integer codigoIbgeUf) {
		this.codigoIbgeUf = codigoIbgeUf;
	}
	
	@Column(name = "CODIGO_TERCEIROS", nullable = false, length = 10)
	public Integer getCodigoTerceiros() {
		return codigoTerceiros;
	}
	
	public void setCodigoTerceiros(Integer codigoTerceiros) {
		this.codigoTerceiros = codigoTerceiros;
	}
	
	@Column(name = "CODIGO_GPS", nullable = false, length = 10)
	public Integer getCodigoGps() {
		return codigoGps;
	}
	
	public void setCodigoGps(Integer codigoGps) {
		this.codigoGps = codigoGps;
	}
	
	@Column(nullable = false, length = 12)
	public String getCei() {
		return cei;
	}
	
	public void setCei(String cei) {
		this.cei = cei;
	}
	
	@Column(name = "CODIGO_CNAE_PRINCIPAL", nullable = false, length = 7)
	public String getCodigoCnaePrincipal() {
		return codigoCnaePrincipal;
	}
		
	public void setCodigoCnaePrincipal(String codigoCnaePrincipal) {
		this.codigoCnaePrincipal = codigoCnaePrincipal;
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
	@JoinColumn(name = "id_sindicato_patronal", nullable = false)
	public SindicatoPatronal getSindicatoPatronal() {
		return sindicatoPatronal;
	}
	
	public void setSindicatoPatronal(SindicatoPatronal sindicatoPatronal) {
		this.sindicatoPatronal = sindicatoPatronal;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_fpas", nullable = false)
	public Fpas getFpas() {
		return fpas;
	}
	
	public void setFpas(Fpas fpas) {
		this.fpas = fpas;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_contador", nullable = false)
	public Contador getContador() {
		return contador;
	}
	
	public void setContador(Contador contador) {
		this.contador = contador;
	}

	@Column(name = "ALIQUOTA_PIS")
	public BigDecimal getAliquotaPis() {
		return aliquotaPis;
	}

	public void setAliquotaPis(BigDecimal aliquotaPis) {
		this.aliquotaPis = aliquotaPis;
	}

	@Column(name = "ALIQUOTA_COFINS")
	public BigDecimal getAliquotaCofins() {
		return aliquotaCofins;
	}

	public void setAliquotaCofins(BigDecimal aliquotaCofins) {
		this.aliquotaCofins = aliquotaCofins;
	}

	@Column(name = "ALIQUOTA_SAT")
	public BigDecimal getAliquotaSat() {
		return aliquotaSat;
	}

	public void setAliquotaSat(BigDecimal aliquotaSat) {
		this.aliquotaSat = aliquotaSat;
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
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}