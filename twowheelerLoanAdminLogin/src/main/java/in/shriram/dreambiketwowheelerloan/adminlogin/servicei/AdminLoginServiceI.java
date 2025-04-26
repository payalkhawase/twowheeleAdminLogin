package in.shriram.dreambiketwowheelerloan.adminlogin.servicei;

import org.springframework.web.multipart.MultipartFile;

public interface AdminLoginServiceI {

	public void saveAdmin(String json, MultipartFile empImage, MultipartFile empPanCard);

}
