/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import components.*;
import dynamicplanting.JavaFxSovellus;
import static dynamicplanting.JavaFxSovellus.o;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * Operations class handles chosen operations from the user interface, reads and
 * writes data from and to files and realizes the button commands.
 */
public class Operations {

    /**
     *
     */
    public ArrayList<Species> species;

    /**
     *
     */
    public ArrayList<String> rows;

    /**
     *
     */
    public GrowingMedia test;

    /**
     *
     */
    public PlantType lpe;

    /**
     *
     */
    public PlantType hpe;

    /**
     *
     */
    public File file = new File("./src/main/resources/Pensasluettelo.csv");

    /**
     *
     */
    public Operations() {
        rows = new ArrayList<>();
        species = new ArrayList<>();
        test = new GrowingMedia(1, 2, 3, 4, 5);
        lpe = new PlantType("lpe");
        hpe = new PlantType("hpe");
    }
    // Creates a new species by a name.

    /**
     *
     * @param finnishName
     * @param latinName
     * @return
     */
    public Species createNewSpecies(String finnishName, String latinName) {
        Species speciesA = new Species(finnishName, latinName);
        species.add(speciesA);
        return speciesA;

    }

    // Creates a new species with full information.
    public Species createNewSpeciesFullData(String finnishName, String latinName, String zone,
            double adultheight, double spacing, double amountPerSquare, GrowingMedia growMedia) {
        Species speciesS = new Species(finnishName, latinName, zone, adultheight, spacing,
                amountPerSquare, growMedia);
        species.add(speciesS);
        String s = "Lisättiin laji: " + speciesS.getLatinName();

        try {
            writeSpeciesToFile(speciesS);
        } catch (NumberFormatException ex) {
            Logger.getLogger(JavaFxSovellus.class.getName()).log(Level.SEVERE, null, ex);
            Label errorFill = new Label("Täytäthän kaikki arvot oikein. korkeus, "
                    + "istutusetäisyys ja istutustiheys ilmoidetaan desimaalilukuna "
                    + "pisteellä eroteltuna.");

        } catch (IOException ex) {
            Logger.getLogger(JavaFxSovellus.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Virhe: ");
        }
        return speciesS;
    }

    // Reads plant data from a file.
    /**
     *
     * @param file
     * @throws FileNotFoundException
     */
    public void readDataFromFile(String file) throws FileNotFoundException {

        Scanner fileReader = new Scanner(new File(file));
        while (fileReader.hasNextLine()) {
            String rivi = fileReader.nextLine();
            rows.add(rivi);
        }
        for (int i = 1; i < rows.size(); i++) {
            if (rows.get(i).equals("")) {
                continue;
            }
            String[] parts = rows.get(i).split(",");
            try {
                double num = Double.parseDouble(parts[5]);
            } catch (NumberFormatException e) {
                System.out.println("desimaalilukua ei voida kääntää.");
            }
            double adultHeightD = Double.parseDouble(parts[5]);
            double spacingD = Double.parseDouble(parts[6]);
            double amountPerSquareD = Double.parseDouble(parts[7]);
            Species s = new Species(parts[2], parts[1], parts[3], adultHeightD,
                    spacingD, amountPerSquareD,
                    new GrowingMedia(Integer.parseInt(parts[8]),
                            Integer.parseInt(parts[9]), Integer.parseInt(parts[10]),
                            Integer.parseInt(parts[11]), Integer.parseInt(parts[12])));

            species.add(s);
            if (parts.length > 13) {
                if (parts[13].equals("lpe")) {
                    s.setPlantType(lpe);
                } else if (parts[13].equals("hpe")) {
                    s.setPlantType(hpe);
                }
            }

        }

    }

    // Method writes new plant data to a file.
    /**
     *
     * @param s
     * @throws IOException
     */
    public void writeSpeciesToFile(Species s) throws IOException {

        String row = s.toString();

        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.newLine();
        bw.write(row);
        bw.close();

    }

    // Method searches species by the latin name.
    /**
     *
     * @param latinName
     * @return
     */
    public ArrayList<Species> speciesSearchLatin(String latinName) {
        ArrayList<Species> results = new ArrayList<>();
        for (int i = 0; i < getPlants().size() - 1; i++) {
            if (getPlants().get(i).getLatinName().equals(latinName)) {
                results.add(species.get(i));
            }
        }
        return results;
    }

    // Method searches species by the finnish name.
    /**
     *
     * @param finName
     * @return
     */
    public ArrayList<Species> speciesSearchFin(String finName) {
        ArrayList<Species> results = new ArrayList<>();
        for (int i = 0; i < species.size(); i++) {
            if (species.get(i).getFinnishName().equals(finName)) {
                //System.out.println(species.get(i));
                results.add(species.get(i));
            }
        }
        return results;
    }

    // Method searches species by the growing media.
    /**
     *
     * @param gm
     * @return
     */
    public ArrayList<Species> speciesSearch(GrowingMedia gm) {
        ArrayList<Species> results = new ArrayList<>();
        for (int i = 0; i < species.size(); i++) {
            if (species.get(i).getGrowMedia().equals(gm)) {
                results.add(species.get(i));
            }
        }
        return results;
    }

    // Method returns a list with all plant species.
    /**
     *
     * @return
     */
    public ArrayList<Species> getPlants() {
        return species;
    }

}
