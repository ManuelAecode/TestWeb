package ai.aecode.testweb.controllers;

import ai.aecode.testweb.dtos.AnswerDTO;
import ai.aecode.testweb.entities.Answer;
import ai.aecode.testweb.entities.Question;
import ai.aecode.testweb.services.IAnswerService;
import ai.aecode.testweb.services.IQuestionService;
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
    @Autowired
    private IQuestionService qS;

    @PostMapping
    public void insert(@RequestBody AnswerDTO dto){
        ModelMapper m = new ModelMapper();
        Answer a = m.map(dto, Answer.class);
        // Obtener la pregunta correspondiente al id proporcionado en el AnswerDTO
        Question question = qS.listId(dto.getId_question());
        if (question != null) {
            a.setQuestion(question);
        }

        aS.insert(a);
    }

    @GetMapping
    public List<AnswerDTO> list() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(Answer.class, AnswerDTO.class)
                .addMapping(src -> src.getQuestion().getId_question(), AnswerDTO::setId_question)
                .addMapping(Answer::getValue_skill_manager, AnswerDTO::setValue_skill_manager)
                .addMapping(Answer::getValue_skill_developer, AnswerDTO::setValue_skill_developer)
                .addMapping(Answer::getValue_skill_executor, AnswerDTO::setValue_skill_executor)
                .addMapping(Answer::getValue_manager, AnswerDTO::setValue_manager)
                .addMapping(Answer::getValue_developer, AnswerDTO::setValue_developer)
                .addMapping(Answer::getValue_executor, AnswerDTO::setValue_executor);

        List<Answer> answerList = aS.list();
        List<AnswerDTO> answerDTOList = answerList.stream()
                .map(answer -> modelMapper.map(answer, AnswerDTO.class))
                .collect(Collectors.toList());

        return answerDTOList;
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
