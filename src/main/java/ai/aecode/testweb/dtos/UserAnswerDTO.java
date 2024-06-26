package ai.aecode.testweb.dtos;

import ai.aecode.testweb.entities.Answer;
import ai.aecode.testweb.entities.Question;
import ai.aecode.testweb.entities.UserProfile;

public class UserAnswerDTO {
    private int id_useranswer;
    private UserProfile userProfile;
    private Question question;
    private Answer answer;

    public int getId_useranswer() {
        return id_useranswer;
    }

    public void setId_useranswer(int id_useranswer) {
        this.id_useranswer = id_useranswer;
    }

    public UserProfile getUser() {
        return userProfile;
    }

    public void setUser(UserProfile userProfile) {
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
