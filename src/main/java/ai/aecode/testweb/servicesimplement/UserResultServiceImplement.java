package ai.aecode.testweb.servicesimplement;

import ai.aecode.testweb.entities.UserResult;
import ai.aecode.testweb.repositories.IUserResultRepository;
import ai.aecode.testweb.services.IUserResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserResultServiceImplement implements IUserResultService {
    @Autowired
    private IUserResultRepository urR;
    @Override
    public void insert(UserResult userresult) {
        urR.save(userresult);
    }

    @Override
    public List<UserResult> list() {
        return urR.findAll();
    }

    @Override
    public void delete(int id_userresult) {
        urR.deleteById(id_userresult);
    }

    @Override
    public UserResult listId(int id_userresult) {
        return urR.findById(id_userresult).orElse(new UserResult());
    }
}
