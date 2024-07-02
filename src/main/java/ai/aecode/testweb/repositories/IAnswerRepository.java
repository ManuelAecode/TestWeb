package ai.aecode.testweb.repositories;

import ai.aecode.testweb.entities.Answer;
import ai.aecode.testweb.entities.Element;
import ai.aecode.testweb.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer, Integer> {
}
