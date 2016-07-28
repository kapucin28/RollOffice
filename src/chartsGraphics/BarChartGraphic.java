package chartsGraphics;

import javafx.geometry.Rectangle2D;
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

    // Constructor------------------------------------------------------------------------------------------------------
    public BarChartGraphic(){

    }
    //------------------------------------------------------------------------------------------------------------------
}
