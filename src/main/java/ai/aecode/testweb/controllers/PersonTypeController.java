package ai.aecode.testweb.controllers;

import ai.aecode.testweb.dtos.PersonTypeDTO;
import ai.aecode.testweb.entities.PersonType;
import ai.aecode.testweb.services.IPersonTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persontype")
public class PersonTypeController {

    @Autowired
    private IPersonTypeService ptS;
    @PostMapping
    public void insert(@RequestBody PersonTypeDTO dto){
        ModelMapper m=new ModelMapper();
        PersonType p= m.map(dto,PersonType.class);
        ptS.insert(p);
    }

    @GetMapping
    public List<PersonTypeDTO> list() {
        return ptS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PersonTypeDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){ptS.delete(id);}

    @GetMapping("/{id}")
    public PersonTypeDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        PersonTypeDTO dto=m.map(ptS.listId(id),PersonTypeDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody PersonTypeDTO dto) {
        ModelMapper m = new ModelMapper();
        PersonType p = m.map(dto, PersonType.class);
        ptS.insert(p);
    }
}
