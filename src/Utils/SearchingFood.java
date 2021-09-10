/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import DAO.FoodList;
import DTO.foodDetails;

/**
 *
 * @author Admin
 */
public class SearchingFood {
    static FoodList list = new FoodList() ;
    public foodDetails searchFoodByType(String information){
        for(int i = 0;i < list.size();i++){
            if(list.get(i).getFoodType().equalsIgnoreCase(information))
                return list.get(i) ;
        }
        return null ;
    }
    public foodDetails searchFoodByPlace(String information){
       for(int i = 0 ;i < list.size();i++){
            if(list.get(i).getPlace().equalsIgnoreCase(information))
                 return list.get(i) ;
        }
        return null ; 
    }
  
}
