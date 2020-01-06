package com.example.singh.alumniportal.Model;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class User implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("rollno")
    private String rollno;
    @SerializedName("batch")
    private String batch;
    @SerializedName("branches")
    private String branches;
    @SerializedName("phonenumber")
    private String phonenumber;
    @SerializedName("dob")
    private String dob;
    @SerializedName("password")
    private String password;
    @SerializedName("role")
    private String role;

    public User(int id, String name, String email, String rollno, String batch, String branches, String phonenumber, String dob, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.rollno = rollno;
        this.batch = batch;
        this.branches = branches;
        this.phonenumber = phonenumber;
        this.dob = dob;
        this.password = password;
        this.role = role;
    }

    public User() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
