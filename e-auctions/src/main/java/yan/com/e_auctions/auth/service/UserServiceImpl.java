package yan.com.e_auctions.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import yan.com.e_auctions.auth.dto.UserDto;
import yan.com.e_auctions.auth.model.User;
import yan.com.e_auctions.auth.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , "USER", userDto.getFullname());
		return userRepository.save(user);
	}
}
