/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import components.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.util.stream.Stream;

/**
 *
 * @author vipy
 */
public class Operations {
    public ArrayList<Species> species;
    public ArrayList<String> rows;
    public GrowingMedia test = new GrowingMedia(1,2,3,4,5);

    public static String CreateNewSpecies(String finnishName, String latinName) {
        Species species = new Species(finnishName, latinName);
        return species.getAcronym();
    }
    public void readDataFromFile(String file) throws FileNotFoundException {
        rows = new ArrayList<>();
        species = new ArrayList<>();
        Scanner fileReader = new Scanner(new File(file));
        while (fileReader.hasNextLine()) {
            String rivi = fileReader.nextLine();
            rows.add(rivi);
        }
//        System.out.println(rows.get(0));
//        System.out.println(rows.get(1));
        for(int i = 1; i < rows.size(); i++) {
            String[] parts = rows.get(i).split(",");
            try {
                double num = Double.parseDouble(parts[5]);
            } catch (NumberFormatException e) {
                continue;
            }
            Species s = new Species(parts[2], parts[1]);

            species.add(s);
            s.setZone(parts[3]);
            s.setAdultHeight(Double.parseDouble(parts[5]));
            s.setSpacing(Double.parseDouble(parts[6]));
            s.setAmountPerSquare(Double.parseDouble(parts[7]));
            s.setGrowMedia(new GrowingMedia(Integer.parseInt(parts[8]),
                            Integer.parseInt(parts[9]), Integer.parseInt(parts[10]),
                            Integer.parseInt(parts[11]), Integer.parseInt(parts[12])));
            s.setType(new PlantType(parts[12]));
            
            //System.out.println(s.getFinnishName());
            System.out.println(species.get(i-1).getFinnishName());
            System.out.print(i-1);
            System.out.println("");

        }
//        
    }

    public ArrayList<Species> getPlants() {
        return species;
    }
    
}
