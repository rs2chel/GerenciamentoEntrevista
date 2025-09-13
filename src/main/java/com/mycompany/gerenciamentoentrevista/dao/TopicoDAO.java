package com.mycompany.gerenciamentoentrevista.dao;

import com.mycompany.gerenciamentoentrevista.model.Topico;
import java.util.List;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TopicoDAO extends GenericDAO<Topico, Long> {

    public List<Topico> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void save(Topico topico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Topico findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}