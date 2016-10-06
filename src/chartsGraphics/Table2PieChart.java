package chartsGraphics;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import table2.Table2;

/**
 * Created by TIMBULI REMUS K@puc!n on 09-Jun-16.
 * <p>
 * This chart will represent the performance
 * from team 2
 */
public class Table2PieChart extends Pane {

    // Table 2 variables------------------------------------------------------------------------------------------------
    private Table2 table2 = new Table2("", 0, 0, 0, 0, 0, 0);
    private long scrap = table2.getScrap();
    private long pending = table2.getPending();
    private long output = table2.getOutput();
    private long target = table2.getTarget();
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
    public Table2PieChart() {
        slicesSetup();
        chartAnimation();
        chartSetup();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Chart setup method-----------------------------------------------------------------------------------------------
    private void chartSetup() {
        chart.setPrefWidth(bounds.getWidth() / 2 - 100);
        chart.setPrefHeight(bounds.getHeight() / 2 - 30);
        chart.setLegendSide(Side.LEFT);
        chart.setTitle("Performance");
    }
    //------------------------------------------------------------------------------------------------------------------

    // Pie slices method------------------------------------------------------------------------------------------------
    private void slicesSetup() {
        pie.addAll(scrapSlice, pendingSlice, outputSlice, targetSlice);
    }
    //------------------------------------------------------------------------------------------------------------------
}
