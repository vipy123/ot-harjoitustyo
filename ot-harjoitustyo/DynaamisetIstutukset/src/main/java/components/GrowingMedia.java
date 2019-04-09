
package components;

/**
 *
 * @author vipy
 */
public class GrowingMedia implements Comparable<GrowingMedia> {
    private String kosteaKuiva;
    private String ravinteisuus;
    private String lapaisevyys;
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
    public int acidicy;
    public GrowingMedia(int moist, int nutrition, int permability, int sunlight, int acidicy) {
        this.moist = moist;
        this.nutrition = nutrition;
        this.permability = permability;
        this.sunlight = sunlight;
        this.acidicy = acidicy;
    }

    @Override
    public int compareTo(GrowingMedia t) {
        if(this.moist == t.getMoist() && this.nutrition == t.getNutrition() 
                && this.permability == t.getPermability() 
                && this.sunlight == t.getSunlight()
                && this.acidicy == t.getAcidicy()) {
            return 0;
        }
        else return -1;
    }

    private int getMoist() {
        return this.moist;
    }

    private int getNutrition() {
        return this.nutrition;
    }

    private int getPermability() {
        return this.permability;
    }

    private int getSunlight() {
        return this.sunlight;
    }

    private int getAcidicy() {
        return this.acidicy;
    }
}
