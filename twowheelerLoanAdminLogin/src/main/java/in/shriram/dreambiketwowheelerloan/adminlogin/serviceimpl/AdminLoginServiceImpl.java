package in.shriram.dreambiketwowheelerloan.adminlogin.serviceimpl;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.shriram.dreambiketwowheelerloan.adminlogin.model.EmployeeDetails;
import in.shriram.dreambiketwowheelerloan.adminlogin.repository.AdminLoginRepository;
import in.shriram.dreambiketwowheelerloan.adminlogin.servicei.AdminLoginServiceI;
import in.shriram.dreambiketwowheelerloan.adminlogin.exceptions.*;

@Service
public class AdminLoginServiceImpl implements AdminLoginServiceI {

	@Autowired
    AdminLoginRepository adminRepo;

	@Autowired
	ObjectMapper objectMapper;
	
	// Define the allowed image MIME types
    private static final List<String> ALLOWED_IMAGE_TYPES = Arrays.asList(
            "image/jpeg", "image/png", "image/jpg"
    );

	@Override
	public void saveAdmin(String json, MultipartFile empImage, MultipartFile empPanCard) {
		try {
			// Convert JSON to EmployeeDetails object
			EmployeeDetails employee = objectMapper.readValue(json, EmployeeDetails.class);
			
			if(employee.getEmpAge() <= 18)
			{
				throw new InvalidAgeException("Age should be greater than 18");
			}
			String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
			  Pattern pt = Pattern.compile(regex);
			  Matcher mt = pt.matcher(employee.getEmpEmail());
			 
			  if(!mt.matches()) {
	        	 
	        	 throw new InvalidEmailException("Invalid email");
	         }
			if(!empPanCard.isEmpty())
			{	
				if (!empPanCard.getContentType().equals("application/pdf")) {
		            throw new InvalidFileTypeException("Only PDF files are allowed for Pan Card");
		        }
				else
				{
					employee.setEmpPanCard(empPanCard.getBytes());
				}
			}
			if(!empImage.isEmpty())
			{
				if (!ALLOWED_IMAGE_TYPES.contains(empImage.getContentType())) {
		            throw new InvalidFileTypeException("Only image files (JPEG, PNG, JPG) are allowed for photo");
		        }
				else {
					employee.setEmpImage(empImage.getBytes());
				}
			}
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
	public List<EmployeeDetails> getAll() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}
}

