package com.eoi.Facturacion.controllers;

import com.eoi.Facturacion.entities.Customer;
import com.eoi.Facturacion.entities.Invoice;
import com.eoi.Facturacion.services.CustomerService;
import com.eoi.Facturacion.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/invoices")//url
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    private CustomerService customerService;
    //Para acceder a los métodos

    @GetMapping(value = {"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showInvoices(Model model){
        //
        model.addAttribute("invoices",invoiceService.findAll());
        //Devuelve el HTML
        return "invoice-list";
    }
    @GetMapping("/new")
    public String showNewInvoiceForm(Model model) {
        model.addAttribute("invoice", new Invoice());
        return "invoice-form";
    }
    @PostMapping("/save")
    public String saveInvoice(@ModelAttribute("invoice") Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices/";
    }
    @GetMapping("/edit/{id}")
    public String showEditInvoiceForm(@PathVariable("id") Long id, Model model) {
        Optional<Invoice> invoice = invoiceService.findById(id);
        if(invoice.isPresent())
        {
            model.addAttribute("invoice", invoice.get());
            return "customer-invoice-form";
        }
        return "error";

    }
    @GetMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable("id") Long id) {
        invoiceService.deleteById(id);
        return "redirect:/customers/";
    }

}
