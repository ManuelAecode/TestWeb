package ai.aecode.testweb.repositories;

import ai.aecode.testweb.entities.UserProfile;
import ai.aecode.testweb.entities.UserResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserResultRepository extends JpaRepository<UserResult,Integer> {

    @Query("SELECT ur FROM UserResult ur WHERE ur.userProfile = :userProfile")
    UserResult findByUserProfile(UserProfile userProfile);
}
