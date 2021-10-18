package app.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.classes.AdminUser;
import app.interfaces.IAdminUser;

public class AdminPage extends JFrame
{
    //components
    private JTextField _adminUser = new JTextField();
    private JPasswordField _adminPassword = new JPasswordField();
    private JButton _verifyButton = new JButton();
    private JButton _backButton = new JButton();

    //admin account
    private AdminUser _admin = AdminUser.getInstance();

    public AdminPage()
    {
        //user field settings
        _adminUser.setBounds(450, 200, 400, 50);

        //pass field settings
        _adminPassword.setBounds(450, 300, 400, 50);

        //button settings
        _verifyButton.setText("Verify Creditentials");
        _verifyButton.setBounds(450, 400, 400, 50);
        _verifyButton.setFocusable(false);
        _verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _admin.adminLogIn(_adminUser.getText(), String.valueOf(_adminPassword.getPassword()));
                if(_admin.is_admin() != true) {
                    JOptionPane.showMessageDialog(null, "Creditentials Incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
                    _adminPassword.setText("");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Log in successful!", "Welcome Back", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }
        });

        _backButton.setText("Close Operation");
        _backButton.setBounds(450, 550, 400, 50);
        _backButton.setFocusable(false);
        _backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //frame settings
        this.setTitle("Admin Log-In Page");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1280,720);
        this.setVisible(true);

        //frame content
        this.add(_adminUser);
        this.add(_adminPassword);
        this.add(_verifyButton);
        this.add(_backButton);
    }
}
