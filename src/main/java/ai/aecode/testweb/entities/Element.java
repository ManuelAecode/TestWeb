package ai.aecode.testweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "element")
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_element;
    @Column(name = "element_name")
    private String element_name;

    public Element() {
    }

    public Element(int id_element, String element_name) {
        this.id_element = id_element;
        this.element_name = element_name;
    }

    public int getId_element() {
        return id_element;
    }

    public void setId_element(int id_element) {
        this.id_element = id_element;
    }

    public String getElement_name() {
        return element_name;
    }

    public void setElement_name(String element_name) {
        this.element_name = element_name;
    }

}
