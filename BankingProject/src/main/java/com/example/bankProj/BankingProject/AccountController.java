package com.example.bankProj.BankingProject;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@Autowired
	 AccountService accountService;
	
	
	//add account
	
	@PostMapping("/add")
	public ResponseEntity<AccountDTO> addAccount (@RequestBody AccountDTO accountDTO)  //request body for getting values in table
	{
		return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
		
	}
	
	// get by id
	@GetMapping("/{id}")
	public  ResponseEntity<AccountDTO> getAccountById (@PathVariable Long  id){
		
		AccountDTO accountDTO = accountService.getAccountById( id);
		return ResponseEntity.ok(accountDTO);
	}
	
	//deposit ammount
	
	@PutMapping("/{id}/deposit")
	
	public  ResponseEntity<AccountDTO> depositAmount (@PathVariable Long  id, @RequestBody Map<String , Double > request){
		
		Double amount = request.get("amount");
		AccountDTO accountDTO = accountService.depositAmmount( id, amount);
		return ResponseEntity.ok(accountDTO);
	}
	
	//withrow ammount
	
	@PutMapping("/{id}/withrow")
	public  ResponseEntity<AccountDTO> WithrowAmount (@PathVariable Long id, @RequestBody Map<String , Double > request){
		
		Double amount = request.get("amount");
		AccountDTO accountDTO = accountService.withrowAmount(id, amount);
		return ResponseEntity.ok(accountDTO);
	}
	
	
	//get all account details
	
	@GetMapping("/all")
	public ResponseEntity<List<AccountDTO>> getAllDetails(){
		List<AccountDTO> accounts = accountService.allAccountDetails();
		 return ResponseEntity.ok(accounts);
	}
	
	//delete account
	
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteAccount (@PathVariable Long id){
		accountService.deleteAccount(id);
		
		return ResponseEntity.ok("ACCOUNT Deleted Successfully");
		
	}
	
	
	
	//update mobile num
	
	
	
	
	 @PutMapping("/{id}/")
	 
	  public ResponseEntity<AccountDTO> updateMobileNumber(@PathVariable Long id, @RequestBody String mobileNumber)
	 {
		 
			AccountDTO accountDTO = accountService.updateMobile(id, mobileNumber );
	  // AccountDTO accountDTO2=  accountService.updateMobile(id, mobileNumber);
	    return ResponseEntity.ok( accountDTO);
	  }
	
	
	
	
	
	

}
