import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ReturnBook extends JFrame {
    private JTextField txtBookTitle;
    private JButton btnReturn;

    public ReturnBook() {
        setTitle("Return Book");
        setSize(300, 200);
        setLayout(null);

        JLabel lblTitle = new JLabel("Book Title:");
        lblTitle.setBounds(30, 30, 100, 30);
        add(lblTitle);

        txtBookTitle = new JTextField();
        txtBookTitle.setBounds(100, 30, 150, 30);
        add(txtBookTitle);

        btnReturn = new JButton("Return");
        btnReturn.setBounds(100, 80, 100, 30);
        add(btnReturn);

        btnReturn.addActionListener(e -> returnBook());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void returnBook() {
        String bookTitle = txtBookTitle.getText().trim();

        if (bookTitle.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a book title.");
            return;
        }

        File inputFile = new File("borrowedBooks.txt");
        File tempFile = new File("tempBorrowedBooks.txt");

        if (!inputFile.exists()) {
            JOptionPane.showMessageDialog(this, "Error: borrowedBooks.txt does not exist.");
            return;
        }

        ArrayList<String> borrowedBooks = new ArrayList<>();
        boolean isBookBorrowed = false;

        // ✅ Read file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().equalsIgnoreCase(bookTitle)) {
                    isBookBorrowed = true;
                } else {
                    borrowedBooks.add(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading the file.");
            return;
        }

        if (!isBookBorrowed) {
            JOptionPane.showMessageDialog(this, "You have not borrowed this book.");
            return;
        }

        // ✅ Write to temp file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            for (String book : borrowedBooks) {
                writer.write(book);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error writing the temporary file.");
            return;
        }

        // ✅ Delete original & rename temp
        if (inputFile.delete()) {
            if (tempFile.renameTo(inputFile)) {
                JOptionPane.showMessageDialog(this, "Book returned successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Error renaming the temporary file.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error deleting the original file.");
        }
    }

    public static void main(String[] args) {
        new ReturnBook();
    }
}
