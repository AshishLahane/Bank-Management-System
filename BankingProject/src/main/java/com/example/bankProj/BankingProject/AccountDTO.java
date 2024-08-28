package com.example.bankProj.BankingProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
	
	private Long id;
	private String accountHolderName;
	private double balance;
	private Long mobileNumber;

}
