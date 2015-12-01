/*
 * Inchidi Commercial License
 * Copyright 2015 inchidi.
 * This program is created and owned by dimas ari ;
 * you CAN NOT redistribute it and/or modify it without owner permit
 * Inchidi, Samarinda, Kalimantan Timur, +62812 7777 9663, Indonesia.
 */
package servlet;

import static java.lang.Double.parseDouble;
import static java.lang.Math.round;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import static org.apache.commons.lang3.ArrayUtils.toPrimitive;

/**
 *
 * @author DimasInchidi
 */
public class F_Function extends F_Koneksi {

    DecimalFormat RpDoubleFormat = new DecimalFormat("#,###.##;(#,###.##)");

    /**
     *
     */
    final public Object[] Desk = {
            "SPARE PARTS",
            "SERVICE (LABOUR)/SMC",
            "FULL MAINTENANCE CONTRACT/FMS",
            "REVENUE",
            "COST OF SALES (SPARE PARTS)",
            "COST OF SALES (SERVICE)",
            "TOTAL COGS",
            "GROSS PROFIT",
            "EXPENSES",
            "OPR. PROFIT"
    };

    /**
     *
     */
    public String[] TempData; //index 0 for String key
    final String[] kolomDB = {"Spare Parts", "SMC", "FMC", "REVENUE", "COST OF SALES (SPARE PARTS)", "COST OF SALES (SERVICE)", "Periodic Maintenance", "Part Repair", "Part R & I", "Component", "GET & Undercarriage Group", "Warranty & Campaign", "Consumable", "TOTAL COGS", "GROSS PROFIT", "EXPENSES", "Employee Expenses", "Asset Depreciation", "Operation Expenses", "OPR. PROFIT", "PROFIT % OF SALES"};

