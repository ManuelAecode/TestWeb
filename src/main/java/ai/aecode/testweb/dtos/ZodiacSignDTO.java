package ai.aecode.testweb.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;

import java.time.MonthDay;
import java.util.Date;

public class ZodiacSignDTO {
    private int id_zodiac;
    private String sign_name;
    @JsonFormat(pattern = "dd-MM")
    private MonthDay sign_startdate;
    @JsonFormat(pattern = "dd-MM")
    private MonthDay sign_enddate;

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
