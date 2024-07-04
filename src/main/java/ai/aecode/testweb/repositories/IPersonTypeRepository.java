package ai.aecode.testweb.repositories;

import ai.aecode.testweb.entities.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonTypeRepository extends JpaRepository<PersonType,Integer> {
    @Query("SELECT pt FROM PersonType pt WHERE pt.person_type_name = :typeName")
    PersonType findByPersonTypeName(@Param("typeName") String typeName);
}
