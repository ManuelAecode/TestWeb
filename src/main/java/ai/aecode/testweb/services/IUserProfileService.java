package ai.aecode.testweb.services;

import ai.aecode.testweb.entities.UserProfile;

import java.util.List;

public interface IUserProfileService {
    public void insert(UserProfile userprofile);
    List<UserProfile> list();
    public void delete(int id_user);
    public UserProfile listId(int id_user);
}
