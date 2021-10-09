package Assignment_1;

public class Citizen {
    private String name;
    private int age;
    private long uniqueId;
    private String VaccinStatus = "Registered";
    private String VaccineName;
    private int dosetime;
    private int doses;

    public Citizen(String name,int age,long ID){
        this.name = name;
        this.age = age;
        this.uniqueId = ID;
    }

    public String getName() {
        return name;
    }

    public int getDosetime() {
        return dosetime;
    }

    public void setDosetime(int dosetime) {
        this.dosetime = dosetime;
    }

    public void setDoses(int doses) {
        this.doses = doses;
    }

    public int getDoses() {
        return doses;
    }

    public String getVaccineName() {
        return VaccineName;
    }

    public void setVaccineName(String vaccineName) {
        VaccineName = vaccineName;
    }

    public long getUniqueId() {
        return uniqueId;
    }

    public String getVaccinStatus(){
        if(VaccinStatus == null){
            return "Not Updated";
        }
        return VaccinStatus;
    }

    public void setVaccinStatus(String status){
        this.VaccinStatus = status;
    }
}
