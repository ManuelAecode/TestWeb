package ai.aecode.testweb.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "0.0")
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer result_manager;
    @Column(name = "result_developer")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "0.0")
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer result_developer;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "0.0")
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "result_executor")
    private Integer result_executor;
    @Column(name = "person_type_description")
    private String person_type_description;

    @ManyToMany
    @JoinTable(name = "detail_skill",
            joinColumns = @JoinColumn(name = "id_userresult"),
            inverseJoinColumns = @JoinColumn(name = "id_skill"))
    private Set<Skill> skillderecho;

    @ManyToMany
    @JoinTable(name = "detail_skill",
            joinColumns = @JoinColumn(name = "id_userresult"),
            inverseJoinColumns = @JoinColumn(name = "id_skill"))
    private Set<Skill> skillizquierdo;


    public UserResult() {
    }

    public UserResult(int id_userresult, UserProfile userProfile, PersonType personType, Integer result_manager, Integer result_developer, Integer result_executor, String person_type_description, Set<Skill> skillderecho, Set<Skill> skillizquierdo) {
        this.id_userresult = id_userresult;
        this.userProfile = userProfile;
        this.personType = personType;
        this.result_manager = result_manager;
        this.result_developer = result_developer;
        this.result_executor = result_executor;
        this.person_type_description = person_type_description;
        this.skillderecho = skillderecho;
        this.skillizquierdo = skillizquierdo;
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

    public Set<Skill> getSkillderecho() {
        return skillderecho;
    }

    public void setSkillderecho(Set<Skill> skillderecho) {
        this.skillderecho = skillderecho;
    }

    public Set<Skill> getSkillizquierdo() {
        return skillizquierdo;
    }

    public void setSkillizquierdo(Set<Skill> skillizquierdo) {
        this.skillizquierdo = skillizquierdo;
    }
}
