import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class LibraryUserTest {
    @Test
    public void borrowBook() throws Exception {
        Book book=new Book("OkulZamani","23");
        LibraryUser user= new LibraryUser("bahar66","123");
        Library library= new Library();
        int i=0;

        List<Book> forTest =new ArrayList<>();

        user.returnBook(library,book);
        user.borrowBook(library,book);

        assertEquals(library.getBookList(), forTest);
    }

    @Test
    public void returnBook() throws Exception {
        Book book=new Book("OkulZamani","23");
        LibraryUser user= new LibraryUser("bahar66","123");
        Library library= new Library();
        int i=0;

        List<Book> forTest =new ArrayList<>();
        forTest.add(book);
        user.returnBook(library,book);

        assertEquals(library.getBookList(), forTest);

    }

}