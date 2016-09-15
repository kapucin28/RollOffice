package table3;

import alerts.ExitAlert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.converter.LongStringConverter;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by TIMBULI REMUS K@puc!n on 07-Jun-16.
 * <p>
 * This class represents the table for
 * team 3
 */
public class MainTable3 extends Pane {

    // Persons details constants----------------------------------------------------------------------------------------
    private final String post = "post";
    private final String scrap = "scrap";
    private final String pending = "pending";
    private final String output = "output";
    private final String target = "target";
    private final String month = "month";
    private final String year = "year";
    //------------------------------------------------------------------------------------------------------------------

    // Menu constants---------------------------------------------------------------------------------------------------
    private final MenuBar menuBar = new MenuBar();
    private final Menu fileMenu = new Menu("_File");
    private final Menu editMenu = new Menu("_Edit");
    private final MenuItem saveTable = new MenuItem("Save As...");
    private final MenuItem loadTable = new MenuItem("Load...");
    private final MenuItem refreshTable = new MenuItem("Refresh");
    private final MenuItem clearTable = new MenuItem("Clear Table");
    private final MenuItem exit = new MenuItem("Exit");
    private final SeparatorMenuItem separator = new SeparatorMenuItem();
    //------------------------------------------------------------------------------------------------------------------

    // Table variables--------------------------------------------------------------------------------------------------
    private final TableView<Table3> tableView = new TableView<>();
    private final TableColumn<Table3, String> postColumn = new TableColumn<>("Post");
    private final TableColumn<Table3, Long> scrapColumn = new TableColumn<>("Scrap");
    private final TableColumn<Table3, Long> pendingColumn = new TableColumn<>("Pending");
    private final TableColumn<Table3, Long> outputColumn = new TableColumn<>("Output");
    private final TableColumn<Table3, Long> targetColumn = new TableColumn<>("Target");
    private final TableColumn<Table3, Long> monthColumn = new TableColumn<>("Month");
    private final TableColumn<Table3, Long> yearColumn = new TableColumn<>("Year");
    private ObservableList<Table3> list = FXCollections.observableArrayList();
    //------------------------------------------------------------------------------------------------------------------

    // Load & Save table variables--------------------------------------------------------------------------------------
    private FileChooser chooser;
    private File file;
    private Stage fileStage;
    private ObjectInputStream fromFile;
    private ObjectOutputStream toFile;
    //------------------------------------------------------------------------------------------------------------------

    // Panes variables--------------------------------------------------------------------------------------------------
    private final Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
    private final GridPane root = new GridPane();
    private final GridPane tableGrid = new GridPane();
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public MainTable3() {
        layoutSetup();
        tableSetup();
        columnsSetup();
        actionsPerformed();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Layout setup-----------------------------------------------------------------------------------------------------
    private void layoutSetup() {
        // MenuBar layout-----------------------------------------------------------------------------------------------
        fileMenu.getItems().addAll(saveTable, loadTable, separator, exit);
        editMenu.getItems().addAll(refreshTable, clearTable);
        menuBar.getMenus().addAll(fileMenu, editMenu);
        //--------------------------------------------------------------------------------------------------------------

        // TableView layout---------------------------------------------------------------------------------------------
        tableView.setItems(list);
        tableView.setPrefHeight(bounds.getHeight() / 2);
        tableView.setPrefWidth(bounds.getWidth());
        //noinspection unchecked
        tableView.getColumns().addAll(postColumn, scrapColumn, pendingColumn,
                outputColumn, targetColumn, monthColumn, yearColumn);
        //--------------------------------------------------------------------------------------------------------------

        // TableGrid layout---------------------------------------------------------------------------------------------
        tableGrid.add(menuBar, 0, 0);
        tableGrid.add(tableView, 0, 1);
        //--------------------------------------------------------------------------------------------------------------

        // Root layout--------------------------------------------------------------------------------------------------
        root.setPrefWidth(bounds.getWidth());
        root.setPrefHeight(bounds.getHeight() / 2 - 50);
        root.add(tableGrid, 0, 0);
        getChildren().add(root);
        //--------------------------------------------------------------------------------------------------------------
    }
    //------------------------------------------------------------------------------------------------------------------

    // TableView method-------------------------------------------------------------------------------------------------
    private void tableSetup() {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    //------------------------------------------------------------------------------------------------------------------

    // TableColumns setup method---------------------------------------------------------------------------------------
    private void columnsSetup() {
        postColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        scrapColumn.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        pendingColumn.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        outputColumn.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        targetColumn.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        monthColumn.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        yearColumn.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));

        postColumn.setCellValueFactory(new PropertyValueFactory<>(post));
        scrapColumn.setCellValueFactory(new PropertyValueFactory<>(scrap));
        pendingColumn.setCellValueFactory(new PropertyValueFactory<>(pending));
        outputColumn.setCellValueFactory(new PropertyValueFactory<>(output));
        targetColumn.setCellValueFactory(new PropertyValueFactory<>(target));
        monthColumn.setCellValueFactory(new PropertyValueFactory<>(month));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>(year));
    }
    //------------------------------------------------------------------------------------------------------------------

    // Actions method setup---------------------------------------------------------------------------------------------
    private void actionsPerformed() {
        saveTableAction();
        loadTableAction();
        refreshTableAction();
        clearTableAction();
        exitAction();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Exit program method----------------------------------------------------------------------------------------------
    private void exitAction() {
        exit.setOnAction(e -> {
            e.consume();
            new ExitAlert();
        });
    }
    //------------------------------------------------------------------------------------------------------------------

    // Refresh table method---------------------------------------------------------------------------------------------
    private void refreshTableAction() {
        refreshTable.setOnAction(e -> tableView.refresh());
    }
    //------------------------------------------------------------------------------------------------------------------

    // Clear table method-----------------------------------------------------------------------------------------------
    private void clearTableAction() {
        clearTable.setOnAction(e -> list.clear());
    }
    //------------------------------------------------------------------------------------------------------------------

    // Save table method------------------------------------------------------------------------------------------------
    private void saveTableAction() {
        saveTable.setOnAction(e -> {
            fileStage = new Stage();
            chooser = new FileChooser();
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files", "*.*"));
        });
    }
    //------------------------------------------------------------------------------------------------------------------
}
