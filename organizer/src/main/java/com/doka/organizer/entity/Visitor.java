package com.doka.organizer.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "VISITOR")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "REGISTRATION_DATE", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "CELLPHONE")
    private String Cellphone;

    @Column(name = "AGE")
    private int age;

    @Column(name = "CHURCH")
    private String church;

    @Column(name = "MET_THE_CHRUCH")
    private String metTheChurch;



    public Visitor() {
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return Cellphone;
    }

    public void setCellphone(String Cellphone) {
        this.Cellphone = Cellphone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getChurch() { return church; }

    public void setChurch(String church) { this.church = church; }

    public LocalDate getRegistrationDate() { return registrationDate; }

    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getMetTheChurch() { return metTheChurch; }

    public void setMetTheChurch(String metTheChurch) { this.metTheChurch = metTheChurch; }
}

