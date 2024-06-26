package ai.aecode.testweb.services;

import ai.aecode.testweb.entities.Element;

import java.util.List;

public interface IElementService {
    public void insert(Element question);
    List<Element> list();
    public void delete(int id_element);
    public Element listId(int id_element);
}
