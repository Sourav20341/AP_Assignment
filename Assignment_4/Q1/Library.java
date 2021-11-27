package Assignment_4.Q1;

import java.util.ArrayList;
import java.util.Comparator;

public class Library <T>{
    T obj;

    public Library(T obj){
        this.obj = obj;
    }

    public String getTitle() {
        if(obj instanceof Book){
            return ((Book) obj).getTitle();
        }
        return null;
    }

    public String getISBN() {
        if(obj instanceof Book){
            return ((Book) obj).getISBN();
        }
        return null;
    }

    public String getBarcode() {
        if(obj instanceof Book){
            return ((Book) obj).getBarcode();
        }
        return null;
    }

    public Library<Book> getBook() {
        if(obj instanceof Slot){
            return ((Slot) obj).getBook();
        }
        return null;
    }

    public int getID(){
        if(obj instanceof Slot){
            return ((Slot) obj).getID();
        }
        return -1;
    }

    public String toString(){
        if(obj instanceof Rack){
            return obj.toString();
        }
        if(obj instanceof Slot){
            return obj.toString();
        }
        return null;
    }

    public ArrayList<Library<Slot>> getSlots() {
        if(obj instanceof Rack){
            return ((Rack) obj).getSlots();
        }
        return null;
    }

    static class sort implements Comparator<Library<Book>> {
        public int compare(Library<Book> Book1,Library<Book> Book2)
        {
            int TitleCompare = Book1.getTitle().compareTo(Book2.getTitle());

            int ISBNCompare = Book1.getISBN().compareTo(Book2.getISBN());

            int BarcodeCompare = Book1.getBarcode().compareTo(Book2.getBarcode());

            if(TitleCompare == 0){
                if(ISBNCompare == 0){
                    return BarcodeCompare;
                }
                return ISBNCompare;
            }
            return TitleCompare;
        }
    }
}
