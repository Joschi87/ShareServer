package server.persistence.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.UUID;

@Data
@Entity
public class DatafileEntity {

    @Id
    private UUID uuid = UUID.randomUUID();
    private String name;
    @Lob
    private byte[] datafile;
}
