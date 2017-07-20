import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class BookTest {
    @Test
    public void setBookName() throws Exception {
        Book book= new Book("book","120");
        String newname= "bookNmae";
        book.setBookName(newname);
        assertEquals(book.getBookName(),newname);
    }

    @Test
    public void setBookNumber() throws Exception {
        Book book= new Book("book","120");
        String newnumber= "50";
        book.setBookName(newnumber);
        assertEquals(book.getBookName(),newnumber);
    }

    @Test
    public void getBookName() throws Exception {
        Book book= new Book("book","120");
        String newname= "bookNmae";
        book.setBookName(newname);
        assertEquals(book.getBookName(),newname);
    }

    @Test
    public void getBookNumber() throws Exception {
        Book book= new Book("book","120");
        String newnumber= "50";
        book.setBookName(newnumber);
        assertEquals(book.getBookName(),newnumber);

    }

}