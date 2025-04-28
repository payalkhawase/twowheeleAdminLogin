package in.shriram.dreambiketwowheelerloan.adminlogin.servicei;

import org.springframework.web.multipart.MultipartFile;

import in.shriram.dreambiketwowheelerloan.adminlogin.model.EmployeeDetails;

public interface AdminLoginServiceI {


	public void saveAdmin(String json, MultipartFile empImage, MultipartFile empPanCard);

	void deleteById(int empId);

	public EmployeeDetails getSingleAdmin(int empId);

	public EmployeeDetails getEmployee(String username, String password);


}
