package chartsGraphics;

import javafx.animation.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.util.Duration;
import table3.Table3;

/**
 * Created by TIMBULI REMUS K@puc!n on 09-Jun-16.
 * <p>
 * This chart will represent the performance
 * from team 3
 */
public class Table3PieChart extends Pane {

    // Table 3 variables------------------------------------------------------------------------------------------------
    private Table3 table3 = new Table3("", 0, 0, 0, 0, 0, 0);
    private long scrap = table3.getScrap();
    private long pending = table3.getPending();
    private long output = table3.getOutput();
    private long target = table3.getTarget();
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
    public Table3PieChart() {
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
        pane.setPrefWidth(bounds.getWidth() / 2);
        pane.setPrefHeight(bounds.getHeight() / 2);
        pane.getChildren().add(chart);
        getChildren().add(pane);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Chart Animation method-------------------------------------------------------------------------------------------
    private void chartAnimation() {
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), e -> {
            for (PieChart.Data data : chart.getData()) {
                data.setPieValue(Math.random() * 1000);
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.play();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Pie slices method------------------------------------------------------------------------------------------------
    private void slicesSetup() {
        pie.addAll(scrapSlice, pendingSlice, outputSlice, targetSlice);
    }
    //------------------------------------------------------------------------------------------------------------------
}
