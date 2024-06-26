package ai.aecode.testweb.servicesimplement;

import ai.aecode.testweb.entities.PersonType;
import ai.aecode.testweb.repositories.IPersonTypeRepository;
import ai.aecode.testweb.services.IPersonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonTypeServiceImplement implements IPersonTypeService {
    @Autowired
    private IPersonTypeRepository ptR;
    @Override
    public void insert(PersonType persontype) {
        ptR.save(persontype);
    }

    @Override
    public List<PersonType> list() {
        return ptR.findAll();
    }

    @Override
    public void delete(int id_person_type) {
        ptR.deleteById(id_person_type);
    }

    @Override
    public PersonType listId(int id_person_type) {
        return ptR.findById(id_person_type).orElse(new PersonType());
    }
}
