package com.example.singh.alumniportal.Model;

public class Birthday {
    private int id;
    private String name;
    private String batch;
    private String branches;
    private String date;
    private int image;

    public Birthday(int id, String name, String batch, String branches, String date, int image) {
        this.id = id;
        this.name = name;
        this.batch = batch;
        this.branches = branches;
        this.date = date;
        this.image = image;
    }

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

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getBranches() {
        return branches;
    }

    public void setBranches(String branches) {
        this.branches = branches;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
