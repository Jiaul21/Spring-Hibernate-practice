package org.example.dbRelations.manyToMany;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Users {
    @Id
    private int userId;
    @Column
    private String name;
    @ManyToMany
    @JoinTable(name = "user_atm_together",
            joinColumns = {@JoinColumn(name = "user-id")},
            inverseJoinColumns = {@JoinColumn(name = "atm-id")})
    private List<Atm> atms;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Atm> getAtms() {
        return atms;
    }

    public void setAtms(List<Atm> atms) {
        this.atms = atms;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", atms=" + atms +
                '}';
    }
}
