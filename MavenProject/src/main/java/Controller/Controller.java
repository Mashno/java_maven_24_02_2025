/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import model.DataGenerator;
import model.Heretic;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Владислав
 */
public class Controller {
    private DataGenerator dataGen = new DataGenerator();
    private ArrayList<Heretic> heretics = new ArrayList<>();
    
    
    public void addHeretic(){
        Heretic heretic= dataGen.generateHeretic();
        heretics.add(heretic);
    }
    
    public ArrayList<Heretic> allHeretics(){
        return heretics;
    }
    
    public ArrayList<String> getNames(){
        ArrayList<String> names = null;
        for(Heretic heretic: heretics){
            names.add(heretic.getName());
        }
        return names;
    }
    
}
