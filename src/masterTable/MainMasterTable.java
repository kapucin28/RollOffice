package masterTable;

import alerts.EmptyAlert;
import alerts.ExitAlert;
import alerts.StreamAlert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.*;

/**
 * Created by TIMBULI REMUS K@puc!n on 08-Jun-16.
 * <p>
 * Master table in which the administrative information
 * is stored by the user
 */
public class MainMasterTable extends Pane {

    // Persons details constants----------------------------------------------------------------------------------------
    private final String name = "name";
    private final String surname = "surname";
    private final String post = "post";
    private final String ID = "ID";
    private final String team = "team";
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
    private final TableView<Persons> tableView = new TableView<>();
    private final TableColumn<Persons, String> nameColumn = new TableColumn<>("Name");
    private final TableColumn<Persons, String> surnameColumn = new TableColumn<>("Surname");
    private final TableColumn<Persons, String> postColumn = new TableColumn<>("Post");
    private final TableColumn<Persons, Integer> IDColumn = new TableColumn<>("ID");
    private final TableColumn<Persons, Integer> teamColumn = new TableColumn<>("Team");
    private ObservableList<Persons> list = FXCollections.observableArrayList();
    //------------------------------------------------------------------------------------------------------------------

    // Load & Save table variables--------------------------------------------------------------------------------------
    private FileChooser chooser;
    private File file;
    private Stage fileStage;
    private ObjectInputStream fromFile;
    private ObjectOutputStream toFile;
    //------------------------------------------------------------------------------------------------------------------

    // Input variables--------------------------------------------------------------------------------------------------
    private final TextField tfName = new TextField();
    private final TextField tfSurname = new TextField();
    private final TextField tfPost = new TextField();
    private final TextField tfID = new TextField();
    private final TextField tfTeam = new TextField();
    private final Button addButton = new Button("Add");
    private final Button removeButton = new Button("Remove");
    //------------------------------------------------------------------------------------------------------------------

