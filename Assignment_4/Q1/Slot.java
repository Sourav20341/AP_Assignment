package Assignment_4.Q1;

public class Slot {

    static int id = 1;
    private final Book book;
    private final int ID;

    public Slot(Book book) {
        this.ID = id;
        this.book = book;
        id++;
    }

    public Book getBook() {
        return book;
    }

    public int getID(){
        return ID;
    }
    @Override
    public String toString(){
        return ("Slot ID : "+this.ID +" "+ "Book : Title : "+this.book.getTitle() +" "+"ISBN : "+book.getISBN()+" "+"Barcode : "+book.getBarcode() +" | ");
    }
}
