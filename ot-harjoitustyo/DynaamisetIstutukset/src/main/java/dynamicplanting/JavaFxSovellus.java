package dynamicplanting;

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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

import javax.swing.JLabel;
import javax.swing.JSlider;
import logic.*;

/**
 *
 * @author vipy
 */
public class JavaFxSovellus extends Application {

    public static Operations o = new Operations();
    public GrowingMedia m;
    public Scene startScene;
    public Scene addDataScene;
    public Scene addNewSpeciesScene;
    public Scene searchSpeciesScene;
    public Stage window = new Stage();

    public static void main(String[] args) throws FileNotFoundException {

        o.readDataFromFile("./src/main/resources/Pensasluettelo.csv");
        launch(JavaFxSovellus.class);

    }

    @Override
    public void start(Stage window) throws Exception {
        //Ensimmäinen näkymä.
        this.startScene = startScene();
        this.addDataScene = addDataScene();
        this.addNewSpeciesScene = addNewSpeciesScene();
        this.searchSpeciesScene = searchSpeciesScene();
        this.window = window;

        window.setScene(startScene);

        window.show();
    }

    public Scene startScene() {
        window.setTitle("Dynaamiset istutukset");
        GridPane componentGroup1 = new GridPane();

        Label nimiTeksti = new Label("Dynaamiset istutukset");
        Button addDataButton = new Button("Lisää lajitietoa");
        Button findSpeciesButton = new Button("Hae lajitietoa");


        componentGroup1.add(nimiTeksti, 3, 1);
        componentGroup1.add(addDataButton, 3, 2);
        componentGroup1.add(findSpeciesButton, 3, 3);


        componentGroup1.setHgap(10);
        componentGroup1.setVgap(10);
        componentGroup1.setPadding(new Insets(50, 20, 50, 20));
        addDataButton.setOnAction((event) -> window.setScene(addDataScene));
        findSpeciesButton.setOnAction((event) -> window.setScene(searchSpeciesScene));
        Scene scene1 = new Scene(componentGroup1, 1800, 1500);
        return scene1;

    }

    public Scene addDataScene() {
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

        componentGroupAddData.add(nimiTeksti2, 3, 1);
        componentGroupAddData.add(howtoText2, 3, 4);
        componentGroupAddData.add(addNewSpeciesButton, 3, 5);
        componentGroupAddData.add(addToExistingButton, 3, 6);
        componentGroupAddData.add(addToExistingTextFielt, 8, 6);
        componentGroupAddData.add(backToStartButton, 3, 7);

        componentGroupAddData.setHgap(10);
        componentGroupAddData.setVgap(10);
        componentGroupAddData.setPadding(new Insets(50, 20, 50, 20));

        backToStartButton.setOnAction((event) -> window.setScene(startScene));
        addNewSpeciesButton.setOnAction((event) -> window.setScene(addNewSpeciesScene));
        

        Scene sceneAdd = new Scene(componentGroupAddData, 1800, 1500);
        return sceneAdd;
    }

