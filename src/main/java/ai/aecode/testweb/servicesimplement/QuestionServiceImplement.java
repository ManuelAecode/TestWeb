package ai.aecode.testweb.servicesimplement;

import ai.aecode.testweb.entities.Question;
import ai.aecode.testweb.repositories.IQuestionRepository;
import ai.aecode.testweb.services.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImplement implements IQuestionService {
@Autowired
private IQuestionRepository qR;

    @Override
    public void insert(Question question) {
        qR.save(question);
    }

    @Override
    public List<Question> list() {
        return qR.findAll();
    }

    @Override
    public void delete(int id_question) {
        qR.deleteById(id_question);
    }

    @Override
    public Question listId(int id_question) {
        return qR.findById(id_question).orElse(new Question());
    }
}
