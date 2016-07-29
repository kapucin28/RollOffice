package chartsGraphics;

import javafx.geometry.Rectangle2D;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

/**
 * Created by TIMBULI REMUS K@puc!n on 05-Jun-16.
 *
 *      This is the chart that will display
 * combined results from all pie charts
 */
public class BarChartGraphic extends Pane{

    // Pane variables---------------------------------------------------------------------------------------------------
    private final Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
    private final Pane pane = new Pane();
    //------------------------------------------------------------------------------------------------------------------

    // Chart variables--------------------------------------------------------------------------------------------------
    private final String year1 = "2016";
    private final String year2 = "2017";
    private final String year3 = "2018";
    private final String year4 = "2019";
    private final String total = "TOTAL";
    private CategoryAxis xAxis = new CategoryAxis();
    private NumberAxis yAxis = new NumberAxis();

    private BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
    private XYChart.Series series1 = new XYChart.Series();
    private XYChart.Series series2 = new XYChart.Series();
    private XYChart.Series series3 = new XYChart.Series();
    private XYChart.Series series4 = new XYChart.Series();
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public BarChartGraphic(){
        seriesSetup();
        paneSetup();
        getChildren().add(pane);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Series setup method----------------------------------------------------------------------------------------------
    @SuppressWarnings({"rawtypes", "unchecked"})
    private void seriesSetup() {
        series1.setName("2016");
        series2.setName("2017");
        series3.setName("2018");
        series4.setName("Overall");

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
        barChart.setPrefWidth(bounds.getWidth() / 2);
        barChart.setTitle("Performance");
        xAxis.setLabel("Teams");
        yAxis.setLabel("Performance");
        barChart.getData().addAll(series1, series2, series3, series4);
        pane.setPrefWidth(bounds.getWidth() / 2);
        pane.setPrefHeight(bounds.getHeight() / 2);
        pane.getChildren().add(barChart);
    }
    //------------------------------------------------------------------------------------------------------------------
}
