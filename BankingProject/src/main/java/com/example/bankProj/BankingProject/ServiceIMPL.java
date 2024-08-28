package com.example.bankProj.BankingProject;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceIMPL implements AccountService {

	
	@Autowired
	private AccountRepo accountRepo;

	
	//for create account
	
	
	@Override
	public AccountDTO createAccount(AccountDTO accountDTO) {
		Account account = AccountMapper.mapToaccount(accountDTO);
		Account savedAccount = accountRepo.save(account);
		System.out.println("Account created successfully");
		return AccountMapper.mapToaccountDto(savedAccount);
	}

	//get account by id 
	
	@Override
	public AccountDTO getAccountById(Long  id) {
		Account account = accountRepo.findById( id).orElseThrow(	()-> new RuntimeException( "Id not found sorry " ));
		return AccountMapper.mapToaccountDto(account);
	}

	
	//deposit account
	@Override
	public AccountDTO depositAmmount(Long  id, double amount) {
		
		Account account = accountRepo.findById( id).orElseThrow(	()-> new RuntimeException( "Id not found sorry " ));
		double total  =account.getBalance() + amount;
		
		account.setBalance(total);
		 Account saveAccount = accountRepo.save(account);
		 System.out.println("Amount deposit successfully in your account Thank you :" +  id );
		return AccountMapper.mapToaccountDto(saveAccount);
	}

	
	//withrow amount 
	
	@Override
	public AccountDTO withrowAmount(Long id, double amount) {

		Account account = accountRepo.findById(id).orElseThrow(	()-> new RuntimeException( "Id not found sorry " ));
		double total  =account.getBalance() - amount;
		
		account.setBalance(total);
		 Account saveAccount = accountRepo.save(account);
		 System.out.println("Amount Withrow successfully in your account Thank you :" + id);
		return AccountMapper.mapToaccountDto(saveAccount);
		}

	
	//get all customers details
	
	@Override
	public List<AccountDTO> allAccountDetails() {

		
		List<Account> accounts = accountRepo.findAll();
		
		return accounts.stream().map((account)-> AccountMapper.mapToaccountDto(account)).collect(Collectors.toList());
		
	}
	
	
	
	//delete account

	@SuppressWarnings("unused")
	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepo.findById(id).orElseThrow(	()-> new RuntimeException( "Id not found sorry " ));
		accountRepo.deleteById(id);
		 System.out.println(" your account  is deleted successfully !!!!! Thank you :" + id);

		
		
	}

	
	
	//update mobile number
	
	
	@Override
	public  AccountDTO updateMobile(Long id , String mobileNumber) {
		Account account = accountRepo.findById(id).orElseThrow(	()-> new RuntimeException( "Id not found sorry " ));
		
		Long newMob = account.getMobileNumber(); 
		account.setMobileNumber(newMob);
		Account saveAccount = accountRepo.save(account);
		return AccountMapper.mapToaccountDto(saveAccount);
	}
	
	


}
