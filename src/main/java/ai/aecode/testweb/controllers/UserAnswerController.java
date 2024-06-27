package ai.aecode.testweb.controllers;

import ai.aecode.testweb.dtos.UserAnswerDTO;
import ai.aecode.testweb.entities.UserAnswer;
import ai.aecode.testweb.services.IUserAnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/useranswer")
public class UserAnswerController {
    @Autowired
    private IUserAnswerService uaS;

    @PostMapping
    public void insert(@RequestBody UserAnswerDTO dto){
        ModelMapper m=new ModelMapper();
        UserAnswer u= m.map(dto,UserAnswer.class);
        uaS.insert(u);
    }

    @GetMapping
    public List<UserAnswerDTO> list() {
        return uaS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserAnswerDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){uaS.delete(id);}

    @GetMapping("/{id}")
    public UserAnswerDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        UserAnswerDTO dto=m.map(uaS.listId(id),UserAnswerDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody UserAnswerDTO dto) {
        ModelMapper m = new ModelMapper();
        UserAnswer u = m.map(dto, UserAnswer.class);
        uaS.insert(u);
    }
}
