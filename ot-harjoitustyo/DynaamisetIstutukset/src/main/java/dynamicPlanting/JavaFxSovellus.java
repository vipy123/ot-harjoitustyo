package dynamicPlanting;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import components.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import javafx.scene.control.Slider;

import javax.swing.JLabel;
import javax.swing.JSlider;
import logic.*;

/**
 *
 * @author vipy
 */
public class JavaFxSovellus extends Application {

    public static Operations o = new Operations();
    public static GrowingMedia m;

    public static void main(String[] args) throws FileNotFoundException {

        o.readDataFromFile("./src/main/resources/Pensasluettelo.csv");
        launch(JavaFxSovellus.class);

//        for(Species species : o.getPensaat()) {
//            System.out.println(species.getFinnishName());
//        }
    }

    @Override
    public void start(Stage window) throws Exception {
        //Ensimmäinen näkymä.
        window.setTitle("Dynaamiset istutukset");
        GridPane componentGroup1 = new GridPane();

        Label nimiTeksti = new Label("Dynaamiset istutukset");
        Button addDataButton = new Button("Lisää lajitietoa");
        Button findSpeciesButton = new Button("Hae lajitietoa");
        Button designDynamicPlantingButton = new Button("Suunnittele dynaaminen istutus");

        componentGroup1.add(nimiTeksti, 3, 1);
        componentGroup1.add(addDataButton, 3, 2);
        componentGroup1.add(findSpeciesButton, 3, 3);
        componentGroup1.add(designDynamicPlantingButton, 3, 4);

        componentGroup1.setHgap(10);
        componentGroup1.setVgap(10);
        componentGroup1.setPadding(new Insets(50, 20, 50, 20));
        Scene scene1 = new Scene(componentGroup1, 1800, 1500);
        window.setScene(scene1);

        // Tiedon lisäysnäkymä.
        GridPane componentGroupAddData = new GridPane();

        Label nimiTeksti2 = new Label("Dynaamiset istutukset");

        Label howtoText2 = new Label("Lisää lajitietoa");
        Button addNewSpeciesButton = new Button("Lisää uusi laji");

        Button addToExistingButton = new Button("Lisää tietoa lajiin...");
        TextField addToExistingTextFielt = new TextField();
        addToExistingTextFielt.setPromptText("Anna lajin suomenkielinen nimi.");
        addToExistingTextFielt.setPrefWidth(300);
        Button backToStartButton = new Button("Palaa takaisin");

        //Asetetaan kosteudelle
//        moist.setMajorTickSpacing(1);
//        Hashtable moistLabels = new Hashtable();
//        moistLabels.put(0, new JLabel("Kuiva"));
//        moistLabels.put(2, new JLabel("Kostea"));
//        moist.setLabelTable(moistLabels);
        componentGroupAddData.add(nimiTeksti2, 3, 1);
        componentGroupAddData.add(howtoText2, 3, 4);
        componentGroupAddData.add(addNewSpeciesButton, 3, 5);
        componentGroupAddData.add(addToExistingButton, 3, 6);
        componentGroupAddData.add(addToExistingTextFielt, 8, 6);
        componentGroupAddData.add(backToStartButton, 3, 7);

        componentGroupAddData.setHgap(10);
        componentGroupAddData.setVgap(10);
        componentGroupAddData.setPadding(new Insets(50, 20, 50, 20));

        Scene sceneAdd = new Scene(componentGroupAddData, 1800, 1500);

        //Lisätään uusi laji -näkymä
        GridPane componentGroupAddNewSpecies = new GridPane();

        Label nimiTeksti3 = new Label("Dynaamiset istutukset");

        Label howtoAddNewSpecies = new Label("Lisää uuden lajin tiedot");

        howtoAddNewSpecies.setPrefWidth(300);
        Button addNewSpeciesDataButton = new Button("Lisää uusi laji");
        addNewSpeciesDataButton.setPrefWidth(300);

        Label acronymLabel = new Label("Tunnus");
        TextField acronymTextFielt = new TextField();
        acronymTextFielt.setPromptText("Automaattinen");

        Label latinLabel = new Label("Latinankielinen nimi");
        TextField latinTextField = new TextField();
        latinTextField.setPromptText("Antennaria dioica");
        latinTextField.setPrefWidth(300);

        Label finnishLabel = new Label("Suomenkielinen nimi");
        TextField finnishTextField = new TextField();
        finnishTextField.setPrefWidth(300);

        //Sliderit, joilla voi asettaa kasville kasvupaikkaolosuhteet.
        Label habitatSetUp = new Label("Syötä kasvin kasvupaikkavaatimukset "
                + "valitsemalla arvo vetojanalla. Jos laji ei vaadi tiettyä arvoa, valitse keskikohta.");
        habitatSetUp.setPrefWidth(300);
        habitatSetUp.setWrapText(true);

        //Kasvualustan kosteuden säätö
        Label moistureLabel = new Label("Kasvualustan kuivuus - kosteus (0-2)");
        Slider moist = new Slider();
        moist.setMin(0);
        moist.setMax(2);
        moist.setMajorTickUnit(1);
        moist.setMinorTickCount(0);
        moist.setSnapToTicks(true);
        moist.setShowTickMarks(false);
        moist.setShowTickLabels(true);
        moist.setValue(1);
        moist.setBlockIncrement(1);
        Label dryText = new Label("kuiva");
        Label dampText = new Label("kostea");

        //Kasvualustan raviteisuuden säätö
        Label nutritionLabel = new Label("Kasvualustan ravinteisuus (0-2)");
        Slider nutrition = new Slider(0, 2, 3);
        nutrition.setMin(0);
        nutrition.setMax(2);
        nutrition.setMajorTickUnit(1);
        nutrition.setMinorTickCount(0);
        nutrition.setSnapToTicks(true);
        nutrition.setShowTickMarks(false);
        nutrition.setShowTickLabels(true);
        nutrition.setValue(1);
        nutrition.setBlockIncrement(1);
        Label poorText = new Label("köyhä");
        Label nutritedText = new Label("runsasravinteinen");

        //Kasvualustan läpäisevyys
        Label permabilityLabel = new Label("Kasvualustan läpäisevyys (0-2)");
        Slider permability = new Slider(0, 2, 3);
        permability.setMin(0);
        permability.setMax(2);
        permability.setMajorTickUnit(1);
        permability.setMinorTickCount(0);
        permability.setSnapToTicks(true);
        permability.setShowTickMarks(false);
        permability.setShowTickLabels(true);
        permability.setValue(1);
        permability.setBlockIncrement(1);
        Label condencedText = new Label("läpäisemätön");
        Label permeableText = new Label("läpäisevä");

        //Kasvupaikan aurinkoisuus
        Label sunLightLabel = new Label("Kasvupaikan varjoisuus - aurinkoisuus (0-2)");
        Slider sunlight = new Slider(0, 2, 3);
        sunlight.setMin(0);
        sunlight.setMax(2);
        sunlight.setMajorTickUnit(1);
        sunlight.setMinorTickCount(0);
        sunlight.setSnapToTicks(true);
        sunlight.setShowTickMarks(false);
        sunlight.setShowTickLabels(true);
        sunlight.setValue(1);
        sunlight.setBlockIncrement(1);
        Label shadowText = new Label("varjoisa");
        Label sunnyText = new Label("aurinkoinen");

        //Kasvualustan happamuus
        Label acidityLabel = new Label("Kasvualustan happamuus - emäksisyys (0-2)");
        Slider acidity = new Slider(0, 2, 3);
        acidity.setMin(0);
        acidity.setMax(2);
        acidity.setMajorTickUnit(1);
        acidity.setMinorTickCount(0);
        acidity.setSnapToTicks(true);
        acidity.setShowTickMarks(false);
        acidity.setShowTickLabels(true);
        acidity.setValue(1);
        acidity.setBlockIncrement(1);
        Label acidText = new Label("varjoisa");
        Label alkalineText = new Label("aurinkoinen");

        Button backToStartButton3 = new Button("Palaa takaisin");
        //Set the components to the Gridpane
        componentGroupAddNewSpecies.add(nimiTeksti3, 3, 1);
        componentGroupAddNewSpecies.add(howtoAddNewSpecies, 3, 2);
        componentGroupAddNewSpecies.add(addNewSpeciesDataButton, 3, 19);
        componentGroupAddNewSpecies.add(acronymLabel, 3, 4);
        componentGroupAddNewSpecies.add(acronymTextFielt, 3, 5);
        componentGroupAddNewSpecies.add(latinLabel, 5, 4);
        componentGroupAddNewSpecies.add(latinTextField, 5, 5);
        componentGroupAddNewSpecies.add(finnishLabel, 7, 4);
        componentGroupAddNewSpecies.add(finnishTextField, 7, 5);
        componentGroupAddNewSpecies.add(habitatSetUp, 3, 7);

        componentGroupAddNewSpecies.add(moistureLabel, 3, 9);
        componentGroupAddNewSpecies.add(moist, 5, 9);
        componentGroupAddNewSpecies.add(dryText, 4, 9);
        componentGroupAddNewSpecies.add(dampText, 6, 9);

        componentGroupAddNewSpecies.add(nutritionLabel, 3, 11);
        componentGroupAddNewSpecies.add(poorText, 4, 11);
        componentGroupAddNewSpecies.add(nutrition, 5, 11);
        componentGroupAddNewSpecies.add(nutritedText, 6, 11);

        componentGroupAddNewSpecies.add(permabilityLabel, 3, 13);
        componentGroupAddNewSpecies.add(condencedText, 4, 13);
        componentGroupAddNewSpecies.add(permability, 5, 13);
        componentGroupAddNewSpecies.add(permeableText, 6, 13);

        componentGroupAddNewSpecies.add(sunLightLabel, 3, 15);
        componentGroupAddNewSpecies.add(shadowText, 4, 15);
        componentGroupAddNewSpecies.add(sunlight, 5, 15);
        componentGroupAddNewSpecies.add(sunnyText, 6, 15);

        componentGroupAddNewSpecies.add(acidityLabel, 3, 17);
        componentGroupAddNewSpecies.add(acidText, 4, 17);
        componentGroupAddNewSpecies.add(acidity, 5, 17);
        componentGroupAddNewSpecies.add(alkalineText, 6, 17);

        componentGroupAddNewSpecies.add(backToStartButton3, 3, 20);

        componentGroupAddNewSpecies.setHgap(10);
        componentGroupAddNewSpecies.setVgap(10);
        componentGroupAddNewSpecies.setPadding(new Insets(50, 20, 50, 20));

        Scene sceneAddSpecies = new Scene(componentGroupAddNewSpecies, 1800, 1500);

        //Tiedonhakunäkymä
        //Button actions
        addDataButton.setOnAction((event) -> window.setScene(sceneAdd));
        backToStartButton.setOnAction((event) -> window.setScene(scene1));
        addNewSpeciesButton.setOnAction((event) -> window.setScene(sceneAddSpecies));
        backToStartButton3.setOnAction((event) -> window.setScene(scene1));
        //Lisätään uusi laji ja sen tiedot:
        addNewSpeciesDataButton.setOnAction((event) -> {
            Species species = o.createNewSpecies(finnishTextField.getText(), latinTextField.getText());
            String acronym = species.getAcronym();
            if (acronymTextFielt.getText().isEmpty()) {
                acronymTextFielt.setText(acronym);
            }
//            species.setGrowMedia(new GrowingMedia(Integer.parseInt(moist.getValue()), 
//                    Integer.parseInt(nutrition.getValue()), Integer.parseInt(permability.getValue())),
//                    Integer.parseInt(sunlight.getValue()), Integer.parseInt(acidity.getValue()));
//                    

        });

        window.show();
    }
}
