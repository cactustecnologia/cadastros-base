package br.com.cactus.cadastros.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class CnpjConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        /*
         * Irá converter CNPJ formatado para um sem pontos e traço.
         * Ex.: 0 3 . 2 4 5 . 1 9 8  /  0  0  3  0  -  2  2 torna-se 03245198003022
         * 		0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
         */
         String cnpj = value;
         if (value!= null && !value.equals(""))
              cnpj = value.replaceAll("\\.", "").replaceAll("\\/", "").replaceAll("\\-", "");

         return cnpj;
    }

	@Override
	 public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        /*
         * Irá converter CNPJ não formatado para um com pontos e traço.
         * Ex.: 03245198003022 torna-se  03.245.198/0030-22
         * 								130.946.848-66
         */
         String cnpj= (String) value;
         if (cnpj != null && cnpj.length() == 14)
        	 cnpj = cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" +cnpj.substring(12, 14);

         return cnpj;
    }
}
