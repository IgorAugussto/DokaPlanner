package com.doka.organizer.repository;

import com.doka.organizer.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface está sendo usado para fazer as buscas (CRUD) com alguns funções já prontas para serem usadas
//Podendo também ser criado aqui na interface para algo mais especifico
public interface VisitorRepository extends JpaRepository<Visitor,Long> {
}
