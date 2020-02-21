package com.algaworks.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.pedidovenda.model.Grupo;
import com.algaworks.pedidovenda.repository.Grupos;
import com.algaworks.pedidovenda.service.PesquisaGrupoService;
import com.algaworks.pedidovenda.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Grupo.class)
public class GrupoConverter implements Converter {

    private PesquisaGrupoService service;

    public GrupoConverter() {
	this.service = CDIServiceLocator.getBean(PesquisaGrupoService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

	if (value != null) {
	    return service.porId(Long.parseLong(value));
	}

	return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

	if (value != null) {
	    Grupo produto = (Grupo) value;
	    return produto.getId() == null ? null : produto.getId().toString();
	}

	return null;
    }

}