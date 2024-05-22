package cl.bootcamp.modulo_69.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class LoginController {

	@GetMapping("/login-propio")
	public String login() {
		return "login.jsp";
	}
}
