package ai.aecode.testweb.controllers;

import ai.aecode.testweb.dtos.UserProfileDTO;
import ai.aecode.testweb.dtos.UserQuestionDTO;
import ai.aecode.testweb.entities.UserProfile;
import ai.aecode.testweb.services.IUserProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/userprofile")
public class UserProfileController {
    @Autowired
    private IUserProfileService upS;


    @PostMapping
    public void insert(@RequestBody UserProfileDTO dto){
        ModelMapper m=new ModelMapper();
        UserProfile s= m.map(dto,UserProfile.class);
        upS.insert(s);
    }

    @GetMapping
    public List<UserProfileDTO> list() {
        return upS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserProfileDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){upS.delete(id);}

    @GetMapping("/{email}")
    public UserProfileDTO listId(@PathVariable("email") String email){
        ModelMapper m=new ModelMapper();
        UserProfileDTO dto=m.map(upS.listId(email),UserProfileDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody UserProfileDTO dto) {
        ModelMapper m = new ModelMapper();
        UserProfile s = m.map(dto, UserProfile.class);
        upS.insert(s);
    }

    @GetMapping("/{email}/questions")
    public ResponseEntity<List<UserQuestionDTO>> getUserQuestionsByElement(@PathVariable String email) {
        List<UserQuestionDTO> questions = upS.getUserQuestionnaireByElement(email);
        if (questions == null) {
            return ResponseEntity.notFound().build(); // Manejar caso de usuario no encontrado
        }
        return ResponseEntity.ok(questions);
    }

}
