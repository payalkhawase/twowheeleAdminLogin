package in.shriram.dreambiketwowheelerloan.adminlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import in.shriram.dreambiketwowheelerloan.adminlogin.model.EmployeeDetails;

@Repository
public interface AdminLoginRepository extends JpaRepository<EmployeeDetails, Integer>{

	
}
