import java.util.ArrayList;
import java.util.List;

public class Library {

    private static List<Book> bookList= new ArrayList<Book>();
    private static List<Book> borrowBookList= new ArrayList<Book>();

    /**
     *
     */
    public Library(){}

    /**
     *
     * @param books
     */
    public Library(List<Book> books)
    {
        for(int i=0; i < books.size();i++)
            bookList.add(books.get(i));
    }

    /**
     *
     * @param list
     */
    public void addBook(Book list)
    {
        bookList.add(list);
    }

    /**
     *
     * @param i
     */
    public void removeBook(int i)
    {
        bookList.remove(i);
    }

    /**
     *
     * @param borrowBookList
     */
    public static void setBorrowBookList(List<Book> borrowBookList) {
        Library.borrowBookList = borrowBookList;
    }

    /**
     *
     * @param bookList
     */
    public static void setBookList(List<Book> bookList) {

        Library.bookList = bookList;
    }

    /**
     *
     * @return
     */
    public List<Book> getBorrowBookList() {
        return borrowBookList;
    }

    /**
     *
     * @return
     */
    public List<Book> getBookList() {
        return bookList;
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