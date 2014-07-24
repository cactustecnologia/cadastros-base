package br.com.cactus.cadastros.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cactus.cadastros.model.Municipio;
import br.com.cactus.cadastros.repository.MunicipioDao;
import br.com.cactus.cadastros.util.cdi.CDIServiceLocator;

@FacesConverter(value="converterMunicipio")
public class MunicipioConverter implements Converter {
	
	//@Inject
		private MunicipioDao municipioDao;
		
		public MunicipioConverter() {
			municipioDao = CDIServiceLocator.getBean(MunicipioDao.class);
		}
	
	 @Override
	    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	        if (value != null && !value.equals("")) {
	            municipioDao = new MunicipioDao();
	            return municipioDao.pesquisarPorId(Integer.valueOf(value));
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext context, UIComponent component, Object value) {
	        if (value instanceof Municipio) {
	            Municipio municipio = (Municipio) value;
	            return String.valueOf(municipio.getId());
	        }
	        return "";
	    }
}