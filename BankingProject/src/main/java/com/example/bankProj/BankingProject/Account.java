package com.example.bankProj.BankingProject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	@Column (name = "Account Holder Name")
	
	private String accountHolderName;
	private double Balance;
	private Long mobileNumber;

}
