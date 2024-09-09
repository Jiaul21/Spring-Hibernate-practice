package org.example;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "person")
//@Cacheable                                            /// version mismatch so, could not implement
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="perId")
    private int id;
    @Column(name="name", length = 30)
    private String name;

    private String address;
    @Transient          // this could not create column in table
    private double salary;
    @Column
    private float hight;
    @Column
    private boolean is_married;
    @Column
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(length = 5000)      /// image byte length should big
    @Lob                    /// @Lob used for large data
    private byte[] image;
    private Job job;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public float getHight() {
        return hight;
    }

    public void setHight(float hight) {
        this.hight = hight;
    }

    public boolean isIs_married() {
        return is_married;
    }

    public void setIs_married(boolean is_married) {
        this.is_married = is_married;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", hight=" + hight +
                ", is_married=" + is_married +
                ", date=" + date +
                ", image=" + Arrays.toString(image) +
                ", job=" + job +
                '}';
    }
}
