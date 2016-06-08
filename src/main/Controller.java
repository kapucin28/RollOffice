package main;

import chartsGraphics.BarChartGraphic;
import chartsInfo.ChartsMasterInfo;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import masterTable.MainMasterTable;
import table1.MainTable1;
import table2.MainTable2;
import table3.MainTable3;
import table4.MainTable4;

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
        chartsLayoutSetup();
        tabsSetup();
        rootLayoutSetup();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Root setup method------------------------------------------------------------------------------------------------
    private void rootLayoutSetup(){
        root.add(chartsGrid, 0, 0);
        root.add(tablesGrid, 0, 1);
        getChildren().add(root);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Charts setup method----------------------------------------------------------------------------------------------
    private void chartsLayoutSetup(){
        chart1.setPrefHeight(bounds.getHeight() / 2);
        chart1.setPrefWidth(bounds.getWidth() / 2);
        chart1.setContent(new ChartsMasterInfo());
        chart2.setPrefHeight(bounds.getHeight() / 2);
        chart2.setPrefWidth(bounds.getWidth() / 2);
        chart2.setContent(new BarChartGraphic());
        chartsGrid.setPrefHeight(bounds.getHeight() / 2);
        chartsGrid.setPrefWidth(bounds.getWidth());
        chartsGrid.add(chart1, 0, 0);
        chartsGrid.add(chart2, 1, 0);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Tabs setup method------------------------------------------------------------------------------------------------
    private void tabsSetup(){
        tableMaster.setClosable(false);
        table1.setClosable(false);
        table2.setClosable(false);
        table3.setClosable(false);
        table4.setClosable(false);
        tableMaster.setContent(new MainMasterTable());
        table1.setContent(new MainTable1());
        table2.setContent(new MainTable2());
        table3.setContent(new MainTable3());
        table4.setContent(new MainTable4());
        tabPane.setPrefHeight(bounds.getHeight() / 2);
        tabPane.setPrefWidth(bounds.getWidth());
        tabPane.getTabs().addAll(tableMaster, table1, table2, table3, table4);
        tablesGrid.add(tabPane, 0, 0);
    }
    //------------------------------------------------------------------------------------------------------------------
}
