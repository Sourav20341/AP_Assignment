package Assignment_4.Q1;

import java.util.Comparator;

public class Book {
    private final String title;
    private final String ISBN;
    private final String barcode;

    public Book(String title, String ISBN, String barcode) {
        this.title = title;
        this.ISBN = ISBN;
        this.barcode = barcode;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getBarcode() {
        return barcode;
    }
}

class sort implements Comparator<Book> {
    public int compare(Book Book1,Book Book2)
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