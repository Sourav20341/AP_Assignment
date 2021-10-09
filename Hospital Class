package Assignment_1;

import java.util.*;

public class Hospital {
    private String name;
    private int pincode;
    private int uniqueId;
    private ArrayList<Slot> slots = new ArrayList<>();

    public String getName() {
        return name;
    }

    public int getPincode() {
        return pincode;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<Slot> slots) {
        this.slots = slots;
    }

    public Hospital(String name, int pincode, int uniqueId){
        this.name = name;
        this.pincode = pincode;
        this.uniqueId = uniqueId;
    }

    public void addSlot(String vacName,int num,int qan){
        Slot s = new Slot(vacName,num,qan);
        slots.add(s);
        sort();
    }

    private void sort(){
        for(int i = 0;i<slots.size();i++){
            for(int j = i+1;j<slots.size();j++){
                if(slots.get(i).getDayNum() > slots.get(j).getDayNum()){
                    Collections.swap(slots,i,j);
                }
            }
        }
    }
}
