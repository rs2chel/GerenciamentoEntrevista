package com.mycompany.gerenciamentoentrevista.util;

import com.mycompany.gerenciamentoentrevista.dao.CandidatoDAO;
import com.mycompany.gerenciamentoentrevista.model.Candidato;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@FacesConverter(value = "candidatoConverter", managed = true) // managed = true para CDI
public class CandidatoConverter implements Converter<Candidato> {

    @Inject
    private CandidatoDAO candidatoDAO;

    @Override
    public Candidato getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(value);
        return candidatoDAO.findById(id); // Busca o objeto Candidato pelo ID
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Candidato candidato) {
        if (candidato == null) {
            return null;
        }
        return candidato.getId().toString(); // Retorna o ID do Candidato como String
    }
}