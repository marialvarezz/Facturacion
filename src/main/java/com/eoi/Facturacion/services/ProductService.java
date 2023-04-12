package com.eoi.Facturacion.services;

import com.eoi.Facturacion.entities.Product;
import com.eoi.Facturacion.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired //Inyección de dependencias - accede al repositorio para guardas los objetos
    private ProductRepository productRepository;

    //Implementación de los métodos principales que se usan al entrar en el CRUD
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    public Optional<Product> findByName(String name){
        return productRepository.findByName(name);
    }
    public Product save(Product product) {
        return productRepository.save(product);
    }
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
