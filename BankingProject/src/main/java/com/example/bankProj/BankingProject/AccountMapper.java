package com.example.bankProj.BankingProject;

public class AccountMapper {
	
	
	public static Account mapToaccount(AccountDTO accountDTO ) {
		
		Account account = new Account(
				accountDTO.getId(),
				accountDTO.getAccountHolderName(),
				accountDTO.getBalance(),
				accountDTO.getMobileNumber()
				);
		return account;
		
	} 
	
	public static AccountDTO mapToaccountDto(Account account ) {
		AccountDTO accountDTO = new AccountDTO(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance(),
				account.getMobileNumber()
				);
		
		return accountDTO;
	}

}
