package server.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Link")
public class LinkEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer id;
	@NotNull(message = "No Link used!")
	private String link;
	
	public LinkEntity() {}
	
	public LinkEntity(String link) {
		this.link = link;
	}
	
	public Integer getID() {
		return id;
	}
	
	public String getLink() {
		return link;
	}
}
