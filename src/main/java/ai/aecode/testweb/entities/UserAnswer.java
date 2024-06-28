package ai.aecode.testweb.entities;

import jakarta.persistence.*;

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
    @JoinTable(name = "detail_Answer",
            joinColumns = @JoinColumn(name = "id_useranswer"),
            inverseJoinColumns = @JoinColumn(name = "id_answer"))
    private Set<Answer> answer;

    public UserAnswer() {
    }

    public UserAnswer(int id_useranswer, UserProfile userProfile, Set<Answer> answer) {
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

    public Set<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(Set<Answer> answer) {
        this.answer = answer;
    }
}
