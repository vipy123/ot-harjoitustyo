
package components;

import java.util.ArrayList;

/**
 *
 * @author vipy
 */
public class Species {
    private String latinName;
    private String finnishName;
    private String acronym;
    private PlantType type;
    private ArrayList<Species> friendlistGroundcreapers;
    private ArrayList<Species> friendlist300_500;
    private GrowingMedia kasvualusta;
    private String aurinkoVarjo;

    public Species(String finnishName, String latinName) {
        this.finnishName = finnishName;
        this.latinName = latinName;
        
        char[] latinToAcronym = this.latinName.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(latinToAcronym[0]));
        sb.append(latinToAcronym[1]);
        
        
        for (int i = 2; i < latinToAcronym.length-3; i++) {
            if (latinToAcronym[i] == ' ') {
                sb.append("_");
                char b = latinToAcronym[i+1];
                sb.append(b);
                sb.append(latinToAcronym[i+2]);
            }
        }
        
        this.acronym =  sb.toString();
        
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public String getFinnishName() {
        return finnishName;
    }

    public void setFinnishName(String finnishName) {
        this.finnishName = finnishName;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public PlantType getType() {
        return type;
    }

    public void setType(PlantType type) {
        this.type = type;
    }

    public ArrayList<Species> getFriendlistGroundcreapers() {
        return friendlistGroundcreapers;
    }

    public void setFriendlistGroundcreapers(ArrayList<Species> friendlistGroundcreapers) {
        this.friendlistGroundcreapers = friendlistGroundcreapers;
    }

    public ArrayList<Species> getFriendlist300_500() {
        return friendlist300_500;
    }

    public void setFriendlist300_500(ArrayList<Species> friendlist300_500) {
        this.friendlist300_500 = friendlist300_500;
    }

    public GrowingMedia getKasvualusta() {
        return kasvualusta;
    }

    public void setKasvualusta(GrowingMedia kasvualusta) {
        this.kasvualusta = kasvualusta;
    }

    public String getAurinkoVarjo() {
        return aurinkoVarjo;
    }

    public void setAurinkoVarjo(String aurinkoVarjo) {
        this.aurinkoVarjo = aurinkoVarjo;
    }
    
}