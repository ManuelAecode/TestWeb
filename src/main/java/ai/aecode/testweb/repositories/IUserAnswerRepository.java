package ai.aecode.testweb.repositories;

import ai.aecode.testweb.entities.UserAnswer;
import ai.aecode.testweb.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserAnswerRepository extends JpaRepository<UserAnswer,Integer> {
    @Query("select ua from UserAnswer ua where ua.userProfile=:userProfile")
    List<UserAnswer> findByUserProfile(UserProfile userProfile);
}
