package com.mycompany.gerenciamentoentrevista.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "avaliacao")
public class Avaliacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nota")
    private Integer nota;

    @Column(name = "data_avaliacao")
    private Date dataAvaliacao;

    // Relacionamento com Candidato
    @ManyToOne
    @JoinColumn(name = "candidato_id", nullable = false)
    private Candidato candidato;

    // Relacionamento com Entrevistador
    @ManyToOne
    @JoinColumn(name = "entrevistador_id", nullable = false)
    private Entrevistador entrevistador;

    // Relacionamento com Topico
    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    // Construtores
    public Avaliacao() {
        this.dataAvaliacao = new Date(); // Define a data atual por padrão
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Entrevistador getEntrevistador() {
        return entrevistador;
    }

    public void setEntrevistador(Entrevistador entrevistador) {
        this.entrevistador = entrevistador;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }
}