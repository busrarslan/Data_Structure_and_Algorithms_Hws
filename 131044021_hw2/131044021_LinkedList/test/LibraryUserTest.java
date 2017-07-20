import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by bs on 5.3.2017.
 */
public class LibraryUserTest {
    @Test
    public void borrowBook() throws Exception {
        Book book=new Book("OkulZamani","23");
        LibraryUser user= new LibraryUser("bahar66","123");
        Library library= new Library();
        int i=0;

        LinkedList<Book> forTest =new LinkedList<>();

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

        LinkedList<Book> forTest =new LinkedList<>();
        forTest.add(book);
        user.returnBook(library,book);

        assertEquals(library.getBookList(), forTest);

    }


}