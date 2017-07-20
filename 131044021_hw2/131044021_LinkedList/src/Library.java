import java.util.LinkedList;

public class Library {

    private static LinkedList<Book> bookList= new LinkedList<Book>();
    private static LinkedList<Book> borrowBookList= new LinkedList<Book>();

    /**
     *
     */
    public Library(){}

    /**
     *
     * @param books
     */
    public Library(LinkedList<Book> books)
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
    public static void setBorrowBookList(LinkedList<Book> borrowBookList) {
        Library.borrowBookList = borrowBookList;
    }

    /**
     *
     * @param bookList
     */
    public static void setBookList(LinkedList<Book> bookList) {

        Library.bookList = bookList;
    }

    /**
     *
     * @return
     */
    public LinkedList<Book> getBorrowBookList() {
        return borrowBookList;
    }

    /**
     *
     * @return
     */
    public LinkedList<Book> getBookList() {
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