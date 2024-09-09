package org.example.dbRelations.oneToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question2 {
    @Id
    private int qId;
    @Column
    private String question;
    @OneToMany(mappedBy = "question",       // So, no extra table will create. all managed by Question2 class object question in Answer2 class
        fetch = FetchType.EAGER,        //   fetch = FetchType.LAZY --- is by default
        cascade = CascadeType.ALL)      //  naw, answer will save,delete (all) automatically during question saving(all) time
    private List<Answer2> answer;

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer2> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer2> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question2{" +
                "qId=" + qId +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                '}';
    }
}