    public Scene addNewSpeciesScene() {
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
        Label habitatSetUp = new Label("Syötä kasvin tiedot sekä kasvupaikkavaatimukset "
                + "valitsemalla arvo vetojanalla. Jos laji ei vaadi tiettyä arvoa, "
                + "valitse keskikohta.");
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
        Label acidText = new Label("hapan");
        Label alkalineText = new Label("kalkkipitoinen");

        //zone
        TextField zoneTextField = new TextField();
        zoneTextField.setPromptText("Menestymisvyöhyke, esim. I-VI");
        latinTextField.setPrefWidth(100);

        //adultheight
        TextField adultheightTextField = new TextField();
        adultheightTextField.setPromptText("Korkeus metreinä täysikasvuisena");
        adultheightTextField.setPrefWidth(100);

        //spacing
        TextField spacingTextField = new TextField();
        spacingTextField.setPromptText("Istutusetäisyys metreinä");
        spacingTextField.setPrefWidth(100);

        //amount per squaremetre
        TextField amountPerSquareTextField = new TextField();
        amountPerSquareTextField.setPromptText("Taimia per m2");
        amountPerSquareTextField.setPrefWidth(100);

        Button backToStartButton3 = new Button("Palaa takaisin");
        //Set the components to the Gridpane
        componentGroupAddNewSpecies.add(nimiTeksti3, 3, 1);
        componentGroupAddNewSpecies.add(howtoAddNewSpecies, 3, 2);

        componentGroupAddNewSpecies.add(acronymLabel, 3, 4);
        componentGroupAddNewSpecies.add(acronymTextFielt, 3, 5);
        componentGroupAddNewSpecies.add(latinLabel, 5, 4);
        componentGroupAddNewSpecies.add(latinTextField, 5, 5);
        componentGroupAddNewSpecies.add(finnishLabel, 7, 4);
        componentGroupAddNewSpecies.add(finnishTextField, 7, 5);
        componentGroupAddNewSpecies.add(habitatSetUp, 3, 7);

        componentGroupAddNewSpecies.add(zoneTextField, 3, 8);
        componentGroupAddNewSpecies.add(adultheightTextField, 3, 9);
        componentGroupAddNewSpecies.add(spacingTextField, 3, 10);
        componentGroupAddNewSpecies.add(amountPerSquareTextField, 3, 11);

        componentGroupAddNewSpecies.add(moistureLabel, 3, 12);
        componentGroupAddNewSpecies.add(moist, 5, 12);
        componentGroupAddNewSpecies.add(dryText, 4, 12);
        componentGroupAddNewSpecies.add(dampText, 6, 12);

        componentGroupAddNewSpecies.add(nutritionLabel, 3, 13);
        componentGroupAddNewSpecies.add(poorText, 4, 13);
        componentGroupAddNewSpecies.add(nutrition, 5, 13);
        componentGroupAddNewSpecies.add(nutritedText, 6, 13);

        componentGroupAddNewSpecies.add(permabilityLabel, 3, 14);
        componentGroupAddNewSpecies.add(condencedText, 4, 14);
        componentGroupAddNewSpecies.add(permability, 5, 14);
        componentGroupAddNewSpecies.add(permeableText, 6, 14);

        componentGroupAddNewSpecies.add(sunLightLabel, 3, 15);
        componentGroupAddNewSpecies.add(shadowText, 4, 15);
        componentGroupAddNewSpecies.add(sunlight, 5, 15);
        componentGroupAddNewSpecies.add(sunnyText, 6, 15);

        componentGroupAddNewSpecies.add(acidityLabel, 3, 16);
        componentGroupAddNewSpecies.add(acidText, 4, 16);
        componentGroupAddNewSpecies.add(acidity, 5, 16);
        componentGroupAddNewSpecies.add(alkalineText, 6, 16);

        componentGroupAddNewSpecies.add(addNewSpeciesDataButton, 3, 23);

        componentGroupAddNewSpecies.add(backToStartButton3, 3, 25);

        componentGroupAddNewSpecies.setHgap(10);
        componentGroupAddNewSpecies.setVgap(10);
        componentGroupAddNewSpecies.setPadding(new Insets(50, 20, 50, 20));

        Scene sceneAddSpecies = new Scene(componentGroupAddNewSpecies, 1800, 1500);

        //Button actions
        backToStartButton3.setOnAction((event) -> window.setScene(startScene));

        //Lisätään uusi laji ja sen tiedot:
        addNewSpeciesDataButton.setOnAction((event) -> {
            String zone = zoneTextField.getText();
            String adultHeightText = adultheightTextField.getText().toString();
            double adultHeight = Double.parseDouble(adultHeightText);
            String spacingText = spacingTextField.getText();
            double spacing = Double.parseDouble(spacingText);
            String amountPerSquareText = amountPerSquareTextField.getText();
            double amountPerSquare = Double.parseDouble(amountPerSquareText);
            int moistI = (int) Math.round(moist.getValue());
            int nutritionI = (int) Math.round(nutrition.getValue());
            int permabilityI = (int) Math.round(permability.getValue());
            int sunlightI = (int) Math.round(sunlight.getValue());
            int acidityI = (int) Math.round(acidity.getValue());
            Species species = o.createNewSpeciesFullData(finnishTextField.getText(),
                    latinTextField.getText(), zone, adultHeight, spacing, amountPerSquare,
                    new GrowingMedia(moistI,
                            nutritionI, permabilityI,
                            sunlightI, acidityI));
            String acronym = species.getAcronym();
            if (acronymTextFielt.getText().isEmpty()) {
                acronymTextFielt.setText(acronym);
            }
            System.out.println(species.getAcronym() + " " + species.getFinnishName());

        });
        return sceneAddSpecies;
    }

