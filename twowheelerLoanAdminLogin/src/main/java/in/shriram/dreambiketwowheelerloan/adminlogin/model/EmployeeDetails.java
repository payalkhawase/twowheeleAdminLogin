package in.shriram.dreambiketwowheelerloan.adminlogin.model;

import in.shriram.dreambiketwowheelerloan.adminlogin.enums.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String empFirstName;
	private String empMiddleName;
	private String empLastName;
	private String empEmail;
	private float empSalary;
	private int empAge;
	
	@Enumerated(EnumType.STRING)
	@Column(length=999999999)
	private UserType userType;
	private String username;
	private String password;
	
	@Lob
	@Column(length = 999999999)
	private byte[] empImage;
	@Lob
	@Column(length = 999999999)
	private byte[] empPanCard;
	
//	"empFirstName":"shubham",
//	"empMiddleName":"R",
//	"empLastName":"chavhan",
//	"empEmail":"empEmail",
//	"empSalary":900000.00,
//	"empAge":28,
//	"userType":"ADMIN",
//	"username":"admin"
//	"password":"admin123"
}
