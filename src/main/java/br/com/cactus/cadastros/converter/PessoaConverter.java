package br.com.cactus.cadastros.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.cactus.cadastros.model.Pessoa;
import br.com.cactus.cadastros.repository.PessoaDao;
import br.com.cactus.cadastros.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter {
	
	//@Inject
	private PessoaDao pessoaDao;
	
	public PessoaConverter() {
		pessoaDao = CDIServiceLocator.getBean(PessoaDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;
		if (value != null) {
			Integer id = new Integer(value);
			retorno = pessoaDao.pesquisarPorId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Pessoa pessoa = (Pessoa) value;
			return pessoa.getId() == null ? null : pessoa.getId().toString();
		}
		return "";
	}
}