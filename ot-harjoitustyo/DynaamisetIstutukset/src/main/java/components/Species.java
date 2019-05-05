package components;

import java.util.ArrayList;

/**
 *
 * @author vipy Species is an object class for species. Here the data transforms
 * into a species object.
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
    private GrowingMedia growMedia;
    private String aurinkoVarjo;

    // Species is created only with a name. Default values are added to other attributes.
    /**
     *
     * @param finnishName
     * @param latinName
     */
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

    // Species is created with full data.
    /**
     *
     * @param finnishName
     * @param latinName
     * @param zone
     * @param adultHeight
     * @param spacing
     * @param amountPerSquare
     * @param media
     * @param type
     */
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

    // Species is created with full data, but without plant type.
    /**
     *
     * @param finnishName
     * @param latinName
     * @param zone
     * @param adultHeight
     * @param spacing
     * @param amountPerSquare
     * @param media
     */
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

    // Growing zone
    /**
     *
     * @return
     */
    public String getZone() {
        return zone;
    }

    /**
     *
     * @param zone
     */
    public void setZone(String zone) {
        this.zone = zone;
    }

    /**
     *
     * @return
     */
    public double getAdultHeight() {
        return adultHeight;
    }

    /**
     *
     * @param adultHeight
     */
    public void setAdultHeight(double adultHeight) {
        this.adultHeight = adultHeight;
    }

    /**
     *
     * @return
     */
    public double getSpacing() {
        return spacing;
    }

    /**
     *
     * @param spacing
     */
    public void setSpacing(double spacing) {
        this.spacing = spacing;
    }

    /**
     *
     * @return
     */
    public double getAmountPerSquare() {
        return amountPerSquare;
    }

    /**
     *
     * @param amountPerSquare
     */
    public void setAmountPerSquare(double amountPerSquare) {
        this.amountPerSquare = amountPerSquare;
    }

    /**
     *
     * @return
     */
    public GrowingMedia getGrowMedia() {
        return growMedia;
    }

    /**
     *
     * @param growMedia
     */
    public void setGrowMedia(GrowingMedia growMedia) {
        this.growMedia = growMedia;
    }

    /**
     *
     * @return
     */
    public String getLatinName() {
        return latinName;
    }

    /**
     *
     * @param latinName
     */
    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    /**
     *
     * @return
     */
    public String getFinnishName() {
        return finnishName;
    }

    /**
     *
     * @param finnishName
     */
    public void setFinnishName(String finnishName) {
        this.finnishName = finnishName;
    }

    /**
     *
     * @return
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     *
     * @param acronym
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    /**
     *
     * @return
     */
    public PlantType getPlantType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setPlantType(PlantType type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public GrowingMedia getKasvualusta() {
        return growMedia;
    }

    /**
     *
     * @param kasvualusta
     */
    public void setKasvualusta(GrowingMedia kasvualusta) {
        this.growMedia = kasvualusta;
    }

    // toString transforms the species into a csv-compatible string.
    /**
     *
     * @return
     */
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
