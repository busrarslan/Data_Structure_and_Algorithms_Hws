import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class LibraryStaff extends Users {

    private static LibraryUser[] LibraryUserList;
    private static int LibraryUserListSize;

    /**
     *
     */
    public LibraryStaff(){
        LibraryUserList = new LibraryUser[200];
        LibraryUserListSize=0;
    }

    /**
     *
     * @param libraryUserList
     */
    public LibraryStaff(List<LibraryUser> libraryUserList) {
        LibraryUserList = new LibraryUser[200];
        for(int i=0; i < libraryUserList.size();i++)
        {
            LibraryUserList[LibraryUserListSize]=libraryUserList.get(i);
            LibraryUserListSize++;
        }
    }

    /**
     *
     * @param name
     * @param passW
     */
    public LibraryStaff(String name, String passW)
    {
        super(name,passW);
    }


    /**
     *
     * @param libraryUserList
     */
    public void setLibraryUserList(List<LibraryUser> libraryUserList)
    {
        LibraryUserList = new LibraryUser[200];
        for(int i=0; i < libraryUserList.size();i++)
        {
            LibraryUserList[LibraryUserListSize]=libraryUserList.get(i);
            LibraryUserListSize++;
        }
    }

    /**
     *
     * @return
     */
    public LibraryUser[] getLibraryUserList()
    {

        return LibraryUserList;
    }

    /**
     *
     * @param libraryUserListSize
     */
    public static void setLibraryUserListSize(int libraryUserListSize) {
        LibraryUserListSize = libraryUserListSize;
    }

    /**
     *
     * @return
     */
    public static int getLibraryUserListSize() {
        return LibraryUserListSize;
    }

    /**
     *
     * @param adder
     * @return
     * @throws IOException
     */
    public boolean registerUser(Person adder) throws IOException {


        if(adder instanceof LibraryUser) {

            for (int i = 0; i < LibraryUserListSize; i++)
            {
                if (LibraryUserList[i].getUsername().equals(adder.getUsername())
                        || LibraryUserList[i].getPassword().equals(adder.getPassword()))
                {
                    System.out.println("User already exists");
                    return false;
                }
            }
            LibraryUserList[LibraryUserListSize] =((LibraryUser) adder);
            LibraryUserListSize++;
            System.out.println("User added by staff");

            //dosyaya user eklenecek

            File file = new File("User.csv");

            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            for(int i=0; i<LibraryUserListSize;i++)
                bWriter.write(LibraryUserList[i].getUsername() + "," + LibraryUserList[i].getPassword() + ",\n");

            bWriter.close();

            return true;

        }
        else{
            System.out.println("Not permission. Can't add user");
            return false;
        }


    }


    /**
     *
     * @param lib
     * @param book
     * @return
     * @throws IOException
     */
    public boolean addBook(Library lib, Book book) throws IOException {

        Book[] t=lib.getBookList();
        for(int i=0; i < lib.getBookListSize() ; i++)
        {
            if(lib.getBookList()[i].getBookName().equals( book.getBookName())
                    && lib.getBookList()[i].getBookNumber().equals(book.getBookNumber()))
            {
                System.out.println("Book already exist.Can't add book");
                return false;
            }

        }

        lib.addBook(lib.getBookListSize(),book);
        System.out.println("Book added");

        //update file
        File file2 = new File("Book.csv");

        FileWriter fileWriter = new FileWriter(file2, false);
        BufferedWriter bWriter2 = new BufferedWriter(fileWriter);

        for(int i=0; i<lib.getBookListSize();i++)
            bWriter2.write(lib.getBookList()[i].getBookName()
                    + "," + lib.getBookList()[i].getBookNumber()  + ",\n");

        bWriter2.close();

        return true;

    }

    /**
     *
     * @param lib
     * @param book
     * @return
     * @throws IOException
     */
    public boolean removeBook(Library lib, Book book) throws IOException {

        for (int i = 0; i < lib.getBookListSize(); i++) {
            if (lib.getBookList()[i].getBookName().equals(book.getBookName())
                    && lib.getBookList()[i].getBookNumber().equals(book.getBookNumber())) {

                lib.removeBook(i);
                System.out.println("Book removed");

                //update file
                File file3 = new File("Book.csv");

                FileWriter fileWriter = new FileWriter(file3, false);
                BufferedWriter bWriter3 = new BufferedWriter(fileWriter);

                for(int j=0; j<lib.getBookListSize();j++)
                    bWriter3.write(lib.getBookList()[j].getBookName()
                            + "," + lib.getBookList()[j].getBookNumber()  + ",\n");

                bWriter3.close();

                return true;
            }
        }

        for(int k=0; k< lib.getBookListSize(); k++)
        {
            if (lib.getBorrowBookList()[k].getBookName().equals(book.getBookName())
                    && lib.getBorrowBookList()[k].getBookNumber().equals(book.getBookNumber()))
            {
                System.out.println("Book can't be removed because it was borrowed by the user.");
            }
        }

        System.out.println("Not found book. Can't remove book");
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "LibraryStaff{}";
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}