/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : Topic.java
 *  Date : 18-5-22 上午6:46
 */

package com.tsuna.textLearning.persistance.bean;

public class Topic {
    private String description;
    private int id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Topic id:" + id + " description:" + description + "\n";
    }
}
