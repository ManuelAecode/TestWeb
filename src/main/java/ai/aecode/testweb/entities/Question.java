package ai.aecode.testweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_question;
    @ManyToOne
    @JoinColumn(name = "id_skill")
    private Skill skill;
    @ManyToOne
    @JoinColumn(name = "id_element")
    private Element element;
    @Column(name = "question_text")
    private String question_text;

    public Question() {
    }

    public Question(int id_question, Skill skill, Element element, String question_text) {
        this.id_question = id_question;
        this.skill = skill;
        this.element = element;
        this.question_text = question_text;
    }

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
