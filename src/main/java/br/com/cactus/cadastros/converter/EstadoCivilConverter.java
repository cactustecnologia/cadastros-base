package br.com.cactus.cadastros.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.cactus.cadastros.model.EstadoCivil;
import br.com.cactus.cadastros.repository.EstadoCivilDao;
import br.com.cactus.cadastros.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = EstadoCivil.class)
public class EstadoCivilConverter implements Converter {
	
	private EstadoCivilDao estadoCivilDao;
	
	public EstadoCivilConverter(){
		estadoCivilDao = CDIServiceLocator.getBean(EstadoCivilDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		EstadoCivil retorno = null;
		if (value != null) {
			Integer id = new Integer(value);
			retorno = estadoCivilDao.pesquisarPorId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			EstadoCivil estadoCivil = (EstadoCivil) value;
			return estadoCivil.getId() == null ? null : estadoCivil.getId().toString();
		}
		return "";
	}

}
