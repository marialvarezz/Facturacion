package com.eoi.Facturacion.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Invoice> invoiceList = new ArrayList<>();


}
