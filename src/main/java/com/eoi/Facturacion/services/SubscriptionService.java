package com.eoi.Facturacion.services;
import com.eoi.Facturacion.entities.Subscription;
import com.eoi.Facturacion.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {
    @Autowired //Inyección de dependencias - accede al repositorio para guardas los objetos
    private SubscriptionRepository subscriptionRepository;

    //Implementación de los métodos principales que se usan al entrar en el CRUD
    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();

    }
    public Optional<Subscription> findById(Long id) {
        return subscriptionRepository.findById(id);

    }
    public Subscription save(Subscription subscription) {
        return subscriptionRepository.save(subscription);

    }
    public void deleteById(Long id) {
        subscriptionRepository.deleteById(id);

    }
    }


