package fr.biboo.banking.service;

import java.util.List;

import fr.biboo.banking.dto.AccountHistoryDTO;
import fr.biboo.banking.dto.AccountOperationDTO;
import fr.biboo.banking.dto.BankAccountDTO;
import fr.biboo.banking.dto.CurrentBankAccountDTO;
import fr.biboo.banking.dto.CustomerDTO;
import fr.biboo.banking.dto.SavingBankAccountDTO;
import fr.biboo.banking.entities.BankAccount;
import fr.biboo.banking.exceptions.BalanceNotSufficient;
import fr.biboo.banking.exceptions.BankAccountNotFoundException;
import fr.biboo.banking.exceptions.CustomerNotFoundException;

public interface BankAccountService {
	public CustomerDTO saveCustomer(CustomerDTO customerDTO);
	CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, Long customerId, double overDraft) throws CustomerNotFoundException;
	SavingBankAccountDTO saveSavingBankAccount(double initialBalance, Long customerId, double interestRate)  throws CustomerNotFoundException;
	List<CustomerDTO> listCustomers();
	BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
	void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficient;
	void credit(String accountId, double amount, String description) throws BalanceNotSufficient, BankAccountNotFoundException;
	void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficient;
	List<BankAccountDTO> listBankAccount();
	CustomerDTO getCustomer(Long id) throws CustomerNotFoundException;
	CustomerDTO updateCustomer(CustomerDTO customerDTO);
	void deleteCustomer(Long customerId);
	List<AccountOperationDTO> accountHistory(String accountId);
	public AccountHistoryDTO accountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
}
