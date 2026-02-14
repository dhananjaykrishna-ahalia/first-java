package com.example.entity;

public class Hobby {
    private String hobbyName;
    private String hobbyDescription;

    public Hobby() {
    }

    public Hobby(String hobbyName, String hobbyDescription) {
        this.hobbyName = hobbyName;
        this.hobbyDescription = hobbyDescription;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public String getHobbyDescription() {
        return hobbyDescription;
    }

    public void setHobbyDescription(String hobbyDescription) {
        this.hobbyDescription = hobbyDescription;
    }

    @Override
    public String toString() {
        return "hobby{" +
                "hobbyName='" + hobbyName + '\'' +
                ", hobbyDescription='" + hobbyDescription + '\'' +
                '}';
    }
}
