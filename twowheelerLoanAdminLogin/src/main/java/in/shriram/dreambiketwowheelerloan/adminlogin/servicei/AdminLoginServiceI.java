package in.shriram.dreambiketwowheelerloan.adminlogin.servicei;

import java.util.List;

import in.shriram.dreambiketwowheelerloan.adminlogin.model.EmployeeDetails;

public interface AdminLoginServiceI {

	void deleteById(int empId);

	public List<EmployeeDetails> getAll();

}
