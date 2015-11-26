/*
 * Inchidi Commercial License
 * Copyright 2015 inchidi.
 * This program is created and owned by dimas ari ;
 * you CAN NOT redistribute it and/or modify it without owner permit
 * Inchidi, Samarinda, Kalimantan Timur, +62812 7777 9663, Indonesia.
 */
package servlet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;

import javax.swing.text.NumberFormatter;
import javax.xml.crypto.Data;

/**
 *
 * @author inchidi
 */
public class F_Function extends F_Koneksi {

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

    public O_DataInput InputData(String tsk, int tahun, int bulan, String project, String datainputActual[], String datainputTarget[]){
        O_DataInput data = new O_DataInput();
        data.setBulanDataHome(bulan);
        data.setTahunDataHome(tahun);
        data.setComboProjectHomeItem(project);
        data.setDataProyek(DataProyekInput("TOTAL CSA GOLD", project));

        if (!tsk.equals("hitung")){
            ReloadTextData(project,bulan,tahun,"actual", data);
            ReloadTextData(project,bulan,tahun,"target", data);
        } else {
            //actual data
            data.setSPAREPARTS_Actual(datainputActual[0]);
            data.setSMC_Actual(datainputActual[1]);
            data.setFMS_Actual(datainputActual[2]);
            data.setREVENUE_Actual(datainputActual[3]);
            data.setCOSTOFSALES_SPAREPARTS__Actual(datainputActual[4]);
            data.setCOSTOFSALES_SERVICE__Actual(datainputActual[5]);
            data.setPeriodicMaintenance_Actual(datainputActual[6]);
            data.setPartRepair_Actual(datainputActual[7]);
            data.setPartRAndI_Actual(datainputActual[8]);
            data.setComponent_Actual(datainputActual[9]);
            data.setGETAndUndercarriageGroup_Actual(datainputActual[10]);
            data.setWarrantyAndCampaign_Actual(datainputActual[11]);
            data.setConsumable_Actual(datainputActual[12]);
            data.setTOTALCOGS_Actual(datainputActual[13]);
            data.setGROSSPROFIT_Actual(datainputActual[14]);
            data.setEXPENSES_Actual(datainputActual[15]);
            data.setEmployeeExpenses_Actual(datainputActual[16]);
            data.setAssetDepreciation_Actual(datainputActual[17]);
            data.setOperationExpenses_Actual(datainputActual[18]);
            data.setOPRPROFIT_Actual(datainputActual[19]);
            data.setPROFITPercentOFSALESActual(datainputActual[20]);

            data.setConsumable_Actual(datainputActual[21]);
            //target data
            data.setSPAREPARTS_Target(datainputTarget[0]);
            data.setSMC_Target(datainputTarget[1]);
            data.setFMS_Target(datainputTarget[2]);
            data.setREVENUE_Target(datainputTarget[3]);
            data.setCOSTOFSALES_SPAREPARTS__Target(datainputTarget[4]);
            data.setCOSTOFSALES_SERVICE__Target(datainputTarget[5]);
            data.setPeriodicMaintenance_Target(datainputTarget[6]);
            data.setPartRepair_Target(datainputTarget[7]);
            data.setPartRAndI_Target(datainputTarget[8]);
            data.setComponent_Target(datainputTarget[9]);
            data.setGETAndUndercarriageGroup_Target(datainputTarget[10]);
            data.setWarrantyAndCampaign_Target(datainputTarget[11]);
            data.setTOTALCOGS_Target(datainputTarget[13]);
            data.setGROSSPROFIT_Target(datainputTarget[14]);
            data.setEXPENSES_Target(datainputTarget[15]);
            data.setEmployeeExpenses_Target(datainputTarget[16]);
            data.setAssetDepreciation_Target(datainputTarget[17]);
            data.setOperationExpenses_Target(datainputTarget[18]);
            data.setOPRPROFIT_Target(datainputTarget[19]);
            data.setPROFITPercentOFSALESTarget(datainputTarget[20]);
            data.setConsumable_Target(datainputTarget[21]);
        }
                return data;
    }

    //            SPAREPARTS
//                    SMC
//            FMS
//                    REVENUE
//            COSTOFSALES_SPAREPARTS_
//                    COSTOFSALES_SERVICE_
//            PeriodicMaintenance
//                    PartRepair
//            PartRAndI
//                    Component
//            GETAndUndercarriageGroup
//                    WarrantyAndCampaign
//            Consumable
//                    TOTALCOGS
//            GROSSPROFIT
//                    EXPENSES
//            EmployeeExpenses
//                    AssetDepreciation
//            OperationExpenses
//                    OPRPROFIT
//            PROFITPercentOFSALESActual

