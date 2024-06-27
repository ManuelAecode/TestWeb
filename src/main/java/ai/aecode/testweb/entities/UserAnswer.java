package ai.aecode.testweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "useranswer")
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_useranswer;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserProfile userProfile;
    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;
    @ManyToOne
    @JoinColumn(name = "id_answer")
    private Answer answer;

    public UserAnswer() {
    }

    public UserAnswer(int id_useranswer, UserProfile userProfile, Question question, Answer answer) {
        this.id_useranswer = id_useranswer;
        this.userProfile = userProfile;
        this.question = question;
        this.answer = answer;
    }

    public int getId_useranswer() {
        return id_useranswer;
    }

    public void setId_useranswer(int id_useranswer) {
        this.id_useranswer = id_useranswer;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
