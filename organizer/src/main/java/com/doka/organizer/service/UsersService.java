package com.doka.organizer.service;

import com.doka.organizer.entity.UserRole;
import com.doka.organizer.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UsersService implements UserDetails {

    //Final define que a variavel não pode ser alterada depois de inicializada dentro do construtor
    private final Users user;

    public UsersService(Users user) {
        this.user = user;
    }

    //Essa função vai ser chamada para ver quais as roles que nós temos
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.user.getRole() == UserRole.MASTER) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_MASTER"),
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        }
        else if (this.user.getRole() == UserRole.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        }
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //Checa se a credencial não está bloqueada
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //Checa se a credencial não está expirada
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //Checa se o usuário está ativo
    @Override
    public boolean isEnabled() {
        return true;
    }
}
