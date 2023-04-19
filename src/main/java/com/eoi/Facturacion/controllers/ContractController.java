package com.eoi.Facturacion.controllers;

import com.eoi.Facturacion.entities.Contract;
import com.eoi.Facturacion.entities.Customer;
import com.eoi.Facturacion.entities.Invoice;
import com.eoi.Facturacion.services.ContractService;
import com.eoi.Facturacion.services.CustomerService;
import com.eoi.Facturacion.services.InvoiceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contracts")//url
@Log4j2
public class ContractController {
    @Autowired
    private ContractService contractService;
    //Para acceder a los métodos


    // Devuelve una lista de todos los contratos y los agrega al modelo
    @GetMapping(value = {"/",""})
    public String getAllContracts(Model model) {
        List<Contract> contracts = contractService.findAll();
        model.addAttribute("contracts", contracts);
        return "contract/contract-list";
    }



    // Obtiene un contrato por su ID, lo agrega al modelo y devuelve la vista correspondiente
    @GetMapping("/{id}")
    public String getContractById(@PathVariable Long id, Model model) {
        Optional<Contract> contract = contractService.findById(id);
        if(contract.isPresent())
        {
            model.addAttribute("contract", contract.get());
            return "contract/contract-form";
        }
        return "error";
    }



    // Crea un nuevo contrato y lo agrega al modelo
    @GetMapping("/new")
    public String newContract(Model model) {
        Contract contract = new Contract();
        model.addAttribute("contract", contract);
        return "contract/contract-form";
    }



    // Guarda un contrato en la base de datos
    @PostMapping("/save")
    public String saveContract(Contract contract) {
        contractService.save(contract);
        return "redirect:/contracts/";
    }



    // Obtiene un contrato por su ID, lo agrega al modelo y devuelve la vista de edición
    @GetMapping("/edit/{id}")
    public String editContract(@PathVariable Long id, Model model) {
        Optional<Contract> contract = contractService.findById(id);
        if(contract.isPresent())
        {
            model.addAttribute("contract", contract.get());
            return "contract/customer-contract-form";
        }
        return "error";
    }



    // Elimina un contrato de la base de datos
    @GetMapping("/delete/{id}")
    public String deleteContract(@PathVariable Long id) {
        contractService.deleteById(id);
        return "redirect:/customers/";
    }
}
