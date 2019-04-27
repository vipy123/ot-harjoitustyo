/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import components.*;
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
import java.util.stream.Stream;

/**
 * Here is where I handle the plant data, read it from files and realize the
 * button commands.
 */
public class Operations {

    public ArrayList<Species> species;
    public ArrayList<String> rows;
    public GrowingMedia test;
    public PlantType lpe;
    public PlantType hpe;

    public Operations() {
        rows = new ArrayList<>();
        species = new ArrayList<>();
        test = new GrowingMedia(1, 2, 3, 4, 5);
        lpe = new PlantType("lpe");
        hpe = new PlantType("hpe");
    }

    public Species createNewSpecies(String finnishName, String latinName) {
        Species species = new Species(finnishName, latinName);
        return species;
        //species.getAcronym();
        
    }
    
    public Species createNewSpeciesFullData(String finnishName, String latinName, String zone,
            double adultheight, double spacing, double amountPerSquare, GrowingMedia growMedia) {
        Species species = new Species(finnishName, latinName, zone, adultheight, spacing,
        amountPerSquare, growMedia);
        return species;
        //species.getAcronym();
        
    }

    public void readDataFromFile(String file) throws FileNotFoundException {

        Scanner fileReader = new Scanner(new File(file));
        while (fileReader.hasNextLine()) {
            String rivi = fileReader.nextLine();
            rows.add(rivi);
        }
//        System.out.println(rows.get(0));
//        System.out.println(rows.get(1));
        for (int i = 1; i < rows.size(); i++) {
            String[] parts = rows.get(i).split(",");
            try {
                double num = Double.parseDouble(parts[5]);
            } catch (NumberFormatException e) {
                continue;
            }
            Species s = new Species(parts[2], parts[1], parts[3], Double.parseDouble(parts[5]),
                    Double.parseDouble(parts[6]), Double.parseDouble(parts[7]), 
                    new GrowingMedia(Integer.parseInt(parts[8]),
                    Integer.parseInt(parts[9]), Integer.parseInt(parts[10]),
                    Integer.parseInt(parts[11]), Integer.parseInt(parts[12])));

            
            species.add(s);
//            s.setZone(parts[3]);
//            s.setAdultHeight(Double.parseDouble(parts[5]));
//            s.setSpacing(Double.parseDouble(parts[6]));
//            s.setAmountPerSquare(Double.parseDouble(parts[7]));
//            s.setGrowMedia(new GrowingMedia(Integer.parseInt(parts[8]),
//                    Integer.parseInt(parts[9]), Integer.parseInt(parts[10]),
//                    Integer.parseInt(parts[11]), Integer.parseInt(parts[12])));
            if (parts[13].equals("lpe")) {
                s.setPlantType(lpe);
            } else if (parts[13].equals("hpe")) {
                s.setPlantType(hpe);
            }

            //System.out.println(s.getFinnishName() + " " + s.getGrowMedia().getAcidity());
//            System.out.println(species.get(i-1).getFinnishName());
//            System.out.print(i-1);
//            System.out.println("");

        }
//        
    }
    public void writeSpeciesToFile(Species s) throws IOException {
        
        String row = s.toString();
        FileWriter fw = new FileWriter("./src/main/resources/Pensasluettelo.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.newLine();
        bw.write(row);
        
        
    }
    public ArrayList<Species> speciesSearchLatin(String latinName) {
        ArrayList<Species> results = new ArrayList<>();
        for(int i = 0; i < getPlants().size() -1; i++) {
            if (getPlants().get(i).getLatinName().equals(latinName)) {
                results.add(getPlants().get(i));
            }
        }
        return results;
    }
    
    public ArrayList<Species> speciesSearchFin(String finName) {
        ArrayList<Species> results = new ArrayList<>();
        for(int i = 0; i < getPlants().size() -1; i++) {
            if (getPlants().get(i).getFinnishName().equals(finName)) {
                results.add(getPlants().get(i));
            }
        }
        return results;
    }
    
    public ArrayList<Species> speciesSearch(GrowingMedia gm) {
        ArrayList<Species> results = new ArrayList<>();
        for(int i = 0; i < getPlants().size() -1; i++) {
            if (getPlants().get(i).getGrowMedia().equals(gm)) {
                results.add(getPlants().get(i));
            }
        }
        return results;
    }

    public ArrayList<Species> getPlants() {
        return species;
    }

    

}
