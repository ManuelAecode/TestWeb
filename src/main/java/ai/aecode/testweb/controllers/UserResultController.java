package ai.aecode.testweb.controllers;

import ai.aecode.testweb.dtos.UserResultDTO;
import ai.aecode.testweb.entities.UserResult;
import ai.aecode.testweb.services.IUserResultService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/userresult")
public class UserResultController {

    @Autowired
    private IUserResultService urS;

    @PostMapping
    public void insert(@RequestBody UserResultDTO dto){
        ModelMapper m=new ModelMapper();
        UserResult u= m.map(dto,UserResult.class);
        urS.insert(u);
    }

    @GetMapping
    public List<UserResultDTO> list() {
        return urS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserResultDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){urS.delete(id);}

    @GetMapping("/{id}")
    public UserResultDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        UserResultDTO dto=m.map(urS.listId(id),UserResultDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody UserResultDTO dto) {
        ModelMapper m = new ModelMapper();
        UserResult u = m.map(dto, UserResult.class);
        urS.insert(u);
    }
}
