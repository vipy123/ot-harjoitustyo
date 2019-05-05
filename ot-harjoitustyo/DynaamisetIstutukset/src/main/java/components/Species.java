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
    private String zone;
    private double adultHeight;
    private double spacing;
    private double amountPerSquare;

    //private ArrayList<Species> friendlistGroundcreapers;
    //private ArrayList<Species> friendlist300_500;
    private GrowingMedia growMedia;
    private String aurinkoVarjo;

    public Species(String finnishName, String latinName) {
        this.finnishName = finnishName;
        this.latinName = latinName;

        char[] latinToAcronym = this.latinName.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(latinToAcronym[0]));
        sb.append(latinToAcronym[1]);

        for (int i = 2; i < latinToAcronym.length - 3; i++) {
            if (latinToAcronym[i] == ' ') {
                sb.append("_");
                char b = latinToAcronym[i + 1];
                sb.append(b);
                sb.append(latinToAcronym[i + 2]);
            }
        }

        this.acronym = sb.toString();
        this.adultHeight = 1;
        this.spacing = 1.0;
        this.amountPerSquare = 1;
        this.growMedia = new GrowingMedia(1, 1, 1, 1, 1);
        this.type = new PlantType("generic");

    }

    public Species(String finnishName, String latinName, String zone, double adultHeight,
            double spacing, double amountPerSquare, GrowingMedia media, PlantType type) {
        this.latinName = latinName;
        this.finnishName = finnishName;
        this.zone = zone;
        this.adultHeight = adultHeight;
        this.spacing = spacing;
        this.amountPerSquare = amountPerSquare;
        this.growMedia = media;
        this.type = type;

        char[] latinToAcronym = this.latinName.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(latinToAcronym[0]));
        sb.append(latinToAcronym[1]);

        for (int i = 2; i < latinToAcronym.length - 3; i++) {
            if (latinToAcronym[i] == ' ') {
                sb.append("_");
                char b = latinToAcronym[i + 1];
                sb.append(b);
                sb.append(latinToAcronym[i + 2]);
            }
        }

        this.acronym = sb.toString();

    }

    public Species(String finnishName, String latinName, String zone, double adultHeight,
            double spacing, double amountPerSquare, GrowingMedia media) {
        this.latinName = latinName;
        this.finnishName = finnishName;
        this.zone = zone;
        this.adultHeight = adultHeight;
        this.spacing = spacing;
        this.amountPerSquare = amountPerSquare;
        this.growMedia = media;
        this.type = new PlantType("generic");

        char[] latinToAcronym = this.latinName.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(latinToAcronym[0]));
        sb.append(latinToAcronym[1]);

        for (int i = 2; i < latinToAcronym.length - 3; i++) {
            if (latinToAcronym[i] == ' ') {
                sb.append(" ");
                char b = latinToAcronym[i + 1];
                sb.append(b);
                sb.append(latinToAcronym[i + 2]);
            }
        }

        this.acronym = sb.toString();

    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public double getAdultHeight() {
        return adultHeight;
    }

    public void setAdultHeight(double adultHeight) {
        this.adultHeight = adultHeight;
    }

    public double getSpacing() {
        return spacing;
    }

    public void setSpacing(double spacing) {
        this.spacing = spacing;
    }

    public double getAmountPerSquare() {
        return amountPerSquare;
    }

    public void setAmountPerSquare(double amountPerSquare) {
        this.amountPerSquare = amountPerSquare;
    }

    public GrowingMedia getGrowMedia() {
        return growMedia;
    }

    public void setGrowMedia(GrowingMedia growMedia) {
        this.growMedia = growMedia;
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

    public PlantType getPlantType() {
        return type;
    }

    public void setPlantType(PlantType type) {
        this.type = type;
    }

//    public ArrayList<Species> getFriendlistGroundcreapers() {
//        return friendlistGroundcreapers;
//    }
//
//    public void setFriendlistGroundcreapers(ArrayList<Species> friendlistGroundcreapers) {
//        this.friendlistGroundcreapers = friendlistGroundcreapers;
//    }
//
//    public ArrayList<Species> getFriendlist300_500() {
//        return friendlist300_500;
//    }
//
//    public void setFriendlist300_500(ArrayList<Species> friendlist300_500) {
//        this.friendlist300_500 = friendlist300_500;
//    }
    public GrowingMedia getKasvualusta() {
        return growMedia;
    }

    public void setKasvualusta(GrowingMedia kasvualusta) {
        this.growMedia = kasvualusta;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(acronym + "," + latinName + "," + finnishName + "," + zone
                + "," + " " + ","
                + adultHeight + "," + spacing + "," + amountPerSquare + ","
                + growMedia.getMoist() + "," + growMedia.getNutrition() + ","
                + growMedia.getPermability() + "," + growMedia.getSunlight()
                + "," + growMedia.getAcidity());
        String speciesString = sb.toString();
        return speciesString;
    }

}
