package br.com.cactus.cadastros.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cactus.cadastros.model.AtividadeForCli;
import br.com.cactus.cadastros.model.Pessoa;
import br.com.cactus.cadastros.repository.AtividadeForCliDao;
import br.com.cactus.cadastros.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Pessoa.class)
public class AtividadeForCliConverter implements Converter {
	
	//@Inject
	private AtividadeForCliDao atividadeForCliDao;
	
	public AtividadeForCliConverter() {
		atividadeForCliDao = CDIServiceLocator.getBean(AtividadeForCliDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		AtividadeForCli retorno = null;
		if (value != null) {
			Integer id = new Integer(value);
			retorno = atividadeForCliDao.pesquisarPorId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			AtividadeForCli atividadeForCli = (AtividadeForCli) value;
			return atividadeForCli.getId() == null ? null : atividadeForCli.getId().toString();
		}
		return "";
	}
}