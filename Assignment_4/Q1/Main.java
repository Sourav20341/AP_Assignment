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
        ArrayList<Library<Book>>books = new ArrayList<>();
        ArrayList<Library<Slot>>slots = new ArrayList<>();
        ArrayList<Library<Rack>>racks = new ArrayList<>();
        System.out.println("\n============================================");
        sc.nextLine();
        for(int i = 0;i<N;i++){
            String title,ISBN;
            String barcode;
            System.out.println("Enter the detail of book " + (i+1));
            System.out.println("============================================");
            System.out.print("Enter the title of book : ");
            title = sc.nextLine();
            System.out.print("Enter the ISBN of book : ");
            ISBN = sc.nextLine();
            boolean ispresent = false;
            while(true){
                System.out.print("Enter the barcode of book : ");
                barcode = sc.nextLine();
                for(Library<Book> book : books){
                    if(book.getBarcode().equalsIgnoreCase(barcode)){
                        ispresent = true;
                        break;
                    }
                }
                if(ispresent){
                    System.out.println("Barcode is already present ! Please re-enter the barcode.");
                    ispresent = false;
                }
                else{
                    Book book = new Book(title,ISBN,barcode);
                    books.add(new Library<>(book));
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

        books.sort(new Library.sort());

        for(Library<Book> book : books){
            slots.add(new Library<>(new Slot(book)));
        }

        int idx = 0;
        for(int i = 0;i<R;i++){
            ArrayList<Library<Slot>>tempslot = new ArrayList<>();
            for(int j = 0;j<number_of_slots;j++){
                tempslot.add(slots.get(idx));
                idx ++;
            }
            racks.add(new Library<>(new Rack(tempslot)));
        }

        while(true){
            int choice;
            System.out.println("============================================");
            System.out.println("               Operation                     ");
            System.out.println("============================================");
            System.out.println("1. Find a book");
            System.out.println("2. Exit");
            System.out.println("============================================\n");
            System.out.print("Choose Operation : ");
            choice = sc.nextInt();
            if(choice == 1){
                String getTitle,getISBN,getBarcode;
                sc.nextLine();
                System.out.print("Enter the Title of Book : ");
                getTitle = sc.nextLine();
                System.out.print("Enter the ISBN of Book : ");
                getISBN = sc.nextLine();
                System.out.print("Enter the Barcode of Book : ");
                getBarcode = sc.nextLine();
                int bookidx = -1;
                for(Library<Book> book : books){
                    if(book.getTitle().equalsIgnoreCase(getTitle) && book.getISBN().equalsIgnoreCase(getISBN) && book.getBarcode().equalsIgnoreCase(getBarcode)){
                        bookidx = books.indexOf(book);
                        break;
                    }
                }
                if(bookidx != -1){
                    int slotidx = -1;
                    for(Library<Slot> slot : slots){
                        if(slot.getBook().getBarcode().equalsIgnoreCase(books.get(bookidx).getBarcode()) && slot.getBook().getISBN().equalsIgnoreCase(books.get(bookidx).getISBN()) &&
                                slot.getBook().getTitle().equalsIgnoreCase(books.get(bookidx).getTitle()))
                        {
                            slotidx = slot.getID();
                            break;
                        }
                    }
                    Library<Rack> rack = null;
                    boolean isget = false;
                    for (Library<Rack> rack1 : racks){
                        for(Library<Slot> slot : rack1.getSlots()){
                            if(slot.getID() == slotidx){
                                rack = rack1;
                                isget = true;
                                break;
                            }
                        }
                        if (isget){
                            break;
                        }
                    }
                    System.out.println("\n============================================");
                    System.out.println(" Book is present in : ");
                    System.out.println("============================================\n");
                    System.out.println(rack);
                    System.out.println("Slot ID : "+slotidx);
                }
                else{
                    System.out.println("\n============================================");
                    System.out.println("No Book is Present with this information in our library.");
                    System.out.println("============================================\n");
                }
            }
            else if(choice == 2){
                System.out.println("\n============================================");
                System.out.println("             Thank you for using  :) "       );
                System.out.println("============================================");
                break;
            }
            else{
                System.out.println("\n============================================");
                System.out.println("               Wrong Input                  ");
                System.out.println("============================================");
            }
        }
    }
}


