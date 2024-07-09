package ai.aecode.testweb.repositories;

import ai.aecode.testweb.entities.Question;
import ai.aecode.testweb.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserProfileRepository extends JpaRepository<UserProfile, Integer> {

    @Query("SELECT p FROM UserProfile p WHERE  p.user_email = :email")
    UserProfile findByUsernameOrEmail(@Param("email") String email);

    @Query("SELECT u FROM UserProfile u WHERE u.user_email = :email")
    UserProfile findByUserEmail(String email);
}
