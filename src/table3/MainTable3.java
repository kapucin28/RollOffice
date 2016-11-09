package table3;

import alerts.EmptyAlert;
import alerts.ExitAlert;
import alerts.StreamAlert;
import enums.MenuItemTitle;
import enums.TableColumnsTextLink;
import enums.TableTitles;
import interfaces.Scale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.LongStringConverter;

import java.io.*;

/**
 * Created by TIMBULI REMUS K@puc!n on 07-Jun-16.
 * <p>
 * This class represents the table for
 * team 3
 */
public class MainTable3 extends Pane implements Scale {

    // Menu constants---------------------------------------------------------------------------------------------------
    private final MenuBar menuBar = new MenuBar();
    private final Menu fileMenu = new Menu(MenuItemTitle._File.toString());
    private final Menu editMenu = new Menu(MenuItemTitle._Edit.toString());
    private final MenuItem saveTable = new MenuItem(MenuItemTitle.SaveAs.toString());
    private final MenuItem loadTable = new MenuItem(MenuItemTitle.Load.toString());
    private final MenuItem refreshTable = new MenuItem(MenuItemTitle.Refresh.toString());
    private final MenuItem clearTable = new MenuItem(MenuItemTitle.ClearTable.toString());
    private final MenuItem exit = new MenuItem(MenuItemTitle.Exit.toString());
    private final SeparatorMenuItem separator = new SeparatorMenuItem();
    //------------------------------------------------------------------------------------------------------------------

    // Table variables--------------------------------------------------------------------------------------------------
    private final TableView<Table3> tableView = new TableView<>();
    private final TableColumn<Table3, String> postColumn = new TableColumn<>(TableColumnsTextLink.Post.toString());
    private final TableColumn<Table3, Long> scrapColumn = new TableColumn<>(TableColumnsTextLink.Scrap.toString());
    private final TableColumn<Table3, Long> pendingColumn = new TableColumn<>(TableColumnsTextLink.Pending.toString());
    private final TableColumn<Table3, Long> outputColumn = new TableColumn<>(TableColumnsTextLink.Output.toString());
    private final TableColumn<Table3, Long> targetColumn = new TableColumn<>(TableColumnsTextLink.Target.toString());
    private final TableColumn<Table3, Long> monthColumn = new TableColumn<>(TableColumnsTextLink.Month.toString());
    private final TableColumn<Table3, Long> yearColumn = new TableColumn<>(TableColumnsTextLink.Year.toString());
    private ObservableList<Table3> list = FXCollections.observableArrayList();
    //------------------------------------------------------------------------------------------------------------------

    // Load & Save table variables--------------------------------------------------------------------------------------
    private FileChooser chooser;
    private File file;
    private Stage fileStage;
    private ObjectInputStream fromFile;
    private ObjectOutputStream toFile;
    //------------------------------------------------------------------------------------------------------------------

    // Panes constants--------------------------------------------------------------------------------------------------
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
        tableView.setPrefHeight(SCREEN_HEIGHT / 2);
        tableView.setPrefWidth(SCREEN_WIDTH);
        //noinspection unchecked
        tableView.getColumns().addAll(postColumn, scrapColumn, pendingColumn,
                outputColumn, targetColumn, monthColumn, yearColumn);
        //--------------------------------------------------------------------------------------------------------------

        // TableGrid layout---------------------------------------------------------------------------------------------
        tableGrid.add(menuBar, 0, 0);
        tableGrid.add(tableView, 0, 1);
        //--------------------------------------------------------------------------------------------------------------

        // Root layout--------------------------------------------------------------------------------------------------
        root.setPrefWidth(SCREEN_WIDTH);
        root.setPrefHeight(SCREEN_HEIGHT / 2 - 50);
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

        postColumn.setCellValueFactory(new PropertyValueFactory<>(TableTitles.post.toString()));
        scrapColumn.setCellValueFactory(new PropertyValueFactory<>(TableTitles.scrap.toString()));
        pendingColumn.setCellValueFactory(new PropertyValueFactory<>(TableTitles.pending.toString()));
        outputColumn.setCellValueFactory(new PropertyValueFactory<>(TableTitles.output.toString()));
        targetColumn.setCellValueFactory(new PropertyValueFactory<>(TableTitles.target.toString()));
        monthColumn.setCellValueFactory(new PropertyValueFactory<>(TableTitles.month.toString()));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>(TableTitles.year.toString()));
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
            if (list.isEmpty()) {
                new EmptyAlert();
            } else {
                file = chooser.showSaveDialog(fileStage);
                try {
                    toFile = new ObjectOutputStream(new FileOutputStream(file));
                    for (Table3 table3 : list) {
                        toFile.writeUTF(table3.getPost());
                        toFile.writeLong(table3.getScrap());
                        toFile.writeLong(table3.getPending());
                        toFile.writeLong(table3.getOutput());
                        toFile.writeLong(table3.getTarget());
                        toFile.writeLong(table3.getMonth());
                        toFile.writeLong(table3.getYear());
                    }
                    toFile.close();
                } catch (IOException e1) {
                    new StreamAlert();
                }
            }
        });
    }
    //------------------------------------------------------------------------------------------------------------------

    // Load table method------------------------------------------------------------------------------------------------
    private void loadTableAction() {
        loadTable.setOnAction(e -> {
            fileStage = new Stage();
            chooser = new FileChooser();
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files", "*.*"));
            file = chooser.showOpenDialog(fileStage);
            try {
                fromFile = new ObjectInputStream(new FileInputStream(file));
                while (file != null) {
                    Table3 table3 = new Table3("", 0, 0, 0, 0, 0, 0);
                    table3.setPost(fromFile.readUTF());
                    table3.setScrap(fromFile.readLong());
                    table3.setPending(fromFile.readLong());
                    table3.setOutput(fromFile.readLong());
                    table3.setTarget(fromFile.readLong());
                    table3.setMonth(fromFile.readLong());
                    table3.setYear(fromFile.readLong());
                    tableView.getItems().add(table3);
                }
                fromFile.close();
            } catch (IOException ignored) {
            }
        });
    }
    //------------------------------------------------------------------------------------------------------------------
}
