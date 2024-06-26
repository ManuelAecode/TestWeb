package ai.aecode.testweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "persontype")
public class PersonType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_person_type;
    @Column(name = "person_typef_name")
    private String person_type_name;
    @Column(name = "person_type_description")
    private String person_type_description;

    public PersonType() {
    }

    public PersonType(int id_person_type, String person_type_name, String person_type_description) {
        this.id_person_type = id_person_type;
        this.person_type_name = person_type_name;
        this.person_type_description = person_type_description;
    }

    public int getId_person_type() {
        return id_person_type;
    }

    public void setId_person_type(int id_person_type) {
        this.id_person_type = id_person_type;
    }

    public String getPerson_type_name() {
        return person_type_name;
    }

    public void setPerson_type_name(String person_type_name) {
        this.person_type_name = person_type_name;
    }

    public String getPerson_type_description() {
        return person_type_description;
    }

    public void setPerson_type_description(String person_type_description) {
        this.person_type_description = person_type_description;
    }
}
