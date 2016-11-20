package com.example.ericzhong.apitest;

/**
 * Created by Eric Zhong on 2016/11/20.
 */

public class PointOfInterestDto {
    public int Id;
    public String Name;
    public String Description;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
