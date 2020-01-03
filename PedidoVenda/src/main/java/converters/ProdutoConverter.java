package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Produto;

@FacesConverter("produtoConverter")
public class ProdutoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String string) {
	
	if (string == null || string.isEmpty()) {
	    return null;
	}
	
	return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object produto) {
	
	if (produto == null || !(produto instanceof Produto)) {
	    return null;
	}
	
	return null;
    }

}
