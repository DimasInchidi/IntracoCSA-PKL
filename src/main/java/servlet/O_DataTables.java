package servlet;

/**
 * Created by inchidi on 22/11/15.
 */
public class O_DataTables {
    private int ComboProjectHomeIndex, TahunDataHome, BulanDataHome;
    private String ComboProjectHomeItem, TableMonth, TableAVB, TableYTD, DataProyek;

    public int getBulanDataHome() {
        return BulanDataHome;
    }

    public int getComboProjectHomeIndex() {
        return ComboProjectHomeIndex;
    }

    public int getTahunDataHome() {
        return TahunDataHome;
    }

    public String getComboProjectHomeItem() {
        return ComboProjectHomeItem;
    }

    public void setTableMonth(String tableMonth) {
        TableMonth = tableMonth;
    }

    public void setTableAVB(String tableAVB) {
        TableAVB = tableAVB;
    }

    public void setTableYTD(String tableYTD) {
        TableYTD = tableYTD;
    }

    public void setDataProyek(String dataProyek) {
        DataProyek = dataProyek;
    }

    public String getDataProyek() {
        return DataProyek;
    }

    public void setBulanDataHome(int bulanDataHome) {
        BulanDataHome = bulanDataHome;
    }

    public void setTahunDataHome(int tahunDataHome) {
        TahunDataHome = tahunDataHome;
    }

    public void setComboProjectHomeIndex(int comboProjectHomeIndex) {
        ComboProjectHomeIndex = comboProjectHomeIndex;
    }

    public void setComboProjectHomeItem(String comboProjectHomeItem) {
        ComboProjectHomeItem = comboProjectHomeItem;
    }

    public String getTableMonth(){ return TableMonth; }

    public String getTableAVB(){
        return TableAVB;
    }

    public String getTableYTD() {
        return TableYTD;
    }


}
