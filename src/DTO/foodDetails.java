/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class foodDetails {
    private String foodID ;
    private String foodName;
    private double weight ;
    private String foodType;
    private String place ;
    private Date expiredDate ;
    
    public foodDetails(){
        
    }

    public foodDetails(String foodID, String foodName, double weight, String foodType, String place, Date expiredDate) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.weight = weight;
        this.foodType = foodType;
        this.place = place;
        this.expiredDate = expiredDate;
    }

    
    public String getFoodID() {
        return foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public String toString() {
        return "foodDetails{" + "foodID=" + foodID + ", foodName=" + foodName + ", weight=" + weight + ", foodType=" + foodType + ", place=" + place + ", expiredDate=" + expiredDate + '}';
    }

   public void showProfile() {
        System.out.printf("|%-10s|%-20s|%7s|%10s|%20s|%-20s|\n", foodID, foodName, weight, foodType, place, expiredDate);
    }
}
