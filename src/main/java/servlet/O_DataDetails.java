package servlet;

public class O_DataDetails {

    private Double[][] dataTarget, dataActual,dataPercent, dataTotal;
    private String[] dataProject;

    public Double[][] getDataTotal() {
        return dataTotal;
    }

    public void setDataTotal(Double[][] dataTotal) {
        this.dataTotal = dataTotal;
    }

    public String[] getDataProject() {
        return dataProject;
    }

    public void setDataProject(String[] dataProject) {
        this.dataProject = dataProject;
    }

    public Double[][] getDataPercent() {

        return dataPercent;
    }

    public void setDataPercent(Double[][] dataPercent) {
        this.dataPercent = dataPercent;
    }

    public Double[][] getDataTarget() {
        return dataTarget;
    }

    public void setDataTarget(Double[][] dataTarget) {
        this.dataTarget = dataTarget;
    }

    public Double[][] getDataActual() {
        return dataActual;
    }

    public void setDataActual(Double[][] dataActual) {
        this.dataActual = dataActual;
    }

}
