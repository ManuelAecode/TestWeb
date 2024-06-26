package ai.aecode.testweb.dtos;

import jakarta.persistence.Column;

import java.util.Date;

public class ZodiacSignDTO {
    private int id_zodiac;
    private String sign_name;
    private Date sign_startdate;
    private Date sign_enddate;

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

    public Date getSign_startdate() {
        return sign_startdate;
    }

    public void setSign_startdate(Date sign_startdate) {
        this.sign_startdate = sign_startdate;
    }

    public Date getSign_enddate() {
        return sign_enddate;
    }

    public void setSign_enddate(Date sign_enddate) {
        this.sign_enddate = sign_enddate;
    }
}
