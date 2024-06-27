package ai.aecode.testweb.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.MonthDay;

@Entity
@Table(name = "zodiacsign")
public class ZodiacSign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_zodiac;
    @Column(name = "sign_name")
    private String sign_name;

    public ZodiacSign() {
    }

    public ZodiacSign(int id_zodiac, String sign_name, MonthDay sign_startdate, MonthDay sign_enddate) {
        this.id_zodiac = id_zodiac;
        this.sign_name = sign_name;

    }

    public int getId_zodiac() {
        return id_zodiac;
    }

    public void setId_zodiac(int id_zodiac) {
        this.id_zodiac = id_zodiac;
    }

    public String getSign_name() {
        return sign_name;
    }

    public void setSign_name(String sign_name) {
        this.sign_name = sign_name;
    }
    
}
