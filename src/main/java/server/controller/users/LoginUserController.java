package server.controller.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import server.service.UserService;

@RestController
public class LoginUserController {
	
	@Autowired
	UserService service;

	@PostMapping(path="/login")
	public String loginController(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {
		return service.login(username, password, request, response);
	}
	
}
