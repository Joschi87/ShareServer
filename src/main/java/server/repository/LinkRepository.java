package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import server.entity.LinkEntity;

public interface LinkRepository extends JpaRepository<LinkEntity, Integer> {

}
