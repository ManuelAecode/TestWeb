package ai.aecode.testweb.repositories;

import ai.aecode.testweb.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserProfileRepository extends JpaRepository<UserProfile, Integer> {
}
