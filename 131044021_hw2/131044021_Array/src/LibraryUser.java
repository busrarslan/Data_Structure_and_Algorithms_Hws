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

        for(int i=0; i< lib.getBookListSize();i++)
        {
            if(lib.getBookList()[i].getBookName().equals(book.getBookName())
                    || lib.getBookList()[i].getBookNumber().equals(book.getBookNumber())) {
                removeMyFunc(i,lib);


                System.out.println("Book borrowed");
                //update file
                File file = new File("Book.csv");

                FileWriter fileWriter = new FileWriter(file, false);
                BufferedWriter bWriter = new BufferedWriter(fileWriter);

                for (int j = 0; j < lib.getBookListSize(); j++)
                    bWriter.write(lib.getBookList()[j].getBookName()
                            + "," + lib.getBookList()[j].getBookNumber() + ",\n");

                bWriter.close();


                //odunc alinan kitap borrowBookList'e eklenir boylece remove edilmek
                //istenen kitap icin uyari verilir
                addMyFunc(lib.getBookListSize(),book,lib);

                return true;
            }
        }
        System.out.println("Book can't be borrowed. Not found book");
        return false;

    }

    /**
     *
     * @param index
     * @param book
     * @param lib
     */
    public void addMyFunc(int index,Book book,Library lib)
    {
        if(index<0 || index > lib.getBookListSize())
            throw new ArrayIndexOutOfBoundsException();
        for(int i=lib.getBookListSize(); i>index; ++i)
            lib.swapBookLists(i,i-1);

        lib.getBookList()[index]=book;

        lib.setBookListSize(lib.getBookListSize()+1);
    }

    /**
     *
     * @param index
     * @param lib
     */
    public void removeMyFunc(int index,Library lib)
    {
        if(index<0 || index > lib.getBookListSize())
            throw new ArrayIndexOutOfBoundsException();
        Book returnValue= lib.getBookList()[index];

        for(int i=index+1; i<lib.getBookListSize(); ++i)
            lib.swapBookLists(i-1,i);

        lib.setBookListSize(lib.getBookListSize()-1);
    }

    /**
     *
     * @param lib
     * @param book
     * @return
     * @throws IOException
     */
    public boolean returnBook(Library lib, Book book) throws IOException {

        for(int i=0; i < lib.getBookListSize() ; i++)
        {
            if(lib.getBookList()[i].getBookName().equals(book.getBookName())
                    && lib.getBookList()[i].getBookNumber().equals(book.getBookNumber()))
            {
                System.out.println("Book already exist.Can't return book");
                return false;
            }
        }

        addMyFunc(lib.getBookListSize(),book,lib);
        System.out.println("Book returned");

        //update file
        File file = new File("Book.csv");

        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);

        for(int j=0; j<lib.getBookListSize();j++)
            bWriter.write(lib.getBookList()[j].getBookName()
                    + "," + lib.getBookList()[j].getBookNumber()  + ",\n");

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