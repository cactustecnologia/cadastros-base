package br.com.cactus.cadastros.repository;

import java.io.Serializable;

import br.com.cactus.cadastros.model.Cliente;

public class ClienteDao extends GenericRepositoryDaoImpl<Cliente> 
	implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Cliente guardar(Cliente cliente){
		if(cliente.getId() == null) {
			return salvar(cliente);
		}else {
			return atualizar(cliente);
		}
	}
}
