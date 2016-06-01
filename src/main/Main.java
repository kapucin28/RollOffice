package main;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Created by TIMBULI REMUS K@puc!n on 01-Jun-16.
 */
public class Main extends Application {


    private Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
    private Pane pane = new Pane();
    private Scene scene = new Scene(pane, bounds.getWidth() / 2, bounds.getHeight() / 2);
    private Stage stage;

    // Main method------------------------------------------------------------------------------------------------------
    public static void main(String[] args){
        Application.launch(args);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Start method-----------------------------------------------------------------------------------------------------
    public void start(Stage stage){
        this.stage = stage;
        layoutSetup();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Layout setup method----------------------------------------------------------------------------------------------
    private void layoutSetup(){
        stage.setTitle("Roll Office");
        stage.setScene(scene);
        stage.show();
    }
    //------------------------------------------------------------------------------------------------------------------
}
