package ai.aecode.testweb.controllers;
import ai.aecode.testweb.dtos.ElementDTO;
import ai.aecode.testweb.entities.Element;
import ai.aecode.testweb.services.IElementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/element")
public class ElementController {
    @Autowired
    private IElementService eS;

    @PostMapping
    public void insert(@RequestBody ElementDTO dto){
        ModelMapper m=new ModelMapper();
        Element e= m.map(dto,Element.class);
        eS.insert(e);
    }

    @GetMapping
    public List<ElementDTO> list() {
        return eS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ElementDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){eS.delete(id);}

    @GetMapping("/{id}")
    public ElementDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        ElementDTO dto=m.map(eS.listId(id),ElementDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody ElementDTO dto) {
        ModelMapper m = new ModelMapper();
        Element e = m.map(dto, Element.class);
        eS.insert(e);
    }
}
