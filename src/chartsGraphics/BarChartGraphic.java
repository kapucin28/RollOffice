package chartsGraphics;

import interfaces.ChartsTitles;
import interfaces.Scale;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.chart.*;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * Created by TIMBULI REMUS K@puc!n on 05-Jun-16.
 * <p>
 * This is the chart that will display
 * combined results from all pie charts
 */
public class BarChartGraphic extends Pane implements Scale {

    // Pane variables---------------------------------------------------------------------------------------------------
    private final Pane pane = new Pane();
    //------------------------------------------------------------------------------------------------------------------

    // Chart variables--------------------------------------------------------------------------------------------------
    private static final String year1 = ChartsTitles.year1;
    private static final String year2 = ChartsTitles.year2;
    private static final String year3 = ChartsTitles.year3;
    private static final String year4 = ChartsTitles.year4;
    private static final String total = ChartsTitles.total;
    private static CategoryAxis xAxis = new CategoryAxis();
    private static NumberAxis yAxis = new NumberAxis();

    private BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
    private XYChart.Series series1 = new XYChart.Series();
    private XYChart.Series series2 = new XYChart.Series();
    private XYChart.Series series3 = new XYChart.Series();
    private XYChart.Series series4 = new XYChart.Series();
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public BarChartGraphic() {
        CSSStyle();
        chartAnimation();
        seriesSetup();
        paneSetup();
        getChildren().add(pane);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Chart animation method-------------------------------------------------------------------------------------------
    private void chartAnimation() {
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), e -> {
            for (XYChart.Series<String, Number> series : barChart.getData()) {
                for (XYChart.Data<String, Number> data : series.getData()) {
                    data.setYValue(Math.random() * 1000);
                }
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.play();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Series setup method----------------------------------------------------------------------------------------------
    @SuppressWarnings({"rawtypes", "unchecked"})
    private void seriesSetup() {
        series1.setName(ChartsTitles.year1);
        series2.setName(ChartsTitles.year2);
        series3.setName(ChartsTitles.year3);
        series4.setName(ChartsTitles.overall);

        series1.getData().add(new XYChart.Data(year1, 1000));
        series1.getData().add(new XYChart.Data(year2, 2000));
        series1.getData().add(new XYChart.Data(year3, 3000));
        series1.getData().add(new XYChart.Data(year4, 4000));
        series1.getData().add(new XYChart.Data(total, 10000));

        series2.getData().add(new XYChart.Data(year1, 4000));
        series2.getData().add(new XYChart.Data(year2, 3000));
        series2.getData().add(new XYChart.Data(year3, 2000));
        series2.getData().add(new XYChart.Data(year4, 1000));
        series2.getData().add(new XYChart.Data(total, 10000));

        series3.getData().add(new XYChart.Data(year1, 1000));
        series3.getData().add(new XYChart.Data(year2, 3000));
        series3.getData().add(new XYChart.Data(year3, 1000));
        series3.getData().add(new XYChart.Data(year4, 4000));
        series3.getData().add(new XYChart.Data(total, 9000));

        series4.getData().add(new XYChart.Data(year1, 5000));
        series4.getData().add(new XYChart.Data(year2, 4000));
        series4.getData().add(new XYChart.Data(year3, 4000));
        series4.getData().add(new XYChart.Data(year4, 5000));
        series4.getData().add(new XYChart.Data(total, 18000));
    }
    //------------------------------------------------------------------------------------------------------------------

    // Pane setup method------------------------------------------------------------------------------------------------
    private void paneSetup() {
        barChart.setPrefWidth(SCREEN_WIDTH / 2);
        barChart.setTitle(ChartsTitles.performanceTitle);
        xAxis.setLabel(ChartsTitles.teamsTitle);
        yAxis.setLabel(ChartsTitles.performanceTitle);
        barChart.getData().addAll(series1, series2, series3, series4);
        pane.setPrefWidth(SCREEN_WIDTH / 2);
        pane.setPrefHeight(SCREEN_HEIGHT / 2);
        pane.getChildren().add(barChart);
    }
    //------------------------------------------------------------------------------------------------------------------

    // CSS style method-------------------------------------------------------------------------------------------------
    private void CSSStyle() {
        xAxis.getStyleClass().add("xAxisStyle");
        yAxis.getStyleClass().add("YAxisStyle");
        barChart.getStyleClass().add("barChartStyle");
        pane.getStyleClass().add("barChartPane");
    }
    //------------------------------------------------------------------------------------------------------------------
}
