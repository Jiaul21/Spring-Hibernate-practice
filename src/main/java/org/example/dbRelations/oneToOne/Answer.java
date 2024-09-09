package org.example.dbRelations.oneToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Answer {
    @Id
    private int ansId;
    @Column
    private String ans;


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

    @Override
    public String toString() {
        return "Answer{" +
                "ansId=" + ansId +
                ", ans='" + ans + '\'' +
                '}';
    }
}
