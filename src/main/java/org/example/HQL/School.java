package org.example.HQL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "school")
public class School {
    @Id
    @Column(name = "school_Id")
    private int sId;
    @Column(name = "school_Name")
    private String name;
    @Column(name = "school_type")
    private String type;
    @Column(name = "total_std")
    private int students;
    @Column(name = "school_Address")
    private String address;


    public School(int sId, String name, String type,int students, String address) {
        this.sId = sId;
        this.name = name;
        this.type = type;
        this.students = students;
        this.address = address;
    }

    public School() {
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        type = type;
    }
    public int getStudents() {
        return students;
    }
    public void setStudents(int students) {
        this.students = students;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "sId=" + sId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", students=" + students +
                ", address='" + address + '\'' +
                '}';
    }
}
