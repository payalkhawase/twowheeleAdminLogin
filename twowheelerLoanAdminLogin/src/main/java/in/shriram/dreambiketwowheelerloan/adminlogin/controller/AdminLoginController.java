package in.shriram.dreambiketwowheelerloan.adminlogin.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import in.shriram.dreambiketwowheelerloan.adminlogin.model.EmployeeDetails;
import org.springframework.web.multipart.MultipartFile;



import in.shriram.dreambiketwowheelerloan.adminlogin.model.EmployeeDetails;

import in.shriram.dreambiketwowheelerloan.adminlogin.servicei.AdminLoginServiceI;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/adminlogin")
public class AdminLoginController {

	@Autowired
	AdminLoginServiceI alsi;
	

	@PostMapping("/saveAdmin")
	public ResponseEntity<String> addAdmin(@RequestPart("info")String json,
			@RequestPart("empImage")MultipartFile empImage,
			@RequestPart("empPanCard")MultipartFile empPanCard
			)
	{
		alsi.saveAdmin(json,empImage,empPanCard);
		return new ResponseEntity<String>("Data added",HttpStatus.CREATED);
	}
	
	@GetMapping("/getAdmin/{empId}")
	public ResponseEntity<EmployeeDetails> getAdmin(@PathVariable("empId")int empId)
	{
		EmployeeDetails a=alsi.getSingleAdmin(empId);
		return new ResponseEntity<EmployeeDetails>(a,HttpStatus.OK);
	}
	
	@GetMapping("/getEmployee/{username}/{password}")
	public ResponseEntity<EmployeeDetails> getEmployee(@PathVariable("username")String username,@PathVariable("password") String password)
	{
		EmployeeDetails ed=alsi.getEmployee(username,password);
		return new ResponseEntity<EmployeeDetails>(ed,HttpStatus.OK);
	}
	

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

