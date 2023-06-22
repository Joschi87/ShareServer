package server.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.lib.Exception.LinkException;
import server.persistence.entity.LinkEntity;
import server.persistence.repository.LinkRepository;

@Service
public class LinkService {
	
	@Autowired
	LinkRepository linkRepo;

	public void createNewLink(LinkEntity link) throws LinkException {
		if(!linkRepo.existsById(link.getId())){
			linkRepo.save(link);
		}else {
			throw new LinkException("Somethings goes wrong by save link");
		}
	}
	
	public List<LinkEntity> getAllLinks() {
		return linkRepo.findAll();
	}
	
	public void deleteLink(LinkEntity entity) throws LinkException {
		if(linkRepo.existsById(entity.getId())){
			linkRepo.deleteById(entity.getId());
			if (linkRepo.existsById(entity.getId())){
				throw new LinkException("deleting process failed!");
			}
		}else {
			throw new LinkException("Entry with uuid: " + entity.getId() + " doesn\'t exists");
		}
	}
}
