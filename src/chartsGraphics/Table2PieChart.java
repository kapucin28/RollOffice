package chartsGraphics;

import interfaces.ChartsTitles;
import interfaces.Scale;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import table2.Table2;

/**
 * Created by TIMBULI REMUS K@puc!n on 09-Jun-16.
 * <p>
 * This chart will represent the performance
 * from team 2
 */
public class Table2PieChart extends Pane implements Scale {

    // Table 2 variables------------------------------------------------------------------------------------------------
    private Table2 table2 = new Table2("", 0, 0, 0, 0, 0, 0);
    private long scrap = table2.getScrap();
    private long pending = table2.getPending();
    private long output = table2.getOutput();
    private long target = table2.getTarget();
    //------------------------------------------------------------------------------------------------------------------

    // Chart variables--------------------------------------------------------------------------------------------------
    private final Pane pane = new Pane();
    private PieChart.Data scrapSlice = new PieChart.Data(ChartsTitles.scrapSlice, scrap);
    private PieChart.Data pendingSlice = new PieChart.Data(ChartsTitles.pendingSlice, pending);
    private PieChart.Data outputSlice = new PieChart.Data(ChartsTitles.outputSlice, output);
    private PieChart.Data targetSlice = new PieChart.Data(ChartsTitles.targetSlice, target);

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
        chart.setPrefWidth(SCREEN_WIDTH / 2 - 100);
        chart.setPrefHeight(SCREEN_HEIGHT / 2 - 30);
        chart.setLegendSide(Side.LEFT);
        chart.setTitle(ChartsTitles.performanceTitle);
        pane.setPrefWidth(SCREEN_WIDTH / 2);
        pane.setPrefHeight(SCREEN_HEIGHT / 2);
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
