package ai.aecode.testweb.repositories;

import ai.aecode.testweb.entities.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAnswerRepository extends JpaRepository<UserAnswer,Integer> {
}
