package com.eoi.Facturacion.services;
import com.eoi.Facturacion.entities.Contract;
import com.eoi.Facturacion.entities.Subscription;
import com.eoi.Facturacion.repositories.ContractRepository;
import com.eoi.Facturacion.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {
    @Autowired //Inyección de dependencias - accede al repositorio para guardas los objetos
    private ContractRepository contractRepository;

    //Implementación de los métodos principales que se usan al entrar en el CRUD
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }
    public Optional<Contract> findById(Long id) {
        return contractRepository.findById(id);

    }
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }
    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }
    }


