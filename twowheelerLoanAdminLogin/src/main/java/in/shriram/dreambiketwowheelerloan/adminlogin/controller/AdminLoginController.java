package in.shriram.dreambiketwowheelerloan.adminlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.shriram.dreambiketwowheelerloan.adminlogin.servicei.AdminLoginServiceI;

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
}
