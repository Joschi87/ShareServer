package server.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import server.persistence.entity.LinkEntity;

import java.util.UUID;

public interface LinkRepository extends JpaRepository<LinkEntity, UUID> {
	
}
