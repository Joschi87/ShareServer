package server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.entity.LinkEntity;
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
	
	public String getAllLinks() {
		String output = "";
		List<LinkEntity> allLinks = new ArrayList<>();
		linkRepo.findAll().forEach(LinkEntity -> allLinks.add(LinkEntity));
		Object[] objAllLinks = allLinks.toArray();
		
		output += "<ul class='list-group'>";
		
		for (int i = 0; i < objAllLinks.length; i++) {
			output += "<li class='list-group-item'>" + objAllLinks[i] + "</li>";
		}
		
		output += "</ul>";

		return output;
	}
	
}
