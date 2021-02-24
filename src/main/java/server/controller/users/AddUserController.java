package server.controller.users;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import server.service.UserService;

@RestController
public class AddUserController {
	
	@Autowired
	UserService serivce;
	
	@PostMapping(path="/register")
	public ResponseEntity<String> addUser(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
		return serivce.createAccount(username, password, request);
	}
	
}
