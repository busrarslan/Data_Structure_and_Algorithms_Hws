import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by bs on 5.3.2017.
 */
public class LibraryStaffTest {
    @Test
    public void setLibraryUserList() throws Exception {
        LibraryStaff staff= new LibraryStaff("bus","123");
        LibraryUser user=new LibraryUser("user","1123");
        LinkedList<LibraryUser> forTest =new LinkedList<>();
        forTest.add(user);
        staff.setLibraryUserList(forTest);
        assertEquals(staff.getLibraryUserList(),forTest);
    }

    @Test
    public void getLibraryUserList() throws Exception {
        LibraryStaff staff= new LibraryStaff("bus","123");
        LibraryUser user=new LibraryUser("user","1123");
        LinkedList<LibraryUser> forTest =new LinkedList<>();
        forTest.add(user);
        staff.setLibraryUserList(forTest);

        assertEquals(staff.getLibraryUserList(),forTest);
    }

    @Test
    public void registerUser() throws Exception {
        LibraryStaff staff= new LibraryStaff("bus","123");
        LibraryUser user=new LibraryUser("user","1123");
        staff.registerUser(user);
        LinkedList<LibraryUser> forTest =new LinkedList<>();
        forTest.add(user);
        assertEquals(staff.getLibraryUserList(),forTest);
    }

    @Test
    public void registerUserList() throws Exception {
        LibraryStaff staff= new LibraryStaff("bus","123");
        LibraryUser user=new LibraryUser("user","1123");
        LinkedList<LibraryUser> forTest =new LinkedList<>();
        forTest.add(user);
        staff.setLibraryUserList(forTest);
        assertEquals(staff.getLibraryUserList(),forTest);
    }

    @Test
    public void addBook() throws Exception {
        Book book=new Book("boook","23");
        LibraryStaff staff= new LibraryStaff("bulut","123");
        Library library= new Library();
        int i=0;

        staff.addBook(library,book);
        LinkedList<Book> forTest =new LinkedList<>();
        forTest.add(book);


        assertEquals(library.getBookList(), forTest);

    }

    @Test
    public void removeBook() throws Exception {

        Book book=new Book("boook","23");
        LibraryStaff staff= new LibraryStaff("bulut","123");
        Library library= new Library();

        LinkedList<Book> forTest =new LinkedList<>();

        staff.addBook(library,book);
        staff.removeBook(library,book);
        assertEquals(library.getBookList(), forTest);

    }


}