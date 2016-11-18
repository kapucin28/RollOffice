package alerts;

import interfaces.AlertsInterface;
import javafx.scene.control.*;
import javafx.stage.*;

/**
 * Created by TIMBULI REMUS K@puc!n on 11-Jun-16.
 * <p>
 * Alert thrown when the program tries to save/load
 * empty files
 */
public class StreamAlert {

    // Alert variable---------------------------------------------------------------------------------------------------
    private Alert alert = new Alert(Alert.AlertType.ERROR,
            AlertsInterface.streamAlertMessage, ButtonType.CANCEL);
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public StreamAlert() {
        streamAlert(alert);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Alert method-----------------------------------------------------------------------------------------------------
    private void streamAlert(Alert alert) {
        this.alert = alert;
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initStyle(StageStyle.TRANSPARENT);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.CANCEL) {
            alert.close();
        }
    }
    //------------------------------------------------------------------------------------------------------------------
}
