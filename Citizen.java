package Assignment_1;

public class Citizen {
    private String name;
    private int age;
    private long uniqueId;
    private String VaccinStatus;

    public Citizen(String name,int age,long ID){
        this.name = name;
        this.age = age;
        this.uniqueId = ID;
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

    public void slotBook(){

    }
}
