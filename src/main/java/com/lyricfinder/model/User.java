package com.lyricfinder.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appuser")
public class User {

  @Id
  private String email;
  @NotNull
  @Column(nullable = false)
  private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
      super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
