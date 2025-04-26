package in.shriram.dreambiketwowheelerloan.adminlogin.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
		
			EmployeeDetails employee = objectMapper.readValue(json, EmployeeDetails.class);

			employee.setEmpImage(empImage.getBytes());
			employee.setEmpPanCard(empPanCard.getBytes());

			
			adminRepo.save(employee);

		} catch (Exception e) {
			throw new RuntimeException("Failed to save admin details: " + e.getMessage(), e);
		}

	}

	@Override
	public void deleteById(int empId) {

		adminRepo.deleteById(empId);

	}
}

