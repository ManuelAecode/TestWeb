package ai.aecode.testweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "userresult")
public class UserResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_userresult;
    @OneToOne
    @JoinColumn(name = "id_user")
    private UserProfile userProfile;
    @ManyToOne
    @JoinColumn(name = "id_person_type")
    private PersonType personType;
    @Column(name = "result_percentage")
    private Double result_percentage;
    @Column(name = "person_type_description")
    private String person_type_description;

    public UserResult() {
    }

    public UserResult(int id_userresult, UserProfile userProfile, PersonType personType, Double result_percentage, String person_type_description) {
        this.id_userresult = id_userresult;
        this.userProfile = userProfile;
        this.personType = personType;
        this.result_percentage = result_percentage;
        this.person_type_description = person_type_description;
    }

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

    public Double getResult_percentage() {
        return result_percentage;
    }

    public void setResult_percentage(Double result_percentage) {
        this.result_percentage = result_percentage;
    }

    public String getPerson_type_description() {
        return person_type_description;
    }

    public void setPerson_type_description(String person_type_description) {
        this.person_type_description = person_type_description;
    }
}
