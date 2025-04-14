import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ViewBorrowedBooks extends JFrame {
    private JTextArea txtArea;

    public ViewBorrowedBooks() {
        setTitle("Borrowed Books");
        setSize(400, 300);
        setLayout(null);

        txtArea = new JTextArea();
        txtArea.setBounds(30, 30, 340, 200);
        txtArea.setEditable(false);
        add(txtArea);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(150, 230, 100, 30);
        add(closeButton);

        closeButton.addActionListener(e -> dispose());

        loadBorrowedBooks();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadBorrowedBooks() {
        ArrayList<String> borrowedBooks = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("borrowedBooks.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                borrowedBooks.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading borrowed books.");
        }

        if (borrowedBooks.isEmpty()) {
            txtArea.setText("No borrowed books found.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String book : borrowedBooks) {
                sb.append(book).append("\n");
            }
            txtArea.setText(sb.toString());
        }
    }

    public static void main(String[] args) {
        new ViewBorrowedBooks();
    }
}
