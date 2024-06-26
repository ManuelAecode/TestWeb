package ai.aecode.testweb.repositories;

import ai.aecode.testweb.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer, Integer> {
}
