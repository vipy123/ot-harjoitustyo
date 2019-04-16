/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 * This is the plant type such as leafy or coniferous shrub or perennial
 */
public class PlantType {

    private String name;

    public PlantType(String nimi) {
        this.name = nimi;
    }

    public String getName() {
        return name;
    }

    public void setName(String nimi) {
        this.name = nimi;
    }

}
