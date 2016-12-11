package main;

import alerts.ExitAlert;
import enums.CSSEnum;
import interfaces.ObjectTitles;
import interfaces.Scale;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by TIMBULI REMUS K@puc!n on 01-Jun-16.
 * <p>
 * The main class where all the objects are
 * displayed on stage
 */
public class Main extends Application implements Scale {

    // Layout variables-------------------------------------------------------------------------------------------------
    private final Pane pane = new Pane();
    private final Scene scene = new Scene(pane, SCREEN_WIDTH, SCREEN_HEIGHT);
    private Stage stage;
    //------------------------------------------------------------------------------------------------------------------

    // Main method------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Application.launch(args);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Start method-----------------------------------------------------------------------------------------------------
    public void start(Stage stage) {
        this.stage = stage;
        layoutSetup();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Layout setup method----------------------------------------------------------------------------------------------
    private void layoutSetup() {
        pane.getChildren().add(new Controller());

        // CSS setup----------------------------------------------------------------------------------------------------
        scene.getStylesheets().add(getClass().getResource(ObjectTitles.cssFile).toExternalForm());
        pane.getStyleClass().add(CSSEnum.mainPane.toString());
        //--------------------------------------------------------------------------------------------------------------

        stage.setTitle(ObjectTitles.stageTitle);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            e.consume();
            new ExitAlert();
        });
    }
    //------------------------------------------------------------------------------------------------------------------
}
