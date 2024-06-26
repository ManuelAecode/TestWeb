package ai.aecode.testweb.servicesimplement;

import ai.aecode.testweb.entities.Answer;
import ai.aecode.testweb.repositories.IAnswerRepository;
import ai.aecode.testweb.services.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImplement implements IAnswerService {
    @Autowired
    private IAnswerRepository aR;
    @Override
    public void insert(Answer answer) {
        aR.save(answer);
    }

    @Override
    public List<Answer> list() {
        return aR.findAll();
    }

    @Override
    public void delete(int id_answer) {
        aR.deleteById(id_answer);
    }

    @Override
    public Answer listId(int id_answer) {
        return aR.findById(id_answer).orElse(new Answer());
    }
}
