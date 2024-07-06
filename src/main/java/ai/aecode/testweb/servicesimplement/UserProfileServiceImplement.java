package ai.aecode.testweb.servicesimplement;

import ai.aecode.testweb.dtos.AnswerDTO;
import ai.aecode.testweb.dtos.UserQuestionDTO;
import ai.aecode.testweb.entities.Element;
import ai.aecode.testweb.entities.Question;
import ai.aecode.testweb.entities.UserProfile;
import ai.aecode.testweb.repositories.IAnswerRepository;
import ai.aecode.testweb.repositories.IQuestionRepository;
import ai.aecode.testweb.repositories.IUserProfileRepository;
import ai.aecode.testweb.services.IUserProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserProfileServiceImplement implements IUserProfileService {
    @Autowired
    private IUserProfileRepository upR;
    @Autowired
    private IQuestionRepository qR;
    @Autowired
    private IAnswerRepository aR;

    @Override
    public void insert(UserProfile userprofile) {
        upR.save(userprofile);
    }

    @Override
    public List<UserProfile> list() {
        return upR.findAll();
    }

    @Override
    public void delete(int id_user) {
        upR.deleteById(id_user);
    }

    @Override
    public UserProfile listId(int id_user) {
        return upR.findById(id_user).orElse(null);
    }

    @Override
    public List<UserQuestionDTO> getUserQuestionnaireByElement(String email) {
        UserProfile userProfile = upR.findUser(email);
        if (userProfile == null || userProfile.getElement() == null) {
            return Collections.emptyList(); // o manejar como sea necesario
        }

        Element userElement = userProfile.getElement();

        // Obtener todas las preguntas asociadas al elemento del usuario
        List<Question> questions = qR.findbyElement(userElement);

        List<UserQuestionDTO> userQuestionDTOs = questions.stream()
                .map(question -> {
                    List<AnswerDTO> answerDTOs = question.getAnswers().stream()
                            .map(answer -> {
                                AnswerDTO answerDTO = new AnswerDTO();
                                answerDTO.setId_answer(answer.getId_answer());
                                answerDTO.setAnswer_text(answer.getAnswer_text());
                                // Establece los valores como value_skill_manager, value_skill_developer, value_skill_executor aquí
                                answerDTO.setValue_skill_manager(answer.getValue_skill_manager());
                                answerDTO.setValue_skill_developer(answer.getValue_skill_developer());
                                answerDTO.setValue_skill_executor(answer.getValue_skill_executor());

                                // Establece los valores como value_manager, value_developer, value_executor aquí
                                answerDTO.setValue_manager(answer.getValue_manager());
                                answerDTO.setValue_developer(answer.getValue_developer());
                                answerDTO.setValue_executor(answer.getValue_executor());
                                answerDTO.setId_question(answer.getQuestion().getId_question());
                                return answerDTO;
                            })
                            .collect(Collectors.toList());

                    UserQuestionDTO userQuestionDTO = new UserQuestionDTO();
                    userQuestionDTO.setId_question(question.getId_question());
                    userQuestionDTO.setQuestion_text(question.getQuestion_text());
                    userQuestionDTO.setSkill_name(question.getSkill().getSkill_name());
                    userQuestionDTO.setElement_name(question.getElement().getElement_name());
                    userQuestionDTO.setAnswer(answerDTOs);
                    return userQuestionDTO;
                })
                .collect(Collectors.toList());
        return userQuestionDTOs;
    }
}
