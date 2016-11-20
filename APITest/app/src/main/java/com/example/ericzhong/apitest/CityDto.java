package com.example.ericzhong.apitest;

import java.util.List;

/**
 * Created by Eric Zhong on 2016/11/20.
 */

public class CityDto {
    public int Id;
    public String Name;
    public String Description;
    public List<PointOfInterestDto> PointsOfInterest;

    public int NumberOfPointsOfInterest()
    {
        return PointsOfInterest.size();
    }

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

    public List<PointOfInterestDto> getPointsOfInterest() {
        return PointsOfInterest;
    }

    public void setPointsOfInterest(List<PointOfInterestDto> pointsOfInterest) {
        PointsOfInterest = pointsOfInterest;
    }
}
