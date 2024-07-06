package ai.aecode.testweb.dtos;

public class AnswerDTO {
    private int id_answer;
    private String answer_text;

    private int value_skill_manager;
    private int value_skill_developer;
    private int value_skill_executor;


    private double value_manager;
    private double value_developer;
    private double value_executor;
    private int id_question;

    public int getId_answer() {
        return id_answer;
    }

    public void setId_answer(int id_answer) {
        this.id_answer = id_answer;
    }

    public String getAnswer_text() {
        return answer_text;
    }

    public void setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
    }

    public int getValue_skill_manager() {
        return value_skill_manager;
    }

    public void setValue_skill_manager(int value_skill_manager) {
        this.value_skill_manager = value_skill_manager;
    }

    public int getValue_skill_developer() {
        return value_skill_developer;
    }

    public void setValue_skill_developer(int value_skill_developer) {
        this.value_skill_developer = value_skill_developer;
    }

    public int getValue_skill_executor() {
        return value_skill_executor;
    }

    public void setValue_skill_executor(int value_skill_executor) {
        this.value_skill_executor = value_skill_executor;
    }

    public double getValue_manager() {
        return value_manager;
    }

    public void setValue_manager(double value_manager) {
        this.value_manager = value_manager;
    }

    public double getValue_developer() {
        return value_developer;
    }

    public void setValue_developer(double value_developer) {
        this.value_developer = value_developer;
    }

    public double getValue_executor() {
        return value_executor;
    }

    public void setValue_executor(double value_executor) {
        this.value_executor = value_executor;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }
}
