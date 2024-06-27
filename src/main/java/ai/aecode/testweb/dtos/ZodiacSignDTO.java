package ai.aecode.testweb.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;

import java.time.MonthDay;
import java.util.Date;

public class ZodiacSignDTO {
    private int id_zodiac;
    private String sign_name;

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
