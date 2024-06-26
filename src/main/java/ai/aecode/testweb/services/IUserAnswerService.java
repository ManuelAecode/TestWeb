package ai.aecode.testweb.services;

import ai.aecode.testweb.entities.UserAnswer;

import java.util.List;

public interface IUserAnswerService {
    public void insert(UserAnswer useranswer);
    List<UserAnswer> list();
    public void delete(int id_useranswer);
    public UserAnswer listId(int id_useranswer);
}
