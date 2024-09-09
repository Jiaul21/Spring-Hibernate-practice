package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Job {
    @Column(name ="job_name")
    private String jobName;
    @Column(name = "location")
    private String location;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobName='" + jobName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
