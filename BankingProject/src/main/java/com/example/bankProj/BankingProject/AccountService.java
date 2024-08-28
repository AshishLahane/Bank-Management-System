package com.example.bankProj.BankingProject;

import java.util.List;

public interface AccountService {
	
	AccountDTO createAccount (AccountDTO accountDTO);
	
	AccountDTO getAccountById (Long  id);
	
	AccountDTO depositAmmount (Long  id , double amount);
	
	AccountDTO withrowAmount (Long id , double amount);
	
	List<AccountDTO> allAccountDetails();
		
	void deleteAccount(Long id);
	
	AccountDTO updateMobile(Long id , String mobileNumber);

	

}
