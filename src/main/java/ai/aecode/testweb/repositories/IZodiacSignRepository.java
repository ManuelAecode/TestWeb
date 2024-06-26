package ai.aecode.testweb.repositories;

import ai.aecode.testweb.entities.ZodiacSign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IZodiacSignRepository extends JpaRepository<ZodiacSign,Integer> {
}
