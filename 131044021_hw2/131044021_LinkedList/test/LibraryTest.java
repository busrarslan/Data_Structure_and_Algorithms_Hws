import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by bs on 5.3.2017.
 */
public class LibraryTest {
    @Test
    public void addBook() throws Exception {
        Book book=new Book("booo555k","23");
        Library library=new Library();

        library.addBook(book);
        LinkedList<Book> forTest =new LinkedList<>();
        forTest.add(book);
        assertEquals(library.getBookList(), forTest);
    }


    @Test
    public void setBorrowBookList() throws Exception {
        Book book=new Book("boook","23");
        Library library= new Library();
        int i=0;

        LinkedList<Book> forTest =new LinkedList<>();
        forTest.add(book);
        library.setBorrowBookList(forTest);
        assertEquals(library.getBorrowBookList(), forTest);

    }

    @Test
    public void setBookList() throws Exception {
        Book book=new Book("boook","23");
        Library library= new Library();
        int i=0;

        LinkedList<Book> forTest =new LinkedList<>();
        forTest.add(book);
        library.setBookList(forTest);
        assertEquals(library.getBookList(), forTest);

    }

    @Test
    public void getBorrowBookList() throws Exception {
        Book book=new Book("boook","23");
        Library library= new Library();
        int i=0;

        LinkedList<Book> forTest =new LinkedList<>();
        forTest.add(book);
        library.setBorrowBookList(forTest);
        assertEquals(library.getBorrowBookList(), forTest);
    }

    @Test
    public void getBookList() throws Exception {
        Book book=new Book("boook","23");
        Library library= new Library();
        int i=0;

        LinkedList<Book> forTest =new LinkedList<>();
        forTest.add(book);
        library.setBookList(forTest);
        assertEquals(library.getBookList(), forTest);

    }
}