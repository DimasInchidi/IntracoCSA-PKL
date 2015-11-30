package servlet;

import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 * Created by inchidi on 22/11/15.
 */
public class O_DataTables {

    private static final Logger LOG = getLogger(O_DataTables.class.getName());
    private int ComboProjectHomeIndex, TahunDataHome, BulanDataHome;
    private String ComboProjectHomeItem, TableMonth, TableAVB, TableYTD, DataProyek;

    /**
     *
     * @return
     */
    public int getBulanDataHome() {
        return BulanDataHome;
    }

    /**
     *
     * @return
     */
    public int getComboProjectHomeIndex() {
        return ComboProjectHomeIndex;
    }

    /**
     *
     * @return
     */
    public int getTahunDataHome() {
        return TahunDataHome;
    }

    /**
     *
     * @return
     */
    public String getComboProjectHomeItem() {
        return ComboProjectHomeItem;
    }

    /**
     *
     * @param tableMonth
     */
    public void setTableMonth(String tableMonth) {
        TableMonth = tableMonth;
    }

    /**
     *
     * @param tableAVB
     */
    public void setTableAVB(String tableAVB) {
        TableAVB = tableAVB;
    }

    /**
     *
     * @param tableYTD
     */
    public void setTableYTD(String tableYTD) {
        TableYTD = tableYTD;
    }

    /**
     *
     * @param dataProyek
     */
    public void setDataProyek(String dataProyek) {
        DataProyek = dataProyek;
    }

    /**
     *
     * @return
     */
    public String getDataProyek() {
        return DataProyek;
    }

    /**
     *
     * @param bulanDataHome
     */
    public void setBulanDataHome(int bulanDataHome) {
        BulanDataHome = bulanDataHome;
    }

    /**
     *
     * @param tahunDataHome
     */
    public void setTahunDataHome(int tahunDataHome) {
        TahunDataHome = tahunDataHome;
    }

    /**
     *
     * @param comboProjectHomeIndex
     */
    public void setComboProjectHomeIndex(int comboProjectHomeIndex) {
        ComboProjectHomeIndex = comboProjectHomeIndex;
    }

    /**
     *
     * @param comboProjectHomeItem
     */
    public void setComboProjectHomeItem(String comboProjectHomeItem) {
        ComboProjectHomeItem = comboProjectHomeItem;
    }

    /**
     *
     * @return
     */
    public String getTableMonth(){ return TableMonth; }

    /**
     *
     * @return
     */
    public String getTableAVB(){
        return TableAVB;
    }

    /**
     *
     * @return
     */
    public String getTableYTD() {
        return TableYTD;
    }


}
