package com.eoi.Facturacion.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class InvoiceTaxId {

    @Column(name = "invoice_id")
    private Long invoiceId;

    @Column(name = "tax_id")
    private Long taxId;
}
