package ai.aecode.testweb.dtos;


public class SkillDTO {
    private int id_skill;
    private String skill_name;
    private Integer final_score;

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

    public Integer getFinal_score() {
        return final_score;
    }

    public void setFinal_score(Integer final_score) {
        this.final_score = final_score;
    }
}
