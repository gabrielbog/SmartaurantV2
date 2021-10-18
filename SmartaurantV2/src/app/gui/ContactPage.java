package app.gui;

import app.interfaces.IRestaurant;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactPage extends JFrame
{
    //components
    private JLabel _managerName = new JLabel();
    private JLabel _managerNumber = new JLabel();

    private JButton _backButton = new JButton();

    public ContactPage()
    {
        //label settings
        _managerName.setText("Manager Name: " + IRestaurant._manager);
        _managerName.setBounds(450, 100, 200, 50);

        _managerNumber.setText("Manager Phone: " + IRestaurant._contact);
        _managerNumber.setBounds(450, 200, 200, 50);

        //button settings
        _backButton.setText("Go Back");
        _backButton.setBounds(450, 300, 200, 50);
        _backButton.setFocusable(false);
        _backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //frame settings
        this.setTitle("Contact Page");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1280,720);
        this.setVisible(true);

        //frame content
        this.add(_managerName);
        this.add(_managerNumber);
        this.add(_backButton);
    }
}
