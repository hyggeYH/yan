package yan.com.e_auctions.auth.service;


import yan.com.e_auctions.auth.dto.UserDto;
import yan.com.e_auctions.auth.model.User;

public interface UserService {
	
	User save (UserDto userDto);
	

}
