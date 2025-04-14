import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnChangeCredentials;

    private String currentUsername = "admin";
    private String currentPassword = "1234";

    public LoginPage() {
        setTitle("Library Management - Login");
        setSize(350, 250);
        setLayout(null);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(50, 30, 100, 30);
        add(lblUser);

        txtUsername = new JTextField();
        txtUsername.setBounds(150, 30, 130, 30);
        add(txtUsername);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(50, 70, 100, 30);
        add(lblPass);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 70, 130, 30);
        add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(120, 110, 100, 30);
        add(btnLogin);

        btnChangeCredentials = new JButton("Change Credentials");
        btnChangeCredentials.setBounds(90, 150, 160, 30);
        add(btnChangeCredentials);

        btnLogin.addActionListener(e -> checkLogin());
        btnChangeCredentials.addActionListener(e -> openChangeCredentialsDialog());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void checkLogin() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if (username.equals(currentUsername) && password.equals(currentPassword)) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            new MainFrame();  // Open the main menu
            dispose(); // Close login window
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password");
        }
    }

    private void openChangeCredentialsDialog() {
        // Dialog to change the username and password
        JTextField newUsernameField = new JTextField();
        JPasswordField newPasswordField = new JPasswordField();

        Object[] message = {
            "New Username:", newUsernameField,
            "New Password:", newPasswordField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Change Credentials", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String newUsername = newUsernameField.getText();
            String newPassword = new String(newPasswordField.getPassword());

            // Update credentials only if both fields are not empty
            if (!newUsername.isEmpty() && !newPassword.isEmpty()) {
                currentUsername = newUsername;
                currentPassword = newPassword;
                JOptionPane.showMessageDialog(this, "Credentials updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Username and Password cannot be empty.");
            }
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
