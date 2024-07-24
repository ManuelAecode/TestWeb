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

    @Column(name = "lower_percentage")
    private Integer lowerPercentage;

    @Column(name = "upper_percentage")
    private Integer upperPercentage;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Person_Zodiac() {
    }


    public Person_Zodiac(int id_person_zodiac, PersonType personType, ZodiacSign zodiacSign, Integer lowerPercentage, Integer upperPercentage, String description) {
        this.id_person_zodiac = id_person_zodiac;
        this.personType = personType;
        this.zodiacSign = zodiacSign;
        this.lowerPercentage = lowerPercentage;
        this.upperPercentage = upperPercentage;
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

    public Integer getLowerPercentage() {
        return lowerPercentage;
    }

    public void setLowerPercentage(Integer lowerPercentage) {
        this.lowerPercentage = lowerPercentage;
    }

    public Integer getUpperPercentage() {
        return upperPercentage;
    }

    public void setUpperPercentage(Integer upperPercentage) {
        this.upperPercentage = upperPercentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
