package br.com.cactus.cadastros.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cactus.cadastros.model.PessoaFisica;
import br.com.cactus.cadastros.repository.PessoaFisicaDao;
import br.com.cactus.cadastros.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = PessoaFisica.class)
public class PessoaFisicaConverter implements Converter {
	
	//@Inject
	private PessoaFisicaDao pessoaFisicaDao;
	
	public PessoaFisicaConverter() {
		pessoaFisicaDao = CDIServiceLocator.getBean(PessoaFisicaDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		PessoaFisica retorno = null;
		if (value != null) {
			Integer id = new Integer(value);
			retorno = pessoaFisicaDao.pesquisarPorId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			PessoaFisica pessoaFisica = (PessoaFisica) value;
			return pessoaFisica.getId() == null ? null : pessoaFisica.getId().toString();
		}
		return "";
	}
}