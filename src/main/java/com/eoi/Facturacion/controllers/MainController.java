package com.eoi.Facturacion.controllers;

import com.eoi.Facturacion.services.CustomerService;
import com.eoi.Facturacion.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    CustomerService customerService;
    @GetMapping(value = {"/",""})
    public String showHome(Model model){
        model.addAttribute("fragmentName","fragment-customer-list");
        model.addAttribute("dataObject",customerService.findAll());
        return "index";
    }
}
