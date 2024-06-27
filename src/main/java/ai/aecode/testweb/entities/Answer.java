package ai.aecode.testweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_answer;
    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;
    @Column(name = "answer_text")
    private String answer_text;
    @Column(name = "value_manager")
    private double value_manager;
    @Column(name = "value_developer")
    private double value_developer;
    @Column(name = "value_executor")
    private double value_executor;

    public Answer() {
    }

    public Answer(int id_answer, Question question, String answer_text, double value_manager, double value_developer, double value_executor) {
        this.id_answer = id_answer;
        this.question = question;
        this.answer_text = answer_text;
        this.value_manager = value_manager;
        this.value_developer = value_developer;
        this.value_executor = value_executor;
    }

    public int getId_answer() {
        return id_answer;
    }

    public void setId_answer(int id_answer) {
        this.id_answer = id_answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer_text() {
        return answer_text;
    }

    public void setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
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

}
