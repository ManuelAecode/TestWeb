package ai.aecode.testweb.dtos;
import ai.aecode.testweb.entities.Element;
import ai.aecode.testweb.entities.ZodiacSign;

import java.time.LocalDate;

public class UserProfileDTO {
    private int id_user;
    private String user_name;
    private String user_email;
    private LocalDate user_birthday;
    private String user_gender;
    private ZodiacSign zodiacsign;
    private Element element;

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
