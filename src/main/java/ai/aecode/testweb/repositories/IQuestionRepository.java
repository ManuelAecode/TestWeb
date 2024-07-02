package ai.aecode.testweb.repositories;

import ai.aecode.testweb.entities.Element;
import ai.aecode.testweb.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQuestionRepository  extends JpaRepository<Question,Integer> {
    @Query("SELECT q from Question q where q.element=:element")
    List<Question> findbyElement(Element element);

}
