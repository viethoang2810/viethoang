/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Admin
 */
public class YesNoQuestions {
    public static boolean getAnswer(String answer){
        if(answer.equalsIgnoreCase("Y") == true){
            return true ;
        }
        return false ;
    }
}
