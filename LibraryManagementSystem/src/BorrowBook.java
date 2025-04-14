import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class BorrowBook extends JFrame {
    private JTextField txtBookTitle;
    private JButton btnBorrow;

    private ArrayList<String> borrowedBooks;

    public BorrowBook() {
        borrowedBooks = new ArrayList<>();
        setTitle("Borrow Book");
        setSize(300, 200);
        setLayout(null);

        JLabel lblTitle = new JLabel("Book Title:");
        lblTitle.setBounds(30, 30, 100, 30);
        add(lblTitle);

        txtBookTitle = new JTextField();
        txtBookTitle.setBounds(100, 30, 150, 30);
        add(txtBookTitle);

        btnBorrow = new JButton("Borrow");
        btnBorrow.setBounds(100, 80, 100, 30);
        add(btnBorrow);

        btnBorrow.addActionListener(e -> borrowBook());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void borrowBook() {
        String bookTitle = txtBookTitle.getText().trim();

        if (bookTitle.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a book title.");
            return;
        }

        // Simulate borrowing a book by adding it to the list
        borrowedBooks.add(bookTitle);

        // Optionally, save the borrowed books to a file (this part is optional)
        try (FileWriter writer = new FileWriter("borrowedBooks.txt", true)) {
            writer.write(bookTitle + "\n");
            JOptionPane.showMessageDialog(this, "Book Borrowed Successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error while borrowing the book.");
        }
    }

    public static void main(String[] args) {
        new BorrowBook();
    }
}
