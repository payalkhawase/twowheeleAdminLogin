package in.shriram.dreambiketwowheelerloan.adminlogin.servicei;

import java.util.List;

import in.shriram.dreambiketwowheelerloan.adminlogin.model.EmployeeDetails;

import org.springframework.web.multipart.MultipartFile;

public interface AdminLoginServiceI {

	public void saveAdmin(String json, MultipartFile empImage, MultipartFile empPanCard);

	void deleteById(int empId);

	public List<EmployeeDetails> getAll();

}
