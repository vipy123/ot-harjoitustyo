package components;

/**
 * The growing media includes growing soil attributes but also the sunlight
 * requirements for different types of plants.
 *
 * @author vipy
 */
public class GrowingMedia {

    /**
     *
     */
    public int moist;
    // tuore = 1;
    // kuiva = 0;
    // kostea = 2;

    /**
     *
     */
    public int nutrition;
    //niukkaravinteinen = 0;
    //keskiravinteinen = 1;
    //runsasravinteinen = 2;

    /**
     *
     */
    public int permability;
    //lapaisematon = 0;
    //lapaiseva = 2;

    /**
     *
     */
    public int sunlight;
    //varjo = 0;
    //aurinko = 2;

    /**
     *
     */
    public int acidicy;

    /**
     *
     * @param moist
     * @param nutrition
     * @param permability
     * @param sunlight
     * @param acidity
     */
    public GrowingMedia(int moist, int nutrition, int permability, int sunlight, int acidity) {
        this.moist = moist;
        this.nutrition = nutrition;
        this.permability = permability;
        this.sunlight = sunlight;
        this.acidicy = acidity;
    }

    /**
     *
     * @param moist
     */
    public void setMoist(int moist) {
        this.moist = moist;
    }

    /**
     *
     * @param nutrition
     */
    public void setNutrition(int nutrition) {
        this.nutrition = nutrition;
    }

    /**
     *
     * @param permability
     */
    public void setPermability(int permability) {
        this.permability = permability;
    }

    /**
     *
     * @param sunlight
     */
    public void setSunlight(int sunlight) {
        this.sunlight = sunlight;
    }

    /**
     *
     * @param acidicy
     */
    public void setAcidity(int acidicy) {
        this.acidicy = acidicy;
    }

    /**
     *
     * @return
     */
    public int getMoist() {
        return this.moist;
    }

    /**
     *
     * @return
     */
    public int getNutrition() {
        return this.nutrition;
    }

    /**
     *
     * @return
     */
    public int getPermability() {
        return this.permability;
    }

    /**
     *
     * @return
     */
    public int getSunlight() {
        return this.sunlight;
    }

    /**
     *
     * @return
     */
    public int getAcidity() {
        return this.acidicy;
    }

    // Equals-method makes it possible to find species with similar growing media. 
    //The equal attributes are seen as same growing media.

    /**
     *
     * @param gm
     * @return
     */
    public boolean equals(GrowingMedia gm) {
        if (this.moist == gm.getMoist() && this.nutrition == gm.getNutrition()
                && this.permability == gm.getPermability()
                && this.sunlight == gm.getSunlight()
                && this.acidicy == gm.getAcidity()) {
            return true;
        } else {
            return false;
        }

    }
}
