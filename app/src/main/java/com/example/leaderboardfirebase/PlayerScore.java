package com.example.leaderboardfirebase;

public class PlayerScore  {
 public    String NAME;
 public    long score;
 public    String uid;

    public PlayerScore(String name, long score, String uid) {
        this.NAME = name;
        this.score = score;
        this.uid = uid;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
