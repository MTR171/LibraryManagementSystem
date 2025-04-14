import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class ViewBooks extends JFrame {

    public ViewBooks() {
        setTitle("View Books");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columns = {"Title", "Author", "Genre"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        ArrayList<String[]> books = readBooksFromFile("books.txt");

        if (books.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No books found in books.txt", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (String[] book : books) {
                model.addRow(book);
            }
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private ArrayList<String[]> readBooksFromFile(String filename) {
        ArrayList<String[]> books = new ArrayList<>();
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("⚠️ File not found: " + filename);
            return books;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println("📖 Reading: " + line);
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    books.add(parts);
                } else {
                    System.out.println("❌ Skipped invalid line: " + line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }

    public static void main(String[] args) {
        new ViewBooks(); // for testing directly
    }
}
