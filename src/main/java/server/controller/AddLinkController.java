package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import server.service.LinkService;

@RestController
public class AddLinkController {
	
	@Autowired
	LinkService service;

	@PostMapping("/addLinkToShare")
	public void addLink(@RequestParam String link) {
		service.createNewLink(link);
	}
}
