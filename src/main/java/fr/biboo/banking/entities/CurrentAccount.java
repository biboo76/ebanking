package fr.biboo.banking.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.*;

@Entity
@DiscriminatorValue("CA")
@Data @NoArgsConstructor @AllArgsConstructor
public class CurrentAccount extends BankAccount {
	private double overDraft;

	public double getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(double overDraft) {
		this.overDraft = overDraft;
	}
	
}
