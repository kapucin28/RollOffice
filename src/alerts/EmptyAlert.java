package alerts;

import interfaces.AlertsInterface;
import javafx.scene.control.*;
import javafx.stage.*;

/**
 * Created by TIMBULI REMUS K@puc!n on 10-Jun-16.
 * <p>
 * Empty alert thrown when tables are empty
 */
public class EmptyAlert {

    // Alert variable---------------------------------------------------------------------------------------------------
    private Alert alert = new Alert(Alert.AlertType.WARNING, AlertsInterface.emptyAlertMessage, ButtonType.CANCEL);
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public EmptyAlert() {
        emptyAlert(alert);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Alert method-----------------------------------------------------------------------------------------------------
    private void emptyAlert(Alert alert) {
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
