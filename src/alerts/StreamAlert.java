package alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

/**
 * Created by TIMBULI REMUS K@puc!n on 11-Jun-16.
 */
public class StreamAlert {

    // Alert variable---------------------------------------------------------------------------------------------------
    private Alert alert = new Alert(Alert.AlertType.ERROR, "Stream Error", ButtonType.CANCEL);
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
