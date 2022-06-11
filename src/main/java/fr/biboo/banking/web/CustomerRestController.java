package fr.biboo.banking.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.biboo.banking.dto.CustomerDTO;
import fr.biboo.banking.exceptions.CustomerNotFoundException;
import fr.biboo.banking.service.BankAccountService;

@RestController
public class CustomerRestController {
	private BankAccountService bankAccountService;

	public CustomerRestController(BankAccountService bankAccountService) {
		super();
		this.bankAccountService = bankAccountService;
	}
	
	@GetMapping("/customers")
	public List<CustomerDTO> listeCustomers() {
		return bankAccountService.listCustomers();
	}
	
	@GetMapping("/customers/{id}")
	public CustomerDTO getCustomer(@PathVariable(name="id") Long id) throws CustomerNotFoundException {
		return bankAccountService.getCustomer(id);
	}
	
	@PostMapping("/customers/")
	public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
		
		return bankAccountService.saveCustomer(customerDTO);
	}
	
	@PutMapping("/customers/{customerId}")
	public CustomerDTO updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDto) {
		customerDto.setId(customerId);
		
		return bankAccountService.updateCustomer(customerDto);
	}

	@DeleteMapping("/customers/{customerId}")
	public void deleteCustomer(@PathVariable Long customerId) {
		bankAccountService.deleteCustomer(customerId);
	}
}
