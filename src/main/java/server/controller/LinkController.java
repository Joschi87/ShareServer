package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import server.lib.Exception.LinkException;
import server.persistence.entity.LinkEntity;
import server.persistence.service.LinkService;

import java.util.List;

@RestController
public class LinkController {

    @Autowired
    LinkService service;

    @PostMapping("/addLinkToShare")
    @ResponseStatus(HttpStatus.CREATED)
    public void addLink(@RequestBody LinkEntity link) throws LinkException {

        service.createNewLink(link);
    }

    @DeleteMapping(path="/deleteLink")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteLinkController(@RequestBody LinkEntity entity) throws LinkException {
        service.deleteLink(entity);
    }

    @GetMapping("/loadLinks")
    @ResponseStatus(HttpStatus.OK)
    public List<LinkEntity> getAllLinks() {
        return service.getAllLinks();
    }
}
