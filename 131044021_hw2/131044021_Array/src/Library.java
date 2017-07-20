import java.util.ArrayList;
import java.util.List;

public class Library {

    private static Book[] bookList= new Book[200];
    private static int bookListSize;
    private static Book[] borrowBookList= new Book[200];


    public Library(){}

    /**
     *
     * @param books
     */
    public Library(List<Book> books)
    {
        for(int i=0; i < books.size();i++)
            bookList[i]=books.get(i);

    }

    public static int getBookListSize() {
        return bookListSize;
    }

    public static void setBookListSize(int bookListSize) {
        Library.bookListSize = bookListSize;
    }

    /**
     *
     * @param list
     */
    public void addBook(int index,Book list)
    {
        if(index<0 || index>getBookListSize())
            throw new ArrayIndexOutOfBoundsException();

        for(int i=getBookListSize(); i>index; ++i)
            bookList[i]=bookList[i-1];

        bookList[index]=list;
        setBookListSize(getBookListSize()+1);
    }

    /**
     *
     * @param index
     */
    public void removeBook(int index)
    {
        if(index<0 || index>=getBookListSize())
            throw new ArrayIndexOutOfBoundsException();

        Book bookValue= bookList[index];
        for(int i=index+1; i<getBookListSize(); i++)
            bookList[i-1]= bookList[i];

        setBookListSize(getBookListSize()-1);
    }

    /**
     *
     * @param borrowBookList
     */
    public static void setBorrowBookList(Book[] borrowBookList) {
        Library.borrowBookList = borrowBookList;
    }

    /**
     *
     * @param bookList
     */
    public static void setBookList(Book[] bookList) {

        Library.bookList = bookList;
    }

    /**
     *
     * @param m
     * @param n
     */
    public static void swapBookLists(int m,int n) {

        bookList[m] = bookList[n];
    }

    /**
     *
     * @return
     */
    public Book[] getBorrowBookList()
    {
        return borrowBookList;
    }

    /**
     *
     * @return
     */
    public Book[] getBookList() {
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