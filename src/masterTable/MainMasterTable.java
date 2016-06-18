package masterTable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by TIMBULI REMUS K@puc!n on 08-Jun-16.
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

    // Constructor------------------------------------------------------------------------------------------------------
    public MainMasterTable(){

    }
    //------------------------------------------------------------------------------------------------------------------
}
