package in.shriram.dreambiketwowheelerloan.adminlogin.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.shriram.dreambiketwowheelerloan.adminlogin.model.EmployeeDetails;
import in.shriram.dreambiketwowheelerloan.adminlogin.repository.AdminLoginRepository;
import in.shriram.dreambiketwowheelerloan.adminlogin.servicei.AdminLoginServiceI;

@Service
public class AdminLoginServiceImpl implements AdminLoginServiceI{

	@Autowired
	AdminLoginRepository alr;

	@Override
	public void deleteById(int empId) {

		alr.deleteById(empId);
	}

	@Override
	public List<EmployeeDetails> getAll() {
		// TODO Auto-generated method stub
		return alr.findAll();
	}
}
