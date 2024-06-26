package ai.aecode.testweb.services;

import ai.aecode.testweb.entities.Answer;

import java.util.List;

public interface IAnswerService {
    public void insert(Answer answer);
    List<Answer> list();
    public void delete(int id_answer);
    public Answer listId(int id_answer);
}
