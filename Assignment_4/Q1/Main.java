package Assignment_4.Q1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("============================================");
        System.out.println("           Welcome to the program           ");
        System.out.println("============================================\n");
        int N,R;
        System.out.print("Enter the number of books : ");
        N = sc.nextInt();
        System.out.print("Enter the number of racks : ");
        R = sc.nextInt();
        int number_of_slots = N/R;
        ArrayList<Book>books = new ArrayList<>();
        ArrayList<Slot>slots = new ArrayList<>();
        ArrayList<Rack>racks = new ArrayList<>();
        System.out.println("\n============================================");
        sc.nextLine();
        for(int i = 0;i<N;i++){
            String title,ISBN;
            String barcode = null;
            System.out.println("Enter the detail of book " + (i+1));
            System.out.println("============================================");
            System.out.print("Enter the title of book : ");
            title = sc.nextLine();
            System.out.print("Enter the ISBN of book : ");
            ISBN = sc.nextLine();
            System.out.print("Enter the barcode of book : ");
            boolean ispresent = false;
            while(true){
                for(Book book : books){
                    barcode = sc.nextLine();
                    if(book.getBarcode().equalsIgnoreCase(barcode)){
                        ispresent = true;
                    }
                }
                if(ispresent){
                    System.out.println("Barcode is already present ! Please re-enter the barcode");
                    ispresent = false;
                }
                else{
                    Book book = new Book(title,ISBN,barcode);
                    books.add(book);
                    break;
                }
            }
            System.out.println();
            System.out.println("============================================");
        }
        System.out.println("Program starts sorting to arrange the books according to the plan!Please Wait.....");
        System.out.println("============================================\n");
        System.out.println("============================================");
        System.out.println("Program Finished!All books are arranged according to plan :)");
        System.out.println("============================================\n");
        System.out.println("Resultant Order :-");

        books.sort(new sort());

        for(Book book : books){
            slots.add(new Slot(book));
        }

        int idx = 0;
        for(int i = 0;i<R;i++){
            ArrayList<Slot>tempslot = new ArrayList<>();
            for(int j = 0;j<number_of_slots;j++){
                tempslot.add(slots.get(idx));
                idx ++;
            }
            racks.add(new Rack(tempslot));
        }

      for(Rack rack : racks){
          System.out.println(rack);
      }
        System.out.println("\n============================================");
        System.out.println("             Thank you for using  :) "       );
        System.out.println("============================================");
    }
}


