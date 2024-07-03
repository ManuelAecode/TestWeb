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
    @Column(name = "result_manager")
    private Double result_manager;
    @Column(name = "result_developer")
    private Double result_developer;
    @Column(name = "result_executor")
    private Double result_executor;
    @Column(name = "person_type_description")
    private String person_type_description;

    public UserResult() {
    }

    public UserResult(int id_userresult, UserProfile userProfile, PersonType personType, Double result_manager, Double result_developer, Double result_executor, String person_type_description) {
        this.id_userresult = id_userresult;
        this.userProfile = userProfile;
        this.personType = personType;
        this.result_manager = result_manager;
        this.result_developer = result_developer;
        this.result_executor = result_executor;
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

    public Double getResult_manager() {
        return result_manager;
    }

    public void setResult_manager(Double result_manager) {
        this.result_manager = result_manager;
    }

    public Double getResult_developer() {
        return result_developer;
    }

    public void setResult_developer(Double result_developer) {
        this.result_developer = result_developer;
    }

    public Double getResult_executor() {
        return result_executor;
    }

    public void setResult_executor(Double result_executor) {
        this.result_executor = result_executor;
    }

    public String getPerson_type_description() {
        return person_type_description;
    }

    public void setPerson_type_description(String person_type_description) {
        this.person_type_description = person_type_description;
    }

    public void SetResults(double rManager, double rDeveloper, double rExecutor){
        this.result_manager = rManager;
        this.result_developer = rDeveloper;
        this.result_executor = rExecutor;
    }
}
