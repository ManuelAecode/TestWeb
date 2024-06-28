package ai.aecode.testweb.dtos;

import ai.aecode.testweb.entities.Answer;
import ai.aecode.testweb.entities.Question;
import ai.aecode.testweb.entities.UserProfile;

import java.util.Set;

public class UserAnswerDTO {
    private int id_useranswer;
    private UserProfile userProfile;
    private Question question;
    private Set<Answer> answer;

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


    public Set<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(Set<Answer> answer) {
        this.answer = answer;
    }

}
