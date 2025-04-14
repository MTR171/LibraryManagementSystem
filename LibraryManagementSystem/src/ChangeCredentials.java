import javax.swing.*;

public class ChangeCredentials extends JFrame {
    private JTextField txtNewUsername;
    private JPasswordField txtNewPassword;

    public ChangeCredentials() {
        setTitle("Change Username & Password");
        setSize(300, 200);
        setLayout(null);

        JLabel lblUsername = new JLabel("New Username:");
        lblUsername.setBounds(20, 30, 100, 25);
        add(lblUsername);

        txtNewUsername = new JTextField();
        txtNewUsername.setBounds(130, 30, 130, 25);
        add(txtNewUsername);

        JLabel lblPassword = new JLabel("New Password:");
        lblPassword.setBounds(20, 70, 100, 25);
        add(lblPassword);

        txtNewPassword = new JPasswordField();
        txtNewPassword.setBounds(130, 70, 130, 25);
        add(txtNewPassword);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(90, 110, 100, 30);
        add(saveButton);

        saveButton.addActionListener(e -> {
            String newUsername = txtNewUsername.getText();
            String newPassword = new String(txtNewPassword.getPassword());

            SecurityUtil.saveCredentials(newUsername, newPassword);
            JOptionPane.showMessageDialog(this, "Username & Password Updated Successfully!");
            dispose();
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
