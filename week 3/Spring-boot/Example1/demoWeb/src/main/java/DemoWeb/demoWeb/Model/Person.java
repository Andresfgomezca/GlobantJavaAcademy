package DemoWeb.demoWeb.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Person {
    //packages model and repo are our representation of the databases
    @Id
    private String idPerson;

    public Person(String name) {
        setName(name);
        setIdPerson(UUID.randomUUID().toString());
    }

    public Person() {

    }

    @Column(name = "DataBaseName", length = 50)
    private String name;

    //length is the amount of chars allowed in the column
    //JPA will not construct the table for this system, it is required to do analyze the design of this database
    //to implement our design desired
    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
