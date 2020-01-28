package com.algaworks.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.repository.Categorias;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {

	@Inject
	private Categorias categorias;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if (value != null) {
			return categorias.porId(Long.parseLong(value));
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (value != null) {
			return ((Categoria) value).getId().toString();
		}
		
		return null;
	}

}
