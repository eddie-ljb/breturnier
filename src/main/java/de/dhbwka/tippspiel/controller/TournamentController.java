package de.dhbwka.tippspiel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import de.dhbwka.tippspiel.repositories.RoleRepository;
import de.dhbwka.tippspiel.repositories.UserRepository;

@RestController
@RequestMapping("/breturnier")
public class TournamentController {
	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;
    
    @GetMapping("/")
    public ModelAndView showLandingPage(@CookieValue("authToken") String authToken, Model model) {
        if (jwtUtils.validateJwtToken(authToken)) {
            model.addAttribute("authToken", authToken);
            return new ModelAndView("esport-championship-landing.html");
        } else {
            return new ModelAndView("redirect:/api/auth/signin");
        }
    }
    
    @GetMapping("/matches")
    public ModelAndView showMatchesPage(@CookieValue("authToken") String authToken, Model model) {
    	if (jwtUtils.validateJwtToken(authToken)) {
    		model.addAttribute("authToken", authToken);
    		return new ModelAndView("matches.html");
    	} else {
    		return new ModelAndView("redirect:/api/auth/signin");
    	}
    }

    @GetMapping("/news")
    public ModelAndView showNewsPage(@CookieValue("authToken") String authToken, Model model) {
    	if (jwtUtils.validateJwtToken(authToken)) {
    		model.addAttribute("authToken", authToken);
    		return new ModelAndView("news.html");
    	} else {
    		return new ModelAndView("redirect:/api/auth/signin");
    	}
    }
    
    @GetMapping("/error")
    public ModelAndView showErrorPage(@CookieValue("authToken") String authToken, Model model) {
    	if (jwtUtils.validateJwtToken(authToken)) {
    		model.addAttribute("authToken", authToken);
    		return new ModelAndView("404.html");
    	} else {
    		return new ModelAndView("redirect:/api/auth/signin");
    	}
    }

}