    public Scene searchSpeciesScene() {
        //Tiedonhakunäkymä
        GridPane componentGroupSearchSpecies = new GridPane();

        Label nimiTeksti3 = new Label("Dynaamiset istutukset");

        Label howtoAddNewSpecies = new Label("Hae lajia täyttämällä mahdollisimman monta"
                + "tietuetta tai antamalla nimi.");

        howtoAddNewSpecies.setPrefWidth(300);
        howtoAddNewSpecies.setWrapText(true);
        Button searchSpeciesButton = new Button("Etsi lajeja");
        searchSpeciesButton.setPrefWidth(300);

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
        Label habitatSetUp = new Label("Syötä kasvin tiedot sekä kasvupaikkavaatimukset "
                + "valitsemalla arvo vetojanalla. Jos laji ei vaadi tiettyä arvoa, "
                + "valitse keskikohta.");
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
        Label acidText = new Label("hapan");
        Label alkalineText = new Label("kalkkipitoinen");

        //zone
        TextField zoneTextField = new TextField();
        zoneTextField.setPromptText("Menestymisvyöhyke, esim. I-VI");
        latinTextField.setPrefWidth(100);

        //adultheight
        TextField adultheightTextField = new TextField();
        adultheightTextField.setPromptText("Korkeus metreinä täysikasvuisena");
        adultheightTextField.setPrefWidth(100);

        ScrollPane resultSpecies = new ScrollPane();
        resultSpecies.setPrefSize(300, 500);

        Button backToStartButton4 = new Button("Palaa takaisin");
        //Set the components to the Gridpane
        componentGroupSearchSpecies.add(nimiTeksti3, 3, 1);
        componentGroupSearchSpecies.add(howtoAddNewSpecies, 3, 2);

        componentGroupSearchSpecies.add(acronymLabel, 3, 4);
        componentGroupSearchSpecies.add(acronymTextFielt, 3, 5);
        componentGroupSearchSpecies.add(latinLabel, 5, 4);
        componentGroupSearchSpecies.add(latinTextField, 5, 5);
        componentGroupSearchSpecies.add(finnishLabel, 7, 4);
        componentGroupSearchSpecies.add(finnishTextField, 7, 5);
        componentGroupSearchSpecies.add(habitatSetUp, 3, 7);

        componentGroupSearchSpecies.add(zoneTextField, 3, 8);
        componentGroupSearchSpecies.add(adultheightTextField, 3, 9);

        componentGroupSearchSpecies.add(moistureLabel, 3, 12);
        componentGroupSearchSpecies.add(moist, 5, 12);
        componentGroupSearchSpecies.add(dryText, 4, 12);
        componentGroupSearchSpecies.add(dampText, 6, 12);

        componentGroupSearchSpecies.add(nutritionLabel, 3, 13);
        componentGroupSearchSpecies.add(poorText, 4, 13);
        componentGroupSearchSpecies.add(nutrition, 5, 13);
        componentGroupSearchSpecies.add(nutritedText, 6, 13);

        componentGroupSearchSpecies.add(permabilityLabel, 3, 14);
        componentGroupSearchSpecies.add(condencedText, 4, 14);
        componentGroupSearchSpecies.add(permability, 5, 14);
        componentGroupSearchSpecies.add(permeableText, 6, 14);

        componentGroupSearchSpecies.add(sunLightLabel, 3, 15);
        componentGroupSearchSpecies.add(shadowText, 4, 15);
        componentGroupSearchSpecies.add(sunlight, 5, 15);
        componentGroupSearchSpecies.add(sunnyText, 6, 15);

        componentGroupSearchSpecies.add(acidityLabel, 3, 16);
        componentGroupSearchSpecies.add(acidText, 4, 16);
        componentGroupSearchSpecies.add(acidity, 5, 16);
        componentGroupSearchSpecies.add(alkalineText, 6, 16);

        componentGroupSearchSpecies.add(searchSpeciesButton, 3, 23);

        componentGroupSearchSpecies.add(backToStartButton4, 3, 25);
        componentGroupSearchSpecies.add(resultSpecies, 3, 26);

        componentGroupSearchSpecies.setHgap(10);
        componentGroupSearchSpecies.setVgap(10);
        componentGroupSearchSpecies.setPadding(new Insets(50, 20, 50, 20));

        Scene sceneSearchSpecies = new Scene(componentGroupSearchSpecies, 1800, 1500);

        //Button actions
        //Etsitään lajia TextFieldeihin syötteiden perusteella.
        int nextRow = 26;
        searchSpeciesButton.setOnAction((event) -> {
            TextArea ta = new TextArea("");
            resultSpecies.setContent(ta);
            StringBuilder sb = new StringBuilder();
            sb.append("TULOKSET: " + "\n");
            if (finnishTextField.getText().length() > 0) {
                String finName = finnishTextField.getText();

                ArrayList<Species> result = o.speciesSearchFin(finName);
                for (int i = 0; i < result.size(); i++) {
                    sb.append(result.get(i).getLatinName() + "  " + result.get(i).getFinnishName()
                            + " koko: " + result.get(i).getAdultHeight() + "\n");
                    sb.append("Tämän lajin kanssa sopivat seuraavat lajit: " + "\n");
                    GrowingMedia gm = result.get(i).getGrowMedia();
                    ArrayList<Species> friends = o.speciesSearch(gm);
                    for (int j = 0; j < friends.size(); j++) {
                        sb.append(friends.get(j).getLatinName() + " " + friends.get(j).getFinnishName()
                                + " koko: " + friends.get(i).getAdultHeight() + "\n");
                    }

                }
            } else if (latinTextField.getText().length() > 0) {
                String latinName = latinTextField.getText();
            } else {
                //String zone = zoneTextField.getText();
                //double adultHeight = Double.parseDouble(adultheightTextField.getText());
                int moistI = (int) Math.round(moist.getValue());
                int nutritionI = (int) Math.round(nutrition.getValue());
                int permabilityI = (int) Math.round(permability.getValue());
                int sunlightI = (int) Math.round(sunlight.getValue());
                int acidityI = (int) Math.round(acidity.getValue());
                GrowingMedia gm = new GrowingMedia(moistI, nutritionI, permabilityI, sunlightI, acidityI);
                ArrayList<Species> result = o.speciesSearch(gm);
                for (int i = 0; i < result.size(); i++) {
                    sb.append(result.get(i).getLatinName() + "  "
                            + result.get(i).getFinnishName() + " "
                            + result.get(i).getAdultHeight() + "\n");
                }

            }
            ta.setText(sb.toString());
            resultSpecies.setContent(ta);

        });
        backToStartButton4.setOnAction((event) -> {
            resultSpecies.setContent(new TextArea(""));
            window.setScene(startScene);
        });

        return sceneSearchSpecies;

    }
}
