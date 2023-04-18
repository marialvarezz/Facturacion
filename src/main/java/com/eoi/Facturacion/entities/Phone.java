package com.eoi.Facturacion.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "phone")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String brand;
    private String model;
    private String color;
    @ManyToMany(mappedBy = "phones")
    private List<Subscription> subscriptions;

    // getters and setters
    // constructors, getters and setters

}
