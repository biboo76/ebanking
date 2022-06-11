package fr.biboo.banking;

import java.util.Iterator;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.biboo.banking.dto.CustomerDTO;
import fr.biboo.banking.entities.Customer;
import fr.biboo.banking.exceptions.BalanceNotSufficient;
import fr.biboo.banking.exceptions.BankAccountNotFoundException;
import fr.biboo.banking.exceptions.CustomerNotFoundException;
import fr.biboo.banking.service.BankAccountService;

@SpringBootApplication
public class EBankingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBankingBackendApplication.class, args);
	}

	//@Bean
	CommandLineRunner start(BankAccountService bankAccountService) {
		return args -> {
			Stream.of("Arthur", "Audrey", "David").forEach(name-> {
				CustomerDTO customerDTO = new CustomerDTO();
				customerDTO.setName(name);
				customerDTO.setEmail(name+"@gmail.com");
				
				bankAccountService.saveCustomer(customerDTO);
			});
			
			bankAccountService.listCustomers().forEach(customer-> {
				try {
					bankAccountService.saveCurrentBankAccount(Math.random()*9000, customer.getId(), 9000 );
					bankAccountService.saveSavingBankAccount(Math.random()*12000, customer.getId(), 5.2);
				} catch (CustomerNotFoundException e) {
					e.printStackTrace();
				}
			});
			
//			bankAccountService.listBankAccount().forEach(bankAccount-> {
//				for (int i = 0; i < 10; i++) {
//					try {
//						bankAccountService.credit(bankAccount.getId(), 10000+Math.random()*12000, "Credit");
//						bankAccountService.debit(bankAccount.getId(), 5000+Math.random()*6000, "Debit");
//					} catch (BalanceNotSufficient e) {
//						e.printStackTrace();
//					} catch (BankAccountNotFoundException e) {
//						e.printStackTrace();
//					}
//				}
//			});
		};
	}
	
	
}