    // Panes variables--------------------------------------------------------------------------------------------------
    private final Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
    private final GridPane root = new GridPane();
    private final GridPane tableGrid = new GridPane();
    private final GridPane inputGrid = new GridPane();
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public MainMasterTable() {
        layoutSetup();
        tableSetup();
        columnsSetup();
        actionsPerformed();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Layout setup-----------------------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    private void layoutSetup() {
        // TextField layout---------------------------------------------------------------------------------------------
        tfName.setPromptText("Name");
        tfSurname.setPromptText("Surname");
        tfPost.setPromptText("Post");
        tfID.setPromptText("ID");
        tfTeam.setPromptText("Team");
        //--------------------------------------------------------------------------------------------------------------

        // MenuBar layout-----------------------------------------------------------------------------------------------
        fileMenu.getItems().addAll(saveTable, loadTable, separator, exit);
        editMenu.getItems().addAll(refreshTable, clearTable);
        menuBar.getMenus().addAll(fileMenu, editMenu);
        //--------------------------------------------------------------------------------------------------------------

        // TableView layout---------------------------------------------------------------------------------------------
        tableView.setItems(list);
        tableView.setPrefWidth(bounds.getWidth());
        tableView.setPrefHeight(bounds.getHeight() / 2 - 120);
        tableView.getColumns().addAll(nameColumn, surnameColumn, postColumn, IDColumn, teamColumn);
        //--------------------------------------------------------------------------------------------------------------

        // TableGrid layout---------------------------------------------------------------------------------------------
        tableGrid.add(menuBar, 0, 0);
        tableGrid.add(tableView, 0, 1);
        //--------------------------------------------------------------------------------------------------------------

        // InputGrid layout---------------------------------------------------------------------------------------------
        inputGrid.setVgap(10);
        inputGrid.setHgap(30);
        inputGrid.setPadding(new Insets(5, bounds.getHeight() / 3, 5, bounds.getHeight() / 3));
        inputGrid.add(tfName, 0, 0);
        inputGrid.add(tfSurname, 1, 0);
        inputGrid.add(tfPost, 2, 0);
        inputGrid.add(tfID, 3, 0);
        inputGrid.add(tfTeam, 4, 0);
        inputGrid.add(addButton, 5, 0);
        inputGrid.add(removeButton, 6, 0);
        //--------------------------------------------------------------------------------------------------------------

        // Root layout--------------------------------------------------------------------------------------------------
        root.setPrefWidth(bounds.getWidth());
        root.setPrefHeight(bounds.getHeight() / 2);
        root.add(tableGrid, 0, 0);
        root.add(inputGrid, 0, 1);
        getChildren().add(root);
        //--------------------------------------------------------------------------------------------------------------
    }
    //------------------------------------------------------------------------------------------------------------------

    // TableView method-------------------------------------------------------------------------------------------------
    private void tableSetup() {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.setEditable(true);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    //------------------------------------------------------------------------------------------------------------------

    // TableColumns method----------------------------------------------------------------------------------------------
    private void columnsSetup() {
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        surnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        postColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        IDColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        teamColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        nameColumn.setCellValueFactory(new PropertyValueFactory<>(name));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>(surname));
        postColumn.setCellValueFactory(new PropertyValueFactory<>(post));
        IDColumn.setCellValueFactory(new PropertyValueFactory<>(ID));
        teamColumn.setCellValueFactory(new PropertyValueFactory<>(team));

        nameColumn.setOnEditCommit(this::nameColumnEdit);
        surnameColumn.setOnEditCommit(this::surnameColumnEdit);
        postColumn.setOnEditCommit(this::postColumnEdit);
        IDColumn.setOnEditCommit(this::IDColumnEdit);
        teamColumn.setOnEditCommit(this::teamColumnEdit);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Handling column edits methods------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    private void nameColumnEdit(Event e) {
        TableColumn.CellEditEvent<Persons, String> cellEdit;
        cellEdit = (TableColumn.CellEditEvent<Persons, String>) e;
        Persons persons = cellEdit.getRowValue();
        persons.setName(cellEdit.getNewValue());
    }

    @SuppressWarnings("unchecked")
    private void surnameColumnEdit(Event e) {
        TableColumn.CellEditEvent<Persons, String> cellEdit;
        cellEdit = (TableColumn.CellEditEvent<Persons, String>) e;
        Persons persons = cellEdit.getRowValue();
        persons.setSurname(cellEdit.getNewValue());
    }

    @SuppressWarnings("unchecked")
    private void postColumnEdit(Event e) {
        TableColumn.CellEditEvent<Persons, String> cellEdit;
        cellEdit = (TableColumn.CellEditEvent<Persons, String>) e;
        Persons persons = cellEdit.getRowValue();
        persons.setPost(cellEdit.getNewValue());
    }

    @SuppressWarnings("unchecked")
    private void IDColumnEdit(Event e) {
        TableColumn.CellEditEvent<Persons, Integer> cellEdit;
        cellEdit = (TableColumn.CellEditEvent<Persons, Integer>) e;
        Persons persons = cellEdit.getRowValue();
        persons.setID(cellEdit.getNewValue());
    }

    @SuppressWarnings("unchecked")
    private void teamColumnEdit(Event e) {
        TableColumn.CellEditEvent<Persons, Integer> cellEdit;
        cellEdit = (TableColumn.CellEditEvent<Persons, Integer>) e;
        Persons persons = cellEdit.getRowValue();
        persons.setTeam(cellEdit.getNewValue());
    }
    //------------------------------------------------------------------------------------------------------------------

    // Action methods setup---------------------------------------------------------------------------------------------
    private void actionsPerformed() {
        addPersonAction();
        removePersonAction();
        refreshTableAction();
        clearTableAction();
        saveTableAction();
        loadTableAction();
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

    // Refresh Table method---------------------------------------------------------------------------------------------
    private void refreshTableAction() {
        refreshTable.setOnAction(e -> tableView.refresh());
    }
    //------------------------------------------------------------------------------------------------------------------

    // Clear Table method-----------------------------------------------------------------------------------------------
    private void clearTableAction() {
        clearTable.setOnAction(e -> list.clear());
    }
    //------------------------------------------------------------------------------------------------------------------

    // Add persons method-----------------------------------------------------------------------------------------------
    private void addPersonAction() {
        addButton.setOnAction(e -> {
            Persons person = new Persons("", "", "", 0, 0);
            person.setName(tfName.getText());
            person.setSurname(tfSurname.getText());
            person.setPost(tfPost.getText());
            person.setID(Integer.parseInt(tfID.getText()));
            person.setTeam(Integer.parseInt(tfTeam.getText()));
            tableView.getItems().add(person);
            tfName.clear();
            tfSurname.clear();
            tfPost.clear();
            tfID.clear();
            tfTeam.clear();
        });
    }
    //------------------------------------------------------------------------------------------------------------------

    // Remove persons method--------------------------------------------------------------------------------------------
    private void removePersonAction() {
        removeButton.setOnAction(e -> {
            ObservableList<Persons> selectedPerson, allDetails;
            allDetails = tableView.getItems();
            selectedPerson = tableView.getSelectionModel().getSelectedItems();
            selectedPerson.forEach(allDetails::remove);
        });
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
                    for (Persons persons : list) {
                        toFile.writeUTF(persons.getName());
                        toFile.writeUTF(persons.getSurname());
                        toFile.writeUTF(persons.getPost());
                        toFile.writeInt(persons.getID());
                        toFile.writeInt(persons.getTeam());
                    }
                    toFile.close();
                } catch (IOException ex) {
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
                    Persons persons = new Persons("", "", "", 0, 0);
                    persons.setName(fromFile.readUTF());
                    persons.setSurname(fromFile.readUTF());
                    persons.setPost(fromFile.readUTF());
                    persons.setID(fromFile.readInt());
                    persons.setTeam(fromFile.readInt());
                    tableView.getItems().add(persons);
                }
                fromFile.close();
            } catch (IOException ignored) {
            }
        });
    }
    //------------------------------------------------------------------------------------------------------------------
}
