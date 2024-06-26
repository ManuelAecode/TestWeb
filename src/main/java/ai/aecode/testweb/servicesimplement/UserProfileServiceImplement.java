package ai.aecode.testweb.servicesimplement;

import ai.aecode.testweb.entities.UserProfile;
import ai.aecode.testweb.repositories.IUserProfileRepository;
import ai.aecode.testweb.services.IUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImplement implements IUserProfileService {
    @Autowired
    private IUserProfileRepository upR;
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
        return upR.findById(id_user).orElse(new UserProfile());
    }
}
