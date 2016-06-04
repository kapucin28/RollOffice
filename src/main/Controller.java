package main;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

/**
 * Created by TIMBULI REMUS K@puc!n on 02-Jun-16.
 */
class Controller extends Pane {

    // TabPane constants------------------------------------------------------------------------------------------------
    private final GridPane tablesGrid = new GridPane();
    private final TabPane tabPane = new TabPane();
    private final Tab tableMaster = new Tab("Master");
    private final Tab table1 = new Tab("Table 1");
    private final Tab table2 = new Tab("Table 2");
    private final Tab table3 = new Tab("Table 3");
    private final Tab table4 = new Tab("Table 4");
    //------------------------------------------------------------------------------------------------------------------

    // TitledPane constants---------------------------------------------------------------------------------------------
    private final GridPane chartsGrid = new GridPane();
    private final Pane expansionPane1 = new Pane();
    private final Pane expansionPane2 = new Pane();
    private final TitledPane chart1 = new TitledPane("Pie Chart", expansionPane1);
    private final TitledPane chart2 = new TitledPane("Bar Chart", expansionPane2);
    //------------------------------------------------------------------------------------------------------------------

    // Root pane constants----------------------------------------------------------------------------------------------
    private final Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
    private final GridPane root = new GridPane();
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    Controller(){
        rootSetup();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Root setup method------------------------------------------------------------------------------------------------
    private void rootSetup(){
        root.add(chartsGrid, 0, 0);
        root.add(tablesGrid, 0, 1);
        getChildren().add(root);
    }
    //------------------------------------------------------------------------------------------------------------------
}
