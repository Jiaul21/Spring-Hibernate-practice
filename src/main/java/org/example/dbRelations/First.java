package org.example.dbRelations;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "first-Table")
public class First {
    @Id
    public int fId;
    public String fValue;
    @OneToMany
    public List<Second> second;

    public First(int fId, String fValue) {
        this.fId = fId;
        this.fValue = fValue;
    }

    @Override
    public String toString() {
        return "First{" +
                "fId=" + fId +
                ", fValue='" + fValue + '\'' +
                ", second=" + second +
                '}';
    }
}
