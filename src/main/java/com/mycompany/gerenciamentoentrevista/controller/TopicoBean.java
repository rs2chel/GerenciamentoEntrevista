package com.mycompany.gerenciamentoentrevista.controller;

import com.mycompany.gerenciamentoentrevista.dao.TopicoDAO;
import com.mycompany.gerenciamentoentrevista.model.Topico;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class TopicoBean implements Serializable {

    @Inject
    private TopicoDAO topicoDAO;

    private Topico topico;
    private List<Topico> topicos;

    public TopicoBean() {
        this.topico = new Topico();
    }

    public void salvar() {
        try {
            topicoDAO.save(topico);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Tópico salvo com sucesso."));
            this.topico = new Topico();
            carregarTopicos();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro ao salvar o tópico."));
            e.printStackTrace();
        }
    }

    public void carregarTopicos() {
        this.topicos = topicoDAO.findAll();
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }
}