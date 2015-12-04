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

    final String[][] dataTargetTemp =  {
            {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(1067400.64637101d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(793648.193915d),String.valueOf(342935.513915d),String.valueOf(304868.68d),String.valueOf(145844d),String.valueOf(273752.452456013d),String.valueOf(0.2564664481d)},
            {String.valueOf(0d),String.valueOf(2134801.576d),String.valueOf(2134801.576d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(2134801.576d),String.valueOf(336297.202d),String.valueOf(156144.29d),String.valueOf(135689.956d),String.valueOf(44462.956d),String.valueOf(1798504.374d),String.valueOf(0.8424691054d)},
            {String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(1067400.64637101d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(784018.193915d),String.valueOf(342935.513915d),String.valueOf(304868.68d),String.valueOf(136214d),String.valueOf(283382.452456013d),String.valueOf(0.265488365d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.788d),String.valueOf(1067400.788d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.788d),String.valueOf(414699.415d),String.valueOf(167286.989d),String.valueOf(135689.878d),String.valueOf(111722.548d),String.valueOf(652701.373d),String.valueOf(0.6114866884d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(1067400.64637101d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(784018.193915d),String.valueOf(342935.513915d),String.valueOf(304868.68d),String.valueOf(136214d),String.valueOf(283382.45245601d),String.valueOf(0.265488365d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.788d),String.valueOf(1067400.788d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.788d),String.valueOf(418333.361d),String.valueOf(176354.437d),String.valueOf(141291.397d),String.valueOf(100687.527d),String.valueOf(649067.427d),String.valueOf(0.6080822071d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(1067400.64637101d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(789368.193915d),String.valueOf(342935.513915d),String.valueOf(304868.68d),String.valueOf(141564d),String.valueOf(278032.45245601d),String.valueOf(0.260476189d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.788d),String.valueOf(1067400.788d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.788d),String.valueOf(438311.321d),String.valueOf(174171.945d),String.valueOf(141291.332d),String.valueOf(122848.044d),String.valueOf(629089.467d),String.valueOf(0.589365751d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(1067400.64637101d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(784018.193915d),String.valueOf(342935.513915d),String.valueOf(304868.68d),String.valueOf(136214d),String.valueOf(283382.45245601d),String.valueOf(0.265488365d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.788d),String.valueOf(1067400.788d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.788d),String.valueOf(368065.137d),String.valueOf(290226.346d),String.valueOf(25570.254d),String.valueOf(52268.537d),String.valueOf(699335.651d),String.valueOf(0.6551762551d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(1067400.64637101d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(784018.193915d),String.valueOf(342935.513915d),String.valueOf(304868.68d),String.valueOf(136214d),String.valueOf(283382.45245601d),String.valueOf(0.265488365d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.788d),String.valueOf(1067400.788d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.788d),String.valueOf(457892.813d),String.valueOf(265423.026d),String.valueOf(141291.367d),String.valueOf(51178.42d),String.valueOf(609507.975d),String.valueOf(0.571020728d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(1067400.64637101d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(868925.193915d),String.valueOf(420887.513915d),String.valueOf(304868.68d),String.valueOf(143169d),String.valueOf(198475.45245601d),String.valueOf(0.1859427883d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.788d),String.valueOf(1067400.788d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.788d),String.valueOf(815336.122d),String.valueOf(347118.26d),String.valueOf(141291.367d),String.valueOf(326926.495d),String.valueOf(252064.666d),String.valueOf(0.2361480981d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(1067400.64637101d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(784018.193915d),String.valueOf(342935.513915d),String.valueOf(304868.68d),String.valueOf(136214d),String.valueOf(283382.45245601d),String.valueOf(0.265488365d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(1067400.64637101d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(784018.193915d),String.valueOf(342935.513915d),String.valueOf(304868.68d),String.valueOf(136214d),String.valueOf(283382.45245601d),String.valueOf(0.265488365d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(1067400.64637101d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(789368.193915d),String.valueOf(342935.513915d),String.valueOf(304868.68d),String.valueOf(141564d),String.valueOf(278032.45245601d),String.valueOf(0.260476189d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(1067400.64637101d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(784018.193915d),String.valueOf(342935.513915d),String.valueOf(304868.68d),String.valueOf(136214d),String.valueOf(283382.45245601d),String.valueOf(0.265488365d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(1067400.64637101d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1067400.64637101d),String.valueOf(812018.193915d),String.valueOf(370935.513915d),String.valueOf(304868.68d),String.valueOf(136214d),String.valueOf(255382.45245601d),String.valueOf(0.2392564154d)},
        {String.valueOf(1.231d),String.valueOf(6d),String.valueOf(6d),String.valueOf(13.231d),String.valueOf(102d),String.valueOf(6d),String.valueOf(6d),String.valueOf(6d),String.valueOf(6d),String.valueOf(6d),String.valueOf(6d),String.valueOf(66d),String.valueOf(6d),String.valueOf(108d),String.valueOf(-94.769d),String.valueOf(18d),String.valueOf(6d),String.valueOf(6d),String.valueOf(6d),String.valueOf(-112.769d),String.valueOf(-0.0852308971d)},
        {String.valueOf(0d),String.valueOf(119106.446052632d),String.valueOf(8468380.46154079d),String.valueOf(8587486.90759342d),String.valueOf(0d),String.valueOf(4677161.44756646d),String.valueOf(575484.805255527d),String.valueOf(0d),String.valueOf(1996014.60437426d),String.valueOf(1836404.16666667d),String.valueOf(179029.87127d),String.valueOf(0d),String.valueOf(90228d),String.valueOf(4677161.44756646d),String.valueOf(3910325.46002696d),String.valueOf(2851406.08078208d),String.valueOf(1268027.96392437d),String.valueOf(95158.2393333333d),String.valueOf(1488219.87752437d),String.valueOf(1058919.37924489d),String.valueOf(0.1233095771d)},
        {String.valueOf(0d),String.valueOf(11291.154d),String.valueOf(7781000.261d),String.valueOf(7792291.415d),String.valueOf(0d),String.valueOf(3042468.514d),String.valueOf(277037.274d),String.valueOf(2048304.792d),String.valueOf(48143.593d),String.valueOf(576329.207d),String.valueOf(0d),String.valueOf(0d),String.valueOf(92653.648d),String.valueOf(3042468.514d),String.valueOf(4749822.901d),String.valueOf(1548742.837d),String.valueOf(1129374.179d),String.valueOf(141977.428d),String.valueOf(277391.23d),String.valueOf(3201080.064d),String.valueOf(0.4108008663d)},
        {String.valueOf(0d),String.valueOf(116614.215789474d),String.valueOf(7735510.23677369d),String.valueOf(7852124.45256316d),String.valueOf(0d),String.valueOf(4677161.44756646d),String.valueOf(575484.805255527d),String.valueOf(0d),String.valueOf(1996014.60437426d),String.valueOf(1836404.16666667d),String.valueOf(179029.87127d),String.valueOf(0d),String.valueOf(90228d),String.valueOf(4677161.44756646d),String.valueOf(3174963.00499671d),String.valueOf(2929274.44772884d),String.valueOf(1159244.65419775d),String.valueOf(95158.2393333333d),String.valueOf(1674871.55419775d),String.valueOf(245688.557267871d),String.valueOf(0.0312894375d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(8438931.563d),String.valueOf(8438931.563d),String.valueOf(0d),String.valueOf(1925823.904d),String.valueOf(438489.699d),String.valueOf(1126386.337d),String.valueOf(0d),String.valueOf(340876.007d),String.valueOf(0d),String.valueOf(0d),String.valueOf(20071.861d),String.valueOf(1925823.904d),String.valueOf(6513107.659d),String.valueOf(1422154.709d),String.valueOf(994487.592d),String.valueOf(141080.121d),String.valueOf(286586.996d),String.valueOf(5090952.95d),String.valueOf(0.6032698467d)},
        {String.valueOf(0d),String.valueOf(119106.446052632d),String.valueOf(8246946.15085263d),String.valueOf(8366052.59690526d),String.valueOf(0d),String.valueOf(4677161.44756646d),String.valueOf(575484.805255527d),String.valueOf(0d),String.valueOf(1996014.60437426d),String.valueOf(1836404.16666667d),String.valueOf(179029.87127d),String.valueOf(0d),String.valueOf(90228d),String.valueOf(4677161.44756646d),String.valueOf(3688891.14933881d),String.valueOf(1966087.9467768d),String.valueOf(1223661.01144347d),String.valueOf(95158.2393333333d),String.valueOf(647268.696d),String.valueOf(1722803.20256201d),String.valueOf(0.2059278474d)},
        {String.valueOf(0d),String.valueOf(18738.216d),String.valueOf(9487928.759d),String.valueOf(9506666.975d),String.valueOf(0d),String.valueOf(5174146.269d),String.valueOf(878320.258d),String.valueOf(2189548.705d),String.valueOf(16149.977d),String.valueOf(2030532.651d),String.valueOf(8134.587d),String.valueOf(0d),String.valueOf(51460.091d),String.valueOf(5174146.269d),String.valueOf(4332520.706d),String.valueOf(1355732.201d),String.valueOf(815266.14d),String.valueOf(143107.025d),String.valueOf(397359.036d),String.valueOf(2976788.505d),String.valueOf(0.3131264104d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(118275.702631579d),String.valueOf(7907634.92636842d),String.valueOf(8025910.629d),String.valueOf(0d),String.valueOf(4677161.44756646d),String.valueOf(575484.805255527d),String.valueOf(0d),String.valueOf(1996014.60437426d),String.valueOf(1836404.16666667d),String.valueOf(179029.87127d),String.valueOf(0d),String.valueOf(90228d),String.valueOf(4677161.44756646d),String.valueOf(3348749.18143354d),String.valueOf(1813216.48449785d),String.valueOf(1335190.60916451d),String.valueOf(95158.2393333333d),String.valueOf(382867.636d),String.valueOf(1535532.69693569d),String.valueOf(0.1913219282d)},
        {String.valueOf(0d),String.valueOf(7858.434d),String.valueOf(9538362.734d),String.valueOf(9546221.168d),String.valueOf(0d),String.valueOf(3474134.084d),String.valueOf(485169.437d),String.valueOf(2237612.993d),String.valueOf(0d),String.valueOf(600432.548d),String.valueOf(66630.692d),String.valueOf(0d),String.valueOf(84288.414d),String.valueOf(3474134.084d),String.valueOf(6072087.084d),String.valueOf(1074509.127d),String.valueOf(751193.38d),String.valueOf(143106.983d),String.valueOf(180208.764d),String.valueOf(4997577.957d),String.valueOf(0.5235137411d)},
        {String.valueOf(0d),String.valueOf(119106.446052632d),String.valueOf(7611252.96701053d),String.valueOf(7730359.41306316d),String.valueOf(0d),String.valueOf(4677161.44756646d),String.valueOf(575484.805255527d),String.valueOf(0d),String.valueOf(1996014.60437426d),String.valueOf(1836404.16666667d),String.valueOf(179029.87127d),String.valueOf(0d),String.valueOf(90228d),String.valueOf(4677161.44756646d),String.valueOf(3053197.9654967d),String.valueOf(3370165.41114681d),String.valueOf(2545701.66381348d),String.valueOf(95158.2393333333d),String.valueOf(729305.508d),String.valueOf(-316967.445650107d),String.valueOf(-0.0410029377d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(9763735.64d),String.valueOf(9763735.64d),String.valueOf(0d),String.valueOf(4667600.882d),String.valueOf(426246.908d),String.valueOf(1718669.441d),String.valueOf(0d),String.valueOf(2492519.2d),String.valueOf(26295.112d),String.valueOf(0d),String.valueOf(3870.221d),String.valueOf(4667600.882d),String.valueOf(5096134.758d),String.valueOf(1258125.589d),String.valueOf(878505.897d),String.valueOf(143106.983d),String.valueOf(236512.709d),String.valueOf(3838009.169d),String.valueOf(0.3930881899d)},
        {String.valueOf(0d),String.valueOf(118275.702631579d),String.valueOf(7421908.33452631d),String.valueOf(7540184.03715789d),String.valueOf(0d),String.valueOf(4677161.44756646d),String.valueOf(575484.805255527d),String.valueOf(0d),String.valueOf(1996014.60437426d),String.valueOf(1836404.16666667d),String.valueOf(179029.87127d),String.valueOf(0d),String.valueOf(90228d),String.valueOf(4677161.44756646d),String.valueOf(2863022.58959143d),String.valueOf(1707551.96397251d),String.valueOf(1252398.40963918d),String.valueOf(95158.2393333333d),String.valueOf(359995.315d),String.valueOf(1155470.62561892d),String.valueOf(0.1532417007d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(30591821.446d),String.valueOf(30591821.446d),String.valueOf(0d),String.valueOf(6736130.135d),String.valueOf(1367712.527d),String.valueOf(2590172.374d),String.valueOf(0d),String.valueOf(2592675.293d),String.valueOf(102390.658d),String.valueOf(0d),String.valueOf(83179.283d),String.valueOf(6736130.135d),String.valueOf(23855691.311d),String.valueOf(1467935.45d),String.valueOf(852218.971d),String.valueOf(137163.116d),String.valueOf(478553.363d),String.valueOf(22387755.861d),String.valueOf(0.7318216047d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(119106.446052632d),String.valueOf(7659330.4428d),String.valueOf(7778436.88885263d),String.valueOf(0d),String.valueOf(4677161.44756646d),String.valueOf(575484.805255527d),String.valueOf(0d),String.valueOf(1996014.60437426d),String.valueOf(1836404.16666667d),String.valueOf(179029.87127d),String.valueOf(0d),String.valueOf(90228d),String.valueOf(4677161.44756646d),String.valueOf(3101275.44128618d),String.valueOf(1697316.97332179d),String.valueOf(1378929.79798846d),String.valueOf(95158.2393333333d),String.valueOf(223228.936d),String.valueOf(1403958.46796438d),String.valueOf(0.1804936503d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(11902890.69d),String.valueOf(11902890.69d),String.valueOf(0d),String.valueOf(4701814.659d),String.valueOf(771872.952d),String.valueOf(1872584.042d),String.valueOf(99.999d),String.valueOf(2000551.964d),String.valueOf(16340.344d),String.valueOf(0d),String.valueOf(40365.358d),String.valueOf(4701814.659d),String.valueOf(7201076.031d),String.valueOf(1616335.299d),String.valueOf(1032246.069d),String.valueOf(136142.799d),String.valueOf(447946.431d),String.valueOf(5584840.731d),String.valueOf(0.46919197d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(119106.446052632d),String.valueOf(7484576.65869474d),String.valueOf(7603683.10474737d),String.valueOf(0d),String.valueOf(4498131.57629646d),String.valueOf(575484.805255527d),String.valueOf(0d),String.valueOf(1996014.60437426d),String.valueOf(1836404.16666667d),String.valueOf(0d),String.valueOf(0d),String.valueOf(90228d),String.valueOf(4498131.57629646d),String.valueOf(3105551.52845091d),String.valueOf(1789982.4617725d),String.valueOf(1433788.63229631d),String.valueOf(95158.2393333333d),String.valueOf(261035.590142857d),String.valueOf(1315569.06667842d),String.valueOf(0.1730173455d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(118275.702631579d),String.valueOf(7421908.33452631d),String.valueOf(7540184.03715789d),String.valueOf(0d),String.valueOf(4498131.57629646d),String.valueOf(575484.805255527d),String.valueOf(0d),String.valueOf(1996014.60437426d),String.valueOf(1836404.16666667d),String.valueOf(0d),String.valueOf(0d),String.valueOf(90228d),String.valueOf(4498131.57629646d),String.valueOf(3042052.46086143d),String.valueOf(1884209.06369407d),String.valueOf(1249707.78210359d),String.valueOf(95158.2393333333d),String.valueOf(539343.042257143d),String.valueOf(1157843.39716736d),String.valueOf(0.1535563842d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(119106.446052632d),String.valueOf(7515098.01543158d),String.valueOf(7634204.46148421d),String.valueOf(0d),String.valueOf(4498131.57629646d),String.valueOf(575484.805255527d),String.valueOf(0d),String.valueOf(1996014.60437426d),String.valueOf(1836404.16666667d),String.valueOf(0d),String.valueOf(0d),String.valueOf(90228d),String.valueOf(4498131.57629646d),String.valueOf(3136072.88518775d),String.valueOf(2268774.96131241d),String.valueOf(1776989.66115051d),String.valueOf(95158.2393333333d),String.valueOf(396627.060828571d),String.valueOf(867297.923875343d),String.valueOf(0.1136068504d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(118275.702631579d),String.valueOf(7328855.15557895d),String.valueOf(7447130.85821052d),String.valueOf(0d),String.valueOf(4498131.57629646d),String.valueOf(575484.805255527d),String.valueOf(0d),String.valueOf(1996014.60437426d),String.valueOf(1836404.16666667d),String.valueOf(0d),String.valueOf(0d),String.valueOf(90228d),String.valueOf(4498131.57629646d),String.valueOf(2948999.28191407d),String.valueOf(1716411.38564328d),String.valueOf(1224626.08548138d),String.valueOf(95158.2393333333d),String.valueOf(396627.060828571d),String.valueOf(1232587.89627078d),String.valueOf(0.1655117816d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(119106.446052632d),String.valueOf(7330769.79946184d),String.valueOf(7449876.24551448d),String.valueOf(0d),String.valueOf(4498131.57629646d),String.valueOf(575484.805255527d),String.valueOf(0d),String.valueOf(1996014.60437426d),String.valueOf(1836404.16666667d),String.valueOf(0d),String.valueOf(0d),String.valueOf(90228d),String.valueOf(4498131.57629646d),String.valueOf(2951744.66921802d),String.valueOf(1760209.71069817d),String.valueOf(1268424.41053627d),String.valueOf(95158.2393333333d),String.valueOf(396627.060828571d),String.valueOf(1191534.95851985d),String.valueOf(0.1599402351d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(450000d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(270685.16800688d),String.valueOf(193812.121928828d),String.valueOf(12581.1623333333d),String.valueOf(64291.8837447191d),String.valueOf(179314.83199312d),String.valueOf(0.3984774044d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(499641.664d),String.valueOf(499641.664d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(499641.664d),String.valueOf(137039.045d),String.valueOf(114163.056d),String.valueOf(12534.989d),String.valueOf(10341d),String.valueOf(362602.619d),String.valueOf(0.725725345d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(450000d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(271848.334014212d),String.valueOf(193812.121928828d),String.valueOf(12581.1623333333d),String.valueOf(65455.0497520514d),String.valueOf(178151.665985788d),String.valueOf(0.3958925911d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(468905.976d),String.valueOf(468905.976d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(468905.976d),String.valueOf(202698.815d),String.valueOf(154301.368d),String.valueOf(12534.999d),String.valueOf(35862.448d),String.valueOf(266207.161d),String.valueOf(0.5677197021d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(450000d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(271848.334014212d),String.valueOf(193812.121928828d),String.valueOf(12581.1623333333d),String.valueOf(65455.0497520514d),String.valueOf(178151.665985788d),String.valueOf(0.3958925911d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(502753.464d),String.valueOf(502753.464d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(502753.464d),String.valueOf(192016.694d),String.valueOf(157470.993d),String.valueOf(12534.989d),String.valueOf(22010.712d),String.valueOf(310736.77d),String.valueOf(0.6180698737d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(450000d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(271848.334014212d),String.valueOf(193812.121928828d),String.valueOf(12581.1623333333d),String.valueOf(65455.0497520514d),String.valueOf(178151.665985788d),String.valueOf(0.3958925911d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(558809.236d),String.valueOf(558809.236d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(558809.236d),String.valueOf(378971.118d),String.valueOf(163701.458d),String.valueOf(12534.989d),String.valueOf(202734.671d),String.valueOf(179838.118d),String.valueOf(0.3218238111d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(450000d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(263328.334014212d),String.valueOf(193812.121928828d),String.valueOf(12581.1623333333d),String.valueOf(56935.0497520514d),String.valueOf(186671.665985788d),String.valueOf(0.4148259244d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(551498.752d),String.valueOf(551498.752d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(551498.752d),String.valueOf(171547.183d),String.valueOf(152479.428d),String.valueOf(212.5d),String.valueOf(18855.255d),String.valueOf(379951.569d),String.valueOf(0.6889436606d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(450000d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(263328.334014212d),String.valueOf(193812.121928828d),String.valueOf(12581.1623333333d),String.valueOf(56935.0497520514d),String.valueOf(186671.665985788d),String.valueOf(0.4148259244d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1250251.364d),String.valueOf(1250251.364d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1250251.364d),String.valueOf(216214.17d),String.valueOf(177010.919d),String.valueOf(12534.992d),String.valueOf(26668.259d),String.valueOf(1034037.194d),String.valueOf(0.82706344d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(450000d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(263328.334014212d),String.valueOf(193812.121928828d),String.valueOf(12581.1623333333d),String.valueOf(56935.0497520514d),String.valueOf(186671.665985788d),String.valueOf(0.4148259244d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(253331.432d),String.valueOf(227446.91d),String.valueOf(12534.989d),String.valueOf(13349.533d),String.valueOf(-253331.432d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(450000d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(263328.334014212d),String.valueOf(193812.121928828d),String.valueOf(12581.1623333333d),String.valueOf(56935.0497520514d),String.valueOf(186671.665985788d),String.valueOf(0.4148259244d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(450000d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(263328.334014212d),String.valueOf(193812.121928828d),String.valueOf(12581.1623333333d),String.valueOf(56935.0497520514d),String.valueOf(186671.665985788d),String.valueOf(0.4148259244d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(450000d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(263328.334014212d),String.valueOf(193812.121928828d),String.valueOf(12581.1623333333d),String.valueOf(56935.0497520514d),String.valueOf(186671.665985788d),String.valueOf(0.4148259244d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(450000d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(263328.334014212d),String.valueOf(193812.121928828d),String.valueOf(12581.1623333333d),String.valueOf(56935.0497520514d),String.valueOf(186671.665985788d),String.valueOf(0.4148259244d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(450000d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(450000d),String.valueOf(263328.334014212d),String.valueOf(193812.121928828d),String.valueOf(12581.1623333333d),String.valueOf(56935.0497520514d),String.valueOf(186671.665985788d),String.valueOf(0.4148259244d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1358683.2552d),String.valueOf(1358683.2552d),String.valueOf(0d),String.valueOf(816801.849858333d),String.valueOf(218827.62095d),String.valueOf(159651.196399139d),String.valueOf(0d),String.valueOf(0d),String.valueOf(418387.875697873d),String.valueOf(0d),String.valueOf(19935.1568113212d),String.valueOf(816801.849858333d),String.valueOf(541881.405341667d),String.valueOf(1117219.9945009d),String.valueOf(622906.874167401d),String.valueOf(143506.7549125d),String.valueOf(350806.365421d),String.valueOf(-575338.589159234d),String.valueOf(-0.4234530653d)},
        {String.valueOf(0d),String.valueOf(46785.246d),String.valueOf(420738.189d),String.valueOf(467523.435d),String.valueOf(0d),String.valueOf(1054867.738d),String.valueOf(21738.258d),String.valueOf(19803d),String.valueOf(0d),String.valueOf(929400.349d),String.valueOf(0d),String.valueOf(10006.96d),String.valueOf(73919.171d),String.valueOf(1054867.738d),String.valueOf(-587344.303d),String.valueOf(1738581.751d),String.valueOf(1367962.954d),String.valueOf(83294.998d),String.valueOf(287323.799d),String.valueOf(-2325926.054d),String.valueOf(-4.9749935081d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1213096.8048d),String.valueOf(1213096.8048d),String.valueOf(0d),String.valueOf(779043.84521707d),String.valueOf(246552.2506d),String.valueOf(141803.344308817d),String.valueOf(0d),String.valueOf(0d),String.valueOf(372919.54787514d),String.valueOf(0d),String.valueOf(17768.7024331134d),String.valueOf(779043.84521707d),String.valueOf(434052.95958293d),String.valueOf(1069036.43592053d),String.valueOf(574723.315587032d),String.valueOf(143506.7549125d),String.valueOf(350806.365421d),String.valueOf(-634983.476337602d),String.valueOf(-0.5234400699d)},
        {String.valueOf(0d),String.valueOf(25046.881d),String.valueOf(1524952.884d),String.valueOf(1549999.765d),String.valueOf(0d),String.valueOf(1458050.966d),String.valueOf(284888.212d),String.valueOf(1060793.229d),String.valueOf(0d),String.valueOf(103372.646d),String.valueOf(0d),String.valueOf(3122.767d),String.valueOf(5874.112d),String.valueOf(1458050.966d),String.valueOf(91948.7990000001d),String.valueOf(709550.441d),String.valueOf(475509.641d),String.valueOf(83206.835d),String.valueOf(150833.965d),String.valueOf(-617601.642d),String.valueOf(-0.3984527327d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1565990.75904d),String.valueOf(1565990.75904d),String.valueOf(0d),String.valueOf(1199468.13577631d),String.valueOf(254257.52645d),String.valueOf(178718.869319376d),String.valueOf(82082d),String.valueOf(190642d),String.valueOf(471310.929400697d),String.valueOf(0d),String.valueOf(22456.8106062358d),String.valueOf(1199468.13577631d),String.valueOf(366522.623263691d),String.valueOf(1069036.43592053d),String.valueOf(574723.315587032d),String.valueOf(143506.7549125d),String.valueOf(350806.365421d),String.valueOf(-702513.812656841d),String.valueOf(-0.4486066144d)},
        {String.valueOf(0d),String.valueOf(90586.0449999999d),String.valueOf(3343518.764d),String.valueOf(3434104.809d),String.valueOf(0d),String.valueOf(1314534.467d),String.valueOf(287871.404d),String.valueOf(665639.802d),String.valueOf(0d),String.valueOf(280434.744d),String.valueOf(22088.14d),String.valueOf(30219.162d),String.valueOf(28281.215d),String.valueOf(1314534.467d),String.valueOf(2119570.342d),String.valueOf(739951.119d),String.valueOf(471715.995d),String.valueOf(83095.841d),String.valueOf(185139.283d),String.valueOf(1379619.223d),String.valueOf(0.4017405699d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1640071.3032d),String.valueOf(1640071.3032d),String.valueOf(0d),String.valueOf(1000975.61072514d),String.valueOf(292381.58745d),String.valueOf(189423.585172996d),String.valueOf(0d),String.valueOf(0d),String.valueOf(495558.299729852d),String.valueOf(0d),String.valueOf(23612.1383722892d),String.valueOf(1000975.61072514d),String.valueOf(639095.692474863d),String.valueOf(1127380.03270315d),String.valueOf(622906.874167401d),String.valueOf(143506.7549125d),String.valueOf(360966.40362325d),String.valueOf(-488284.340228288d),String.valueOf(-0.2977214096d)},
        {String.valueOf(0d),String.valueOf(14077.654d),String.valueOf(1314587.412d),String.valueOf(1328665.066d),String.valueOf(0d),String.valueOf(904152.114d),String.valueOf(162648.167d),String.valueOf(445986.713d),String.valueOf(0d),String.valueOf(0d),String.valueOf(264887.37d),String.valueOf(0d),String.valueOf(30629.864d),String.valueOf(904152.114d),String.valueOf(424512.952d),String.valueOf(801943.614d),String.valueOf(462179.269d),String.valueOf(82837.324d),String.valueOf(256927.021d),String.valueOf(-377430.662d),String.valueOf(-0.284067574d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1667542.18656d),String.valueOf(1667542.18656d),String.valueOf(0d),String.valueOf(1290387.88492313d),String.valueOf(304898.02315d),String.valueOf(189781.774323102d),String.valueOf(82082d),String.valueOf(190642d),String.valueOf(499198.502345229d),String.valueOf(0d),String.valueOf(23785.5851048015d),String.valueOf(1290387.88492313d),String.valueOf(377154.301636867d),String.valueOf(1079196.47412278d),String.valueOf(574723.315587032d),String.valueOf(143506.7549125d),String.valueOf(360966.40362325d),String.valueOf(-702042.172485915d),String.valueOf(-0.421004145d)},
        {String.valueOf(0d),String.valueOf(67940.388d),String.valueOf(1016291.366d),String.valueOf(1084231.754d),String.valueOf(0d),String.valueOf(1248566.917d),String.valueOf(119372.547d),String.valueOf(627074.627d),String.valueOf(0d),String.valueOf(0d),String.valueOf(444816.046d),String.valueOf(42528.697d),String.valueOf(14775d),String.valueOf(1248566.917d),String.valueOf(-164335.163d),String.valueOf(628547.967d),String.valueOf(441764.535d),String.valueOf(4194.805d),String.valueOf(182588.627d),String.valueOf(-792883.13d),String.valueOf(-0.7312856565d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1663181.3712d),String.valueOf(1663181.3712d),String.valueOf(0d),String.valueOf(991943.742558144d),String.valueOf(209750.2068d),String.valueOf(190589.553432063d),String.valueOf(0d),String.valueOf(0d),String.valueOf(567940.786681849d),String.valueOf(0d),String.valueOf(23663.1956442318d),String.valueOf(991943.742558144d),String.valueOf(671237.628641856d),String.valueOf(1079196.47412278d),String.valueOf(574723.315587032d),String.valueOf(143506.7549125d),String.valueOf(360966.40362325d),String.valueOf(-407958.845480926d),String.valueOf(-0.2452882485d)},
        {String.valueOf(105285.799d),String.valueOf(50972.52d),String.valueOf(1860429.734d),String.valueOf(2016688.053d),String.valueOf(0d),String.valueOf(1556089.115d),String.valueOf(187154.522d),String.valueOf(409227.969d),String.valueOf(0d),String.valueOf(753430.911d),String.valueOf(178434.229d),String.valueOf(2305.57d),String.valueOf(25535.914d),String.valueOf(1556089.115d),String.valueOf(460598.938d),String.valueOf(662470.174d),String.valueOf(442399.217d),String.valueOf(77351.197d),String.valueOf(142719.76d),String.valueOf(-201871.236d),String.valueOf(-0.1001003778d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1737419.90736d),String.valueOf(1737419.90736d),String.valueOf(0d),String.valueOf(1345758.45625731d),String.valueOf(265001.6868d),String.valueOf(197130.241657107d),String.valueOf(82082d),String.valueOf(190642d),String.valueOf(586424.043717911d),String.valueOf(0d),String.valueOf(24478.4840822948d),String.valueOf(1345758.45625731d),String.valueOf(391661.451102687d),String.valueOf(1278349.64875858d),String.valueOf(773876.490222832d),String.valueOf(143506.7549125d),String.valueOf(360966.40362325d),String.valueOf(-886688.197655895d),String.valueOf(-0.5103476678d)},
        {String.valueOf(694940.269d),String.valueOf(44552.189d),String.valueOf(1391044.029d),String.valueOf(2130536.487d),String.valueOf(0d),String.valueOf(953069.622d),String.valueOf(89500.898d),String.valueOf(489368.935d),String.valueOf(0d),String.valueOf(160602.859d),String.valueOf(200063.592d),String.valueOf(0d),String.valueOf(13533.338d),String.valueOf(953069.622d),String.valueOf(1177466.865d),String.valueOf(875162.063d),String.valueOf(587538.864d),String.valueOf(76741.8d),String.valueOf(210881.399d),String.valueOf(302304.802d),String.valueOf(0.1418913986d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1723096.92576d),String.valueOf(1723096.92576d),String.valueOf(0d),String.valueOf(900827.680516287d),String.valueOf(186857.71825d),String.valueOf(189882.779996347d),String.valueOf(0d),String.valueOf(0d),String.valueOf(500251.427845751d),String.valueOf(0d),String.valueOf(23835.7544241885d),String.valueOf(900827.680516287d),String.valueOf(822269.245243714d),String.valueOf(1079196.47412278d),String.valueOf(574723.315587032d),String.valueOf(143506.7549125d),String.valueOf(360966.40362325d),String.valueOf(-256927.228879069d),String.valueOf(-0.1491078215d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1616258.50944d),String.valueOf(1616258.50944d),String.valueOf(0d),String.valueOf(1230692.4245852d),String.valueOf(290028.79685d),String.valueOf(178181.025402531d),String.valueOf(82082d),String.valueOf(190642d),String.valueOf(467484.129368504d),String.valueOf(0d),String.valueOf(22274.4729641612d),String.valueOf(1230692.4245852d),String.valueOf(385566.084854804d),String.valueOf(1079196.47412278d),String.valueOf(574723.315587032d),String.valueOf(143506.7549125d),String.valueOf(360966.40362325d),String.valueOf(-693630.389267978d),String.valueOf(-0.4291580742d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1774687.417536d),String.valueOf(1774687.417536d),String.valueOf(0d),String.valueOf(1000557.50389136d),String.valueOf(311593.50685d),String.valueOf(183560.093030329d),String.valueOf(0d),String.valueOf(0d),String.valueOf(482417.874685038d),String.valueOf(0d),String.valueOf(22986.0293259914d),String.valueOf(1000557.50389136d),String.valueOf(774129.913644642d),String.valueOf(1079196.47412278d),String.valueOf(574723.315587032d),String.valueOf(143506.7549125d),String.valueOf(360966.40362325d),String.valueOf(-305066.56047814d),String.valueOf(-0.1718987566d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1436833.7568d),String.valueOf(1436833.7568d),String.valueOf(0d),String.valueOf(787913.199426708d),String.valueOf(225302.5383d),String.valueOf(150774.609049682d),String.valueOf(0d),String.valueOf(0d),String.valueOf(393105.536749752d),String.valueOf(0d),String.valueOf(18730.5153272747d),String.valueOf(787913.199426708d),String.valueOf(648920.557373292d),String.valueOf(1079196.47412278d),String.valueOf(574723.315587032d),String.valueOf(143506.7549125d),String.valueOf(360966.40362325d),String.valueOf(-430275.91674949d),String.valueOf(-0.2994611692d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1520374.9968d),String.valueOf(1520374.9968d),String.valueOf(0d),String.valueOf(865304.913006551d),String.valueOf(269933.5957d),String.valueOf(159772.085700426d),String.valueOf(0d),String.valueOf(0d),String.valueOf(415787.954659877d),String.valueOf(0d),String.valueOf(19811.2769462486d),String.valueOf(865304.913006551d),String.valueOf(655070.083793448d),String.valueOf(1079196.47412278d),String.valueOf(574723.315587032d),String.valueOf(143506.7549125d),String.valueOf(360966.40362325d),String.valueOf(-424126.390329334d),String.valueOf(-0.2789616978d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(850759.587094892d),String.valueOf(850759.587094892d),String.valueOf(0d),String.valueOf(327142.877220675d),String.valueOf(146396.876416667d),String.valueOf(94216.56d),String.valueOf(12119.5513166667d),String.valueOf(60597.7565833333d),String.valueOf(7812.1329040088d),String.valueOf(0d),String.valueOf(6000d),String.valueOf(327142.877220675d),String.valueOf(523616.709874216d),String.valueOf(285899.65107714d),String.valueOf(170460.666666667d),String.valueOf(35960.0533333333d),String.valueOf(79478.9310771403d),String.valueOf(237717.058797076d),String.valueOf(0.2794174317d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(152001.738d),String.valueOf(113725.757d),String.valueOf(10665.895d),String.valueOf(27610.086d),String.valueOf(-152001.738d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(850759.587094892d),String.valueOf(850759.587094892d),String.valueOf(0d),String.valueOf(327142.877220675d),String.valueOf(146396.876416667d),String.valueOf(94216.56d),String.valueOf(12119.5513166667d),String.valueOf(60597.7565833333d),String.valueOf(7812.1329040088d),String.valueOf(0d),String.valueOf(6000d),String.valueOf(327142.877220675d),String.valueOf(523616.709874216d),String.valueOf(279829.65107714d),String.valueOf(165460.666666667d),String.valueOf(35960.0533333333d),String.valueOf(78408.9310771403d),String.valueOf(243787.058797076d),String.valueOf(0.2865522323d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1668371.088d),String.valueOf(1668371.088d),String.valueOf(0d),String.valueOf(548115.361d),String.valueOf(0d),String.valueOf(149498.068d),String.valueOf(0d),String.valueOf(398617.293d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(548115.361d),String.valueOf(1120255.727d),String.valueOf(186747.523d),String.valueOf(115323.15d),String.valueOf(10665.896d),String.valueOf(60758.477d),String.valueOf(933508.204d),String.valueOf(0.5595327147d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(850759.587094892d),String.valueOf(850759.587094892d),String.valueOf(0d),String.valueOf(327142.877220675d),String.valueOf(146396.876416667d),String.valueOf(94216.56d),String.valueOf(12119.5513166667d),String.valueOf(60597.7565833333d),String.valueOf(7812.1329040088d),String.valueOf(0d),String.valueOf(6000d),String.valueOf(327142.877220675d),String.valueOf(523616.709874216d),String.valueOf(279829.65107714d),String.valueOf(165460.666666667d),String.valueOf(35960.0533333333d),String.valueOf(78408.9310771403d),String.valueOf(243787.058797076d),String.valueOf(0.2865522323d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(1061517.31199999d),String.valueOf(1061517.31199999d),String.valueOf(0d),String.valueOf(154295.282d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(153617.676d),String.valueOf(0d),String.valueOf(677.606d),String.valueOf(0d),String.valueOf(154295.282d),String.valueOf(907222.02999999d),String.valueOf(162900.804d),String.valueOf(102381.752d),String.valueOf(10665.895d),String.valueOf(49853.157d),String.valueOf(744321.22599999d),String.valueOf(0.7011861395d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(850759.587094892d),String.valueOf(850759.587094892d),String.valueOf(0d),String.valueOf(327142.877220675d),String.valueOf(146396.876416667d),String.valueOf(94216.56d),String.valueOf(12119.5513166667d),String.valueOf(60597.7565833333d),String.valueOf(7812.1329040088d),String.valueOf(0d),String.valueOf(6000d),String.valueOf(327142.877220675d),String.valueOf(523616.709874216d),String.valueOf(279829.65107714d),String.valueOf(165460.666666667d),String.valueOf(35960.0533333333d),String.valueOf(78408.9310771403d),String.valueOf(243787.058797076d),String.valueOf(0.2865522323d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(946760.46d),String.valueOf(946760.46d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(946760.46d),String.valueOf(173436.998d),String.valueOf(93479.492d),String.valueOf(10665.889d),String.valueOf(69291.617d),String.valueOf(773323.462d),String.valueOf(0.8168100535d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(850759.587094892d),String.valueOf(850759.587094892d),String.valueOf(0d),String.valueOf(327142.877220675d),String.valueOf(146396.876416667d),String.valueOf(94216.56d),String.valueOf(12119.5513166667d),String.valueOf(60597.7565833333d),String.valueOf(7812.1329040088d),String.valueOf(0d),String.valueOf(6000d),String.valueOf(327142.877220675d),String.valueOf(523616.709874216d),String.valueOf(281079.65107714d),String.valueOf(166710.666666667d),String.valueOf(35960.0533333333d),String.valueOf(78408.9310771403d),String.valueOf(242537.058797076d),String.valueOf(0.285082957d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(912953.974d),String.valueOf(912953.974d),String.valueOf(0d),String.valueOf(355.354d),String.valueOf(267.873d),String.valueOf(87.481d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(355.354d),String.valueOf(912598.62d),String.valueOf(183040.066d),String.valueOf(142137.763d),String.valueOf(5849.203d),String.valueOf(35053.1d),String.valueOf(729558.554d),String.valueOf(0.7991186574d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(850759.587094892d),String.valueOf(850759.587094892d),String.valueOf(0d),String.valueOf(327142.877220675d),String.valueOf(146396.876416667d),String.valueOf(94216.56d),String.valueOf(12119.5513166667d),String.valueOf(60597.7565833333d),String.valueOf(7812.1329040088d),String.valueOf(0d),String.valueOf(6000d),String.valueOf(327142.877220675d),String.valueOf(523616.709874216d),String.valueOf(279829.65107714d),String.valueOf(165460.666666667d),String.valueOf(35960.0533333333d),String.valueOf(78408.9310771403d),String.valueOf(243787.058797076d),String.valueOf(0.2865522323d)},
        {String.valueOf(18187.624d),String.valueOf(692.871d),String.valueOf(726947.869d),String.valueOf(745828.364d),String.valueOf(0d),String.valueOf(1143179.368d),String.valueOf(267698.46d),String.valueOf(115300.186d),String.valueOf(0d),String.valueOf(760180.722d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1143179.368d),String.valueOf(-397351.004d),String.valueOf(136339.585d),String.valueOf(93542.782d),String.valueOf(10665.895d),String.valueOf(32130.908d),String.valueOf(-533690.589d),String.valueOf(-0.7155675686d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(850759.587094892d),String.valueOf(850759.587094892d),String.valueOf(0d),String.valueOf(327142.877220675d),String.valueOf(146396.876416667d),String.valueOf(94216.56d),String.valueOf(12119.5513166667d),String.valueOf(60597.7565833333d),String.valueOf(7812.1329040088d),String.valueOf(0d),String.valueOf(6000d),String.valueOf(327142.877220675d),String.valueOf(523616.709874216d),String.valueOf(285179.65107714d),String.valueOf(165460.666666667d),String.valueOf(35960.0533333333d),String.valueOf(83758.9310771403d),String.valueOf(238437.058797076d),String.valueOf(0.2802637342d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(875399.616d),String.valueOf(875399.616d),String.valueOf(0d),String.valueOf(1522455.55d),String.valueOf(765954.05d),String.valueOf(679456.16d),String.valueOf(0d),String.valueOf(0d),String.valueOf(77045.34d),String.valueOf(0d),String.valueOf(0d),String.valueOf(1522455.55d),String.valueOf(-647055.934d),String.valueOf(163372.37d),String.valueOf(132529.78d),String.valueOf(10665.893d),String.valueOf(20176.697d),String.valueOf(-810428.304d),String.valueOf(-0.9257809681d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(850759.587094892d),String.valueOf(850759.587094892d),String.valueOf(0d),String.valueOf(327142.877220675d),String.valueOf(146396.876416667d),String.valueOf(94216.56d),String.valueOf(12119.5513166667d),String.valueOf(60597.7565833333d),String.valueOf(7812.1329040088d),String.valueOf(0d),String.valueOf(6000d),String.valueOf(327142.877220675d),String.valueOf(523616.709874216d),String.valueOf(280899.65107714d),String.valueOf(165460.666666667d),String.valueOf(35960.0533333333d),String.valueOf(79478.9310771403d),String.valueOf(242717.058797076d),String.valueOf(0.2852945326d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(850759.587094892d),String.valueOf(850759.587094892d),String.valueOf(0d),String.valueOf(327142.877220675d),String.valueOf(146396.876416667d),String.valueOf(94216.56d),String.valueOf(12119.5513166667d),String.valueOf(60597.7565833333d),String.valueOf(7812.1329040088d),String.valueOf(0d),String.valueOf(6000d),String.valueOf(327142.877220675d),String.valueOf(523616.709874216d),String.valueOf(280579.65107714d),String.valueOf(166210.666666667d),String.valueOf(35960.0533333333d),String.valueOf(78408.9310771403d),String.valueOf(243037.058797076d),String.valueOf(0.2856706671d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(850759.587094892d),String.valueOf(850759.587094892d),String.valueOf(0d),String.valueOf(327142.877220675d),String.valueOf(146396.876416667d),String.valueOf(94216.56d),String.valueOf(12119.5513166667d),String.valueOf(60597.7565833333d),String.valueOf(7812.1329040088d),String.valueOf(0d),String.valueOf(6000d),String.valueOf(327142.877220675d),String.valueOf(523616.709874216d),String.valueOf(279829.65107714d),String.valueOf(165460.666666667d),String.valueOf(35960.0533333333d),String.valueOf(78408.9310771403d),String.valueOf(243787.058797076d),String.valueOf(0.2865522323d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(850759.587094892d),String.valueOf(850759.587094892d),String.valueOf(0d),String.valueOf(327142.877220675d),String.valueOf(146396.876416667d),String.valueOf(94216.56d),String.valueOf(12119.5513166667d),String.valueOf(60597.7565833333d),String.valueOf(7812.1329040088d),String.valueOf(0d),String.valueOf(6000d),String.valueOf(327142.877220675d),String.valueOf(523616.709874216d),String.valueOf(279829.65107714d),String.valueOf(165460.666666667d),String.valueOf(35960.0533333333d),String.valueOf(78408.9310771403d),String.valueOf(243787.058797076d),String.valueOf(0.2865522323d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(850759.587094892d),String.valueOf(850759.587094892d),String.valueOf(0d),String.valueOf(327142.877220675d),String.valueOf(146396.876416667d),String.valueOf(94216.56d),String.valueOf(12119.5513166667d),String.valueOf(60597.7565833333d),String.valueOf(7812.1329040088d),String.valueOf(0d),String.valueOf(6000d),String.valueOf(327142.877220675d),String.valueOf(523616.709874216d),String.valueOf(280329.65107714d),String.valueOf(165960.666666667d),String.valueOf(35960.0533333333d),String.valueOf(78408.9310771403d),String.valueOf(243287.058797076d),String.valueOf(0.2859645222d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)},
        {String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d),String.valueOf(0d)}
    };
    /**
     *
     * @param level
     * @return
     */
    public O_DataDetails DataDetails(String level){
        O_DataDetails data = new O_DataDetails();
        data.setDataActual(dataTargetTemp);
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
        return Insert(Query);
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
