package com.eoi.Facturacion.services;
import com.eoi.Facturacion.entities.Contract;
import com.eoi.Facturacion.entities.Phone;
import com.eoi.Facturacion.repositories.ContractRepository;
import com.eoi.Facturacion.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {
    @Autowired //Inyección de dependencias - accede al repositorio para guardas los objetos
    private PhoneRepository phoneRepository;

    //Implementación de los métodos principales que se usan al entrar en el CRUD
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }
    public Optional<Phone> findById(Long id) {
        return phoneRepository.findById(id);

    }
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }
    public void deleteById(Long id) {
        phoneRepository.deleteById(id);
    }
    }


