package fr.biboo.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.biboo.banking.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
