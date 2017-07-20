import java.util.*;

public class Book
{

    private String bookName;
    private String bookNumber;

    /**
     *
     * @param name
     * @param num
     */
    public Book(String name, String num){
        setBookName(name);
        setBookNumber(num);

    }

    /**
     *
     * @param name
     */
    public void setBookName(String name){
        bookName=name;
    }

    /**
     *
     * @param num
     */
    public void setBookNumber(String num)
    {
        bookNumber= num;
    }

    /**
     *
     * @return
     */
    public String getBookName()
    {
        return bookName;
    }

    /**
     *
     * @return
     */
    public String getBookNumber()
    {
        return bookNumber;
    }

}