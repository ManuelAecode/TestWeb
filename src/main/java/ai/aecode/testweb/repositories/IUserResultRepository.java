package ai.aecode.testweb.repositories;

import ai.aecode.testweb.entities.UserResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserResultRepository extends JpaRepository<UserResult,Integer> {
}
