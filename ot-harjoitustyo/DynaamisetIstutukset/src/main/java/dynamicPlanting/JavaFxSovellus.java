
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
import logic.*;
/**
 *
 * @author vipy
 */
public class JavaFxSovellus extends Application {
    public static void main(String[] args) {
        launch(JavaFxSovellus.class);
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
        Scene scene1 = new Scene(componentGroup1, 800, 500);
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
        
        componentGroupAddData.add(nimiTeksti2, 3, 1);
        componentGroupAddData.add(howtoText2, 3, 4);
        componentGroupAddData.add(addNewSpeciesButton, 3, 5);
        componentGroupAddData.add(addToExistingButton, 3, 6);
        componentGroupAddData.add(addToExistingTextFielt, 8, 6);
        componentGroupAddData.add(backToStartButton, 3, 7);
        
        componentGroupAddData.setHgap(10);
        componentGroupAddData.setVgap(10);
        componentGroupAddData.setPadding(new Insets(50, 20, 50, 20));
        
        Scene sceneAdd = new Scene(componentGroupAddData, 800, 500);
        
        
        
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
        
        Button backToStartButton3 = new Button("Palaa takaisin");
        
        componentGroupAddNewSpecies.add(nimiTeksti3, 3, 1);
        componentGroupAddNewSpecies.add(howtoAddNewSpecies, 3, 2);
        componentGroupAddNewSpecies.add(addNewSpeciesDataButton, 3, 3);
        componentGroupAddNewSpecies.add(acronymLabel, 3, 4);
        componentGroupAddNewSpecies.add(acronymTextFielt, 3, 5);
        componentGroupAddNewSpecies.add(latinLabel, 8, 4);
        componentGroupAddNewSpecies.add(latinTextField, 8, 5);
        componentGroupAddNewSpecies.add(finnishLabel, 16, 4);
        componentGroupAddNewSpecies.add(finnishTextField, 16, 5);
        
        componentGroupAddNewSpecies.add(backToStartButton3, 3, 7);
        
        componentGroupAddNewSpecies.setHgap(10);
        componentGroupAddNewSpecies.setVgap(10);
        componentGroupAddNewSpecies.setPadding(new Insets(50, 20, 50, 20));
        
        Scene sceneAddSpecies = new Scene(componentGroupAddNewSpecies, 800, 500);
        
        //Tiedonhakunäkymä
        
        //Button actions
        addDataButton.setOnAction((event) -> window.setScene(sceneAdd));
        backToStartButton.setOnAction((event) -> window.setScene(scene1));
        addNewSpeciesButton.setOnAction((event) -> window.setScene(sceneAddSpecies));
        backToStartButton3.setOnAction((event) -> window.setScene(scene1));
        //Lisätään uusi laji ja sen tiedot:
        addNewSpeciesDataButton.setOnAction((event) -> {
            String acronym = logic.Operations.CreateNewSpecies(finnishTextField.getText(), latinTextField.getText());
            if (acronymTextFielt.getText().isEmpty()) {
                acronymTextFielt.setText(acronym);
            }
        }); 
        
        
        
        window.show();
    }
}
