/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Владислав
 */
public class Heretic {
    private String name;
    private String crimes;
    private String last_appear;
    private String id;
    private String level_threat;
    
    public Heretic(String name, String crimes, String last_appear, String id, String level_threat){
        this.name = name;
        this.crimes = crimes;
        this.last_appear = last_appear;
        this.id = id;
        this.level_threat = level_threat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCrimes(String crimes) {
        this.crimes = crimes;
    }

    public void setLast_appear(String last_appear) {
        this.last_appear = last_appear;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLevel_threat(String level_threat) {
        this.level_threat = level_threat;
    }

    public String getName() {
        return name;
    }

    public String getCrimes() {
        return crimes;
    }

    public String getLast_appear() {
        return last_appear;
    }

    public String getId() {
        return id;
    }

    public String getLevel_threat() {
        return level_threat;
    }
    
    
}
