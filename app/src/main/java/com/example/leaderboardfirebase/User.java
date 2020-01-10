package com.example.leaderboardfirebase;

public class User {
  public   String Nane;
 public    String Email;
 public    String  Uid;
public     String PassWord;
public     long score;

    public User(String nane, String email, String passWord,String uID,long score) {
        this.Nane = nane;
        this.Email = email;
        this.PassWord = passWord;
        this.Uid=uID;
        this.score=score;

    }
    public User()
    {

    }
}
