package Assignment_1;

public class Vaccine {

    private String name;
    private int numofDoses;
    private int doseGap;

    public Vaccine(String name, int numofDoses, int doseGap) {
        this.name = name;
        this.numofDoses = numofDoses;
        this.doseGap = doseGap;
    }

    public String getName() {
        return name;
    }

    public int getNumofDoses() {
        return numofDoses;
    }

    public int getDoseGap() {
        return doseGap;
    }

    public void setNumofDoses(int numofDoses) {
        this.numofDoses = numofDoses;
    }

    public void setDoseGap(int doseGap) {
        this.doseGap = doseGap;
    }
}
