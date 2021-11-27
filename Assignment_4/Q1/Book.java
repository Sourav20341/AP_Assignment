package Assignment_4.Q1;

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

