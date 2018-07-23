package com.example.dave.programmerpuzzle;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Puzzle {
    @Id(autoincrement = true)
    private Long id;

    @Property
    private String description;

    @Property
    private String code;

    @Generated(hash = 1423291492)
    public Puzzle(Long id, String description, String code) {
        this.id = id;
        this.description = description;
        this.code = code;
    }

    @Generated(hash = 1758366711)
    public Puzzle() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
