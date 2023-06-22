package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.lib.Exception.DatafileException;
import server.persistence.entity.DatafileEntity;
import server.persistence.service.DatafileService;

import java.util.List;
import java.util.UUID;

@RestController
public class DatafileController {

    @Autowired
    private DatafileService service;

    @GetMapping(value="/Datafile")
    public ResponseEntity<List<DatafileEntity>> getAllDatafiles() throws DatafileException{
        return new ResponseEntity<>(service.getAllDatafiles(), HttpStatus.OK);
    }

    @GetMapping(value="/Datafile{id}")
    public ResponseEntity<DatafileEntity> getDatafileByID(@RequestParam("id") UUID id) throws DatafileException {
        return new ResponseEntity<>(service.getDataFileByID(id), HttpStatus.OK);
    }

    @PostMapping(value ="/Datafile")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDatafileEntry(@RequestBody DatafileEntity datafile) throws DatafileException {
        service.uploadNewDatafile(datafile);
    }

    @PutMapping(value = "/Datafile")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateDatafileEntry(@RequestBody DatafileEntity datafile) throws DatafileException {
        service.updateDatafile(datafile);
    }

    @DeleteMapping(value ="/Datafile{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteDatafileEntry(@RequestParam("id") UUID uuid) throws DatafileException {
        service.deleteDatafile(uuid);
    }
}
