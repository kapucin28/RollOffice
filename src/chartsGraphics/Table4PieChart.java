package chartsGraphics;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import table4.Table4;

/**
 * Created by TIMBULI REMUS K@puc!n on 09-Jun-16.
 * <p>
 * This chart will represent the performance
 * from team 4
 */
public class Table4PieChart extends Pane {

    // Table 4 variables------------------------------------------------------------------------------------------------
    private Table4 table4 = new Table4("", 0, 0, 0, 0, 0, 0);
    private long scrap = table4.getScrap();
    private long pending = table4.getPending();
    private long output = table4.getOutput();
    private long target = table4.getTarget();
    //------------------------------------------------------------------------------------------------------------------

    // Chart variables--------------------------------------------------------------------------------------------------
    private final Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
    private final Pane pane = new Pane();
    private PieChart.Data scrapSlice = new PieChart.Data("Scrap", scrap);
    private PieChart.Data pendingSlice = new PieChart.Data("Pending", pending);
    private PieChart.Data outputSlice = new PieChart.Data("Output", output);
    private PieChart.Data targetSlice = new PieChart.Data("Target", target);

    private ObservableList<PieChart.Data> pie = FXCollections.observableArrayList();
    private PieChart chart = new PieChart(pie);
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public Table4PieChart() {

    }
    //------------------------------------------------------------------------------------------------------------------
}
