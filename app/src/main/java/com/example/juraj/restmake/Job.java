package com.example.juraj.restmake;

/**
 * Created by Juraj on 2/5/2018.
 */

public class Job {

    String title;
    String description;
    double price;
    String latitude;
    String longitude;

    public Job() {
    }

    public Job(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

}
