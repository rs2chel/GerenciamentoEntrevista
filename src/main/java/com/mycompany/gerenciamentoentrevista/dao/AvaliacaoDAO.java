package com.mycompany.gerenciamentoentrevista.dao;

import com.mycompany.gerenciamentoentrevista.model.Avaliacao;
import java.util.List;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class AvaliacaoDAO extends GenericDAO<Avaliacao, Long> {

    public void save(Avaliacao avaliacao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Avaliacao> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}