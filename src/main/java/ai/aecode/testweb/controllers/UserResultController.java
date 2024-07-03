package ai.aecode.testweb.controllers;

import ai.aecode.testweb.dtos.UserResultDTO;
import ai.aecode.testweb.entities.UserAnswer;
import ai.aecode.testweb.entities.UserResult;
import ai.aecode.testweb.services.IUserAnswerService;
import ai.aecode.testweb.services.IUserResultService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/userresult")
public class UserResultController {

    @Autowired
    private IUserResultService urS;
    @Autowired
    private IUserAnswerService uaS;

    @GetMapping
    public List<UserResultDTO> list() {
        List<UserResult> userResults = urS.list();
        List<UserResultDTO> userResultDTOs = new ArrayList<>();

        for (UserResult userResult : userResults) {
            UserResultDTO userResultDTO = new UserResultDTO();
            userResultDTO.setResult_manager(userResult.getResult_manager());
            userResultDTO.setResult_developer(userResult.getResult_developer());
            userResultDTO.setResult_executor(userResult.getResult_executor());
            // Include other fields you want to display in the UserResultDTO

            userResultDTOs.add(userResultDTO);
        }

        return userResultDTOs;
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
