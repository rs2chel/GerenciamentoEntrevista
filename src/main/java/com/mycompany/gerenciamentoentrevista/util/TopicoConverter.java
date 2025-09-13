package com.mycompany.gerenciamentoentrevista.util;

import com.mycompany.gerenciamentoentrevista.dao.TopicoDAO;
import com.mycompany.gerenciamentoentrevista.model.Topico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@FacesConverter(value = "topicoConverter", managed = true)
public class TopicoConverter implements Converter<Topico> {

    @Inject
    private TopicoDAO topicoDAO;

    @Override
    public Topico getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(value);
        return topicoDAO.findById(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Topico topico) {
        if (topico == null) {
            return null;
        }
        return topico.getId().toString();
    }
}