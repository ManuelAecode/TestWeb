package ai.aecode.testweb.repositories;

import ai.aecode.testweb.entities.PersonType;
import ai.aecode.testweb.entities.Person_Zodiac;
import ai.aecode.testweb.entities.ZodiacSign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerson_ZodiacRepository extends JpaRepository<Person_Zodiac, Integer> {
    // Método para encontrar PersonZodiac por personType y zodiacSign
    @Query("SELECT pz FROM Person_Zodiac pz WHERE pz.personType = :personType AND pz.zodiacSign = :zodiacSign AND pz.lowerPercentage <= :percentage AND pz.upperPercentage >= :percentage")
    Person_Zodiac findByPersonTypeAndZodiacSign(PersonType personType, ZodiacSign zodiacSign, int percentage);
}
