package ai.aecode.testweb.dtos;

import ai.aecode.testweb.entities.Element;
import ai.aecode.testweb.entities.Skill;

public class QuestionDTO {
    private int id_question;
    private Skill skill;
    private Element element;
    private String question_text;

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }
}
