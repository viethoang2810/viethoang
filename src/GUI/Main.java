/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.FoodList;
import Utils.menu;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        String[] options = {"Add a new food", "Remove a food base on ID", "Search food base on ID", "Print the list of food", 
                            "Update food base on ID","Quit"};
        int choice = 0;
        FoodList list = new FoodList();
        do {
            System.out.println("===Welcome to Food Management - @ 2021 by <SE150787-ĐỖ VIỆT HOÀNG>===");
            System.out.println("Select the options below: ");
            choice = menu.getUserChoice(options);
            switch (choice) {
                case 1:
                    list.addFood();
                    break;
                case 2:
                    list.removeFood();
                    break;
                case 3:
                    list.searchFood();
                    break;
                case 4:
                    System.out.println("The food list in the descending order of expired date: ");
                    System.out.println("|ID        |NAME                |WEIGHT |TYPE      |PLACE               |EXPIRED DATE        |");
                    list.printList();
                    break;
                case 5:
                    list.updateFood();
                    break;
            }
        } while (choice > 0 && choice < 7);
    }
}
