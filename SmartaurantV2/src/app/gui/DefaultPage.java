package app.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import app.classes.AdminUser;
import app.interfaces.IRestaurant;
import app.classes.Restaurant;

public class DefaultPage extends JFrame
{
    //components
    private JButton _catalogueButton = new JButton();
    private JButton _contactButton = new JButton();
    private JButton _adminButton = new JButton();
    private JButton _removeFoodButton = new JButton();

    //class instances
    private AdminUser _admin = AdminUser.getInstance();
    private Restaurant _restaurant = Restaurant.getInstance();

    public DefaultPage()
    {
        //first and foremost
        _restaurant.loadFood();

        //button settings
        _catalogueButton.setText("Check Food Catalogue");
        _catalogueButton.setBounds(450, 100, 400, 50);
        _catalogueButton.setFocusable(false);
        _catalogueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CataloguePage();
            }
        });

        _contactButton.setText("Check Contact Details");
        _contactButton.setBounds(450, 200, 400, 50);
        _contactButton.setFocusable(false);
        _contactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactPage();
            }
        });

        _adminButton.setText("Admin Log In");
        _adminButton.setBounds(450, 300, 400, 50);
        _adminButton.setFocusable(false);
        _adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminPage _page = new AdminPage();

                //verificare daca pagina se inchide
                _page.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        becomeVisible();
                    }
                });
            }
        });

        _removeFoodButton.setText("Remove Food");
        _removeFoodButton.setBounds(450, 400, 400, 50);
        _removeFoodButton.setFocusable(false);
        _removeFoodButton.setEnabled(_admin.is_admin()); //becomes visible if you're admin
        _removeFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveFoodPage();
            }
        });

        //frame settings
        this.setTitle(IRestaurant._name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1280,720);
        this.setVisible(true);

        //frame content
        this.add(_catalogueButton);
        this.add(_contactButton);
        this.add(_adminButton);
        this.add(_removeFoodButton);
    }

    //admin-specific button visibility
    public void becomeVisible()
    {
        _removeFoodButton.setEnabled(_admin.is_admin()); //becomes visible if you're admin
        _adminButton.setEnabled(!_admin.is_admin()); //becomes invisible if you're admin
    }
}
