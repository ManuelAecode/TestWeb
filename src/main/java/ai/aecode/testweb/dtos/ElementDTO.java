package ai.aecode.testweb.dtos;

import jakarta.persistence.Column;

public class ElementDTO {
    private int id_element;
    private String element_name;

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
