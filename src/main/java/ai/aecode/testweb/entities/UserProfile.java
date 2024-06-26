package ai.aecode.testweb.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "userprofile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "user_email")
    private String user_email;
    @Column(name = "user_birthday")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate user_birthday;
    @Column(name = "gender")
    private String user_gender;
    @ManyToOne
    @JoinColumn(name = "id_zodiac")
    private ZodiacSign zodiacsign;
    @ManyToOne
    @JoinColumn(name = "id_element")
    private Element element;

    public UserProfile() {
    }

    public UserProfile(int id_user, String user_name, String user_email, LocalDate user_birthday, String user_gender, ZodiacSign zodiacsign, Element element) {
        this.id_user = id_user;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_birthday = user_birthday;
        this.user_gender = user_gender;
        this.zodiacsign = zodiacsign;
        this.element = element;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public LocalDate getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(LocalDate user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public ZodiacSign getZodiacsign() {
        return zodiacsign;
    }

    public void setZodiacsign(ZodiacSign zodiacsign) {
        this.zodiacsign = zodiacsign;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
