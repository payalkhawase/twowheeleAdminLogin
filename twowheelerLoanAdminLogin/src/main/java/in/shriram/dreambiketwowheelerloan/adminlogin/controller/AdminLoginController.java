package in.shriram.dreambiketwowheelerloan.adminlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.shriram.dreambiketwowheelerloan.adminlogin.servicei.AdminLoginServiceI;

@RestController
@RequestMapping("/adminlogin")
public class AdminLoginController {

	@Autowired
	AdminLoginServiceI alsi;
	
	@DeleteMapping("/deleteById/{empId}")
	public void deleteById(@PathVariable("empId") int empId){
		alsi.deleteById(empId);
	}
}
