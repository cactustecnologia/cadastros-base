package br.com.cactus.cadastros.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.CloseEvent;
import br.com.cactus.cadastros.model.Contato;
import br.com.cactus.cadastros.model.Endereco;
import br.com.cactus.cadastros.model.EstadoCivil;
import br.com.cactus.cadastros.model.Pessoa;
import br.com.cactus.cadastros.model.PessoaFisica;
import br.com.cactus.cadastros.model.PessoaJuridica;
import br.com.cactus.cadastros.model.TipoPessoa;
import br.com.cactus.cadastros.model.TipoRaca;
import br.com.cactus.cadastros.model.TipoSangue;
import br.com.cactus.cadastros.model.TipoSexo;
import br.com.cactus.cadastros.repository.EstadoCivilDao;
import br.com.cactus.cadastros.repository.PessoaDao;
import br.com.cactus.cadastros.repository.PessoaFisicaDao;
import br.com.cactus.cadastros.repository.PessoaJuridicaDao;
import br.com.cactus.cadastros.util.jpa.Transactional;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private Contato contato;
	private Contato contatoSelecionado;
	private Endereco endereco;
	private Endereco enderecoSelecionado;
	private PessoaFisica pessoaFisica;
	private PessoaJuridica pessoaJuridica;	
	private List<EstadoCivil> listaEstadoCivil;	
	@Inject
	private PessoaDao pessoaDao;
	@Inject
	private EstadoCivilDao estadoCivilDao; 
	@Inject
	private PessoaFisicaDao pessoaFisicaDao;
	@Inject
	private PessoaJuridicaDao pessoaJuridicaDao;
	
	@PostConstruct
	public void init(){
		limpar();
		this.listarEstadoCivil();
	}
	
	public void limpar(){		
		this.pessoaJuridica = new PessoaJuridica();
		this.pessoa = new Pessoa();
		contato = new Contato();
		endereco = new Endereco();
		pessoaFisica = new PessoaFisica();
	}
		
	@Transactional
	public void salvar(){
		if (pessoa.getId()  == null) {	
			this.pessoa = pessoaDao.salvar(pessoa);
			if(TipoPessoa.FISICA.equals(pessoa.getTipo())){
				this.pessoaFisica.setPessoa(pessoa);
				pessoaFisicaDao.salvar(pessoaFisica);
			}
			if (TipoPessoa.JURIDICA.equals(pessoa.getTipo())){
				this.pessoaJuridica.setPessoa(pessoa);
				pessoaJuridicaDao.salvar(pessoaJuridica);
			}			
			FacesUtil.addInfoMessage("Pessoa salvo com sucesso!");
		} else {
			pessoaDao.atualizar(pessoa);
			FacesUtil.addInfoMessage("Pessoa atualizada com sucesso!");
		}
		limpar();
	}	
		
	public void adicionaContato(){
		if(this.contatoSelecionado == null){
			contato.setPessoa(pessoa);			
			this.pessoa.getContatos().add(this.contato);			
		}
		this.limparContato();
	}

	public void limparContato(){
		this.contato = new Contato();
		this.contatoSelecionado = null;
	}
	
	public void adicionaEndereco(){
		if (this.enderecoSelecionado == null) {
			endereco.setPessoa(pessoa);
			this.pessoa.getEnderecos().add(this.endereco);
		}
		limparEndereco();
	}
	
	public void limparEndereco(){
		this.endereco = new Endereco();
		this.enderecoSelecionado = null;
	}	
	
	public TipoPessoa[] getTiposPessoas() {
	    return TipoPessoa.values();
	}
	
	public TipoSexo[] getTiposSexos(){
		return TipoSexo.values();
	}
	
	public TipoRaca[] getTiposRacas(){
		return TipoRaca.values();
	}
	
	public TipoSangue[] getTiposSangues(){
		return TipoSangue.values();
	}
	
	public void listarEstadoCivil(){
		listaEstadoCivil = estadoCivilDao.todos();
	}
	
	public void handleClose(CloseEvent event) {
		if (contato != null) {
			contato = new Contato();
			this.contatoSelecionado = null;
			System.out.println("Chamou o fechar");
		}
		if (endereco != null) {
			endereco = new Endereco();
			this.enderecoSelecionado = null;
			System.out.println("Chamou o fechar");
		}
	}

	//GETTER AND SETTER
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Contato getContatoSelecionado() {
		return contatoSelecionado;
	}

	public void setContatoSelecionado(Contato contatoSelecionado) {
		this.contatoSelecionado = contatoSelecionado;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Endereco getEnderecoSelecionado() {
		return enderecoSelecionado;
	}

	public void setEnderecoSelecionado(Endereco enderecoSelecionado) {
		this.enderecoSelecionado = enderecoSelecionado;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public List<EstadoCivil> getListaEstadoCivil() {
		return listaEstadoCivil;
	}
}
