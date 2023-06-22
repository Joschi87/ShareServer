package server.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.persistence.entity.DatafileEntity;

import java.util.UUID;

@Repository
public interface DatafileRepository extends JpaRepository<DatafileEntity, UUID> {

    public boolean existsByName(String name);
}
