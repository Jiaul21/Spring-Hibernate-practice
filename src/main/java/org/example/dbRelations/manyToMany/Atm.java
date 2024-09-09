package org.example.dbRelations.manyToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Atm {
    @Id
    private int atmId;
    @Column
    private String location;
    @ManyToMany(mappedBy = "atms")  // now, only one join table will create, otherwise two
    private List<Users> users;

    public int getAtmId() {
        return atmId;
    }

    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "atmId=" + atmId +
                ", location='" + location + '\'' +
                ", users=" + users +
                '}';
    }
}
