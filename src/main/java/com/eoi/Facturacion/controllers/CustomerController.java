package com.eoi.Facturacion.controllers;

import com.eoi.Facturacion.entities.Customer;
import com.eoi.Facturacion.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")//url
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    //Para acceder a los métodos

    @GetMapping(value = {"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showCustomers(Model model){
        //
        model.addAttribute("customer",customerService.findAll());
        //Devuelve el HTML
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
    public String showEditCustomerForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer-form";
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteById(id);
        return "redirect:/customers/";
    }

}
