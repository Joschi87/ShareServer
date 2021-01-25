package server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.entity.LinkEntity;
import server.lib.BasicHTMLCode;
import server.repository.LinkRepository;

@Service
public class LinkService {
	
	@Autowired
	LinkRepository linkRepo;

	public void createNewLink(String link) {
		LinkEntity newLink = new LinkEntity(link);
		List<LinkEntity> list = new ArrayList<>();
		
		list.add(newLink);
		
		linkRepo.saveAll(list);
	}
	
	public List<LinkEntity> getAllLinks() {
		String output = "";
		List<LinkEntity> allLinks = new ArrayList<>();
		linkRepo.findAll().forEach(LinkEntity -> allLinks.add(LinkEntity));

		return allLinks;
	}
	
	public String deleteLink(String id) {
		linkRepo.deleteById(Integer.parseInt(id));
		return "<script>alert('Link are deleted!');window.close();</script>";
	}
	
}
