package br.com.cactus.cadastros.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CloseEvent;
import org.primefaces.model.LazyDataModel;

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
import br.com.cactus.cadastros.repository.filter.PessoaFisicaFilter;
import br.com.cactus.cadastros.repository.filter.PessoaJuridicaFilter;
import br.com.cactus.cadastros.service.PessoaService;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private Pessoa pessoaSelecionada;
	private Contato contato;
	private Contato contatoSelecionado;
	private Endereco endereco;
	private Endereco enderecoSelecionado;
	private PessoaFisica pessoaFisica;
	private PessoaJuridica pessoaJuridica;	
	private List<EstadoCivil> listaEstadoCivil;	
	@Inject
	private PessoaService pessoaService;
	@Inject
	private EstadoCivilDao estadoCivilDao;
	private LazyDataModel<PessoaFisica> lazyModelFisica;
	private LazyDataModel<PessoaJuridica> lazyModelJuridica;
	private PessoaFisicaFilter filtro;
	private PessoaJuridicaFilter filtroJuridica;
	
	@PostConstruct
	public void init(){
		limpar();
		this.listarEstadoCivil();
		filtro = new PessoaFisicaFilter();
		filtroJuridica = new PessoaJuridicaFilter();
		pesquisar();
	}
	
	public void limpar(){		
		this.pessoaJuridica = new PessoaJuridica();
		this.pessoa = new Pessoa();
		contato = new Contato();
		endereco = new Endereco();
		pessoaFisica = new PessoaFisica();
		pessoa.setTipo(TipoPessoa.FISICA);
	}
		
	public void salvar(){
		this.pessoaService.salvar(pessoa, pessoaFisica, pessoaJuridica);
		FacesUtil.addInfoMessage("Transação realizada com sucesso.");
		limpar();
	}
	
	public void pesquisar(){
		lazyModelFisica = pessoaService.filtrados(filtro);
		limparPesquisa();
	}
	
	public void pesquisarJuridica(){
		lazyModelJuridica = pessoaService.filtradosJuridica(filtroJuridica);
		limparPesquisa();
	}
	
	public void limparPesquisa(){
		this.filtro = new PessoaFisicaFilter();
		this.filtroJuridica = new PessoaJuridicaFilter();
	}
	
	public void excluir(){
		pessoaService.remover(pessoaSelecionada);
		pesquisar();
		FacesUtil.addInfoMessage("Pessoa " + pessoaSelecionada.getNome()
				+ " excluída com sucesso!");
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
	
	public void preparaAlterar(){
		this.setPessoa(pessoaSelecionada);
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

	public LazyDataModel<PessoaFisica> getLazyModelFisica() {
		return lazyModelFisica;
	}

	public void setLazyModelFisica(LazyDataModel<PessoaFisica> lazyModelFisica) {
		this.lazyModelFisica = lazyModelFisica;
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	public PessoaFisicaFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(PessoaFisicaFilter filtro) {
		this.filtro = filtro;
	}

	public LazyDataModel<PessoaJuridica> getLazyModelJuridica() {
		return lazyModelJuridica;
	}

	public void setLazyModelJuridica(LazyDataModel<PessoaJuridica> lazyModelJuridica) {
		this.lazyModelJuridica = lazyModelJuridica;
	}

	public PessoaJuridicaFilter getFiltroJuridica() {
		return filtroJuridica;
	}

	public void setFiltroJuridica(PessoaJuridicaFilter filtroJuridica) {
		this.filtroJuridica = filtroJuridica;
	}
}
