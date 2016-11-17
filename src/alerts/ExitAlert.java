package alerts;

import interfaces.AlertsInterface;
import javafx.scene.control.*;
import javafx.stage.*;

/**
 * Created by TIMBULI REMUS K@puc!n on 02-Jun-16.
 * <p>
 * Alert thrown when exiting the program
 */
public class ExitAlert {

    // Alert variable---------------------------------------------------------------------------------------------------
    private Alert alert = new Alert(Alert.AlertType.CONFIRMATION, AlertsInterface.exitProgramMessage,
            ButtonType.OK, ButtonType.CANCEL);
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public ExitAlert() {
        exitAlert(alert);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Alert method-----------------------------------------------------------------------------------------------------
    private void exitAlert(Alert alert) {
        this.alert = alert;
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initStyle(StageStyle.TRANSPARENT);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            System.exit(0);
        } else {
            alert.close();
        }
    }
    //------------------------------------------------------------------------------------------------------------------
}
