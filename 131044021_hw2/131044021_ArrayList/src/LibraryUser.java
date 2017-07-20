import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibraryUser extends Users
{
    /**
     *
     */
    public LibraryUser(){}

    /**
     *
     * @param name
     * @param passW
     */
    public LibraryUser(String name,String passW)
    {
        super(name,passW);
    }

    /**
     *
     * @param lib
     * @param book
     * @return
     * @throws IOException
     */
    public boolean borrowBook(Library lib, Book book) throws IOException {

        for(int i=0; i< lib.getBookList().size();i++)
        {
            if(lib.getBookList().get(i).getBookName().equals(book.getBookName())
                    || lib.getBookList().get(i).getBookNumber().equals(book.getBookNumber())) {
                lib.getBookList().remove(i);


                System.out.println("Book borrowed");
                //update file
                File file = new File("Book.csv");

                FileWriter fileWriter = new FileWriter(file, false);
                BufferedWriter bWriter = new BufferedWriter(fileWriter);

                for (int j = 0; j < lib.getBookList().size(); j++)
                    bWriter.write(lib.getBookList().get(j).getBookName()
                            + "," + lib.getBookList().get(j).getBookNumber() + ",\n");

                bWriter.close();


                //odunc alinan kitap borrowBookList'e eklenir boylece remove edilmek
                //istenen kitap icin uyari verilir
                lib.getBorrowBookList().add(book);

                return true;
            }
        }
        System.out.println("Book can't be borrowed. Not found book");
        return false;

    }

    /**
     *
     * @param lib
     * @param book
     * @return
     * @throws IOException
     */
    public boolean returnBook(Library lib, Book book) throws IOException {

        for(int i=0; i < lib.getBookList().size() ; i++)
        {
            if(lib.getBookList().get(i).getBookName().equals(book.getBookName())
                    && lib.getBookList().get(i).getBookNumber().equals(book.getBookNumber()))
            {
                System.out.println("Book already exist.Can't return book");
                return false;
            }
        }

        lib.getBookList().add(book);
        System.out.println("Book returned");

        //update file
        File file = new File("Book.csv");

        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);

        for(int j=0; j<lib.getBookList().size();j++)
            bWriter.write(lib.getBookList().get(j).getBookName()
                    + "," + lib.getBookList().get(j).getBookNumber()  + ",\n");

        bWriter.close();

        return true;

    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
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