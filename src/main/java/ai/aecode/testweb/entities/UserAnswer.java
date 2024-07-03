package ai.aecode.testweb.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "useranswer")
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_useranswer;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserProfile userProfile;
    @ManyToMany
    private List<Answer> answer;

    public UserAnswer() {
    }


    public UserAnswer(int id_useranswer, UserProfile userProfile, List<Answer> answer) {
        this.id_useranswer = id_useranswer;
        this.userProfile = userProfile;
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

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    //Formulas
    public void calculateTotalValues(UserResult userResult){
        double totalManager=answer.stream().mapToDouble(Answer::getValue_manager)
                .reduce(1,(a,b)->a*b);
        double totalDeveloper=answer.stream().mapToDouble(Answer::getValue_developer)
                .reduce(1,(a,b)->a*b);
        double totalExecutor=answer.stream().mapToDouble(Answer::getValue_executor)
                .reduce(1,(a,b)->a*b);
        userResult.SetResults(totalManager, totalDeveloper, totalExecutor);
    }
}
