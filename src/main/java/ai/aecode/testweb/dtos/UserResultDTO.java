package ai.aecode.testweb.dtos;

import ai.aecode.testweb.entities.PersonType;
import ai.aecode.testweb.entities.UserProfile;


public class UserResultDTO {
    private int id_userresult;
    private UserProfile userProfile;
    private PersonType personType;
    private Double result_percentage;

    public int getId_userresult() {
        return id_userresult;
    }

    public void setId_userresult(int id_userresult) {
        this.id_userresult = id_userresult;
    }

    public UserProfile getUser() {
        return userProfile;
    }

    public void setUser(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public Double getResult_percentage() {
        return result_percentage;
    }

    public void setResult_percentage(Double result_percentage) {
        this.result_percentage = result_percentage;
    }
}
