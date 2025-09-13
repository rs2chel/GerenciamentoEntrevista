package com.mycompany.gerenciamentoentrevista.util;

import com.mycompany.gerenciamentoentrevista.dao.EntrevistadorDAO;
import com.mycompany.gerenciamentoentrevista.model.Entrevistador;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@FacesConverter(value = "entrevistadorConverter", managed = true)
public class EntrevistadorConverter implements Converter<Entrevistador> {

    @Inject
    private EntrevistadorDAO entrevistadorDAO;

    @Override
    public Entrevistador getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(value);
        return entrevistadorDAO.findById(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Entrevistador entrevistador) {
        if (entrevistador == null) {
            return null;
        }
        return entrevistador.getId().toString();
    }
}