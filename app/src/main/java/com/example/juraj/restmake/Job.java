package com.example.juraj.restmake;

/**
 * Created by Juraj on 2/5/2018.
 */

public class Job {

    String title;
    String description;
    double salary;
    boolean salary_type;
    String latitude;
    String longitude;

    public Job() {
    }

    public Job(String title, String description, double salary, boolean salary_type, String latitude, String longitude) {
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.salary_type = salary_type;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
