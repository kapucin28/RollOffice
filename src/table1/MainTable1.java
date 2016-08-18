package table1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

/**
 * Created by TIMBULI REMUS K@puc!n on 07-Jun-16.
 *
 *      This class represents the table for
 * team 1
 */
public class MainTable1 extends Pane {

    // Random test variables--------------------------------------------------------------------------------------------
    private Table1 table1 = new Table1("", 0, 0, 0, 0, 0, 0);
    //------------------------------------------------------------------------------------------------------------------

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
    private final TableView<Table1> tableView = new TableView<>();
    private final TableColumn<Table1, String> postColumn = new TableColumn<>("Post");
    private final TableColumn<Table1, Long> scrapColumn = new TableColumn<>("Scrap");
    private final TableColumn<Table1, Long> pendingColumn = new TableColumn<>("Pending");
    private final TableColumn<Table1, Long> outputColumn = new TableColumn<>("Output");
    private final TableColumn<Table1, Long> targetColumn = new TableColumn<>("Target");
    private final TableColumn<Table1, Long> monthColumn = new TableColumn<>("Month");
    private final TableColumn<Table1, Long> yearColumn = new TableColumn<>("Year");
    private ObservableList<Table1> list = FXCollections.observableArrayList();
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public MainTable1(){

    }
    //------------------------------------------------------------------------------------------------------------------
}
