package ai.aecode.testweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "person_zodiac")
public class Person_Zodiac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_person_zodiac;
    @ManyToOne
    @JoinColumn(name = "id_person_type")
    private PersonType personType;

    @ManyToOne
    @JoinColumn(name = "id_zodiac")
    private ZodiacSign zodiacSign;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Person_Zodiac() {
    }


    public Person_Zodiac(int id_person_zodiac, PersonType personType, ZodiacSign zodiacSign, String description) {
        this.id_person_zodiac = id_person_zodiac;
        this.personType = personType;
        this.zodiacSign = zodiacSign;
        this.description = description;
    }

    public int getId_person_zodiac() {
        return id_person_zodiac;
    }

    public void setId_person_zodiac(int id_person_zodiac) {
        this.id_person_zodiac = id_person_zodiac;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public ZodiacSign getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(ZodiacSign zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
