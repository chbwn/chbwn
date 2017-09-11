package com.example.demo;

import java.lang.reflect.Member;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class AccountService {
	public HashMap<String,String> member=new HashMap<String,String>();
	public AccountService(){
		member.put("admin", "123456");
		member.put("jake", "124");
		member.put("tom", "235");
		member.put("amy", "2344");
		member.put("lily", "111");
	}
  
	public boolean valid (Account account) {
    if(member.get(account.getID()).equals(account.getPassword())) {
      return true;
    }
    return false;
  
	}
}
