package com.doka.organizer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doka.organizer.entity.Visitor;
import com.doka.organizer.repository.VisitorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorService {
    //Essa função junto com o Autowired serve para acessar banco de dado, executar concultas pré-definidas e manipular entidades relacionada aos viistantes do sistema
    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Autowired
    private VisitorRepository visitorRepository;

    public Visitor createVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    public List<Visitor> listAll() {
        return visitorRepository.findAll();
    }

    // a classe Optional serve para lidar com valores nulos de maneira mais segura e elegante.
    // Isso permite evitar o clássico erro de NullPointerException, forçando você a lidar explicitamente com a ausência de valor.
    public Optional<Visitor> searchForId(Long id) {
        return visitorRepository.findById(id);
    }

    public Visitor updateVisitor(Long id, Visitor updatedVisitor) {
        return visitorRepository.findById(id).map(v -> {
            v.setName(updatedVisitor.getName());
            v.setCellphone(updatedVisitor.getCellphone());
            v.setAge(updatedVisitor.getAge());
            v.setChurch(updatedVisitor.getChurch());
            return visitorRepository.save(v);
        }).orElseThrow(() -> new RuntimeException("Visitante não encontrado com ID: " + id));
    }

    public void deleteVisitor(Long id) {
        visitorRepository.deleteById(id);
    }

}
