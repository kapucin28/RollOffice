package main;

import alerts.ExitAlert;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.*;

/**
 * Created by TIMBULI REMUS K@puc!n on 01-Jun-16.
 * <p>
 * The main class where all the objects are
 * displayed on stage
 */
public class Main extends Application {

    // Layout variables-------------------------------------------------------------------------------------------------
    private final Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
    private final Pane pane = new Pane();
    private final Scene scene = new Scene(pane, bounds.getWidth(), bounds.getHeight());
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
        scene.getStylesheets().add(getClass().getResource("CSS.css").toExternalForm());
        stage.setTitle("Roll Office");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            e.consume();
            new ExitAlert();
        });
    }
    //------------------------------------------------------------------------------------------------------------------
}