    private void ReloadTextData(String project, int bulan, int tahun, String tipe, O_DataInput data) {
        if (!SetTempData("SELECT * FROM `IntracoCSA`.`DetailRincian` WHERE `Project`= '" + project + "' AND `Bulan`='" + bulan + "' AND `Tahun`='" + tahun + "' AND `Tipe`='" + tipe + "'",
                25, null, null)) {
            InsertData("INSERT INTO `IntracoCSA`.`DetailRincian` (`Project`, `Bulan`, `Tahun`, `Tipe`) VALUES ('" + project + "', '" + bulan + "', '" + tahun + "', '" + tipe + "')",
                    25, "0");
        }
        if (tipe.equals("target")) {
            //revenue
            data.setSPAREPARTS_Target(String.valueOf(1000 * Double.parseDouble(TempData[0 + 5])));
            data.setSMC_Target(String.valueOf(1000 * Double.parseDouble(TempData[1 + 5])));
            data.setFMS_Target(String.valueOf(1000 * Double.parseDouble(TempData[2 + 5])));
            data.setREVENUE_Target(String.valueOf(1000 * Double.parseDouble(TempData[3 + 5])));
            //cost
            data.setCOSTOFSALES_SPAREPARTS__Target(String.valueOf(1000 * Double.parseDouble(TempData[4 + 5])));
            data.setCOSTOFSALES_SERVICE__Target(String.valueOf(1000 * Double.parseDouble(TempData[5 + 5])));

            data.setPeriodicMaintenance_Target(String.valueOf(1000 * Double.parseDouble(TempData[6 + 5])));
            data.setPartRepair_Target(String.valueOf(1000 * Double.parseDouble(TempData[7 + 5])));
            data.setPartRAndI_Target(String.valueOf(1000 * Double.parseDouble(TempData[8 + 5])));
            data.setComponent_Target(String.valueOf(1000 * Double.parseDouble(TempData[9 + 5])));
            data.setGETAndUndercarriageGroup_Target(String.valueOf(1000 * Double.parseDouble(TempData[10 + 5])));
            data.setWarrantyAndCampaign_Target(String.valueOf(1000 * Double.parseDouble(TempData[11 + 5])));
            data.setConsumable_Target(String.valueOf(1000 * Double.parseDouble(TempData[12 + 5])));

            //TODO: sebelumnya ga ada
//            data.setTOTALCOGS_Target(String.valueOf(1000 * Double.parseDouble(TempData[13 + 5])));
//            data.setGROSSPROFIT_Target(String.valueOf(1000 * Double.parseDouble(TempData[14 + 5])));
            //expenses
            data.setEXPENSES_Target(String.valueOf(1000 * Double.parseDouble(TempData[15 + 5])));
            data.setEmployeeExpenses_Target(String.valueOf(1000 * Double.parseDouble(TempData[16 + 5])));
            data.setAssetDepreciation_Target(String.valueOf(1000 * Double.parseDouble(TempData[17 + 5])));
            data.setOperationExpenses_Target(String.valueOf(1000 * Double.parseDouble(TempData[18 + 5])));

            //TODO: sebelumnya ga ada juga
//            data.setOPRPROFIT_Target(String.valueOf(1000 * Double.parseDouble(TempData[19 + 5])));
//            data.setPROFITPercentOFSALESTarget(String.valueOf(1000 * Double.parseDouble(TempData[20 + 5])));

        } else {

            data.setSPAREPARTS_Actual(String.valueOf(1000 * Double.parseDouble(TempData[0 + 5])));
            data.setSMC_Actual(String.valueOf(1000 * Double.parseDouble(TempData[1 + 5])));
            data.setFMS_Actual(String.valueOf(1000 * Double.parseDouble(TempData[2 + 5])));
            data.setREVENUE_Actual(String.valueOf(1000 * Double.parseDouble(TempData[3 + 5])));
            data.setCOSTOFSALES_SPAREPARTS__Actual(String.valueOf(1000 * Double.parseDouble(TempData[4 + 5])));
            data.setCOSTOFSALES_SERVICE__Actual(String.valueOf(1000 * Double.parseDouble(TempData[5 + 5])));
            data.setPeriodicMaintenance_Actual(String.valueOf(1000 * Double.parseDouble(TempData[6 + 5])));
            data.setPartRepair_Actual(String.valueOf(1000 * Double.parseDouble(TempData[7 + 5])));
            data.setPartRAndI_Actual(String.valueOf(1000 * Double.parseDouble(TempData[8 + 5])));
            data.setComponent_Actual(String.valueOf(1000 * Double.parseDouble(TempData[9 + 5])));
            data.setGETAndUndercarriageGroup_Actual(String.valueOf(1000 * Double.parseDouble(TempData[10 + 5])));
            data.setWarrantyAndCampaign_Actual(String.valueOf(1000 * Double.parseDouble(TempData[11 + 5])));
            data.setConsumable_Actual(String.valueOf(1000 * Double.parseDouble(TempData[12 + 5])));
//            data.setTOTALCOGS_Actual(String.valueOf(1000 * Double.parseDouble(TempData[13 + 5])));
//            data.setGROSSPROFIT_Actual(String.valueOf(1000 * Double.parseDouble(TempData[14 + 5])));
            data.setEXPENSES_Actual(String.valueOf(1000 * Double.parseDouble(TempData[15 + 5])));
            data.setEmployeeExpenses_Actual(String.valueOf(1000 * Double.parseDouble(TempData[16 + 5])));
            data.setAssetDepreciation_Actual(String.valueOf(1000 * Double.parseDouble(TempData[17 + 5])));
            data.setOperationExpenses_Actual(String.valueOf(1000 * Double.parseDouble(TempData[18 + 5])));
//            data.setOPRPROFIT_Actual(String.valueOf(1000 * Double.parseDouble(TempData[19 + 5])));
//            data.setPROFITPercentOFSALESActual(String.valueOf(1000 * Double.parseDouble(TempData[20 + 5])));

//            //revenue
//            TextActualSpareParts.setValue(1000 * Double.parseDouble(TempData[1 + 4]));
//            TextActualSMC.setValue(1000 * Double.parseDouble(TempData[2 + 4]));
//            TextActualFMC.setValue(1000 * Double.parseDouble(TempData[3 + 4]));
//            TextActualRevenue.setValue(1000 * Double.parseDouble(TempData[4 + 4]));
//
//            //cost
//            TextActualCOSSpareParts.setValue(1000 * Double.parseDouble(TempData[5 + 4]));
//            TextActualCOSService.setValue(1000 * Double.parseDouble(TempData[6 + 4]));
//
//            TextActualPeriodicMain.setValue(1000 * Double.parseDouble(TempData[7 + 4]));
//            TextActualPartRepair.setValue(1000 * Double.parseDouble(TempData[8 + 4]));
//            TextActualPartRNI.setValue(1000 * Double.parseDouble(TempData[9 + 4]));
//            TextActualComponent.setValue(1000 * Double.parseDouble(TempData[10 + 4]));
//            TextActualUnderGroup.setValue(1000 * Double.parseDouble(TempData[11 + 4]));
//            TextActualWarranty.setValue(1000 * Double.parseDouble(TempData[12 + 4]));
//            TextActualConsumable.setValue(1000 * Double.parseDouble(TempData[13 + 4]));
//
//            //expenses
//            TextActualExpenses.setValue(1000 * Double.parseDouble(TempData[16 + 4]));
//            TextActualEmployee.setValue(1000 * Double.parseDouble(TempData[17 + 4]));
//            TextActualDeprecation.setValue(1000 * Double.parseDouble(TempData[18 + 4]));
//            TextActualOperation.setValue(1000 * Double.parseDouble(TempData[19 + 4]));
        }
    }


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


