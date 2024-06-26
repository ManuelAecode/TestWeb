package ai.aecode.testweb.controllers;

import ai.aecode.testweb.dtos.SkillDTO;
import ai.aecode.testweb.entities.Skill;
import ai.aecode.testweb.services.ISkillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    private ISkillService sS;

    @PostMapping
    public void insert(@RequestBody SkillDTO dto){
        ModelMapper m=new ModelMapper();
        Skill s= m.map(dto,Skill.class);
        sS.insert(s);
    }

    @GetMapping
    public List<SkillDTO> list() {
        return sS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SkillDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){sS.delete(id);}

    @GetMapping("/{id}")
    public SkillDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        SkillDTO dto=m.map(sS.listId(id),SkillDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody SkillDTO dto) {
        ModelMapper m = new ModelMapper();
        Skill s = m.map(dto, Skill.class);
        sS.insert(s);
    }
}
