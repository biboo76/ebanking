package fr.biboo.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.biboo.banking.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String>{

}
