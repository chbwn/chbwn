package com.example.demo.controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Account;
import com.example.demo.AccountService;

/* 
 * 登录地址为http://localhost:8080/account/login
 * 登录提交后跳转到http://localhost:8080/account/valid
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    /*@RequestMapping("/index")
    public String index(Map<String,Object> map){
        map.put("name", "HelloController");
        return "index";
    }*/
    
    @Autowired
    AccountService accountService; 
    @RequestMapping(value="/login")
    public String Login() {
      return "login"; //没有用ResponseBody，返回string，跳转的是jsp页面："login" + ".jsp"后缀
    }
    
    @RequestMapping("/valid")
    @ResponseBody
    public String Valid(HttpServletRequest request) {
      Account account = new Account();
      account.setID(request.getParameter("id"));
      account.setPassword(request.getParameter("password"));
      String total="";
      if(accountService.valid(account)) {

			try {
				File f = new File("d:/1.txt");
				BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(f.getAbsolutePath()), "gbk"));
				while(reader.ready()){
					total = reader.readLine() ;
				}
				FileOutputStream fout = new FileOutputStream("d:/1.txt");
		        OutputStreamWriter writer = new OutputStreamWriter(fout, "gbk");
		        total = Integer.toString(Integer.parseInt(total)+1);
        		writer.write(total);
                writer.flush();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	  
        return "Welcome,"+account.getID()+"!  total:"+total;
      }
      else {
        return "Invalid id or password";
      }
    }
}

	