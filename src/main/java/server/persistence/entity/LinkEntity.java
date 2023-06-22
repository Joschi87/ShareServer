package server.persistence.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.UUID;

@Data
@Entity
public class LinkEntity {

	@Id
	private UUID id = UUID.randomUUID();
	private String link;
}