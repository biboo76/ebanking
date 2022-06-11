package fr.biboo.banking.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.biboo.banking.entities.CurrentAccount;
import fr.biboo.banking.entities.SavingAccount;
import fr.biboo.banking.repository.CustomerRepository;

@Service
@Transactional
public class BankService {
	@Autowired
	private CustomerRepository customerRepository;
	public void consulter() {
		customerRepository.findAll().forEach(cust-> {
			System.out.println("*************");
			System.out.println("Client :\t"+cust.getName()+" ("+cust.getId()+")");
			System.out.println("Mail :\t"+cust.getEmail());
			cust.getBankAccounts().forEach(acc -> {
				if(acc instanceof SavingAccount) {
					System.out.println("---------\nId compte : "+ ((SavingAccount)acc).getId());
					System.out.println("Taux d'interet : "+((SavingAccount)acc).getInterestRate());
					System.out.println("Statut : "+((SavingAccount)acc).getStatus());
					
				} else if(acc instanceof CurrentAccount) {
					System.out.println("---------\nId compte : "+ ((CurrentAccount)acc).getId());
					System.out.println("Decouvert : "+((CurrentAccount)acc).getOverDraft());
					System.out.println("Statut : "+((CurrentAccount)acc).getStatus());
					
				}
			});
		});
	}
}
