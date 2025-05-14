package com.doka.organizer.repository;

import com.doka.organizer.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

//Por parametro dessa interface ela vai receber "Users que seria o tipo da entidade(tabela) e a char primaria que é o
//Id, sendo assim uma String
public interface UsersRepository extends JpaRepository<Users, String> {

    //Metodo para cosultar o usuário pelo login (email)
    UserDetails findByLogin(String login);
}
