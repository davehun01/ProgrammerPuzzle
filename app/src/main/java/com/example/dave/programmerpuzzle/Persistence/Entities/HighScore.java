package com.example.dave.programmerpuzzle.Persistence.Entities;

import androidx.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class HighScore implements Comparable<HighScore> {

    @Id(autoincrement = true)
    private Long id;

    @Property
    private String player;

    @Property
    private long points;

    @Generated(hash = 609411273)
    public HighScore(Long id, String player, long points) {
        this.id = id;
        this.player = player;
        this.points = points;
    }

    @Generated(hash = 2093454292)
    public HighScore() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayer() {
        return this.player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public long getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    @Override
    public int compareTo(@NonNull HighScore other) {
        if (this.points == other.points) return 0;
        if (this.points > other.points) return -1;
        if (this.points < other.points) return 1;
        return 0;
    }
}
