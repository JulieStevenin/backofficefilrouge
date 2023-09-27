package com.example.jakartafilrouge.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="fname")
    private String fname;

    @Column(name="lname")
    private String lname;

    @Column (name = "mail")
    private String mail;

    @Column (name = "password")
    private String password;

    @Column (name="photo")
    private String photo;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Role> roleList;


    public User() {
    }

    public User(String fname, String lname, String mail, String password, String photo, List<Role> roleList) {
        this.fname = fname;
        this.lname = lname;
        this.mail = mail;
        this.password = password;
        this.photo = photo;
        this.roleList = roleList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
