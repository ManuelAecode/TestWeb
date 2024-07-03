package ai.aecode.testweb.servicesimplement;

import ai.aecode.testweb.entities.Answer;
import ai.aecode.testweb.entities.UserAnswer;
import ai.aecode.testweb.entities.UserProfile;
import ai.aecode.testweb.entities.UserResult;
import ai.aecode.testweb.repositories.IUserAnswerRepository;
import ai.aecode.testweb.repositories.IUserProfileRepository;
import ai.aecode.testweb.repositories.IUserResultRepository;
import ai.aecode.testweb.services.IUserAnswerService;
import ai.aecode.testweb.services.IUserResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerServiceImplement implements IUserAnswerService {
    @Autowired
    private IUserAnswerRepository uaR;
    @Autowired
    private IUserProfileRepository upR;

    @Autowired
    private IUserResultRepository urR;

    @Autowired
    private IUserResultService urS;

    @Override
    public void insert(UserAnswer useranswer) {
        uaR.save(useranswer);
    }

    @Override
    public List<UserAnswer> list() {
        return uaR.findAll();
    }

    @Override
    public void delete(int id_useranswer) {
        uaR.deleteById(id_useranswer);
    }

    @Override
    public UserAnswer listId(int id_useranswer) {
        return uaR.findById(id_useranswer).orElse(new UserAnswer());
    }

    @Override
    public UserResult processUserAnswersAndSaveResult(int userId) {
        // Obtener el perfil del usuario por ID
        UserProfile userProfile = upR.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Obtener las respuestas del usuario
        List<UserAnswer> userAnswers = uaR.findByUserProfile(userProfile);

        // Calcular los resultados
        double totalManager = 1.0;
        double totalDeveloper = 1.0;
        double totalExecutor = 1.0;

        for (UserAnswer userAnswer : userAnswers) {
            for (Answer answer : userAnswer.getAnswer()) {
                totalManager *= answer.getValue_manager();
                totalDeveloper *= answer.getValue_developer();
                totalExecutor *= answer.getValue_executor();
            }
        }

        // Crear y devolver el objeto UserResult
        UserResult userResult = new UserResult();
        userResult.setUserProfile(userProfile);
        userResult.setResult_manager(totalManager);
        userResult.setResult_developer(totalDeveloper);
        userResult.setResult_executor(totalExecutor);

        return userResult;
    }
}