    /**
     *
     * @param tsk
     * @param tahun
     * @param bulan
     * @param project
     * @param dtiA
     * @param dtiT
     * @return
     */
    public O_DataInput InputData(String tsk, int tahun, int bulan, String project, Object dtiA, Object dtiT){
        O_DataInput data = new O_DataInput();
        String[] datainputActual = (String[]) dtiA;
        String[] datainputTarget = (String[]) dtiT;
        data.setBulanDataHome(bulan);
        data.setTahunDataHome(tahun);
        data.setComboProjectHomeItem(project);
        data.setDataProyek(DataProyekInput("TOTAL CSA GOLD", project));

        if (!tsk.equals("calculate")){
            ReloadTextData(project,bulan,tahun,"Actual", data);
            ReloadTextData(project,bulan,tahun,"Target", data);
        } else {
            //actual data
            data.setSPAREPARTS_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[0])));
            data.setSMC_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[1])));
            data.setFMS_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[2])));
            data.setREVENUE_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[3])));
            data.setCOSTOFSALES_SPAREPARTS__Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[5])));
            data.setCOSTOFSALES_SERVICE__Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[4])));
            data.setPeriodicMaintenance_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[6])));
            data.setPartRepair_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[7])));
            data.setPartRAndI_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[8])));
            data.setComponent_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[9])));
            data.setGETAndUndercarriageGroup_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[10])));
            data.setWarrantyAndCampaign_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[11])));
            data.setConsumable_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[12])));
            data.setTOTALCOGS_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[13])));
            data.setGROSSPROFIT_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[14])));
            data.setEXPENSES_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[15])));
            data.setEmployeeExpenses_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[16])));
            data.setAssetDepreciation_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[17])));
            data.setOperationExpenses_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[18])));
            data.setOPRPROFIT_Actual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[19])));
            data.setPROFITPercentOFSALESActual(RpDoubleFormat.format(1_000 * parseDouble(datainputActual[20])));

            //target data
            data.setSPAREPARTS_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[0])));
            data.setSMC_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[1])));
            data.setFMS_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[2])));
            data.setREVENUE_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[3])));
            data.setCOSTOFSALES_SPAREPARTS__Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[5])));
            data.setCOSTOFSALES_SERVICE__Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[4])));
            data.setPeriodicMaintenance_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[6])));
            data.setPartRepair_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[7])));
            data.setPartRAndI_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[8])));
            data.setComponent_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[9])));
            data.setGETAndUndercarriageGroup_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[10])));
            data.setWarrantyAndCampaign_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[11])));
            data.setConsumable_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[12])));
            data.setTOTALCOGS_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[13])));
            data.setGROSSPROFIT_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[14])));
            data.setEXPENSES_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[15])));
            data.setEmployeeExpenses_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[16])));
            data.setAssetDepreciation_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[17])));
            data.setOperationExpenses_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[18])));
            data.setOPRPROFIT_Target(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[19])));
            data.setPROFITPercentOFSALESTarget(RpDoubleFormat.format(1_000 * parseDouble(datainputTarget[20])));
        }
                return data;
    }

    private void ReloadTextData(String project, int bulan, int tahun, String tipe, O_DataInput data) {
        if (!SetTempData("SELECT * FROM `DetailRincian` WHERE `Project`= '" + project + "' AND `Bulan`='" + bulan + "' AND `Tahun`='" + tahun + "' AND `Tipe`='" + tipe + "'",
                26, null, null)) {
            InsertData("INSERT INTO `DetailRincian` (`Project`, `Bulan`, `Tahun`, `Tipe`) VALUES ('" + project + "', '" + bulan + "', '" + tahun + "', '" + tipe + "')",
                    26, "0");
        }
        if (tipe.equals("Target")) {

            //revenue
            data.setSPAREPARTS_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[5])));
            data.setSMC_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[1 + 5])));
            data.setFMS_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[2 + 5])));
            data.setREVENUE_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[3 + 5])));
            //cost
            data.setCOSTOFSALES_SPAREPARTS__Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[4 + 5])));
            data.setCOSTOFSALES_SERVICE__Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[5 + 5])));

            data.setPeriodicMaintenance_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[6 + 5])));
            data.setPartRepair_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[7 + 5])));
            data.setPartRAndI_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[8 + 5])));
            data.setComponent_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[9 + 5])));
            data.setGETAndUndercarriageGroup_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[10 + 5])));
            data.setWarrantyAndCampaign_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[11 + 5])));
            data.setConsumable_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[12 + 5])));

            //TODO: sebelumnya ga ada
            data.setTOTALCOGS_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[13 + 5])));
            data.setGROSSPROFIT_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[14 + 5])));
            //expenses
            data.setEXPENSES_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[15 + 5])));
            data.setEmployeeExpenses_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[16 + 5])));
            data.setAssetDepreciation_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[17 + 5])));
            data.setOperationExpenses_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[18 + 5])));

            //TODO: sebelumnya ga ada juga
            data.setOPRPROFIT_Target(RpDoubleFormat.format(1_000 * parseDouble(TempData[19 + 5])));
            data.setPROFITPercentOFSALESTarget(RpDoubleFormat.format(100 * parseDouble(TempData[20 + 5])));

        } else {

            data.setSPAREPARTS_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[5])));
            data.setSMC_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[1 + 5])));
            data.setFMS_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[2 + 5])));
            data.setREVENUE_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[3 + 5])));
            data.setCOSTOFSALES_SPAREPARTS__Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[4 + 5])));
            data.setCOSTOFSALES_SERVICE__Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[5 + 5])));
            data.setPeriodicMaintenance_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[6 + 5])));
            data.setPartRepair_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[7 + 5])));
            data.setPartRAndI_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[8 + 5])));
            data.setComponent_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[9 + 5])));
            data.setGETAndUndercarriageGroup_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[10 + 5])));
            data.setWarrantyAndCampaign_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[11 + 5])));
            data.setConsumable_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[12 + 5])));
            data.setTOTALCOGS_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[13 + 5])));
            data.setGROSSPROFIT_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[14 + 5])));
            data.setEXPENSES_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[15 + 5])));
            data.setEmployeeExpenses_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[16 + 5])));
            data.setAssetDepreciation_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[17 + 5])));
            data.setOperationExpenses_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[18 + 5])));
            data.setOPRPROFIT_Actual(RpDoubleFormat.format(1_000 * parseDouble(TempData[19 + 5])));
            data.setPROFITPercentOFSALESActual(RpDoubleFormat.format(100 * parseDouble(TempData[20 + 5])));
        }
    }

    /**
     *
     * @param level
     * @return
     */
    public O_DataDetails DataDetails(String level){
        O_DataDetails data = new O_DataDetails();

        return data;
    }

    /**
     *
     * @param tahun
     * @param bulan
     * @param projectindex
     * @param project
     * @return
     */
    public O_DataTables TableData(int tahun, int bulan, int projectindex, String project){
        O_DataTables tables = new O_DataTables();
        tables.setTahunDataHome(tahun);
        tables.setBulanDataHome(bulan);
        tables.setComboProjectHomeItem(project);
        tables.setComboProjectHomeIndex(projectindex);
        tables.setDataProyek(DataProyek("TOTAL CSA GOLD", project));
        tables.setTableAVB(TableAVB(tahun,bulan,project,projectindex));
        tables.setTableMonth(TableMonth(tahun,bulan,project,projectindex));
        tables.setTableYTD(TableYTD(tahun,bulan,project,projectindex));
        return tables;
    }

    /**
     *
     * @param Head
     * @param Selected
     * @return
     */
    public String DataProyek(String Head, String Selected){
        String hasil = "<select name=\"project\" class=\"form-control\">";
        for (String Hasil : SetCombo("SELECT `Project` FROM `DetailRincian` group by `Project`", Head)){
            if (Hasil.equals(Selected)){
                hasil += "<option selected name=\"" + Hasil + "\">" + Hasil + "</option>";
            }else {
                hasil += "<option name=\"" + Hasil + "\">" + Hasil + "</option>";
            }
        }

        hasil+= "</select>";
        return hasil;
    }

    /**
     *
     * @param Head
     * @param Selected
     * @return
     */
    public String DataProyekInput(String Head,String Selected){
        String hasil = "<select name=\"project\" class=\"form-control\">";
        for (String Hasil : SetCombo("SELECT `Project` FROM `DetailRincian` group by `Project`", Head)){
            if (!Hasil.equals(Head)){
                if (Hasil.equals(Selected)){
                    hasil += "<option selected name=\"" + Hasil + "\">" + Hasil + "</option>";
                }else {
                    hasil += "<option name=\"" + Hasil + "\">" + Hasil + "</option>";
                }
            }
        }

        hasil+= "</select>";
        return hasil;
    }

    /**
     *
     * @param TahunDataHome
     * @param BulanDataHome
     * @param ComboProjectHomeItem
     * @param ComboProjectHomeIndex
     * @return
     */
    public String TableMonth(int TahunDataHome, int BulanDataHome, String ComboProjectHomeItem,int ComboProjectHomeIndex) {
        String Query1;
        String Query2;
        if (ComboProjectHomeIndex == 0) {
            Query1 = "SELECT sum(`Spare Parts`), sum(`SMC`), sum(`FMC`), sum(`REVENUE`), sum(`COST OF SALES (SPARE PARTS)`), sum(`COST OF SALES (SERVICE)`), sum(`TOTAL COGS`), sum(`GROSS PROFIT`), sum(`EXPENSES`), sum(`OPR. PROFIT`) FROM `DetailRincian` WHERE `Tahun`='" + TahunDataHome + "' and `Bulan`='" + BulanDataHome + "' and `Tipe`='Target'";
            Query2 = "SELECT sum(`Spare Parts`), sum(`SMC`), sum(`FMC`), sum(`REVENUE`), sum(`COST OF SALES (SPARE PARTS)`), sum(`COST OF SALES (SERVICE)`), sum(`TOTAL COGS`), sum(`GROSS PROFIT`), sum(`EXPENSES`), sum(`OPR. PROFIT`) FROM `DetailRincian` WHERE `Tahun`='" + TahunDataHome + "' and `Bulan`='" + BulanDataHome + "' and `Tipe`='Actual'";
        } else {
            Query1 = "SELECT sum(`Spare Parts`), sum(`SMC`), sum(`FMC`), sum(`REVENUE`), sum(`COST OF SALES (SPARE PARTS)`), sum(`COST OF SALES (SERVICE)`), sum(`TOTAL COGS`), sum(`GROSS PROFIT`), sum(`EXPENSES`), sum(`OPR. PROFIT`) FROM `DetailRincian` WHERE `Project`='" + ComboProjectHomeItem + "' and `Tahun`='" + TahunDataHome + "' and `Bulan`='" + BulanDataHome + "' and `Tipe`='Target'";
            Query2 = "SELECT sum(`Spare Parts`), sum(`SMC`), sum(`FMC`), sum(`REVENUE`), sum(`COST OF SALES (SPARE PARTS)`), sum(`COST OF SALES (SERVICE)`), sum(`TOTAL COGS`), sum(`GROSS PROFIT`), sum(`EXPENSES`), sum(`OPR. PROFIT`) FROM `DetailRincian` WHERE `Project`='" + ComboProjectHomeItem + "' and `Tahun`='" + TahunDataHome + "' and `Bulan`='" + BulanDataHome + "' and `Tipe`='Actual'";
        }
        return SetTableDataReview(Query1, Query2);
    }

    /**
     *
     * @param TahunDataHome
     * @param BulanDataHome
     * @param ComboProjectHomeItem
     * @param ComboProjectHomeIndex
     * @return
     */
    public String TableAVB(int TahunDataHome, int BulanDataHome, String ComboProjectHomeItem,int ComboProjectHomeIndex) {
        String Query1;
        String Query2;
        if (ComboProjectHomeIndex == 0) {
            Query1 = "SELECT sum(`Spare Parts`), sum(`SMC`), sum(`FMC`), sum(`REVENUE`), sum(`COST OF SALES (SPARE PARTS)`), sum(`COST OF SALES (SERVICE)`), sum(`TOTAL COGS`), sum(`GROSS PROFIT`), sum(`EXPENSES`), sum(`OPR. PROFIT`) FROM `DetailRincian` WHERE `Tahun`='" + TahunDataHome + "' and `Tipe`='Target'";
            Query2 = "SELECT sum(`Spare Parts`), sum(`SMC`), sum(`FMC`), sum(`REVENUE`), sum(`COST OF SALES (SPARE PARTS)`), sum(`COST OF SALES (SERVICE)`), sum(`TOTAL COGS`), sum(`GROSS PROFIT`), sum(`EXPENSES`), sum(`OPR. PROFIT`) FROM `DetailRincian` WHERE `Tahun`='" + TahunDataHome + "' and `Bulan`<='" + BulanDataHome + "' and `Tipe`='Actual'";
        } else {
            Query1 = "SELECT sum(`Spare Parts`), sum(`SMC`), sum(`FMC`), sum(`REVENUE`), sum(`COST OF SALES (SPARE PARTS)`), sum(`COST OF SALES (SERVICE)`), sum(`TOTAL COGS`), sum(`GROSS PROFIT`), sum(`EXPENSES`), sum(`OPR. PROFIT`) FROM `DetailRincian` WHERE `Project`='" + ComboProjectHomeItem + "' and `Tahun`='" + TahunDataHome + "' and `Tipe`='Target'";
            Query2 = "SELECT sum(`Spare Parts`), sum(`SMC`), sum(`FMC`), sum(`REVENUE`), sum(`COST OF SALES (SPARE PARTS)`), sum(`COST OF SALES (SERVICE)`), sum(`TOTAL COGS`), sum(`GROSS PROFIT`), sum(`EXPENSES`), sum(`OPR. PROFIT`) FROM `DetailRincian` WHERE `Project`='" + ComboProjectHomeItem + "' and `Tahun`='" + TahunDataHome + "' and `Bulan`<='" + BulanDataHome + "' and `Tipe`='Actual'";
        }
        return (SetTableDataReview(Query1, Query2));
    }

    /**
     *
     * @param TahunDataHome
     * @param BulanDataHome
     * @param ComboProjectHomeItem
     * @param ComboProjectHomeIndex
     * @return
     */
    public String TableYTD(int TahunDataHome, int BulanDataHome, String ComboProjectHomeItem, int ComboProjectHomeIndex) {
        String Query1;
        String Query2;
        if (ComboProjectHomeIndex == 0) {
            Query1 = "SELECT sum(`Spare Parts`), sum(`SMC`), sum(`FMC`), sum(`REVENUE`), sum(`COST OF SALES (SPARE PARTS)`), sum(`COST OF SALES (SERVICE)`), sum(`TOTAL COGS`), sum(`GROSS PROFIT`), sum(`EXPENSES`), sum(`OPR. PROFIT`) FROM `DetailRincian` WHERE `Tahun`='" + TahunDataHome + "' and `Bulan`<='" + BulanDataHome + "' and `Tipe`='Target'";
            Query2 = "SELECT sum(`Spare Parts`), sum(`SMC`), sum(`FMC`), sum(`REVENUE`), sum(`COST OF SALES (SPARE PARTS)`), sum(`COST OF SALES (SERVICE)`), sum(`TOTAL COGS`), sum(`GROSS PROFIT`), sum(`EXPENSES`), sum(`OPR. PROFIT`) FROM `DetailRincian` WHERE `Tahun`='" + TahunDataHome + "' and `Bulan`<='" + BulanDataHome + "' and `Tipe`='Actual'";
        } else {
            Query1 = "SELECT sum(`Spare Parts`), sum(`SMC`), sum(`FMC`), sum(`REVENUE`), sum(`COST OF SALES (SPARE PARTS)`), sum(`COST OF SALES (SERVICE)`), sum(`TOTAL COGS`), sum(`GROSS PROFIT`), sum(`EXPENSES`), sum(`OPR. PROFIT`) FROM `DetailRincian` WHERE `Project`='" + ComboProjectHomeItem + "' and `Tahun`='" + TahunDataHome + "' and `Bulan`<='" + BulanDataHome + "' and `Tipe`='Target'";
            Query2 = "SELECT sum(`Spare Parts`), sum(`SMC`), sum(`FMC`), sum(`REVENUE`), sum(`COST OF SALES (SPARE PARTS)`), sum(`COST OF SALES (SERVICE)`), sum(`TOTAL COGS`), sum(`GROSS PROFIT`), sum(`EXPENSES`), sum(`OPR. PROFIT`) FROM `DetailRincian` WHERE `Project`='" + ComboProjectHomeItem + "' and `Tahun`='" + TahunDataHome + "' and `Bulan`<='" + BulanDataHome + "' and `Tipe`='Actual'";
        }
        return (SetTableDataReview(Query1, Query2));
    }

    /**
     *
     * @param Query
     * @param colCount
     * @param Static
     * @param fromDouble
     * @return
     */
    public boolean SetTempData(String Query, int colCount, String Static, boolean[] fromDouble) {
        try {
            try (ResultSet rs = Select(Query)) {
                rs.next();
                List<String> dokumenList = new ArrayList<>();
                dokumenList.add(Static);
                for (int i = 1; i < colCount; i++) {
                    if (fromDouble != null && fromDouble[i]) {
                        Double nile = rs.getDouble(i);
                        dokumenList.add(Integer.toString(round(nile.floatValue())));
                    } else {
                        dokumenList.add(rs.getString(i));
                    }
                    rs.next();
                }
                TempData = new String[dokumenList.size()];
                TempData = dokumenList.toArray(TempData);
            }
            return true;
        } catch (SQLException | java.lang.NullPointerException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     *
     * @param Query
     * @return
     */
    public String[] SetTempData(String Query) {
        String[] cm;
        try {
            try (ResultSet rs = Select(Query)) {
                rs.next();
                List<String> dokumenList = new ArrayList<>();
                while (!rs.isAfterLast()) {
                    Double nile = rs.getDouble(1);
                    dokumenList.add(Integer.toString(round(nile.floatValue())));
                    rs.next();
                }
                String[] docArr = new String[dokumenList.size()];
                docArr = dokumenList.toArray(docArr);
                cm = docArr;
            }
        } catch (SQLException ex) {
            List<String> dokumenList = new ArrayList<>();
                dokumenList.add("0");

            String[] docArr = new String[dokumenList.size()];
            docArr = dokumenList.toArray(docArr);
            cm = docArr;
        }
        return cm;
    }

    /**
     *
     * @param Query
     * @param colCount
     * @param Replacer
     * @return
     */
    public boolean InsertData(String Query, int colCount, String Replacer) {
        if (Replacer != null) {
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < colCount; i++) {
                dataList.add(Replacer);
            }
            TempData = new String[dataList.size()];
            TempData = dataList.toArray(TempData);
        }
        return Update(Query);
    }

    /**
     *
     * @param Query
     * @param Header
     * @return
     */
    public String[] SetCombo(String Query, String Header) {
        String[] cm;
        try {
            try (ResultSet rs = Select(Query)) {
                rs.next();
                List<String> dokumenList = new ArrayList<>();
                if (Header != null) {
                    dokumenList.add(Header);
                }
                while (!rs.isAfterLast()) {
                    if (Header != null && !Header.equals(rs.getString(1))) {
                        dokumenList.add(rs.getString(1));
                    }
                    rs.next();
                }
                String[] docArr = new String[dokumenList.size()];
                docArr = dokumenList.toArray(docArr);
                cm = docArr;
            }
        } catch (SQLException ex) {
            List<String> dokumenList = new ArrayList<>();
            if (Header != null) {
                dokumenList.add(Header);
            } else {
                dokumenList.add("No Data");
            }
            String[] docArr = new String[dokumenList.size()];
            docArr = dokumenList.toArray(docArr);
            cm = docArr;
        }
        return cm;
    }
/*
    public TableModel SetTableData(String Query, String[] TableHeader, Class[] types, boolean[] canEdit, boolean[] ColumnSumBool, int[] ColumnSum) {
        Class[] Ftypes = getClass(TableHeader, types);
        boolean[] FcanEdit;
        boolean[] FColumnSumBool;
        int[] FColumnSum;
        if (null == canEdit) {
            FcanEdit = new boolean[TableHeader.length];
        } else {
            FcanEdit = canEdit;
        }
        if (null == ColumnSumBool) {
            FColumnSumBool = new boolean[TableHeader.length];
        } else {
            FColumnSumBool = ColumnSumBool;
        }
        if (null == ColumnSum) {
            List<Integer> dataListInt = new ArrayList<>();
            for (String TableHeader1 : TableHeader) {
                dataListInt.add(0);
            }
            FColumnSum = ArrayUtils.toPrimitive(dataListInt.toArray(new Integer[dataListInt.size()]));
        } else {
            FColumnSum = ColumnSum;
        }

        DefaultTableModel dtm = new javax.swing.table.DefaultTableModel(null, TableHeader) {
            @Override
            public Class getColumnClass(int columnIndex) {
                Class[] tipe = Ftypes;
                return tipe[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                boolean[] Edit = FcanEdit;
                return Edit[columnIndex];
            }
        };
        try {
            try (ResultSet rs = Select(Query)) {
                rs.next();
                int dataSumList = 0;
                while (!rs.isAfterLast()) {
                    List<String> dataList = new ArrayList<>();
                    for (int i = 0; i < TableHeader.length; i++) {
                        dataList.add(rs.getString(i + 1));
                        if (FColumnSumBool[i]) {
                            FColumnSum[i] = FColumnSum[i] + rs.getInt(i + 1);
                        }
                        dataSumList++;
                    }
                    String[] docArr = new String[dataList.size()];
                    docArr = dataList.toArray(docArr);
                    dtm.addRow(docArr);
                    rs.next();
                }
            }
            if (CekBool(FColumnSumBool)) {
                String[] a = Arrays.toString(FColumnSum).split("[\\[\\]]")[1].split(", ");
                for (int index = 0; index < a.length; index++) {
                    if (a[index].equals("0")) {
                        a[index] = a[index].replace("0", "");
                    }
                    if (index == 0) {
                        a[index] = "Jumlah";
                    }
                }
                dtm.addRow(a);
            }
        } catch (SQLException | java.lang.NullPointerException ex) {
            String[] uno = {"Data Kosong"};
            dtm = new javax.swing.table.DefaultTableModel(null, uno);
        }
        return dtm;
    }

    private Class[] getClass(String[] TableHeader, Class[] types) {
        Class[] Ftypes;
        if (null == types) {
            List<Class> dataList = new ArrayList<>();
            for (String TableHeader1 : TableHeader) {
                dataList.add(java.lang.String.class);
            }
            Ftypes = new Class[dataList.size()];
            Ftypes = dataList.toArray(Ftypes);
        } else {
            Ftypes = types;
        }
        return Ftypes;
    }

    private boolean CekBool(boolean[] FColumnSumBool) {
        for (boolean value : FColumnSumBool) {
            if (value) {
                return true;
            }
        }
        return false;
    }
*/

    /**
     *
     * @param Query1
     * @param Query2
     * @return
     */

    public String SetTableDataReview(String Query1, String Query2) {
        String data = "";
        int k = 0;
        try {
            try (ResultSet rs1 = Select(Query1)) {
                try (ResultSet rs2 = Select(Query2)) {
                    rs1.next();
                    rs2.next();
                    for (int i = 1; i < 11; i++) {
                        List<Integer> dataList = new ArrayList<>();
                        Double target = rs1.getDouble(i);
                        Double actual = rs2.getDouble(i);
                        dataList.add(round(target.intValue()));
                        dataList.add(round(actual.intValue()));
                        Double fs;
                        fs = (actual / target) * 100d;
                        if (fs.isNaN()) {
                            fs = 0d;
                        }
                        if (fs.isInfinite()) {
                            fs = -1d;
                        }
                        int persen = round(fs.intValue());
                        dataList.add(persen);
                        int hasil[] = toPrimitive(dataList.toArray(new Integer[dataList.size()]));
                        String[] a = Arrays.toString(hasil).split("[\\[\\]]")[1].split(", ");
                        DecimalFormat DFor = new java.text.DecimalFormat("#,###;(#,###)");
                        for (int index = 0; index < a.length; index++) {
                            if (index == a.length - 1) {
                                a[index] = Integer.toString(persen);

                                if (a[index].equals("-1")) {
                                    a[index] = a[index].replace("-1", "-");
                                } else {
                                    a[index] += " %";
                                }
                            } else {
                                a[index] = DFor.format(parseDouble(a[index]));
                            }
                        }
                        data += "<tr>";
                        data += "<td>"+ Desk[k]+"</td>";
                        data += "<td>Rp. "+a[0] +" </td>";
                        data += "<td>Rp. "+a[1] +" </td>";
                        data += "<td> "+a[2] +" </td>";
                        data += "</tr>";
                        k++;
                    }
                }
            }
        } catch (SQLException | java.lang.NullPointerException ex) {
            ex.printStackTrace();
            data += "<tr><td>"+null +"</td></tr>";
        }
        return data;
    }

    /**
     *
     * @param project
     * @return
     */
    public O_DataLihat LihatData(String project) {
        O_DataLihat data = new O_DataLihat();
        return data;
    }

    /**
     *
     * @param TabelData
     * @param project
     * @param bulan
     * @param tahun
     * @param ProfitPercentActual
     */
    public void UpdateData(String[] TabelData, String project, String bulan, String tahun, Double ProfitPercentActual) {
        String data = "";
        for (int i = 0; i < TabelData.length-1; i++) {
            double Value = parseDouble(TabelData[i].replace(".00", "").replaceAll(" ", "").replace("Rp", "").replaceAll(",", ""));
            data += "`"+kolomDB[i]+"` = '"+Value/1000d+"', ";
        }
        data += "`"+kolomDB[TabelData.length-1]+"` = '"+ProfitPercentActual/100d+"', ";
        data = data.substring(0, data.length()-2);
        String con =" `DetailRincian`.`Project` = '"+project+"' AND `DetailRincian`.`Bulan` = "+bulan+" AND `DetailRincian`.`Tahun` = "+tahun+" AND `DetailRincian`.`Tipe` = 'Actual';";
        Update(data,"`DetailRincian`", con);
    }
/*
    public int[] PrepareExportData(String Query1, String Query2) {
        int[] hasil = {0, 0, 0};
        try {
            try (ResultSet rs1 = Select(Query1)) {
                try (ResultSet rs2 = Select(Query2)) {
                    rs1.next();
                    rs2.next();
                    List<Integer> dataList = new ArrayList<>();
                    Double target = rs1.getDouble(1);
                    Double actual = rs2.getDouble(1);
                    dataList.add(Math.round(target.intValue()));
                    dataList.add(Math.round(actual.intValue()));
                    Double fs;
                    fs = (actual / target) * 100d;
                    if (fs.isNaN()) {
                        fs = 0d;
                    }
                    if (fs.isInfinite()) {
                        fs = 0d;
                    }
                    int persen = Math.round(fs.intValue());
                    dataList.add(persen);
                    hasil = ArrayUtils.toPrimitive(dataList.toArray(new Integer[dataList.size()]));
                    return hasil;
                }
            }
        } catch (SQLException | java.lang.NullPointerException ex) {
            return hasil;
        }
    }
  */
    private static final Logger LOG = Logger.getLogger(F_Function.class.getName());
}
