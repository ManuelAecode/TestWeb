package ai.aecode.testweb.servicesimplement;

import ai.aecode.testweb.entities.Element;
import ai.aecode.testweb.repositories.IElementRepository;
import ai.aecode.testweb.services.IElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementServiceImplement implements IElementService {
    @Autowired
    private IElementRepository eR;
    @Override
    public void insert(Element question) {
        eR.save(question);
    }

    @Override
    public List<Element> list() {
        return eR.findAll();
    }

    @Override
    public void delete(int id_element) {
        eR.deleteById(id_element);
    }

    @Override
    public Element listId(int id_element) {
        return eR.findById(id_element).orElse(new Element());
    }
}
