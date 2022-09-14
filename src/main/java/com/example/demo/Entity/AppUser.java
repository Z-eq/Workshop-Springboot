package com.example.demo.Entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity

public class AppUser {


    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;

    @Column(length = 250, nullable = false, unique = true)
    private String username;

   @Column(length = 150, nullable = false)
    private String password;

   @Column(nullable = false)
    private LocalDate regDate;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name ="details_id")
    private Details userDetails;

    public AppUser() {
    }

    public AppUser(int appUserId, String username, String password, LocalDate regDate) {
        this.appUserId = appUserId;
        this.username = username;
        this.password = password;
        this.regDate = regDate;
    }

    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Details getUserDetails(){
        return userDetails;
    }

    public void setUserDetails(Details userDetails){
        this.userDetails = userDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return getAppUserId() == appUser.getAppUserId() && Objects.equals(getUsername(), appUser.getUsername()) && Objects.equals(getPassword(), appUser.getPassword()) && Objects.equals(getRegDate(), appUser.getRegDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAppUserId(), getUsername(), getPassword(), getRegDate());
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "appUserId=" + appUserId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}

