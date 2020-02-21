package com.algaworks.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.repository.Usuarios;
import com.algaworks.pedidovenda.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

    private Usuarios usuarios;

    public UsuarioConverter() {
	this.usuarios = CDIServiceLocator.getBean(Usuarios.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

	if (value != null) {
	    return usuarios.porId(Long.parseLong(value));
	}

	return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

	if (value != null) {
	    Usuario usuario = (Usuario) value;
	    return usuario.getId() == null ? null : usuario.getId().toString();
	}

	return null;
    }

}