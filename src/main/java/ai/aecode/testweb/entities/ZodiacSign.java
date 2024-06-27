package ai.aecode.testweb.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Date;

@Entity
@Table(name = "zodiacsign")
public class ZodiacSign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_zodiac;
    @Column(name = "sign_name")
    private String sign_name;
    @Column(name="sign_startdate")
    @JsonFormat(pattern = "dd-MM")
    private MonthDay sign_startdate;
    @Column(name="sign_enddate")
    @JsonFormat(pattern = "dd-MM")
    private MonthDay sign_enddate;

    public ZodiacSign() {
    }

    public ZodiacSign(int id_zodiac, String sign_name, MonthDay sign_startdate, MonthDay sign_enddate) {
        this.id_zodiac = id_zodiac;
        this.sign_name = sign_name;
        this.sign_startdate = sign_startdate;
        this.sign_enddate = sign_enddate;
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

    public MonthDay getSign_startdate() {
        return sign_startdate;
    }

    public void setSign_startdate(MonthDay sign_startdate) {
        this.sign_startdate = sign_startdate;
    }

    public MonthDay getSign_enddate() {
        return sign_enddate;
    }

    public void setSign_enddate(MonthDay sign_enddate) {
        this.sign_enddate = sign_enddate;
    }
}
