package org.example.dbRelations.oneToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Answer2 {
    @Id
    private int ansId;
    @Column
    private String ans;
    @ManyToOne
    private Question2 question;

    public int getAnsId() {
        return ansId;
    }

    public void setAnsId(int ansId) {
        this.ansId = ansId;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Question2 getQuestion() {
        return question;
    }

    public void setQuestion(Question2 question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer2{" +
                "ansId=" + ansId +
                ", ans='" + ans + '\'' +
                ", question=" + question +
                '}';
    }
}
