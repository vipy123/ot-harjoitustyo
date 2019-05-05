
package components;

/**
 * This is the plant type such as leafy or coniferous shrub or perennial
 */
public class PlantType {

    private String name;

    /**
     *
     * @param nimi
     */
    public PlantType(String nimi) {
        this.name = nimi;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param nimi
     */
    public void setName(String nimi) {
        this.name = nimi;
    }

}
