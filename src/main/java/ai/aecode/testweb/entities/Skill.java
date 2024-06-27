package ai.aecode.testweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_skill;
    @Column(name = "skill_name")
    private String skill_name;

    public Skill() {
    }

    public Skill(int id_skill, String skill_name) {
        this.id_skill = id_skill;
        this.skill_name = skill_name;
    }

    public int getId_skill() {
        return id_skill;
    }

    public void setId_skill(int id_skill) {
        this.id_skill = id_skill;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

}
