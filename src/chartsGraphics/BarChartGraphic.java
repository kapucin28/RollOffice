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

    }
    //------------------------------------------------------------------------------------------------------------------
}
