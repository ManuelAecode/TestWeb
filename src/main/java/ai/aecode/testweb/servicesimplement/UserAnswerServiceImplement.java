package ai.aecode.testweb.servicesimplement;

import ai.aecode.testweb.entities.UserAnswer;
import ai.aecode.testweb.repositories.IUserAnswerRepository;
import ai.aecode.testweb.services.IUserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerServiceImplement implements IUserAnswerService {
    @Autowired
    private IUserAnswerRepository uaR;
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
}
