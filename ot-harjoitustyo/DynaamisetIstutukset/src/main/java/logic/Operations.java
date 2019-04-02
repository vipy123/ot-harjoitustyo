/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import components.*;
/**
 *
 * @author vipy
 */
public class Operations {

    public static String CreateNewSpecies(String finnishName, String latinName) {
        Species species = new Species(finnishName, latinName);
        return species.getAcronym();
    }
    
}