    public String[] TempData;  //index 0 for String key

    public boolean SetTempData(String Query, int colCount, String Static, boolean[] fromDouble) {
        try {
            try (ResultSet rs = Select(Query)) {
                rs.first();
                List<String> dokumenList = new ArrayList<>();
                dokumenList.add(Static);
                for (int i = 1; i < colCount; i++) {
                    if (fromDouble != null && fromDouble[i]) {
                        Double nile = rs.getDouble(i);
                        dokumenList.add(Integer.toString(Math.round(nile.floatValue())));
                    } else {
                        dokumenList.add(rs.getString(i));
                    }
                }
                TempData = new String[dokumenList.size()];
                TempData = dokumenList.toArray(TempData);
            }
            return true;
        } catch (SQLException | java.lang.NullPointerException ex) {
            return false;
        }
    }

    public boolean UpdateData(String Query) {
        return Update(Query);
    }

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

    public String[] SetCombo(String Query, String Header) {
        String[] cm;
        try {
            try (ResultSet rs = Select(Query)) {
                rs.first();
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
                rs.first();
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
    public String SetTableDataReview(String Query1, String Query2) {
        String data = "";
        int k = 0;
        try {
            try (ResultSet rs1 = Select(Query1)) {
                try (ResultSet rs2 = Select(Query2)) {
                    rs1.first();
                    rs2.first();
                    for (int i = 1; i < 11; i++) {
                        List<Integer> dataList = new ArrayList<>();
                        Double target = rs1.getDouble(i);
                        Double actual = rs2.getDouble(i);
                        dataList.add(Math.round(target.intValue()));
                        dataList.add(Math.round(actual.intValue()));
                        Double fs;
                        fs = (actual / target) * 100d;
                        if (fs.isNaN()) {
                            fs = 0d;
                        }
                        if (fs.isInfinite()) {
                            fs = -1d;
                        }
                        int persen = Math.round(fs.intValue());
                        dataList.add(persen);
                        int hasil[] = ArrayUtils.toPrimitive(dataList.toArray(new Integer[dataList.size()]));
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
                                a[index] = DFor.format(Double.parseDouble(a[index]));
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
            data += "<tr><td>"+null +"</td></tr>";
        }
        return data;
    }

    public O_DataLihat LihatData(String project) {
        O_DataLihat data = new O_DataLihat();
        return data;
    }
/*
    public int[] PrepareExportData(String Query1, String Query2) {
        int[] hasil = {0, 0, 0};
        try {
            try (ResultSet rs1 = Select(Query1)) {
                try (ResultSet rs2 = Select(Query2)) {
                    rs1.first();
                    rs2.first();
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
}
