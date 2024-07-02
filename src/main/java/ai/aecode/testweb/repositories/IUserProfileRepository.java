package ai.aecode.testweb.repositories;

import ai.aecode.testweb.entities.Question;
import ai.aecode.testweb.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserProfileRepository extends JpaRepository<UserProfile, Integer> {
    @Query("SELECT u FROM UserProfile u WHERE u.id_user = :id")
    UserProfile findUser(int id);
}
