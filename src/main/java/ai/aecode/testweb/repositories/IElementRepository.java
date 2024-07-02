package ai.aecode.testweb.repositories;

import ai.aecode.testweb.entities.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IElementRepository extends JpaRepository<Element,Integer> {

}
