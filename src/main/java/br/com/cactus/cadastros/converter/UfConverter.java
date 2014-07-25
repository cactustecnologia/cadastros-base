package br.com.cactus.cadastros.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cactus.cadastros.model.Uf;
import br.com.cactus.cadastros.repository.UfDao;
import br.com.cactus.cadastros.util.cdi.CDIServiceLocator;

@FacesConverter(value="converterUf", forClass = Uf.class)
public class UfConverter implements Converter {

	//@Inject
		private UfDao ufDao;

		public UfConverter() {
			ufDao = CDIServiceLocator.getBean(UfDao.class);
		}

	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Uf retorno = null;
		if (value != null) {
			Integer id = new Integer(value);
			retorno = ufDao.pesquisarPorId(id);
		}
		return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
    	if (value != null) {
			Uf uf = (Uf) value;
			return uf.getId() == null ? null : uf.getId().toString();
		}
		return "";
    }
}