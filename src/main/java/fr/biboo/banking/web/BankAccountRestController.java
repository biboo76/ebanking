package fr.biboo.banking.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.biboo.banking.dto.AccountHistoryDTO;
import fr.biboo.banking.dto.AccountOperationDTO;
import fr.biboo.banking.dto.BankAccountDTO;
import fr.biboo.banking.exceptions.BankAccountNotFoundException;
import fr.biboo.banking.service.BankAccountService;

@RestController
public class BankAccountRestController {
	private BankAccountService bankAccountService;

	public BankAccountRestController(BankAccountService bankAccountService) {
		super();
		this.bankAccountService = bankAccountService;
	}

	public BankAccountService getBankAccountService() {
		return bankAccountService;
	}

	public void setBankAccountService(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}
	
	@GetMapping("/accounts/{accountId}")
	public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
		return bankAccountService.getBankAccount(accountId);
	}
	
	@GetMapping("/accounts")
	public List<BankAccountDTO> listBankAccounts() {
		return bankAccountService.listBankAccount();
	}
	
	@GetMapping("/accounts/{accountId}/operations")
	public List<AccountOperationDTO> listHistory(@PathVariable String accountId) {
		
		return bankAccountService.accountHistory(accountId);
	}
	
	@GetMapping("/accounts/{accountId}/pageOperations")
	public AccountHistoryDTO getAccountHistory(@PathVariable String accountId, 
			@RequestParam(name="page", defaultValue = "0") int page, 
			@RequestParam(name="size", defaultValue = "5") int size) throws BankAccountNotFoundException {
		
		return bankAccountService.accountHistory(accountId, page, size);
	}
}
