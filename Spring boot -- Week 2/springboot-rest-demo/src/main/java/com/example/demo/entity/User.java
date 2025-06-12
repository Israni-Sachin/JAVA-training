package com.example.demo.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "app_user")
public class User {

    @Id @GeneratedValue()
    private Integer id;
    private String username;
    private String password;
    private String email;

    public enum Role {
        USER, ADMIN
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Enumerated(EnumType.STRING)
    private Role role;
}
