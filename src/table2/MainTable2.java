package table2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
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
 *
 *      This class represents the table for
 * team 2
 */
public class MainTable2 extends Pane{

    // Persons details variables----------------------------------------------------------------------------------------
    private final String post = "post";
    private final String scrap = "scrap";
    private final String pending = "pending";
    private final String output = "output";
    private final String target = "target";
    private final String month = "month";
    private final String year = "year";
    //------------------------------------------------------------------------------------------------------------------

    // Menu variables---------------------------------------------------------------------------------------------------
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
    private final TableView<Table2> tableView = new TableView<>();
    private final TableColumn<Table2, String> postColumn = new TableColumn<>("Post");
    private final TableColumn<Table2, Long> scrapColumn = new TableColumn<>("Scrap");
    private final TableColumn<Table2, Long> pendingColumn = new TableColumn<>("Pending");
    private final TableColumn<Table2, Long> outputColumn = new TableColumn<>("Output");
    private final TableColumn<Table2, Long> targetColumn = new TableColumn<>("Target");
    private final TableColumn<Table2, Long> monthColumn = new TableColumn<>("Month");
    private final TableColumn<Table2, Long> yearColumn = new TableColumn<>("Year");
    private ObservableList<Table2> list = FXCollections.observableArrayList();
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
    public MainTable2(){
        layoutSetup();
        tableSetup();
        columnsSetup();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Layout setup-----------------------------------------------------------------------------------------------------
    private void layoutSetup(){
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
    }
    //------------------------------------------------------------------------------------------------------------------
}
