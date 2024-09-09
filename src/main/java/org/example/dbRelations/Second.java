package org.example.dbRelations;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "second-Table")
public class Second {
    @Id
    public int sId;
    public String sValue;
    @OneToOne
    public First first;

    public Second(int sId, String sValue) {
        this.sId = sId;
        this.sValue = sValue;
    }

    @Override
    public String toString() {
        return "Second{" +
                "sId=" + sId +
                ", sValue='" + sValue + '\'' +
                '}';
    }
}
