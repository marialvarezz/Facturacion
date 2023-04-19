package com.eoi.Facturacion.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoice_tax")
public class InvoiceTax {
    @EmbeddedId
    private InvoiceTaxId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("invoiceId")
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("taxId")
    @JoinColumn(name = "tax_id")
    private Tax tax;

    @Column(name = "total_tax")
    private Double totalTax;

    // getters y setters
}




