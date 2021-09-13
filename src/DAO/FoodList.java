/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.foodDetails;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class FoodList extends ArrayList<foodDetails> implements IDAO {

    static Scanner sc = new Scanner(System.in);

    public boolean isCodeDuplicate(String code) {
        return searchById(code) != null;
    }
    //Tìm food theo ID và tìm code đã có trong list
    public foodDetails searchById(String code) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFoodID().equalsIgnoreCase(code)) {
                return this.get(i);
            }
        }
        return null;
    }
    //Tìm food theo tên
    public foodDetails searchFoodByName(String information) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFoodName().equalsIgnoreCase(information)) {
                return this.get(i);
            }
        }
        return null;
    }
    //Tìm food theo type of food
    public foodDetails searchFoodByType(String information){
        for(int i = 0;i < this.size();i++){
            if(this.get(i).getFoodType().equalsIgnoreCase(information))
                return this.get(i) ;
        }
        return null ;
    }
    //Tìm food theo ngăn tủ lạnh
    public foodDetails searchFoodByPlace(String information){
       for(int i = 0 ;i < this.size();i++){
            if(this.get(i).getPlace().equalsIgnoreCase(information))
                 return this.get(i) ;
        }
        return null ; 
    }
  
    //Thêm 1 food vào danh sách
    @Override
    public void addFood() {
        String foodID;
        String foodName;
        double weight = 0;
        String foodType;
        String place;
        Date expiredDate;
        String choice;
        boolean checkDuplicated = false;
        boolean checkAnswer = false;
        boolean check = false ;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy") ;
        do {
            try {
                do {
                   foodID = Utils.CheckValidate.inputID("Enter food ID: ", "[0-9]{3}") ;
                    checkDuplicated = isCodeDuplicate(foodID);
                    if (checkDuplicated) {
                        System.out.println("The ID is already exist in list ");
                    }
                } while (checkDuplicated == true);
                foodName = Utils.CheckValidate.inputString("Enter name of food: ");
                do{
                    try{
                    System.out.print("Enter weight of food: ");
                    weight = Double.parseDouble(sc.nextLine()) ;
                    if(weight < 0 || weight > 10){
                        System.out.println("The refrigerator cannot contain the food weight greater than 10kg");
                        check = false ;
                    }
                    }catch(Exception e){
                        System.out.println(e);
                        check = true ;
                    }
                }while(check == true) ;
                foodType =Utils.CheckValidate.inputString("Enter type of food: ");
                place = Utils.CheckValidate.inputString("Enter place of food in refrigerator: ") ;
                System.out.print("Enter expired date (day): ");
                expiredDate =  formatter.parse(sc.nextLine());
                foodDetails list = new foodDetails(foodID, foodName, weight, foodType, place, expiredDate);
                this.add(list);
                System.err.println("Adding successfully !");
                System.out.print("Do you want to add more food? Y/N: ");
                String answer = sc.nextLine();
                checkAnswer = Utils.YesNoQuestions.getAnswer(answer);
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (checkAnswer == true);
    }

    //In danh sách các food được sắp xếp giảm dần theo ngày hết hạn
    @Override
    public void printList() {
        Collections.sort(this, new Comparator<foodDetails>() {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            @Override
            public int compare(foodDetails food1, foodDetails food2) {
                return food2.getExpiredDate().compareTo(food1.getExpiredDate());
            }

        });
        for (foodDetails x : this) {
            x.showProfile();
        }
    }

    //Xóa food base on ID inputted
    @Override
    public void removeFood() {
        boolean checkAnswer = false;
        if (this.isEmpty()) {
            System.out.println("The refrigerator is empty!");
            return;
        }
        System.out.println("Enter the foodID: ");
        String code = sc.nextLine();
        foodDetails x = this.searchById(code);
        if (x == null) {
            System.out.println("The food does not exist");
        } else {
            System.out.print("Are you sure to remove food " + code + "? Y/N : ");
            String answer = sc.nextLine();
            checkAnswer = Utils.YesNoQuestions.getAnswer(answer);
            if (checkAnswer == true) {
                this.remove(x);
                foodDetails check = this.searchById(code);
                if (check == null) {
                    System.out.println("Food " + code + "is deleted successfully !");
                } else {
                    System.err.println("Remove fail ! ");
                }
                return;
            }

        }
    }

    //Tìm kiếm food bằng ID
    @Override
    public void searchFood() {
        boolean checkAnswer = false;
        do {
            if (this.isEmpty()) {
                System.out.println("The refrigerator is empty");
                return;
            }
            System.out.println("Enter the information of food: ");
            String information = sc.nextLine();
            foodDetails x;
            x = this.searchById(information);
            if (x != null) {
                x.showProfile();
            }
            x = this.searchFoodByName(information);
            if(x != null){
                x.showProfile();
            }
            x = this.searchFoodByType(information);
            if(x != null){
                x.showProfile();
            }
            x = this.searchFoodByPlace(information);
            if(x != null){
                x.showProfile();
            }
            System.out.print("Do you want to search more food ? Y/N: ");
            String answer = sc.nextLine();
            checkAnswer = Utils.YesNoQuestions.getAnswer(answer);
        } while (checkAnswer == true);
    }
}
