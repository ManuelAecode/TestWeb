package ai.aecode.testweb.repositories;

import ai.aecode.testweb.entities.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonTypeRepository extends JpaRepository<PersonType,Integer> {
}
