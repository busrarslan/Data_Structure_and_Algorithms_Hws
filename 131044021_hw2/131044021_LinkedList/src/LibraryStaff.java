import java.io.*;
import java.util.*;


public class LibraryStaff extends Users {

    private static LinkedList<LibraryUser> LibraryUserList= new LinkedList<LibraryUser>();

    /**
     *
     */
    public LibraryStaff(){}

    /**
     *
     * @param libraryUserList
     */
    public LibraryStaff(LinkedList<LibraryUser> libraryUserList) {
        LibraryUserList = libraryUserList;
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
    public void setLibraryUserList(LinkedList<LibraryUser> libraryUserList) {
        LibraryUserList = libraryUserList;
    }

    /**
     *
     * @return
     */
    public LinkedList<LibraryUser> getLibraryUserList() {
        return LibraryUserList;
    }

    /**
     *
     * @param adder
     * @return
     * @throws IOException
     */
    public boolean registerUser(Person adder) throws IOException {

        if(adder instanceof LibraryUser) {

            for (int i = 0; i < LibraryUserList.size(); i++)
            {
                if (LibraryUserList.get(i).getUsername().equals(adder.getUsername())
                        || LibraryUserList.get(i).getPassword().equals(adder.getPassword()))
                {
                    System.out.println("User already exists");
                    return false;
                }
            }
            LibraryUserList.add((LibraryUser) adder);
            System.out.println("User added by staff");

            //dosyaya user eklenecek
            try {
                File file = new File("User.csv");

                FileWriter fileWriter = new FileWriter(file, false);
                BufferedWriter bWriter = new BufferedWriter(fileWriter);
                for (int i = 0; i < LibraryUserList.size(); i++)
                    bWriter.write(LibraryUserList.get(i).getUsername() + "," + LibraryUserList.get(i).getPassword() + ",\n");

                bWriter.close();
            } catch(FileNotFoundException e) {
                System.err.println("Caught FileNotFoundException: " + e.getMessage());
                throw new RuntimeException(e);
            } catch(IOException e) {
                System.err.println("Caught IOException: " + e.getMessage());
            }

            return true;

        }
        else{
            System.out.println("Not permission. Can't add user");
            return false;
        }

    }

    /**
     *
     * @param adder
     * @return
     * @throws IOException
     */
    public boolean registerUserList(LinkedList<LibraryUser> adder) throws IOException {

        for (int i = 0; i < adder.size(); i++)
        {
            LibraryUserList.add(adder.get(i));

        }
        return true;
    }

    /**
     *
     * @param lib
     * @param book
     * @return
     * @throws IOException
     */
    public boolean addBook(Library lib, Book book) throws IOException {

        LinkedList<Book> t=lib.getBookList();
        for(int i=0; i < lib.getBookList().size() ; i++)
        {
            if(lib.getBookList().get(i).getBookName().equals( book.getBookName())
                    && lib.getBookList().get(i).getBookNumber().equals(book.getBookNumber()))
            {
                System.out.println("Book already exist.Can't add book");
                return false;
            }

        }

        lib.addBook(book);
        System.out.println("Book added");

        try {
            //update file
            File file2 = new File("Book.csv");

            FileWriter fileWriter = new FileWriter(file2, false);
            BufferedWriter bWriter2 = new BufferedWriter(fileWriter);

            for (int i = 0; i < lib.getBookList().size(); i++)
                bWriter2.write(lib.getBookList().get(i).getBookName()
                        + "," + lib.getBookList().get(i).getBookNumber() + ",\n");

            bWriter2.close();
        }  catch(FileNotFoundException e) {
            System.err.println("Caught FileNotFoundException: " + e.getMessage());
            throw new RuntimeException(e);
        } catch(IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

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

        for (int i = 0; i < lib.getBookList().size(); i++) {
            if (lib.getBookList().get(i).getBookName().equals(book.getBookName())
                    || lib.getBookList().get(i).getBookNumber().equals(book.getBookNumber())) {

                lib.removeBook(i);
                System.out.println("Book removed");

                //update file
                try {
                    File file3 = new File("Book.csv");

                    FileWriter fileWriter = new FileWriter(file3, false);
                    BufferedWriter bWriter3 = new BufferedWriter(fileWriter);

                    for (int j = 0; j < lib.getBookList().size(); j++)
                        bWriter3.write(lib.getBookList().get(j).getBookName()
                                + "," + lib.getBookList().get(j).getBookNumber() + ",\n");

                    bWriter3.close();
                }
                catch(FileNotFoundException e) {
                    System.err.println("Caught FileNotFoundException: " + e.getMessage());
                    throw new RuntimeException(e);
                } catch(IOException e) {
                    System.err.println("Caught IOException: " + e.getMessage());
                }

                return true;
            }
        }

        for(int k=0; k< lib.getBorrowBookList().size(); k++)
        {
            if (lib.getBorrowBookList().get(k).getBookName().equals(book.getBookName())
                    && lib.getBorrowBookList().get(k).getBookNumber().equals(book.getBookNumber()))
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