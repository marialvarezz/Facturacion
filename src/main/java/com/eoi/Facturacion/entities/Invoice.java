package com.eoi.Facturacion.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "invoices")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Column(name = "id_Invoice")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer")
    private Customer invoiceToCustomer;



}
