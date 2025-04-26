package in.shriram.dreambiketwowheelerloan.adminlogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.shriram.dreambiketwowheelerloan.adminlogin.model.EmployeeDetails;
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
	
	@GetMapping("/adminEmployee")
	public ResponseEntity<List<EmployeeDetails>> getAllEnquiry(){
		
		List<EmployeeDetails> eq = alsi.getAll();
		
		return new ResponseEntity<List<EmployeeDetails>>(eq, HttpStatus.OK);
	}
}
