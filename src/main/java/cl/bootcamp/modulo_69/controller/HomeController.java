package cl.bootcamp.modulo_69.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	
	
	@GetMapping
	public String home(Authentication authentication) {
		
		//Authentication authentication=	SecurityContextHolder.getContext().getAuthentication();
		
		authentication.getName();
		
		System.out.println("getName:"+authentication.getName());
		System.out.println("getPrincipal:"+authentication.getPrincipal());
		
		return "home.jsp";
	}
}
