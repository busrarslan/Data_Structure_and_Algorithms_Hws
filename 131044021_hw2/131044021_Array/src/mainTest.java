import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class mainTest {

    public static void main(String[] args) throws IOException {

        //Staff UserS ve Book  icin Dosyalarin Okunmasi
        String fileName1 = "Staff.csv";
        String fileName2 = "User.csv";
        String fileName3 = "Book.csv";

        String tempLine;
        String line1 = "";
        int tempSize1 = 0;
        String line2 = "";
        int tempSize2 = 0;
        String line3 = "";
        int tempSize3 = 0;


        LibraryStaff[] StaffList_;
        LibraryUser[] UserList_;
        Book[] BookList_;

        String[] temp1 = null;
        String[] temp2 = null;
        String[] temp3 = null;


        try {
            FileReader fileReader1 = new FileReader(fileName1);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);

            FileReader fileReader2 = new FileReader(fileName2);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);

            FileReader fileReader3 = new FileReader(fileName3);
            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);

            //Staff dosya okuma
            while ((tempLine = bufferedReader1.readLine()) != null) {
                line1 += tempLine;
                ++tempSize1;
            }
            StaffList_ = new LibraryStaff[tempSize1 * 2];
            //temp amacli kullanilmistir
            List<LibraryStaff> StaffList= new ArrayList<LibraryStaff>();

            //List halinde kuyup class içerisinde Array kullandım

            temp1 = line1.split(",");
            //staff
            for (int j = 0; j < temp1.length; j += 2) {
                StaffList.add(new LibraryStaff(temp1[j], temp1[j + 1]));

            }

            //User dosya okuma
            while ((tempLine = bufferedReader2.readLine()) != null) {
                line2 += tempLine;
                ++tempSize2;
            }
            UserList_ = new LibraryUser[tempSize2 * 2];
            List<LibraryUser> UserList= new ArrayList<LibraryUser>();
            temp2 = line2.split(",");
            //user
            for (int j = 0; j < temp2.length; j += 2) {
                UserList.add(new LibraryUser(temp2[j], temp2[j + 1]));
                //System.out.println( UserList[j]);
            }

            //Book dosya okuma
            while ((tempLine = bufferedReader3.readLine()) != null) {
                line3 += tempLine;
                ++tempSize3;
            }

            BookList_ = new Book[tempSize3 * 2];
            //temp amacli kullanilmistir
            List<Book> BookList= new ArrayList<Book>();

            temp3 = line3.split(",");
            //book
            for (int j = 0; j < temp3.length; j += 2) {
                BookList.add(new Book(temp3[j], temp3[j + 1]));
                // System.out.println( BookList[j]);
            }

            ////
            Library library = new Library(BookList);
            library.setBookListSize(tempSize3);
            //LibraryStaff staff = null;
            //staff.setLibraryUserListSize(tempSize2);
            StaffList.get(0).setLibraryUserList(UserList);

            //close files.
            bufferedReader1.close();
            bufferedReader2.close();
            bufferedReader3.close();


            int number;
            ////////////////////////////LIBRARY MANAGEMENT MENU////////////////////////
            ///////////////////////////////////////////////////////////////////////////
            do {
                System.out.println("Which user are you? Please choose:  [1] or [2]");
                System.out.println("[1] Staff ");
                System.out.println("[2] User");
                System.out.println("[3] Exit");
                Scanner keyboard = new Scanner(System.in);
                int staffIndex = 0;
                int userIndex = 0;
                String named;
                String passw;

                do {

                    while (!keyboard.hasNextInt()) {
                        System.out.println("Please Try Again");
                        keyboard.next();
                    }
                    number = keyboard.nextInt();
                    if (number < 0)
                        System.out.println("Please Try Again");
                } while (number <= 0);

                //STAFF
                if (number == 1) {
                    System.out.println("Please you enter username and password");
                    named = keyboard.next();
                    passw = keyboard.next();
                    int a = 0;

                    while (a == 0) {

                        for (int i = 0; i < tempSize1; ++i) {
                            if (StaffList.get(i).getUsername().equals(named) && StaffList.get(i).getPassword().equals(passw)) {
                                System.out.println("You entered the system as staff.");
                                a = 1;
                                staffIndex = i;
                            }
                        }
                        if (a == 0) {
                            System.out.println("This staff does not exist on the list");
                            System.out.println("Please you repeat entered username and password");

                            named = keyboard.next();
                            passw = keyboard.next();
                        }
                    }

                    System.out.println("Select an operation: [1] or [2] or [3]");
                    System.out.println("[1] Register a new library user ");
                    System.out.println("[2] Add a new book");
                    System.out.println("[3] Remove a book ");

                    do {

                        while (!keyboard.hasNextInt()) {
                            System.out.println("Please Try Again");
                            keyboard.next();
                        }
                        number = keyboard.nextInt();
                        if (number < 0)
                            System.out.println("Please Try Again");
                    } while (number <= 0);

                    if (number == 1) {
                        System.out.println("Enter a username and password to add a LibraryUser");
                        named = keyboard.next();
                        passw = keyboard.next();
                        LibraryUser user = new LibraryUser(named, passw);

                        StaffList.get(staffIndex).registerUser(user);

                    } else if (number == 2) {
                        System.out.println("Enter a bookName and number to add a Book");
                        named = keyboard.next();
                        passw = keyboard.next();
                        Book book = new Book(named, passw);
                        StaffList.get(staffIndex).addBook(library, book);
                    } else if (number == 3) {
                        System.out.println("Enter a bookName and number to remove a Book");
                        named = keyboard.next();
                        passw = keyboard.next();
                        Book book = new Book(named, passw);
                        StaffList.get(staffIndex).removeBook(library, book);
                    }

                }
                //USER
                else if (number == 2) {
                    System.out.println("Please you enter username and password");

                    named = keyboard.next();
                    passw = keyboard.next();
                    int a = 0;


                    while (a == 0) {

                        for (int i = 0; i < tempSize2; ++i) {
                            if (UserList.get(i).getUsername().equals(named) && UserList.get(i).getPassword().equals(passw)) {
                                System.out.println("You entered the system as user.");
                                a = 1;
                                userIndex = i;
                            }
                        }
                        if (a == 0) {
                            System.out.println("This user does not exist on the list");
                            System.out.println("Please you repeat entered bookname and number");

                            named = keyboard.next();
                            passw = keyboard.next();
                        }
                    }

                    System.out.println("Select an operation: [1] or [2]");
                    System.out.println("[1] Borrow book ");
                    System.out.println("[2] Return book ");

                    do {

                        while (!keyboard.hasNextInt()) {
                            System.out.println("Please Try Again");
                            keyboard.next();
                        }
                        number = keyboard.nextInt();
                        if (number < 0)
                            System.out.println("Please Try Again");
                    } while (number <= 0);

                    if (number == 1) {
                        System.out.println("Enter a bookName and number to borrow a Book");
                        named = keyboard.next();
                        passw = keyboard.next();
                        Book book = new Book(named, passw);


                        UserList.get(userIndex).borrowBook(library, book);
                    } else if (number == 2) {
                        System.out.println("Enter a bookName and number to borrow a Book");
                        named = keyboard.next();
                        passw = keyboard.next();
                        Book book = new Book(named, passw);

                        UserList.get(userIndex).returnBook(library, book);

                    }

                } else if (number == 3) {
                    System.exit(1);
                } else {
                    System.out.println("You false choice.Repeat choose");
                    System.out.println("Enter 3 to exit the system");

                }

            } while (number >= 0);

        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '");
        }

    }
}
