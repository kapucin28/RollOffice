package table2;

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

    // Constructor------------------------------------------------------------------------------------------------------
    public MainTable2(){

    }
    //------------------------------------------------------------------------------------------------------------------
}
