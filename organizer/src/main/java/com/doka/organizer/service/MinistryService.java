package com.doka.organizer.service;

import com.doka.organizer.entity.Ministry;
import com.doka.organizer.repository.MinistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinistryService {

    @Autowired
    private MinistryRepository ministryRepository;

    // Salvar um novo ministério
    public Ministry saveMinistry(Ministry ministry) {
        return ministryRepository.save(ministry);
    }

    // Buscar todos os ministérios
    public List<Ministry> getAllMinistries() {
        return ministryRepository.findAll();
    }
}
