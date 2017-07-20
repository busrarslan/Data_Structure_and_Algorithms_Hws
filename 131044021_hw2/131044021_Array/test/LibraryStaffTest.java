import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class LibraryStaffTest {
    @Test
    public void setLibraryUserList() throws Exception {
        LibraryStaff staff= new LibraryStaff("bus","123");
        LibraryUser user=new LibraryUser("user","1123");
        List<LibraryUser> forTest =new ArrayList<>();
        forTest.add(user);
        staff.setLibraryUserList(forTest);
        assertEquals(staff.getLibraryUserList(),forTest);
    }

    @Test
    public void getLibraryUserList() throws Exception {
        LibraryStaff staff= new LibraryStaff("bus","123");
        LibraryUser user=new LibraryUser("user","1123");
        List<LibraryUser> forTest =new ArrayList<>();
        forTest.add(user);
        staff.setLibraryUserList(forTest);

        assertEquals(staff.getLibraryUserList(),forTest);
    }

    @Test
    public void registerUser() throws Exception {
        LibraryStaff staff= new LibraryStaff("bus","123");
        LibraryUser user=new LibraryUser("user","1123");
        staff.registerUser(user);
        List<LibraryUser> forTest =new ArrayList<>();
        forTest.add(user);
        assertEquals(staff.getLibraryUserList(),forTest);
    }

    @Test
    public void registerUserList() throws Exception {
        LibraryStaff staff= new LibraryStaff("bus","123");
        LibraryUser user=new LibraryUser("user","1123");
        List<LibraryUser> forTest =new ArrayList<>();
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
        List<Book> forTest =new ArrayList<>();
        forTest.add(book);


        assertEquals(library.getBookList(), forTest);

    }

    @Test
    public void removeBook() throws Exception {

        Book book=new Book("boook","23");
        LibraryStaff staff= new LibraryStaff("bulut","123");
        Library library= new Library();

        List<Book> forTest =new ArrayList<>();

        staff.addBook(library,book);
        staff.removeBook(library,book);
        assertEquals(library.getBookList(), forTest);

    }

}