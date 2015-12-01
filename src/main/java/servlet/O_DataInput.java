package servlet;

import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author DimasInchidi
 */
public class O_DataInput {

    private static final Logger LOG = getLogger(O_DataInput.class.getName());
    private int ComboProjectHomeIndex;


    private int TahunDataHome;
    private int BulanDataHome;
    private String ComboProjectHomeItem, DataProyek;
    private String SPAREPARTS_Actual,SMC_Actual,FMS_Actual,REVENUE_Actual,COSTOFSALES_SPAREPARTS__Actual,COSTOFSALES_SERVICE__Actual,PeriodicMaintenance_Actual,PartRepair_Actual,PartRAndI_Actual,Component_Actual,GETAndUndercarriageGroup_Actual,WarrantyAndCampaign_Actual,Consumable_Actual,TOTALCOGS_Actual,GROSSPROFIT_Actual,EXPENSES_Actual,EmployeeExpenses_Actual,AssetDepreciation_Actual,OperationExpenses_Actual,OPRPROFIT_Actual,PROFITPercentOFSALESActual;
    private String SPAREPARTS_Target,SMC_Target,FMS_Target,REVENUE_Target,COSTOFSALES_SPAREPARTS__Target,COSTOFSALES_SERVICE__Target,PeriodicMaintenance_Target,PartRepair_Target,PartRAndI_Target,Component_Target,GETAndUndercarriageGroup_Target,WarrantyAndCampaign_Target,Consumable_Target,TOTALCOGS_Target,GROSSPROFIT_Target,EXPENSES_Target,EmployeeExpenses_Target,AssetDepreciation_Target,OperationExpenses_Target,OPRPROFIT_Target,PROFITPercentOFSALESTarget;
    /**
     *
     * @return
     */
    public String getDataProyek() {
        return DataProyek;
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
    public int getComboProjectHomeIndex() {
        return ComboProjectHomeIndex;
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
     * @return
     */
    public int getTahunDataHome() {
        return TahunDataHome;
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
     * @return
     */
    public int getBulanDataHome() {
        return BulanDataHome;
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
     * @return
     */
    public String getComboProjectHomeItem() {
        return ComboProjectHomeItem;
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
    public String getSPAREPARTS_Actual() {
        return SPAREPARTS_Actual;
    }

    /**
     *
     * @param SPAREPARTS_Actual
     */
    public void setSPAREPARTS_Actual(String SPAREPARTS_Actual) {
        this.SPAREPARTS_Actual = SPAREPARTS_Actual;
    }

    /**
     *
     * @return
     */
    public String getSMC_Actual() {
        return SMC_Actual;
    }

    /**
     *
     * @param SMC_Actual
     */
    public void setSMC_Actual(String SMC_Actual) {
        this.SMC_Actual = SMC_Actual;
    }

    /**
     *
     * @return
     */
    public String getFMS_Actual() {
        return FMS_Actual;
    }

    /**
     *
     * @param FMS_Actual
     */
    public void setFMS_Actual(String FMS_Actual) {
        this.FMS_Actual = FMS_Actual;
    }

    /**
     *
     * @return
     */
    public String getREVENUE_Actual() {
        return REVENUE_Actual;
    }

    /**
     *
     * @param REVENUE_Actual
     */
    public void setREVENUE_Actual(String REVENUE_Actual) {
        this.REVENUE_Actual = REVENUE_Actual;
    }

    /**
     *
     * @return
     */
    public String getCOSTOFSALES_SPAREPARTS__Actual() {
        return COSTOFSALES_SPAREPARTS__Actual;
    }

    /**
     *
     * @param COSTOFSALES_SPAREPARTS__Actual
     */
    public void setCOSTOFSALES_SPAREPARTS__Actual(String COSTOFSALES_SPAREPARTS__Actual) {
        this.COSTOFSALES_SPAREPARTS__Actual = COSTOFSALES_SPAREPARTS__Actual;
    }

    /**
     *
     * @return
     */
    public String getCOSTOFSALES_SERVICE__Actual() {
        return COSTOFSALES_SERVICE__Actual;
    }

    /**
     *
     * @param COSTOFSALES_SERVICE__Actual
     */
    public void setCOSTOFSALES_SERVICE__Actual(String COSTOFSALES_SERVICE__Actual) {
        this.COSTOFSALES_SERVICE__Actual = COSTOFSALES_SERVICE__Actual;
    }

    /**
     *
     * @return
     */
    public String getPeriodicMaintenance_Actual() {
        return PeriodicMaintenance_Actual;
    }

    /**
     *
     * @param periodicMaintenance_Actual
     */
    public void setPeriodicMaintenance_Actual(String periodicMaintenance_Actual) {
        PeriodicMaintenance_Actual = periodicMaintenance_Actual;
    }

    /**
     *
     * @return
     */
    public String getPartRepair_Actual() {
        return PartRepair_Actual;
    }

    /**
     *
     * @param partRepair_Actual
     */
    public void setPartRepair_Actual(String partRepair_Actual) {
        PartRepair_Actual = partRepair_Actual;
    }

    /**
     *
     * @return
     */
    public String getPartRAndI_Actual() {
        return PartRAndI_Actual;
    }

    /**
     *
     * @param partRAndI_Actual
     */
    public void setPartRAndI_Actual(String partRAndI_Actual) {
        PartRAndI_Actual = partRAndI_Actual;
    }

    /**
     *
     * @return
     */
    public String getComponent_Actual() {
        return Component_Actual;
    }

    /**
     *
     * @param component_Actual
     */
    public void setComponent_Actual(String component_Actual) {
        Component_Actual = component_Actual;
    }

    /**
     *
     * @return
     */
    public String getGETAndUndercarriageGroup_Actual() {
        return GETAndUndercarriageGroup_Actual;
    }

    /**
     *
     * @param GETAndUndercarriageGroup_Actual
     */
    public void setGETAndUndercarriageGroup_Actual(String GETAndUndercarriageGroup_Actual) {
        this.GETAndUndercarriageGroup_Actual = GETAndUndercarriageGroup_Actual;
    }

    /**
     *
     * @return
     */
    public String getWarrantyAndCampaign_Actual() {
        return WarrantyAndCampaign_Actual;
    }

    /**
     *
     * @param warrantyAndCampaign_Actual
     */
    public void setWarrantyAndCampaign_Actual(String warrantyAndCampaign_Actual) {
        WarrantyAndCampaign_Actual = warrantyAndCampaign_Actual;
    }

    /**
     *
     * @return
     */
    public String getConsumable_Actual() {
        return Consumable_Actual;
    }

    /**
     *
     * @param consumable_Actual
     */
    public void setConsumable_Actual(String consumable_Actual) {
        Consumable_Actual = consumable_Actual;
    }

    /**
     *
     * @return
     */
    public String getTOTALCOGS_Actual() {
        return TOTALCOGS_Actual;
    }

    /**
     *
     * @param TOTALCOGS_Actual
     */
    public void setTOTALCOGS_Actual(String TOTALCOGS_Actual) {
        this.TOTALCOGS_Actual = TOTALCOGS_Actual;
    }

    /**
     *
     * @return
     */
    public String getGROSSPROFIT_Actual() {
        return GROSSPROFIT_Actual;
    }

    /**
     *
     * @param GROSSPROFIT_Actual
     */
    public void setGROSSPROFIT_Actual(String GROSSPROFIT_Actual) {
        this.GROSSPROFIT_Actual = GROSSPROFIT_Actual;
    }

    /**
     *
     * @return
     */
    public String getEXPENSES_Actual() {
        return EXPENSES_Actual;
    }

    /**
     *
     * @param EXPENSES_Actual
     */
    public void setEXPENSES_Actual(String EXPENSES_Actual) {
        this.EXPENSES_Actual = EXPENSES_Actual;
    }

    /**
     *
     * @return
     */
    public String getEmployeeExpenses_Actual() {
        return EmployeeExpenses_Actual;
    }

    /**
     *
     * @param employeeExpenses_Actual
     */
    public void setEmployeeExpenses_Actual(String employeeExpenses_Actual) {
        EmployeeExpenses_Actual = employeeExpenses_Actual;
    }

    /**
     *
     * @return
     */
    public String getAssetDepreciation_Actual() {
        return AssetDepreciation_Actual;
    }

    /**
     *
     * @param assetDepreciation_Actual
     */
    public void setAssetDepreciation_Actual(String assetDepreciation_Actual) {
        AssetDepreciation_Actual = assetDepreciation_Actual;
    }

    /**
     *
     * @return
     */
    public String getOperationExpenses_Actual() {
        return OperationExpenses_Actual;
    }

    /**
     *
     * @param operationExpenses_Actual
     */
    public void setOperationExpenses_Actual(String operationExpenses_Actual) {
        OperationExpenses_Actual = operationExpenses_Actual;
    }

    /**
     *
     * @return
     */
    public String getOPRPROFIT_Actual() {
        return OPRPROFIT_Actual;
    }

    /**
     *
     * @param OPRPROFIT_Actual
     */
    public void setOPRPROFIT_Actual(String OPRPROFIT_Actual) {
        this.OPRPROFIT_Actual = OPRPROFIT_Actual;
    }

    /**
     *
     * @return
     */
    public String getPROFITPercentOFSALESActual() {
        return PROFITPercentOFSALESActual;
    }

    /**
     *
     * @param PROFITPercentOFSALESActual
     */
    public void setPROFITPercentOFSALESActual(String PROFITPercentOFSALESActual) {
        this.PROFITPercentOFSALESActual = PROFITPercentOFSALESActual;
    }

    /**
     *
     * @return
     */
    public String getSPAREPARTS_Target() {
        return SPAREPARTS_Target;
    }

    /**
     *
     * @param SPAREPARTS_Target
     */
    public void setSPAREPARTS_Target(String SPAREPARTS_Target) {
        this.SPAREPARTS_Target = SPAREPARTS_Target;
    }

    /**
     *
     * @return
     */
    public String getSMC_Target() {
        return SMC_Target;
    }

    /**
     *
     * @param SMC_Target
     */
    public void setSMC_Target(String SMC_Target) {
        this.SMC_Target = SMC_Target;
    }

    /**
     *
     * @return
     */
    public String getFMS_Target() {
        return FMS_Target;
    }

    /**
     *
     * @param FMS_Target
     */
    public void setFMS_Target(String FMS_Target) {
        this.FMS_Target = FMS_Target;
    }

    /**
     *
     * @return
     */
    public String getREVENUE_Target() {
        return REVENUE_Target;
    }

    /**
     *
     * @param REVENUE_Target
     */
    public void setREVENUE_Target(String REVENUE_Target) {
        this.REVENUE_Target = REVENUE_Target;
    }

    /**
     *
     * @return
     */
    public String getCOSTOFSALES_SPAREPARTS__Target() {
        return COSTOFSALES_SPAREPARTS__Target;
    }

    /**
     *
     * @param COSTOFSALES_SPAREPARTS__Target
     */
    public void setCOSTOFSALES_SPAREPARTS__Target(String COSTOFSALES_SPAREPARTS__Target) {
        this.COSTOFSALES_SPAREPARTS__Target = COSTOFSALES_SPAREPARTS__Target;
    }

    /**
     *
     * @return
     */
    public String getCOSTOFSALES_SERVICE__Target() {
        return COSTOFSALES_SERVICE__Target;
    }

    /**
     *
     * @param COSTOFSALES_SERVICE__Target
     */
    public void setCOSTOFSALES_SERVICE__Target(String COSTOFSALES_SERVICE__Target) {
        this.COSTOFSALES_SERVICE__Target = COSTOFSALES_SERVICE__Target;
    }

    /**
     *
     * @return
     */
    public String getPeriodicMaintenance_Target() {
        return PeriodicMaintenance_Target;
    }

    /**
     *
     * @param periodicMaintenance_Target
     */
    public void setPeriodicMaintenance_Target(String periodicMaintenance_Target) {
        PeriodicMaintenance_Target = periodicMaintenance_Target;
    }

    /**
     *
     * @return
     */
    public String getPartRepair_Target() {
        return PartRepair_Target;
    }

    /**
     *
     * @param partRepair_Target
     */
    public void setPartRepair_Target(String partRepair_Target) {
        PartRepair_Target = partRepair_Target;
    }

    /**
     *
     * @return
     */
    public String getPartRAndI_Target() {
        return PartRAndI_Target;
    }

    /**
     *
     * @param partRAndI_Target
     */
    public void setPartRAndI_Target(String partRAndI_Target) {
        PartRAndI_Target = partRAndI_Target;
    }

    /**
     *
     * @return
     */
    public String getComponent_Target() {
        return Component_Target;
    }

    /**
     *
     * @param component_Target
     */
    public void setComponent_Target(String component_Target) {
        Component_Target = component_Target;
    }

    /**
     *
     * @return
     */
    public String getGETAndUndercarriageGroup_Target() {
        return GETAndUndercarriageGroup_Target;
    }

    /**
     *
     * @param GETAndUndercarriageGroup_Target
     */
    public void setGETAndUndercarriageGroup_Target(String GETAndUndercarriageGroup_Target) {
        this.GETAndUndercarriageGroup_Target = GETAndUndercarriageGroup_Target;
    }

    /**
     *
     * @return
     */
    public String getWarrantyAndCampaign_Target() {
        return WarrantyAndCampaign_Target;
    }

    /**
     *
     * @param warrantyAndCampaign_Target
     */
    public void setWarrantyAndCampaign_Target(String warrantyAndCampaign_Target) {
        WarrantyAndCampaign_Target = warrantyAndCampaign_Target;
    }

    /**
     *
     * @return
     */
    public String getConsumable_Target() {
        return Consumable_Target;
    }

    /**
     *
     * @param consumable_Target
     */
    public void setConsumable_Target(String consumable_Target) {
        Consumable_Target = consumable_Target;
    }

    /**
     *
     * @return
     */
    public String getTOTALCOGS_Target() {
        return TOTALCOGS_Target;
    }

    /**
     *
     * @param TOTALCOGS_Target
     */
    public void setTOTALCOGS_Target(String TOTALCOGS_Target) {
        this.TOTALCOGS_Target = TOTALCOGS_Target;
    }

    /**
     *
     * @return
     */
    public String getGROSSPROFIT_Target() {
        return GROSSPROFIT_Target;
    }

    /**
     *
     * @param GROSSPROFIT_Target
     */
    public void setGROSSPROFIT_Target(String GROSSPROFIT_Target) {
        this.GROSSPROFIT_Target = GROSSPROFIT_Target;
    }

    /**
     *
     * @return
     */
    public String getEXPENSES_Target() {
        return EXPENSES_Target;
    }

    /**
     *
     * @param EXPENSES_Target
     */
    public void setEXPENSES_Target(String EXPENSES_Target) {
        this.EXPENSES_Target = EXPENSES_Target;
    }

    /**
     *
     * @return
     */
    public String getEmployeeExpenses_Target() {
        return EmployeeExpenses_Target;
    }

    /**
     *
     * @param employeeExpenses_Target
     */
    public void setEmployeeExpenses_Target(String employeeExpenses_Target) {
        EmployeeExpenses_Target = employeeExpenses_Target;
    }

    /**
     *
     * @return
     */
    public String getAssetDepreciation_Target() {
        return AssetDepreciation_Target;
    }

    /**
     *
     * @param assetDepreciation_Target
     */
    public void setAssetDepreciation_Target(String assetDepreciation_Target) {
        AssetDepreciation_Target = assetDepreciation_Target;
    }

    /**
     *
     * @return
     */
    public String getOperationExpenses_Target() {
        return OperationExpenses_Target;
    }

    /**
     *
     * @param operationExpenses_Target
     */
    public void setOperationExpenses_Target(String operationExpenses_Target) {
        OperationExpenses_Target = operationExpenses_Target;
    }

    /**
     *
     * @return
     */
    public String getOPRPROFIT_Target() {
        return OPRPROFIT_Target;
    }

    /**
     *
     * @param OPRPROFIT_Target
     */
    public void setOPRPROFIT_Target(String OPRPROFIT_Target) {
        this.OPRPROFIT_Target = OPRPROFIT_Target;
    }

    /**
     *
     * @return
     */
    public String getPROFITPercentOFSALESTarget() {
        return PROFITPercentOFSALESTarget;
    }

    /**
     *
     * @param PROFITPercentOFSALESTarget
     */
    public void setPROFITPercentOFSALESTarget(String PROFITPercentOFSALESTarget) {
        this.PROFITPercentOFSALESTarget = PROFITPercentOFSALESTarget;
    }
}
