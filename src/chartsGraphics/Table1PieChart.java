package chartsGraphics;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
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
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public Table1PieChart() {

    }
    //------------------------------------------------------------------------------------------------------------------
}
