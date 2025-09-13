package com.mycompany.gerenciamentoentrevista.controller;

import com.mycompany.gerenciamentoentrevista.dao.AvaliacaoDAO;
import com.mycompany.gerenciamentoentrevista.dao.CandidatoDAO;
import com.mycompany.gerenciamentoentrevista.dao.EntrevistadorDAO;
import com.mycompany.gerenciamentoentrevista.dao.TopicoDAO;
import com.mycompany.gerenciamentoentrevista.model.Avaliacao;
import com.mycompany.gerenciamentoentrevista.model.Candidato;
import com.mycompany.gerenciamentoentrevista.model.Entrevistador;
import com.mycompany.gerenciamentoentrevista.model.Topico;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Date;

@Named
@SessionScoped
public class AvaliacaoBean implements Serializable {

    @Inject
    private AvaliacaoDAO avaliacaoDAO;

    @Inject
    private CandidatoDAO candidatoDAO;

    @Inject
    private EntrevistadorDAO entrevistadorDAO;

    @Inject
    private TopicoDAO topicoDAO;

    private Avaliacao avaliacao;
    private List<Avaliacao> avaliacoes;
    private List<Candidato> candidatos;
    private List<Entrevistador> entrevistadores;
    private List<Topico> topicos;

    // Inicializa o bean
    public AvaliacaoBean() {
        this.avaliacao = new Avaliacao();
    }

    public void salvar() {
        try {
            avaliacao.setDataAvaliacao(new Date()); // Garante a data atual na avaliação
            avaliacaoDAO.save(avaliacao);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Avaliação salva com sucesso."));
            this.avaliacao = new Avaliacao();
            carregarAvaliacoes();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro ao salvar a avaliação."));
            e.printStackTrace();
        }
    }

    public void carregarAvaliacoes() {
        this.avaliacoes = avaliacaoDAO.findAll();
    }

    // Carrega dados para os <h:selectOneMenu>
    public void carregarDadosSelecao() {
        this.candidatos = candidatoDAO.findAll();
        this.entrevistadores = entrevistadorDAO.findAll();
        this.topicos = topicoDAO.findAll();
    }

    // Getters e Setters
    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public List<Entrevistador> getEntrevistadores() {
        return entrevistadores;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }
}