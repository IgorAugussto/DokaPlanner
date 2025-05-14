package com.doka.organizer.infra.security;
//Essa classe está sendo usada para desabilitar as configurações padrão do SpringSecurity para a colocar um propria

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    SecurityFilter securityFilter;

    //Filtro de validaçãoes
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers(HttpMethod.POST,"/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST,"/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST,"/rooms").hasRole("MASTER")
                        // VISITANTES - qualquer role pode adicionar visitantes
                        .requestMatchers(HttpMethod.POST, "/visitors").hasAnyRole("USER", "ADMIN", "MASTER")
                        // ADICIONAR USUÁRIOS NA BASE (futuramente) - apenas ADMIN e MASTER
                        .requestMatchers(HttpMethod.POST, "/users/add").hasAnyRole("ADMIN", "MASTER")
                        // PROMOVER ALGUÉM PARA ADMIN - apenas ADMIN e MASTER
                        .requestMatchers(HttpMethod.PUT, "/users/promote").hasAnyRole("ADMIN", "MASTER")
                        // ROTA DE CONTROLE GERAL - só o MASTER pode
                        .requestMatchers("/admin/**").hasRole("MASTER")
                        .anyRequest().authenticated())
                .headers(headers -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    //Metodo para fazer a transformação de uma senha normal para uma senha em hash para que ele seja colocada da forma correta
    //no banco de dados
    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //Método pra fazer a criptografia das nossas senhas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
