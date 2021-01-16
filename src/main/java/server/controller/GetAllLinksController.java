package server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import server.entity.LinkEntity;
import server.service.LinkService;

@RestController
public class GetAllLinksController {
	
	@Autowired
	LinkService linkService;

	@GetMapping("/loadLinks")
	public List<LinkEntity> getAllLinks() {
		return linkService.getAllLinks();
	}
	
}
