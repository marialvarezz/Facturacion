package com.eoi.Facturacion.controllers;

import com.eoi.Facturacion.entities.Customer;
import com.eoi.Facturacion.entities.Invoice;
import com.eoi.Facturacion.services.CustomerService;
import com.eoi.Facturacion.services.InvoiceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/customers")//url
@Log4j2
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    //Para acceder a los métodos

    @Autowired
    private InvoiceService invoiceService;
    //Para acceder a los métodos

    @GetMapping(value = {"/",""})
    public String showCustomers(Model model){
        //Se le llama en el customer-list.html
        model.addAttribute("customers",customerService.findAll());
        return "customer-list";
    }
    @GetMapping("/new")
    public String showNewCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers/";
    }
    @GetMapping("/edit/{id}")
    public String showEditInvoiceForm(@PathVariable("id") Long id, Model model) {
        Optional<Customer> customer=customerService.findById(id);
        if(customer.isPresent()){
            model.addAttribute("customer",customer.get());
        }else {
            return "error-page";
        }
        return "customer-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteById(id);
        return "redirect:/customers/";
    }

    @GetMapping("/{id}/invoices/new")

    public String newInvoiceForm(@PathVariable("id") Long id, Model model) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            Invoice invoice = new Invoice();
            invoice.setCustomer(customer.get());
            model.addAttribute("invoice",invoice);
            return "customer-invoice-form";
        } else {
            return "error-page";
        }
    }
    @PostMapping("/{id}/invoices/new")

    public String createInvoice(@PathVariable("id") Long id, @ModelAttribute("invoice") Invoice invoice) {
        Optional<Customer> customer = customerService.findById(id);
        if(customer.isPresent()){
            invoice.setCustomer(customer.get());
            invoiceService.save(invoice);
            return "redirect:/customers/edit/" + id;
        }
        {
            return "error";
        }



    }

}
