package ai.aecode.testweb.dtos;

import ai.aecode.testweb.entities.PersonType;
import ai.aecode.testweb.entities.UserProfile;
import jakarta.persistence.Column;

import java.util.List;


public class UserResultDTO {
    private int id_userresult;
    private UserProfile userProfile;
    private PersonType personType;
    private Integer result_manager;
    private Integer result_developer;
    private Integer result_executor;
    private String person_type_description;
    private List<SkillDTO> skillderecho;
    private List<SkillDTO> skillizquierdo;

    public int getId_userresult() {
        return id_userresult;
    }

    public void setId_userresult(int id_userresult) {
        this.id_userresult = id_userresult;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public Integer getResult_manager() {
        return result_manager;
    }

    public void setResult_manager(Integer result_manager) {
        this.result_manager = result_manager;
    }

    public Integer getResult_developer() {
        return result_developer;
    }

    public void setResult_developer(Integer result_developer) {
        this.result_developer = result_developer;
    }

    public Integer getResult_executor() {
        return result_executor;
    }

    public void setResult_executor(Integer result_executor) {
        this.result_executor = result_executor;
    }

    public String getPerson_type_description() {
        return person_type_description;
    }

    public void setPerson_type_description(String person_type_description) {
        this.person_type_description = person_type_description;
    }

    public List<SkillDTO> getSkillderecho() {
        return skillderecho;
    }

    public void setSkillderecho(List<SkillDTO> skillderecho) {
        this.skillderecho = skillderecho;
    }

    public List<SkillDTO> getSkillizquierdo() {
        return skillizquierdo;
    }

    public void setSkillizquierdo(List<SkillDTO> skillizquierdo) {
        this.skillizquierdo = skillizquierdo;
    }
}
