package servlet;

import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 * Created by inchidi on 27/11/15.
 */
public class O_DataDetails {

    private static final Logger LOG = getLogger(O_DataDetails.class.getName());

    private String[][] dataTarget, dataActual;

    public String[][] getDataTarget() {
        return dataTarget;
    }

    public void setDataTarget(String[][] dataTarget) {
        this.dataTarget = dataTarget;
    }

    public String[][] getDataActual() {
        return dataActual;
    }

    public void setDataActual(String[][] dataActual) {
        this.dataActual = dataActual;
    }

    public O_DataDetails() {
    }

}
