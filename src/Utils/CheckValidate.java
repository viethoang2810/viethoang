/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CheckValidate {
    static Scanner sc = new Scanner(System.in) ;
    public static String inputID(String str , String pattern){
        String input = "" ;
        do {                
            System.out.print(str);
            input = sc.nextLine() ;
        } while (!input.matches(pattern));
        return input ;
    }
    public static String inputString(String str){
        String input = "" ;
        do {            
            System.out.print(str);
            input = sc.nextLine();
        } while (input.length() == 0);
        return input ;
    }
    public static String inputAnswer(String str){
        String pattern1 = "Y" ;
        String pattern2 = "N" ;
        String input = " " ;
        do{
            System.out.println(str);
            input = sc.nextLine() ;
        }while(!(input.matches(pattern1)||input.matches(pattern2)));
        return input ;
    }
}
