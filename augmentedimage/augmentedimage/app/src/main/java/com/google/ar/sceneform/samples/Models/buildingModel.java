package com.google.ar.sceneform.samples.Models;

public class buildingModel {
    public int Similarity;
    public int Floor;
    public String Department;
    public String BuildingName;
    public buildingModel(int Similarity,int Floor,String Department,String BuildingName){
        this.Similarity = Similarity;
        this.Floor = Floor;
        this.Department = Department;
        this.BuildingName = BuildingName;
    }
}
