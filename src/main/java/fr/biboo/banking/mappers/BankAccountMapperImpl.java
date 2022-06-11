package fr.biboo.banking.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import fr.biboo.banking.dto.AccountOperationDTO;
import fr.biboo.banking.dto.CurrentBankAccountDTO;
import fr.biboo.banking.dto.CustomerDTO;
import fr.biboo.banking.dto.SavingBankAccountDTO;
import fr.biboo.banking.entities.AccountOperation;
import fr.biboo.banking.entities.CurrentAccount;
import fr.biboo.banking.entities.Customer;
import fr.biboo.banking.entities.SavingAccount;

@Service
public class BankAccountMapperImpl {
	
	public CustomerDTO fromCustomer(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		BeanUtils.copyProperties(customer, customerDTO);
		return customerDTO;
	}
	
	public Customer fromCustomerDTO(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);

		return customer;
	}
	
	public AccountOperationDTO fromAccountOperation(AccountOperation accountOperation) {
		AccountOperationDTO accountOPerationDTO = new AccountOperationDTO();
		BeanUtils.copyProperties(accountOperation, accountOPerationDTO);
		return accountOPerationDTO;
	}
	
	public AccountOperation fromAccountOperationDTO(AccountOperationDTO accountOperationDTO) {
		AccountOperation accountOperation = new AccountOperation();
		BeanUtils.copyProperties(accountOperationDTO, accountOperation);

		return accountOperation;
	}
	
	public SavingBankAccountDTO fromSavingBankAccount(SavingAccount savingAccount) {
		SavingBankAccountDTO saveBankAccountDTO = new SavingBankAccountDTO();
		BeanUtils.copyProperties(savingAccount, saveBankAccountDTO);
		
		saveBankAccountDTO.setCustomerDTO(fromCustomer(savingAccount.getCustomer()));
		saveBankAccountDTO.setType(SavingAccount.class.getSimpleName());
		return saveBankAccountDTO;
	}
	
	public SavingAccount fromSavingBankAccountDTO(SavingBankAccountDTO savingBankAccountDTO) {
		SavingAccount savingAccount = new SavingAccount();
		BeanUtils.copyProperties(savingBankAccountDTO, savingAccount);
		savingAccount.setCustomer(fromCustomerDTO(savingBankAccountDTO.getCustomerDTO()));
		
		return savingAccount;
	}
	
	
	public CurrentBankAccountDTO fromCurrentBankAccount(CurrentAccount currentAccount) {
		CurrentBankAccountDTO currentBankAccountDTO = new CurrentBankAccountDTO();
		BeanUtils.copyProperties(currentAccount, currentBankAccountDTO);
		currentBankAccountDTO.setCustomerDTO(fromCustomer(currentAccount.getCustomer()));
		currentBankAccountDTO.setType(CurrentAccount.class.getSimpleName());
		return currentBankAccountDTO;
	}
	
	public CurrentAccount fromCurrentBankAccountDTO(CurrentBankAccountDTO currentBankAccountDTO) {
		CurrentAccount currentAccount = new CurrentAccount();
		BeanUtils.copyProperties(currentBankAccountDTO, currentAccount);
		currentAccount.setCustomer(fromCustomerDTO(currentBankAccountDTO.getCustomerDTO()));
		
		return currentAccount;
	}
	
}
