package ai.aecode.testweb.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_answer;
    @Column(name = "answer_text")
    private String answer_text;

    @Column(name = "value_skill_manager")
    private double value_skill_manager;
    @Column(name = "value_skill_developer")
    private double value_skill_developer;
    @Column(name = "value_skill_executor")
    private double value_skill_executor;

    @Column(name = "value_manager")
    private double value_manager;
    @Column(name = "value_developer")
    private double value_developer;
    @Column(name = "value_executor")
    private double value_executor;
    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;

    public Answer() {
    }

    public Answer(int id_answer, String answer_text, double value_skill_manager, double value_skill_developer, double value_skill_executor, double value_manager, double value_developer, double value_executor, Question question) {
        this.id_answer = id_answer;
        this.answer_text = answer_text;
        this.value_skill_manager = value_skill_manager;
        this.value_skill_developer = value_skill_developer;
        this.value_skill_executor = value_skill_executor;
        this.value_manager = value_manager;
        this.value_developer = value_developer;
        this.value_executor = value_executor;
        this.question = question;
    }

    public int getId_answer() {
        return id_answer;
    }

    public void setId_answer(int id_answer) {
        this.id_answer = id_answer;
    }

    public String getAnswer_text() {
        return answer_text;
    }

    public void setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
    }

    public double getValue_skill_manager() {
        return value_skill_manager;
    }

    public void setValue_skill_manager(double value_skill_manager) {
        this.value_skill_manager = value_skill_manager;
    }

    public double getValue_skill_developer() {
        return value_skill_developer;
    }

    public void setValue_skill_developer(double value_skill_developer) {
        this.value_skill_developer = value_skill_developer;
    }

    public double getValue_skill_executor() {
        return value_skill_executor;
    }

    public void setValue_skill_executor(double value_skill_executor) {
        this.value_skill_executor = value_skill_executor;
    }

    public double getValue_manager() {
        return value_manager;
    }

    public void setValue_manager(double value_manager) {
        this.value_manager = value_manager;
    }

    public double getValue_developer() {
        return value_developer;
    }

    public void setValue_developer(double value_developer) {
        this.value_developer = value_developer;
    }

    public double getValue_executor() {
        return value_executor;
    }

    public void setValue_executor(double value_executor) {
        this.value_executor = value_executor;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
