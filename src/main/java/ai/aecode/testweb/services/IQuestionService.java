package ai.aecode.testweb.services;

import ai.aecode.testweb.entities.Question;

import java.util.List;

public interface IQuestionService {
    public void insert(Question question);
    List<Question> list();
    public void delete(int id_question);
    public Question listId(int id_question);
}
