package com.te.assignmentmvc.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.assignmentmvc.base.dto.ProductDetails;
import com.te.assignmentmvc.base.dto.ProductId;
import com.te.assignmentmvc.base.exception.ProductException;
import com.te.assignmentmvc.base.service.ProductService;


import net.bytebuddy.asm.Advice.Return;

@Controller
public class ControllerMethod {
	@Autowired
	private ProductService service;
	@GetMapping("/login")
	public String  login() {
		return "loginform";		
	}
	
	@PostMapping("/welcome")
	public String welcome(int id,String password,ModelMap map,HttpServletRequest request) {
		ProductId productId=service.authenticate(id, password);
		HttpSession session=request.getSession();
		session.setAttribute("loggedin", productId);
		if(productId != null) {
			map.addAttribute("key","Welcome to product details");	
			return "welcome";
		}else {
			map.addAttribute("err", "INVALID CREDENTIALS!!");
			return "loginform";
		}
			
	}
	@GetMapping("/add")
	public String addProduct(@SessionAttribute (name = "loggedin",required = false)ProductId productId,ModelMap map) {
		
		if(productId != null ) {
			return "add";
		}else {
			map.addAttribute("err", "please login first");
			return "loginform";
		}
	}
	
@PostMapping("/add")	
public String  addDetails(@SessionAttribute(name = "loggedin" ,required = false)ProductDetails details ,ModelMap map) {
	if(details != null) {
		if(service.addProduct(details)) {
			map.addAttribute("msg", "response noted successfully will be published soon thank you");
			return "add";
		}else {
			map.addAttribute("err",  "something went wrong");  
			return "add";
		}
	}else {
		map.addAttribute("err",  "please login in first ");
		return "loginform";
	}
}
@GetMapping("/delete")
public String delate(@SessionAttribute(name = "logedin",required = false)ProductDetails details ,ModelMap map) {
	if(details != null) {
		return "delete";
	}else {
		map.addAttribute("err", "please login first");
		return "loginform";
	}
	
}



@PostMapping("/delete")
public String deleteData(@SessionAttribute(name = "loggedin",required = false)ProductDetails details,ModelMap map,int id) {
	if(details != null) {
		if(service.deleteData(id)) {
			map.addAttribute("msg", "data delete successfully");
			return "delete";
		}else {
			map.addAttribute("err", "there is no product id for:"+id);
			return "delete";
		}
	}else {
		map.addAttribute("err", "please login first");
		return "loginform";
	}
}
@GetMapping("/details")
public String getDetails(@SessionAttribute(name = "loggedin",required = false)ProductDetails details,ModelMap map ) {
  if(details != null) {
	  return "details";
  }else {
	  map.addAttribute("err", "please login first");
	  return "loginform";
  }
}

@PostMapping("/details")
public String  getDetails(@SessionAttribute(name = "loggedin",required = false)ProductDetails details ,ModelMap map,int id) {
	if(details != null ) {
		ProductDetails details1=service.getDetails(id);
		if(details1 !=null) {
			map.addAttribute("data", details1);
			return "details";
		}else {
			map.addAttribute("err", "data didnot found for id:"+id);
			return "details";
		}
	}else {
		map.addAttribute("err", "please login first");
		return "loginform";
	}
}
@GetMapping("/update")
public String  updateDate(@SessionAttribute(name ="loggedin",required = false)ProductDetails details,ModelMap map ) {
	if(details != null ) {
		map.addAttribute("data", details.getId());
		return "update";
	}else {
		map.addAttribute("err", "please login first");
		return "loginform";
	}
}
@PostMapping("/update")
public String updateDetails(@SessionAttribute(name ="loggenin",required = false)ProductDetails details,ProductDetails details3,ModelMap map,int id) {
if(details != null) {
	if(service.update(details3, id)) {
		map.addAttribute("msg", "details entered successfully")	;
		return "update";
	}else {
		map.addAttribute("err", "something went wrong");
		return "update";
	}
}
else {
	map.addAttribute("err", "please loggin first");
	return "loginform";
}
}



@GetMapping("/logout")
public String logout(ModelMap map, HttpSession session) {
	session.invalidate();
	map.addAttribute("err", "Logged Out Successfully");
	return "loginform";
}
}
