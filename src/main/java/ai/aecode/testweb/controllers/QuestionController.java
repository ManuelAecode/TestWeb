package ai.aecode.testweb.controllers;

import ai.aecode.testweb.dtos.QuestionDTO;
import ai.aecode.testweb.entities.Question;
import ai.aecode.testweb.services.IQuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private IQuestionService qS;
    @PostMapping
    public void insert(@RequestBody QuestionDTO dto){
        ModelMapper m=new ModelMapper();
        Question q= m.map(dto,Question.class);
        qS.insert(q);
    }

    @GetMapping
    public List<QuestionDTO> list() {
        return qS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, QuestionDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){qS.delete(id);}

    @GetMapping("/{id}")
    public QuestionDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        QuestionDTO dto=m.map(qS.listId(id),QuestionDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody QuestionDTO dto) {
        ModelMapper m = new ModelMapper();
        Question q = m.map(dto, Question.class);
        qS.insert(q);
    }
}
