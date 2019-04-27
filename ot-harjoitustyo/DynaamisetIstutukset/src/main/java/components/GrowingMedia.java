package components;

/**
 * The growing media includes growing soil attributes but also the sunlight
 * requirements for different types of plants.
 *
 * @author vipy
 */
public class GrowingMedia implements Comparable<GrowingMedia> {

    public int moist;
    // tuore = 1;
    // kuiva = 0;
    // kostea = 2;
    public int nutrition;
    //niukkaravinteinen = 0;
    //keskiravinteinen = 1;
    //runsasravinteinen = 2;
    public int permability;
    //lapaisematon = 0;
    //lapaiseva = 2;
    public int sunlight;
    //varjo = 0;
    //aurinko = 2;
    public int acidicy;

    public GrowingMedia(int moist, int nutrition, int permability, int sunlight, int acidity) {
        this.moist = moist;
        this.nutrition = nutrition;
        this.permability = permability;
        this.sunlight = sunlight;
        this.acidicy = acidity;
    }

    public void setMoist(int moist) {
        this.moist = moist;
    }

    public void setNutrition(int nutrition) {
        this.nutrition = nutrition;
    }

    public void setPermability(int permability) {
        this.permability = permability;
    }

    public void setSunlight(int sunlight) {
        this.sunlight = sunlight;
    }

    public void setAcidity(int acidicy) {
        this.acidicy = acidicy;
    }

    // I made this compare to -method so the iqual attributes are seen as the 
    //same growing media. I'm not sure if I should also make some sort of 
    //equals-method? 
    @Override
    public int compareTo(GrowingMedia t) {
        if (this.moist == t.getMoist() && this.nutrition == t.getNutrition()
                && this.permability == t.getPermability()
                && this.sunlight == t.getSunlight()
                && this.acidicy == t.getAcidity()) {
            return 0;
        } else {
            return -1;
        }
    }

    public int getMoist() {
        return this.moist;
    }

    public int getNutrition() {
        return this.nutrition;
    }

    public int getPermability() {
        return this.permability;
    }

    public int getSunlight() {
        return this.sunlight;
    }

    public int getAcidity() {
        return this.acidicy;
    }
}
