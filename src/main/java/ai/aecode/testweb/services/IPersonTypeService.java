package ai.aecode.testweb.services;

import ai.aecode.testweb.entities.PersonType;

import java.util.List;

public interface IPersonTypeService {
    public void insert(PersonType persontype);
    List<PersonType> list();
    public void delete(int id_person_type);
    public PersonType listId(int id_person_type);
}
