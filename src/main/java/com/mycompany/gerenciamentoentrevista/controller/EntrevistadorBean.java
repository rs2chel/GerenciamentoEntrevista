package com.mycompany.gerenciamentoentrevista.controller;

import com.mycompany.gerenciamentoentrevista.dao.EntrevistadorDAO;
import com.mycompany.gerenciamentoentrevista.model.Entrevistador;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class EntrevistadorBean implements Serializable {

    @Inject
    private EntrevistadorDAO entrevistadorDAO;

    private Entrevistador entrevistador;
    private List<Entrevistador> entrevistadores;

    public EntrevistadorBean() {
        this.entrevistador = new Entrevistador();
    }

    public void salvar() {
        try {
            entrevistadorDAO.save(entrevistador);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Entrevistador salvo com sucesso."));
            this.entrevistador = new Entrevistador();
            carregarEntrevistadores();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro ao salvar o entrevistador."));
            e.printStackTrace();
        }
    }

    public void carregarEntrevistadores() {
        this.entrevistadores = entrevistadorDAO.findAll();
    }

    public Entrevistador getEntrevistador() {
        return entrevistador;
    }

    public void setEntrevistador(Entrevistador entrevistador) {
        this.entrevistador = entrevistador;
    }

    public List<Entrevistador> getEntrevistadores() {
        return entrevistadores;
    }

    public void setEntrevistadores(List<Entrevistador> entrevistadores) {
        this.entrevistadores = entrevistadores;
    }
}