package fr.biboo.banking.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.biboo.banking.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "TYPE", length = 4)
@Data @NoArgsConstructor @AllArgsConstructor
public class BankAccount {
	@Id
	private String id;
	private double balance;
	private Date createdAt;
	@Enumerated(EnumType.ORDINAL)
	private AccountStatus status;
	@ManyToOne
	private Customer customer;
	@OneToMany(mappedBy = "bankAccount")
	private List<AccountOperation> accountOperations;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<AccountOperation> getAccountOperations() {
		return accountOperations;
	}
	public void setAccountOperations(List<AccountOperation> accountOperations) {
		this.accountOperations = accountOperations;
	}
}
