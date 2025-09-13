package com.mycompany.gerenciamentoentrevista.controller;

import com.mycompany.gerenciamentoentrevista.dao.CandidatoDAO;
import com.mycompany.gerenciamentoentrevista.model.Candidato;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CandidatoBean implements Serializable {

    @Inject
    private CandidatoDAO candidatoDAO;

    private Candidato candidato;
    private List<Candidato> candidatos;

    // Inicializa o bean
    public CandidatoBean() {
        this.candidato = new Candidato();
    }

    public void salvar() {
        try {
            candidatoDAO.save(candidato);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Candidato salvo com sucesso."));
            this.candidato = new Candidato(); // Limpa o formulário
            carregarCandidatos();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro ao salvar o candidato."));
            e.printStackTrace();
        }
    }

    public void carregarCandidatos() {
        this.candidatos = candidatoDAO.findAll();
    }

    // Getters e Setters
    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }
}