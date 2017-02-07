package com.lisnykov.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by pasha on 2/3/17.
 */
@Entity
@Table(name = "GAME_DATA")
public class GameData {

    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "id")
    private Integer Id;

    @NotNull(message = "Name is required")
    @Size(min = 3, max = 50, message = "name must be longer than 3 and less than 40 characters")
    private String name;



    @NotNull(message = "Question is required")
    @Column(name = "QUESTION")
    private String question;

    @NotNull(message = "Type is required")
    @Column(name = "TYPE")
    private String type;

    @Column(name = "DATE")
    private Date date;

    @NotNull(message = "Point is required")
    @Column(name = "POINTS")
    private Integer points;

    @NotNull(message = "Answer is required")
    @Column(name = "ANSWER")
    private String answer;

    public GameData() {
    }

    public GameData(String name, String question, String type, Date date, Integer points, String answer) {
        this.name = name;
        this.question = question;
        this.type = type;
        this.date = date;
        this.points = points;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "GameData{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", question='" + question + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", points=" + points +
                ", answer='" + answer + '\'' +
                '}';
    }
}
