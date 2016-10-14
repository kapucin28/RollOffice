package chartsGraphics;

import javafx.geometry.Rectangle2D;
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
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public Table4PieChart() {

    }
    //------------------------------------------------------------------------------------------------------------------
}
