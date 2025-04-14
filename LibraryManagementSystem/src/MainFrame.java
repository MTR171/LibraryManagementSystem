import javax.swing.*;
//import java.util.ArrayList;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Library Management System");
        setSize(400, 500);
        setLayout(null);

        JButton addBookButton = new JButton("Add Book");
        addBookButton.setBounds(100, 50, 200, 40);
        add(addBookButton);

        JButton viewBooksButton = new JButton("View Books");
        viewBooksButton.setBounds(100, 100, 200, 40);
       add(viewBooksButton);
        


        JButton borrowBookButton = new JButton("Borrow Book");
        borrowBookButton.setBounds(100, 150, 200, 40);
        add(borrowBookButton);

        JButton returnBookButton = new JButton("Return Book");
        returnBookButton.setBounds(100, 200, 200, 40);
        add(returnBookButton);

        JButton viewBorrowedBooksButton = new JButton("View Borrowed Books");
        viewBorrowedBooksButton.setBounds(100, 250, 200, 40);
        add(viewBorrowedBooksButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(100, 300, 200, 40);
        add(logoutButton);

        addBookButton.addActionListener(e -> new AddBook());
        viewBooksButton.addActionListener(e -> new ViewBooks());
        //manageBookButton.addActionListener(e -> new ManageBook());
        borrowBookButton.addActionListener(e -> new BorrowBook());
        returnBookButton.addActionListener(e -> new ReturnBook());
        viewBorrowedBooksButton.addActionListener(e -> new ViewBorrowedBooks());
        logoutButton.addActionListener(e -> {
            dispose();
            new LoginPage(); // Go back to login
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
//    public static class Book{
//        String id, name, author, status;
//        
//        public Book(String id, String name, String author, String status){
//            this.id = id;
//            this.name=name;
//            this.author=author;
//            this.status=status;
//        }
//    }
//    public static ArrayList<Book> bookList = new ArrayList<>();
}


