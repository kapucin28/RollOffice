package chartsGraphics;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.util.Duration;
import table1.Table1;

/**
 * Created by TIMBULI REMUS K@puc!n on 09-Jun-16.
 * <p>
 * This chart will represent the performance
 * from team 1
 */
public class Table1PieChart extends Pane {

    // Table 1 variable--------------------------------------------------------------------------------------------------
    private Table1 table1 = new Table1("", 0, 0, 0, 0, 0, 0);
    private long scrap = table1.getScrap();
    private long pending = table1.getPending();
    private long output = table1.getOutput();
    private long target = table1.getTarget();
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
    public Table1PieChart() {
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
