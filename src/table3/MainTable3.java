package table3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by TIMBULI REMUS K@puc!n on 07-Jun-16.
 *
 *      This class represents the table for
 * team 3
 */
public class MainTable3 extends Pane{

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
    public MainTable3(){

    }
    //------------------------------------------------------------------------------------------------------------------
}
