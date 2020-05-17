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
	@NotNull
	private String link;
	
	@Override
	public String toString() {
		return String.format("<button type='button' class='btn btn-secondary' onclick='cacheLink(%s)' value='%s'>%s</button>", link, link, link);
	}
	
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
