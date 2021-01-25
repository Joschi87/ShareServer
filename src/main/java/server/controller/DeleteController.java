package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import server.service.LinkService;

@RestController
public class DeleteController {

	@Autowired
	LinkService service;
	
	@GetMapping(path="/deleteLink")
	public String deleteLinkController(@RequestParam String id) {
		return service.deleteLink(id);
	}
	
}
