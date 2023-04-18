package com.eoi.Facturacion.repositories;

import com.eoi.Facturacion.entities.Contract;
import com.eoi.Facturacion.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract,Long> {


}
