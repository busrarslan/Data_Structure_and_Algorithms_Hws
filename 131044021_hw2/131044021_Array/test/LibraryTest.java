import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class LibraryTest {
    @Test
    public void addBook() throws Exception {
        Book book=new Book("booo555k","23");
        Library library=new Library();

        library.addBook(book);
        List<Book> forTest =new ArrayList<>();
        forTest.add(book);
        assertEquals(library.getBookList(), forTest);
    }


    @Test
    public void setBorrowBookList() throws Exception {
        Book book=new Book("boook","23");
        Library library= new Library();
        int i=0;

        List<Book> forTest =new ArrayList<>();
        forTest.add(book);
        library.setBorrowBookList(forTest);
        assertEquals(library.getBorrowBookList(), forTest);

    }

    @Test
    public void setBookList() throws Exception {
        Book book=new Book("boook","23");
        Library library= new Library();
        int i=0;

        List<Book> forTest =new ArrayList<>();
        forTest.add(book);
        library.setBookList(forTest);
        assertEquals(library.getBookList(), forTest);

    }

    @Test
    public void getBorrowBookList() throws Exception {
        Book book=new Book("boook","23");
        Library library= new Library();
        int i=0;

        List<Book> forTest =new ArrayList<>();
        forTest.add(book);
        library.setBorrowBookList(forTest);
        assertEquals(library.getBorrowBookList(), forTest);
    }

    @Test
    public void getBookList() throws Exception {
        Book book=new Book("boook","23");
        Library library= new Library();
        int i=0;

        List<Book> forTest =new ArrayList<>();
        forTest.add(book);
        library.setBookList(forTest);
        assertEquals(library.getBookList(), forTest);

    }

}