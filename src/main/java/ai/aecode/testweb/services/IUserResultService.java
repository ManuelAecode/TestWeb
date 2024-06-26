package ai.aecode.testweb.services;

import ai.aecode.testweb.entities.UserResult;

import java.util.List;

public interface IUserResultService {
    public void insert(UserResult userresult);
    List<UserResult> list();
    public void delete(int id_userresult);
    public UserResult listId(int id_userresult);
}
