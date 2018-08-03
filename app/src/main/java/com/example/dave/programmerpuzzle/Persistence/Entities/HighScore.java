package com.example.dave.programmerpuzzle.Persistence.Entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class HighScore {

    @Id(autoincrement = true)
    private Long id;

    @Property
    private String player;

    @Property
    private int points;

    @Generated(hash = 1949885959)
    public HighScore(Long id, String player, int points) {
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

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
