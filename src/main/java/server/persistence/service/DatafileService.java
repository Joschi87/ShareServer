package server.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.lib.Exception.DatafileException;
import server.persistence.entity.DatafileEntity;
import server.persistence.repository.DatafileRepository;

import java.util.List;
import java.util.UUID;

@Service
public class DatafileService {

    @Autowired
    private DatafileRepository repo;

    public void uploadNewDatafile(DatafileEntity datafile) throws DatafileException {
        if(!repo.existsByName(datafile.getName())){
            repo.save(datafile);
            if (!eqaulsToDataFiles(datafile, datafile.getUuid())){
                throw new DatafileException("Upload of file \"" + datafile.getName() + "\" failed");
            }
        }else{
            throw new DatafileException("File with name: " + datafile.getName() + " already exsists in the database");
        }
    }

    public void updateDatafile(DatafileEntity datafile) throws DatafileException {
        if(repo.existsById(datafile.getUuid())){
            repo.save(datafile);
            if (!eqaulsToDataFiles(datafile, datafile.getUuid())){
                throw new DatafileException("Update failed for id: " + datafile.getUuid());
            }
        }else{
            throw new DatafileException("Datafile with id: " + datafile.getUuid() + " doesn't exisit in database");
        }
    }

    public void deleteDatafile(UUID uuid) throws DatafileException {
        if (repo.existsById(uuid)){
            repo.deleteById(uuid);
            if (repo.existsById(uuid))
                throw new DatafileException("Deleting process failed for id: " + uuid);
        }else{
            throw new DatafileException("Datafile with id: " + uuid + " doesn't exisit in database");
        }
    }

    public DatafileEntity getDataFileByID(UUID uuid) throws DatafileException {
        if(repo.existsById(uuid)){
            return repo.getOne(uuid);
        }else{
            throw new DatafileException("Datafile with id: " + uuid + " doesn't exisit in database");
        }
    }

    public List<DatafileEntity> getAllDatafiles(){
        return repo.findAll();
    }

    private boolean eqaulsToDataFiles(DatafileEntity datafileToCompare, UUID idFromDataOfDatabase){
        DatafileEntity datafileFromDatabase = repo.getOne(idFromDataOfDatabase);
        if(datafileToCompare.equals(datafileFromDatabase)){
            return true;
        }else{
            return false;
        }
    }
}
