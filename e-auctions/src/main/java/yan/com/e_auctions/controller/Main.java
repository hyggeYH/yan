package yan.com.e_auctions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import yan.com.e_auctions.auth.model.User;
import yan.com.e_auctions.auth.repositories.UserRepository;
import yan.com.e_auctions.dto.AuctionDto;
import yan.com.e_auctions.service.auctionService.AuctionService;

import java.security.Principal;
import java.util.List;

@Controller
public class Main {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuctionService auctionService;
    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping(value = {"/","/start"}, method = RequestMethod.GET)
    public ModelAndView start() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start");
        return modelAndView;
    }

    @RequestMapping(value = {"/new-auction"}, method = RequestMethod.GET)
    public ModelAndView newAuction() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("create-auction");
        return modelAndView;
    }

    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public ModelAndView profile(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");

        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);

        return modelAndView;
    }

    @RequestMapping(value = {"/bid"}, method = RequestMethod.GET)
    public ModelAndView bid(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bid");

        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);

        return modelAndView;
    }

}
