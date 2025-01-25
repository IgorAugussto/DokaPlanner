package com.doka.organizer.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.util.List;

@Entity
@Table(name = "MINISTRY")
public class Ministry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "ministry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;

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
}
