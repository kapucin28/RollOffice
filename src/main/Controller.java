package main;

import chartsGraphics.*;
import chartsInfo.ChartsMasterInfo;
import interfaces.ObjectTitles;
import interfaces.Scale;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import masterTable.MainMasterTable;
import table1.MainTable1;
import table2.MainTable2;
import table3.MainTable3;
import table4.MainTable4;

/**
 * Created by TIMBULI REMUS K@puc!n on 02-Jun-16.
 * <p>
 * This is the controller class where all the GUI
 * are organised
 */
class Controller extends Pane implements Scale {

    // TabPane constants------------------------------------------------------------------------------------------------
    private final GridPane tablesGrid = new GridPane();
    private final TabPane tabPane = new TabPane();
    private final Tab tableMaster = new Tab(ObjectTitles.tabMaster);
    private final Tab table1 = new Tab(ObjectTitles.tab1);
    private final Tab table2 = new Tab(ObjectTitles.tab2);
    private final Tab table3 = new Tab(ObjectTitles.tab3);
    private final Tab table4 = new Tab(ObjectTitles.tab4);
    //------------------------------------------------------------------------------------------------------------------

    // TitledPane constants---------------------------------------------------------------------------------------------
    private final GridPane chartsGrid = new GridPane();
    private final Pane expansionPane1 = new Pane();
    private final Pane expansionPane2 = new Pane();
    private final TitledPane chart1 = new TitledPane(ObjectTitles.titledPane1, expansionPane1);
    private final TitledPane chart2 = new TitledPane(ObjectTitles.titledPane2, expansionPane2);
    //------------------------------------------------------------------------------------------------------------------

    // Root pane constants----------------------------------------------------------------------------------------------
    private final GridPane root = new GridPane();
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    Controller() {
        CSSSetup();
        updateChartSetup();
        chartsLayoutSetup();
        tabsSetup();
        rootLayoutSetup();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Root setup method------------------------------------------------------------------------------------------------
    private void rootLayoutSetup() {
        root.add(chartsGrid, 0, 0);
        root.add(tablesGrid, 0, 1);
        getChildren().add(root);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Charts setup method----------------------------------------------------------------------------------------------
    private void chartsLayoutSetup() {
        chart1.setPrefHeight(SCREEN_HEIGHT / 2);
        chart1.setPrefWidth(SCREEN_WIDTH / 2);
        chart1.setContent(new ChartsMasterInfo());
        chart2.setPrefHeight(SCREEN_HEIGHT / 2);
        chart2.setPrefWidth(SCREEN_WIDTH / 2);
        chart2.setContent(new BarChartGraphic());
        chartsGrid.setPrefHeight(SCREEN_HEIGHT / 2);
        chartsGrid.setPrefWidth(SCREEN_WIDTH);
        chartsGrid.add(chart1, 0, 0);
        chartsGrid.add(chart2, 1, 0);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Tabs setup method------------------------------------------------------------------------------------------------
    private void tabsSetup() {
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
        tabPane.setPrefHeight(SCREEN_HEIGHT / 2);
        tabPane.setPrefWidth(SCREEN_WIDTH);
        tabPane.getTabs().addAll(tableMaster, table1, table2, table3, table4);
        tablesGrid.add(tabPane, 0, 0);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Selecting tabs method--------------------------------------------------------------------------------------------
    private void updateChartSetup() {
        tableMaster.setOnSelectionChanged(e -> {
            chart1.setContent(new ChartsMasterInfo());
            chart1.setText(ObjectTitles.updateChart1M);
        });
        table1.setOnSelectionChanged(e -> {
            chart1.setContent(new Table1PieChart());
            chart1.setText(ObjectTitles.updateChart1);
        });
        table2.setOnSelectionChanged(e -> {
            chart1.setContent(new Table2PieChart());
            chart1.setText(ObjectTitles.updateChart2);
        });
        table3.setOnSelectionChanged(e -> {
            chart1.setContent(new Table3PieChart());
            chart1.setText(ObjectTitles.updateChart3);
        });
        table4.setOnSelectionChanged(e -> {
            chart1.setContent(new Table4PieChart());
            chart1.setText(ObjectTitles.updateChart4);
        });
    }
    //------------------------------------------------------------------------------------------------------------------

    // CSS setup--------------------------------------------------------------------------------------------------------
    private void CSSSetup() {
        tablesGrid.getStyleClass().add("tablesGrid");
        tabPane.getStyleClass().add("tabPane");
        tableMaster.getStyleClass().add("tableMaster");
        table1.getStyleClass().add("table1");
        table2.getStyleClass().add("table2");
        table3.getStyleClass().add("table3");
        table4.getStyleClass().add("table4");
        chartsGrid.getStyleClass().add("chartsGrid");
        expansionPane1.getStyleClass().add("expansionPane1");
        expansionPane2.getStyleClass().add("expansionPane2");
        chart1.getStyleClass().add("chart1");
        chart2.getStyleClass().add("chart2");
        root.getStyleClass().add("rootController");
    }
    //------------------------------------------------------------------------------------------------------------------
}