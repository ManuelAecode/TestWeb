package ai.aecode.testweb.controllers;

import ai.aecode.testweb.dtos.AnswerDTO;
import ai.aecode.testweb.entities.Answer;
import ai.aecode.testweb.services.IAnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private IAnswerService aS;

    @PostMapping
    public void insert(@RequestBody AnswerDTO dto){
        ModelMapper m=new ModelMapper();
        Answer a= m.map(dto,Answer.class);
        aS.insert(a);
    }

    @GetMapping
    public List<AnswerDTO> list() {
        return aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AnswerDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){aS.delete(id);}

    @GetMapping("/{id}")
    public AnswerDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        AnswerDTO dto=m.map(aS.listId(id),AnswerDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody AnswerDTO dto) {
        ModelMapper m = new ModelMapper();
        Answer a = m.map(dto, Answer.class);
        aS.insert(a);
    }
}
