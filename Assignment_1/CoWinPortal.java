package Assignment_1;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CoWin_Portal {

    public static String uniqueIdGenerator(){
        int number = ThreadLocalRandom.current().nextInt(100000 , 1000000);
        return String.format("%06d", number);
    }

    public static void main(String[] args) {

        System.out.println("********************CoWin_Portal*******************");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        ArrayList<Vaccine>vaccineList = new ArrayList<>();
        ArrayList<Hospital>HospitalRegistry = new ArrayList<>();
        ArrayList<Citizen>CitizenRegistry = new ArrayList<>();

        while(true) {
            System.out.println("==========================================================");
            System.out.println("                      Option Menu                         ");
            System.out.println("==========================================================");
            System.out.println(1 + " Add Vaccine");
            System.out.println(2 + " Register Hospital");
            System.out.println(3 + " Register Citizen");
            System.out.println(4 + " Create Slot for Vaccination");
            System.out.println(5 + " Book Slot for Vaccination");
            System.out.println(6 + " List all slots for a hospital");
            System.out.println(7 + " Check Vaccination Status");
            System.out.println(8 + " Exit");
            System.out.println("==========================================================");
            System.out.print("Enter the number of operation from the option menu : ");
            int n;
            n = sc.nextInt();

            //Add Vaccine

            if(n == 1) {

                String name;
                int DosesNumber;
                int DoseGap;
                int vaccineIndex = -1;
                sc.nextLine();
                System.out.print("Enter the name of the vaccine : ");
                name = sc.nextLine();
                for (Vaccine vac : vaccineList) {
                    if (vac.getName().equalsIgnoreCase(name.toUpperCase())) {
                        vaccineIndex = vaccineList.indexOf(vac);
                    }
                }
                while (true) {
                    System.out.print("Enter the number of doses required : ");
                    DosesNumber = sc.nextInt();
                    if (DosesNumber <= 0) {
                        System.out.println("Enter the valid number of doses!");
                    } else {
                        break;
                    }
                }
                while(true){
                    System.out.print("Enter the number of Gaps between doses : ");
                    DoseGap = sc.nextInt();
                    if(DoseGap < 0){
                        System.out.println("Enter a valid Gap between Doses!");
                    }
                    else{
                        break;
                    }
                }
                if (vaccineIndex == -1) {
                    Vaccine vac = new Vaccine(name, DosesNumber, DoseGap);
                    vaccineList.add(vac);
                    System.out.println("Successfully Vaccine is added");
                    System.out.println("=================================");
                    System.out.println("Details of the added vaccine");
                    System.out.println("=================================");
                    System.out.print("Name of the vaccine : ");
                    int vaccineIdx;
                    vaccineIdx = vaccineList.indexOf(vac);
                    System.out.println(vaccineList.get(vaccineIdx).getName());
                    System.out.print("Number of Doses required : ");
                    System.out.println(vaccineList.get(vaccineIdx).getNumofDoses());
                    System.out.print("Number of Gaps required between doses : ");
                    System.out.println(vaccineList.get(vaccineIdx).getDoseGap());
                    System.out.println("=================================");
                } else {
                    vaccineList.get(vaccineIndex).setNumofDoses(DosesNumber);
                    vaccineList.get(vaccineIndex).setDoseGap(DoseGap);
                    System.out.println("Successfully Vaccine is Updated");
                    System.out.println("=================================");
                    System.out.println("Details of the Updated vaccine");
                    System.out.println("=================================");
                    System.out.print("Name of the vaccine : ");
                    System.out.println(vaccineList.get(vaccineIndex).getName());
                    System.out.print("Number of Doses required : ");
                    System.out.println(vaccineList.get(vaccineIndex).getNumofDoses());
                    System.out.print("Number of Gaps required between doses : ");
                    System.out.println(vaccineList.get(vaccineIndex).getDoseGap());
                    System.out.println("=================================");
                }
            }

            // Hospital Registry

            else if(n == 2){
                boolean isRegistered = false;
                String name;
                int pincode;
                int uniqueid;
                sc.nextLine();
                System.out.print("Enter the name of the hospital : ");
                name = sc.nextLine();
                for (Hospital hospital:HospitalRegistry) {
                    if(hospital.getName().equalsIgnoreCase(name)){
                        System.out.println("This Hospital is already registered with this portal!");
                        isRegistered = true;
                        break;
                    }
                }
                if(!isRegistered){
                    System.out.print("Enter the pincode of the hospital : ");
                    pincode = sc.nextInt();
                    uniqueid = Integer.parseInt(uniqueIdGenerator());
                    Hospital hospital = new Hospital(name,pincode,uniqueid);
                    HospitalRegistry.add(hospital);
                    System.out.println("=================================");
                    System.out.println("Details of the added Hospital");
                    System.out.println("=================================");
                    System.out.println("Name of the Hospital : " + hospital.getName());
                    System.out.println("Pincode of the Hospital : " + hospital.getPincode());
                    System.out.println("ID of the Hospital : "+hospital.getUniqueId());
                }
            }

            // Citizen Registry

            else if(n == 3){
                boolean isRegistered = false;
                String citizeName;
                int Age;
                boolean isStop = false;
                long uniqueId;
                sc.nextLine();
                System.out.print("Enter the name of the citizen : ");
                citizeName = sc.nextLine();
                while(true) {
                    System.out.print("Enter Your 12 Digit ID : ");
                    uniqueId = sc.nextLong();
                    int length = String.valueOf(uniqueId).length();
                    if (length != 12) {
                        System.out.println("Your ID should be of 12 Digits only.Please check once again and then retry!If you enter 0 then you go to the option menu");
                    }
                    else if(uniqueId == 0){
                        isStop = true;
                        break;
                    }
                    else{
                        break;
                    }
                }
                if(isStop){
                    System.out.println("Going to the option menu!");
                    continue;
                }
                for (Citizen cit: CitizenRegistry) {
                    if(cit.getUniqueId() == uniqueId){
                        System.out.println("This Citizen is already registered to this portal!");
                        isRegistered = true;
                        break;
                    }
                }
                if(!isRegistered){
                    System.out.print("Enter the age of the citizen : ");
                    Age = sc.nextInt();
                    Citizen citizen = new Citizen(citizeName,Age,uniqueId);
                    System.out.println("=================================");
                    System.out.println("Details of the added Citizen");
                    System.out.println("=================================");
                    System.out.println("Citizen Name : "+citizeName);
                    System.out.println("Citizen age : "+Age);
                    System.out.println("Citizen ID : "+uniqueId);
                    if(Age <= 18){
                        System.out.println("Only above 18 are allowed!");
                    }
                    else {
                        CitizenRegistry.add(citizen);
                    }
                }
            }

            // Create a slot

            else if(n == 4) {
                long Hospitalid;
                int desireHospitalIndex = -1;
                boolean isExit = false;
                boolean isStop = false;
                while (true) {
                    System.out.print("Enter the Hospital ID in which you have to create a slot : ");
                    Hospitalid = sc.nextLong();
                    for (Hospital hospital : HospitalRegistry) {
                        if (hospital.getUniqueId() == Hospitalid) {
                            desireHospitalIndex = HospitalRegistry.indexOf(hospital);
                            break;
                        }
                    }
                    if(Hospitalid == 0){
                        isStop = true;
                        break;
                    }
                    if (desireHospitalIndex == -1) {
                        System.out.println("No Hospital is found with ID " + Hospitalid + ".Try Again!You also enter 0 in Hospital ID for Stopping!");
                    } else {
                        break;
                    }
                }
                if(isStop){
                    System.out.println("Quitting!");
                    continue;
                }
                int numberOfSlots;
                System.out.print("Enter the number of slots which you have to create in this Hospital : ");
                numberOfSlots = sc.nextInt();
                if (numberOfSlots <= 0) {
                    System.out.println("No slot has been created!");
                    break;
                }
                for (int i = 0; i < numberOfSlots; i++) {
                    int dayNumber;
                    int vaccQuantity;
                    String vaccineName = null;
                    int s = 0;
                    System.out.println("-----------------------------------------");
                    System.out.println("Select Vaccine");
                    for (Vaccine vac : vaccineList) {
                        System.out.println(s + " " + vac.getName());
                        s++;
                    }
                    if (s == 0) {
                        System.out.println("No vaccine is present for creating a slot, So please add the vaccine first!");
                        break;
                    }
                    int vaccineNameIndex;
                    while (true) {
                        System.out.print("Choose the index from above list which you have to add : ");
                        vaccineNameIndex = sc.nextInt();
                        if (vaccineNameIndex >= 0 && vaccineNameIndex < s) {
                            vaccineName = vaccineList.get(vaccineNameIndex).getName();
                            break;
                        } else if (vaccineNameIndex == -1) {
                            break;
                        } else {
                            System.out.println("You select an invalid option please check once again the list and enter your choice again!");
                            System.out.println("If you don't want to create more slots then you can enter -1 then you will be exit from this operation");
                        }
                    }
                    if (vaccineNameIndex == -1) {
                        isExit = true;
                        break;
                    }
                    System.out.print("Enter the day number : ");
                    dayNumber = sc.nextInt();
                    System.out.print("Enter the vaccine quantity : ");
                    vaccQuantity = sc.nextInt();
                    HospitalRegistry.get(desireHospitalIndex).addSlot(vaccineName, dayNumber, vaccQuantity);
                    vaccineList.get(vaccineNameIndex).setNumofDoses(vaccineList.get(vaccineNameIndex).getNumofDoses() - vaccQuantity);
                    System.out.println("Slot has been created successfully!");
                    System.out.println("=================================");
                    System.out.println("Details of the added slot");
                    System.out.println("=================================");
                    System.out.println("Slot added by Hospital with ID " + Hospitalid + " on Day : " + dayNumber + " with Available Quantiy : " + vaccQuantity + " of Vaccine : " + vaccineName);
                }
                if (isExit) {
                    System.out.println("Quiting!");
                }else {
                    System.out.println("All slots has been created successfully!");
                }
            }

            // Book a Slot

            else if(n == 5){
                long PId;
                int Oper;
                int checkerStatus;
                int citizenIndex = -1;
                System.out.print("Enter the Citizen's unique ID : ");
                PId = sc.nextLong();
                for (Citizen citizen:CitizenRegistry) {
                    if(citizen.getUniqueId() == PId){
                        citizenIndex = CitizenRegistry.indexOf(citizen);
                    }
                }
                if(citizenIndex == -1){
                    System.out.println("No Patient Found!Try Again");
                    continue;
                }
                if(CitizenRegistry.get(citizenIndex).getVaccinStatus().equalsIgnoreCase("Fully Vaccinated")){
                    System.out.println("Citizen is already fully vaccinated! So you can't book a slot.");
                    continue;
                }
                else if(CitizenRegistry.get(citizenIndex).getVaccinStatus().equalsIgnoreCase("Partially Vaccinated")){
                    checkerStatus = 1;
                }
                else{
                    checkerStatus = 2;
                }
                while(true){
                    System.out.println("1. Search by area");
                    System.out.println("2. Search by vaccine");
                    System.out.println("3. Exit");
                    System.out.print("Enter the option from above searching method's table : ");
                    Oper = sc.nextInt();

                    if(Oper == 1){
                        int hospitalIndex = -1;
                        ArrayList<Hospital>SearchedValues = new ArrayList<>();
                        int pin;
                        System.out.print("Enter the pincode : ");
                        pin = sc.nextInt();
                        for (Hospital hospital: HospitalRegistry)
                        {
                            if(hospital.getPincode() == pin){
                                SearchedValues.add(hospital);
                            }
                        }
                        if(!SearchedValues.isEmpty()){
                            for (Hospital hospital:SearchedValues) {
                                System.out.println("Hospital's ID : " + hospital.getUniqueId());
                                System.out.println("Hospital's Name : " + hospital.getName());
                                System.out.println();
                            }
                            while(true) {
                                int HID;
                                System.out.print("Enter Hospital ID in which you have to book a slot from above : ");
                                HID = sc.nextInt();
                                for (Hospital hospital : SearchedValues) {
                                    if (hospital.getUniqueId() == HID) {
                                        hospitalIndex = HospitalRegistry.indexOf(hospital);
                                        break;
                                    }
                                }
                                if(hospitalIndex == -1){
                                    System.out.println("Enter a valid Hospital ID.No Hospital is found with this ID!");
                                }
                                else{
                                    break;
                                }
                            }
                            int i = 0;
                            ArrayList<String>VaccineName = new ArrayList<>();
                            ArrayList<Integer>daynum = new ArrayList<>();
                            for (Slot slot:HospitalRegistry.get(hospitalIndex).getSlots()) {
                                VaccineName.add(slot.getVaccineName());
                                daynum.add(slot.getDayNum());
                                System.out.println(i + "--> Day : "+slot.getDayNum() + "--> Available Quantiy : "+slot.getQuantity() + "--> Vaccine Name : "+slot.getVaccineName());
                                i++;
                            }
                            if(i == 0){
                                System.out.println("No slot has been created by this hospital!");
                                break;
                            }
                            int slotnum;
                            if(checkerStatus == 1){
                                System.out.println("You can only choose a slot of vaccine : " + CitizenRegistry.get(citizenIndex).getVaccineName() + " and your day number must not be less than : "+ CitizenRegistry.get(citizenIndex).getDosetime());
                            }
                            int doses = 0;
                            int doseGap = 0;
                            while(true){
                                System.out.print("Choose the slot or enter -1 for exit : ");
                                slotnum = sc.nextInt();
                                if(slotnum < i && slotnum >= 0){
                                    if(checkerStatus == 1 && (daynum.get(slotnum) >= CitizenRegistry.get(citizenIndex).getDosetime()) && VaccineName.get(slotnum).equalsIgnoreCase(CitizenRegistry.get(citizenIndex).getVaccineName())){
                                        CitizenRegistry.get(citizenIndex).setDoses(CitizenRegistry.get(citizenIndex).getDoses()+1);
                                        for (Vaccine vac:vaccineList) {
                                            if(vac.getName().equalsIgnoreCase(VaccineName.get(slotnum))){
                                                doses = vac.getNumofDoses();
                                                doseGap = vac.getDoseGap();
                                                break;
                                            }
                                        }
                                    }
                                    else if(checkerStatus == 2){
                                        CitizenRegistry.get(citizenIndex).setDosetime(daynum.get(slotnum));
                                        CitizenRegistry.get(citizenIndex).setVaccineName(VaccineName.get(slotnum));
                                        CitizenRegistry.get(citizenIndex).setDoses(CitizenRegistry.get(citizenIndex).getDoses()+1);
                                        for (Vaccine vac:vaccineList) {
                                            if(vac.getName().equalsIgnoreCase(VaccineName.get(slotnum))){
                                                doses = vac.getNumofDoses();
                                                doseGap = vac.getDoseGap();
                                                break;
                                            }
                                        }
                                    }
                                    else{
                                        System.out.println("Slot is not applicable for you!");
                                        break;
                                    }
                                    if(CitizenRegistry.get(citizenIndex).getDoses() == doses){
                                        CitizenRegistry.get(citizenIndex).setVaccinStatus("FULLY VACCINATED");
                                    }
                                    else {
                                        CitizenRegistry.get(citizenIndex).setVaccinStatus("PARTIALLY VACCINATED");
                                        CitizenRegistry.get(citizenIndex).setDosetime(CitizenRegistry.get(citizenIndex).getDosetime() + doseGap);
                                    }

                                    ArrayList<Slot>TempSlots = HospitalRegistry.get(hospitalIndex).getSlots();
                                    TempSlots.get(slotnum).setQuantity(TempSlots.get(slotnum).getQuantity() - 1);
                                    System.out.println(CitizenRegistry.get(citizenIndex).getName() + " is vaccinated with " + TempSlots.get(slotnum).getVaccineName());
                                    if(TempSlots.get(slotnum).getQuantity() == 0){
                                        TempSlots.remove(slotnum);
                                    }
                                    HospitalRegistry.get(hospitalIndex).setSlots(TempSlots);
                                    break;
                                }
                                else if(slotnum == -1){
                                    System.out.println("Quitting the operation!");
                                    break;
                                }
                                else{
                                    System.out.println("Enter a valid slot number or you can enter -1 if you wish to quit!");
                                }
                            }
                        }
                        else {
                            System.out.println("No Hospital is found in area having pincode " + pin + "!");
                        }
                        break;
                    }

                    else if(Oper == 2){
                        int Hosindx = -1;
                        boolean present = false;
                        String vacName;
                        boolean find = false;
                        boolean quit = false;
                        sc.nextLine();
                        System.out.print("Enter the vaccine name : ");
                        vacName = sc.nextLine();
                        int doses = 0;
                        int doseGap = 0;
                        for (Vaccine vacin : vaccineList) {
                            if(vacin.getName().equalsIgnoreCase(vacName)){
                                doses = vacin.getNumofDoses();
                                doseGap = vacin.getDoseGap();
                                present = true;
                                break;
                            }
                        }
                        if(!present){
                            System.out.println("No vaccine is authorize with name "+vacName + "!");
                            break;
                        }
                        if(checkerStatus == 1 && !(vacName.equalsIgnoreCase(CitizenRegistry.get(citizenIndex).getVaccineName()))){
                            System.out.println("You can't take this vaccine!");
                            break;
                        }
                        for (Hospital hospital:HospitalRegistry) {
                            System.out.println(hospital.getUniqueId() + " " + hospital.getName());
                        }

                        while (true) {
                            int HosId;
                            System.out.print("Enter the ID of Hospital in which you want to take vaccine : ");
                            HosId = sc.nextInt();
                            for (Hospital hospital : HospitalRegistry) {
                                if (hospital.getUniqueId() == HosId) {
                                    Hosindx = HospitalRegistry.indexOf(hospital);
                                    find = true;
                                    break;
                                }
                            }
                            if(find){
                                break;
                            }
                            else if (HosId == -1){
                                quit = true;
                                System.out.println("Quitting the operation!");
                                break;
                            }
                            else{
                                System.out.println("You enter a wrong Hospital ID!Please check once again or you can enter -1 for go back to the option menu!");
                            }
                        }
                        if(quit){
                            break;
                        }
                        int i = 0;
                        ArrayList<Integer>daynum = new ArrayList<>();
                        ArrayList<Integer>quan = new ArrayList<>();
                        for (Slot slot:HospitalRegistry.get(Hosindx).getSlots())
                        {
                            if(slot.getVaccineName().equalsIgnoreCase(vacName)){
                                daynum.add(slot.getDayNum());
                                quan.add(slot.getQuantity());
                                System.out.println(i + "--> Day : "+slot.getDayNum() + "--> Available Quantiy : "+slot.getQuantity() + "--> Vaccine Name : "+slot.getVaccineName());
                                i++;
                            }
                        }
                        if(i == 0){
                            System.out.println("No slot has been created by this hospital!");
                            break;
                        }
                        int slotnum;
                        if(checkerStatus == 1){
                            System.out.println("You can only choose a slot which has day number greater or equal to : "+ CitizenRegistry.get(citizenIndex).getDosetime());
                        }

                        while(true){
                            System.out.print("Choose the slot or enter -1 for exit : ");
                            slotnum = sc.nextInt();
                            if(slotnum < i && slotnum >= 0){
                                if(checkerStatus == 1 && (daynum.get(slotnum) >= CitizenRegistry.get(citizenIndex).getDosetime())){
                                    CitizenRegistry.get(citizenIndex).setDoses(CitizenRegistry.get(citizenIndex).getDoses()+1);
                                }
                                else if(checkerStatus == 2){
                                    CitizenRegistry.get(citizenIndex).setDosetime(daynum.get(slotnum));
                                    CitizenRegistry.get(citizenIndex).setVaccineName(vacName);
                                    CitizenRegistry.get(citizenIndex).setDoses(CitizenRegistry.get(citizenIndex).getDoses()+1);
                                }
                                else{
                                    System.out.println("Slot is not applicable for you!");
                                    break;
                                }
                                if(CitizenRegistry.get(citizenIndex).getDoses() == doses){
                                    CitizenRegistry.get(citizenIndex).setVaccinStatus("FULLY VACCINATED");
                                }
                                else {
                                    CitizenRegistry.get(citizenIndex).setVaccinStatus("PARTIALLY VACCINATED");
                                    CitizenRegistry.get(citizenIndex).setDosetime(CitizenRegistry.get(citizenIndex).getDosetime() + doseGap);
                                }
                                int realSlotnum = -1;
                                for (Slot slot : HospitalRegistry.get(Hosindx).getSlots()){
                                    if(slot.getVaccineName().equalsIgnoreCase(vacName) && slot.getQuantity() == quan.get(slotnum) && slot.getDayNum() == daynum.get(slotnum)){
                                        realSlotnum = HospitalRegistry.get(Hosindx).getSlots().indexOf(slot);
                                    }
                                }
                                if(realSlotnum == -1){
                                    break;
                                }
                                ArrayList<Slot>TempSlots = HospitalRegistry.get(Hosindx).getSlots();
                                TempSlots.get(realSlotnum).setQuantity(TempSlots.get(realSlotnum).getQuantity() - 1);
                                System.out.println(CitizenRegistry.get(citizenIndex).getName() + " is vaccinated with " + TempSlots.get(realSlotnum).getVaccineName());
                                if(TempSlots.get(realSlotnum).getQuantity() == 0){
                                    TempSlots.remove(realSlotnum);
                                }
                                HospitalRegistry.get(Hosindx).setSlots(TempSlots);
                                break;
                            }
                            else if(slotnum == -1){
                                System.out.println("Quitting the operation!");
                                break;
                            }
                            else{
                                System.out.println("Enter a valid slot number or you can enter -1 if you wish to quit!");
                            }
                        }
                        break;
                    }

                    else if(Oper == 3){
                        System.out.println("Operation is closing");
                        break;
                    }

                    else{
                        System.out.println("Enter a valid input");
                    }
                }
            }

            // Print all slots of a Hospital

            else if(n == 6){
                int Id;
                System.out.print("Enter the Hospital ID for which you have to find the list of slots in that Hospital : ");
                Id = sc.nextInt();
                int idx = -1;
                for (Hospital hospital:HospitalRegistry)
                {
                    if(hospital.getUniqueId() == Id) {
                        idx = HospitalRegistry.indexOf(hospital);
                    }
                }
                if(idx == -1){
                    System.out.println("No hospital found with ID "+Id);
                    System.out.println("------------------------------------------------------------");
                    continue;
                }
                if(HospitalRegistry.get(idx).getSlots().size() == 0){
                    System.out.println("No slot is found in Hospital with ID " + Id);
                    System.out.println("------------------------------------------------------------");
                    continue;
                }
                for (Slot slot: HospitalRegistry.get(idx).getSlots())
                {
                    System.out.println("Day : "+slot.getDayNum() + " Quantiy : "+slot.getQuantity() + " Vaccine Name : "+slot.getVaccineName());
                }
                System.out.println("------------------------------------------------------------");
            }

            // Vaccination Status

            else if(n == 7){
                long citizenid;
                System.out.print("Enter the Citizen Id for which you have to check vaccination status : ");
                citizenid = sc.nextLong();
                int citizenidx = -1;
                for (Citizen citizen: CitizenRegistry) {
                    if(citizen.getUniqueId() == citizenid){
                        citizenidx = CitizenRegistry.indexOf(citizen);
                    }
                }
                if(citizenidx == -1){
                    System.out.println("No citizen is found with ID : "+citizenid+" please check again your ID and then retry!");
                    System.out.println("------------------------------------------------------------");
                    continue;
                }
                System.out.println("Details of the Citizen");
                System.out.println("Vaccination Status : "+CitizenRegistry.get(citizenidx).getVaccinStatus());
                if(CitizenRegistry.get(citizenidx).getVaccinStatus().equalsIgnoreCase("Registered")){
                    System.out.println("------------------------------------------------------------");
                    continue;
                }
                System.out.println("Vaccine Given : "+CitizenRegistry.get(citizenidx).getVaccineName());
                System.out.println("Number of doses given : "+CitizenRegistry.get(citizenidx).getDoses());
                if(CitizenRegistry.get(citizenidx).getVaccinStatus().equalsIgnoreCase("Fully Vaccinated")){
                    System.out.println("------------------------------------------------------------");
                    continue;
                }
                System.out.println("Next Dose Day : "+CitizenRegistry.get(citizenidx).getDosetime());
                System.out.println("------------------------------------------------------------");
            }

            //Exit

            else if( n == 8){
                System.out.println("Thanks for using our portal!");
                break;
            }
        }
    }
}
