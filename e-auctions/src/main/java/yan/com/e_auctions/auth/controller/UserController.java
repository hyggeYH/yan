package yan.com.e_auctions.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import yan.com.e_auctions.auth.dto.UserDto;
import yan.com.e_auctions.auth.service.UserService;
import yan.com.e_auctions.dto.AuctionDto;
import yan.com.e_auctions.service.auctionService.AuctionService;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {
	
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	AuctionService auctionService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Registered Successfuly!");
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/user-page")
	public String userPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		List<AuctionDto> auctions = auctionService.findAllAuction();
		model.addAttribute("auctions", auctions);
		return "user";
	}
	
	@GetMapping("admin-page")
	public String adminPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "admin";
	}

}
