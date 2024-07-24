package ai.aecode.testweb.dtos;

import ai.aecode.testweb.entities.PersonType;
import ai.aecode.testweb.entities.ZodiacSign;

public class Person_ZodiacDTO {
    private int id_person_zodiac;
    private PersonType personType;
    private ZodiacSign zodiacSign;
    private Integer lowerPercentage;
    private Integer upperPercentage;
    private String description;

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

