package in.shriram.dreambiketwowheelerloan.adminlogin.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.shriram.dreambiketwowheelerloan.adminlogin.model.EmployeeDetails;
import in.shriram.dreambiketwowheelerloan.adminlogin.repository.AdminLoginRepository;
import in.shriram.dreambiketwowheelerloan.adminlogin.servicei.AdminLoginServiceI;

@Service
public class AdminLoginServiceImpl implements AdminLoginServiceI {

	@Autowired
    AdminLoginRepository adminRepo;

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public void saveAdmin(String json, MultipartFile empImage, MultipartFile empPanCard) {
		try {
			// Convert JSON to EmployeeDetails object
			EmployeeDetails employee = objectMapper.readValue(json, EmployeeDetails.class);

			// Set uploaded file data
			employee.setEmpImage(empImage.getBytes());
			employee.setEmpPanCard(empPanCard.getBytes());

			// Save to DB
			adminRepo.save(employee);

		} catch (Exception e) {
			throw new RuntimeException("Failed to save admin details: " + e.getMessage(), e);
		}

	}

	@Override
	public void deleteById(int empId) {

		adminRepo.deleteById(empId);

	}

	@Override
	public EmployeeDetails UpdateEmployee(int a,String json, MultipartFile empImage, MultipartFile empPanCard) {
		
		
		
		try {
			EmployeeDetails employee = objectMapper.readValue(json, EmployeeDetails.class);
			employee.setEmpImage(empImage.getBytes());
			employee.setEmpPanCard(empPanCard.getBytes());
			
			Optional<EmployeeDetails> oe= adminRepo.findById(a);
			if(oe.isPresent())
			{
				
				EmployeeDetails ed =oe.get();
				ed.setEmpFirstName(employee.getEmpFirstName());
				ed.setEmpEmail(employee.getEmpEmail());
				ed.setEmpAge(employee.getEmpAge());
				ed.setEmpMiddleName(employee.getEmpMiddleName());
				ed.setEmpLastName(employee.getEmpLastName());
				ed.setUsername(employee.getUsername());
				ed.setPassword(employee.getPassword());
				ed.setEmpSalary(employee.getEmpSalary());
				ed.setEmpImage(employee.getEmpImage());
				ed.setEmpPanCard(employee.getEmpPanCard());
				
				EmployeeDetails eds=adminRepo.save(ed);

				return eds;
				
			}
			else
			{
			    throw new RuntimeException("EmployeeDetails Not Found")	;
			}		
			}
			catch (Exception e) {
				throw new RuntimeException("Failed to save admin details: " + e.getMessage(), e);
			}
		
			
		} 
	}


