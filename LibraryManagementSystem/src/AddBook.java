import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AddBook extends JFrame {
    JTextField titleField, authorField, genreField;
    JButton addButton, clearButton;

    public AddBook() {
        setTitle("Add Book");
        setSize(400, 250);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Title:"));
        titleField = new JTextField();
        add(titleField);

        add(new JLabel("Author:"));
        authorField = new JTextField();
        add(authorField);

        add(new JLabel("Genre:"));
        genreField = new JTextField();
        add(genreField);

        addButton = new JButton("Add Book");
        clearButton = new JButton("Clear");

        add(addButton);
        add(clearButton);

        addButton.addActionListener(e -> saveBookToFile());
        clearButton.addActionListener(e -> clearFields());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void saveBookToFile() {
        try (FileWriter writer = new FileWriter("books.txt", true)) {
            writer.write(titleField.getText() + "," + authorField.getText() + "," + genreField.getText() + "\n");
            JOptionPane.showMessageDialog(this, "Book Added Successfully!");
            clearFields();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving book!");
            ex.printStackTrace();
        }
    }
    
    private void clearFields() {
        titleField.setText("");
        authorField.setText("");
        genreField.setText("");
    }

    public static void main(String[] args) {
        new AddBook();
    }
}
