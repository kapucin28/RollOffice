package chartsGraphics;

import javafx.scene.layout.Pane;
import table3.Table3;

/**
 * Created by TIMBULI REMUS K@puc!n on 09-Jun-16.
 * <p>
 * This chart will represent the performance
 * from team 3
 */
public class Table3PieChart extends Pane {

    // Team 3 variable--------------------------------------------------------------------------------------------------
    private Table3 table3 = new Table3("", 0, 0, 0, 0, 0, 0);
    private long scrap = table3.getScrap();
    private long pending = table3.getPending();
    private long output = table3.getOutput();
    private long target = table3.getTarget();
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public Table3PieChart() {

    }
    //------------------------------------------------------------------------------------------------------------------
}
