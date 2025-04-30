package in.shriram.dreambiketwowheelerloan.adminlogin.servicei;

import org.springframework.web.multipart.MultipartFile;

import in.shriram.dreambiketwowheelerloan.adminlogin.model.EmployeeDetails;

public interface AdminLoginServiceI {


	public void saveAdmin(String json, MultipartFile empImage, MultipartFile empPanCard);

	void deleteById(int empId);

	public EmployeeDetails UpdateEmployee(int a, String json, MultipartFile empImage, MultipartFile empPanCard);


}
