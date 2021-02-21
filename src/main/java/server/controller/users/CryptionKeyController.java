package server.controller.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import server.service.CryptionKeyService;

@RestController
public class CryptionKeyController {
	
	@Autowired
	CryptionKeyService service;
	
	public String createCryptionKeyController(@RequestParam String key, HttpServletRequest request, HttpServletResponse response) {
		return service.setCryptionKey(key, response, request);
	}

}
