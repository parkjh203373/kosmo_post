package com.winter.app.account;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AccountDTO {
	
	private String accountNum;
	private String username;
	private Long productNum;
	private Long accountPw;
	private Long accountBalance;
	private LocalDate accountDate;

}
