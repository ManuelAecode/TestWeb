package ai.aecode.testweb.controllers;

import ai.aecode.testweb.dtos.UserAnswerDTO;
import ai.aecode.testweb.dtos.UserResultDTO;
import ai.aecode.testweb.entities.UserAnswer;
import ai.aecode.testweb.entities.UserProfile;
import ai.aecode.testweb.entities.UserResult;
import ai.aecode.testweb.services.IUserAnswerService;
import ai.aecode.testweb.services.IUserProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/useranswer")
public class UserAnswerController {
    @Autowired
    private IUserAnswerService uaS;
    @Autowired
    private IUserProfileService upS;

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

    @GetMapping("/userresult/{email}")
    public ResponseEntity<UserResult> getUserResult(@PathVariable("email") String email) {
        UserResult userResult = uaS.processUserAnswersAndSaveResult(email);

        if (userResult == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userResult);
    }

}
