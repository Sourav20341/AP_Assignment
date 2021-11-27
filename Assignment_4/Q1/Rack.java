package Assignment_4.Q1;

import java.util.*;

public class Rack {
    static int id = 1;
    private final ArrayList<Slot>slots;
    private final int ID;
    public Rack(ArrayList<Slot> slots) {
        this.slots = slots;
        ID = id;
        id ++;
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }

    @Override
    public String toString(){
        String result = "Rack ID : "+ this.ID + " ";
        for(Slot slot : slots){
            result = result.concat(slot.toString());
        }
        return result;
    }
}
