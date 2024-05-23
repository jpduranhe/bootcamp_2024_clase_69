package cl.bootcamp.modulo_69.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

	@GetMapping("/public")
	public String publico() {
		return "public.jsp";
	}
}
