package app.gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import app.classes.Restaurant;
import app.classes.FoodVegan;
import app.classes.FoodMeat;

public class CataloguePage extends JFrame
{
    //components
    private JList _list;
    private JScrollPane _listScroll;

    private JButton _backButton = new JButton();
    private JButton _clearButton = new JButton();
    private JButton _addButton = new JButton();
    private JButton _purchaseButton = new JButton();

    private JLabel _totalPrice = new JLabel();

    //class instances
    private Restaurant _restaurant = Restaurant.getInstance();

    //variables
    private int _price = -1;
    private int _priceSum = 0;

    public CataloguePage()
    {
        //list stuff
        _restaurant.loadFood();
        _list = new JList(_restaurant.get_foodVector());
        _list.setVisibleRowCount(6);
        _list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        _list.setVisible(true);

        _list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(_restaurant.get_food(_list.getSelectedIndex()) instanceof FoodMeat)
                {
                    FoodMeat tmp = (FoodMeat)_restaurant.get_food(_list.getSelectedIndex());
                    _price = tmp.get_price();
                }
                else if(_restaurant.get_food(_list.getSelectedIndex()) instanceof FoodVegan)
                {
                    FoodVegan tmp = (FoodVegan)_restaurant.get_food(_list.getSelectedIndex());
                    _price = tmp.get_price();
                }
            }
        });

        //hand the initial list over to a new list but with scrolling capabilities
        _listScroll = new JScrollPane(_list);
        _listScroll.setBounds(20, 20, 1200, 130);

        //label
        _totalPrice.setText("Total Price: " + _priceSum + "$");
        _totalPrice.setBounds(100, 600, 200, 50);

        //buttons
        _backButton.setText("Go Back");
        _backButton.setBounds(360, 600, 200, 50);
        _backButton.setFocusable(false);
        _backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        _clearButton.setText("Clear Selection");
        _clearButton.setBounds(580, 600, 200, 50);
        _clearButton.setFocusable(false);
        _clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _priceSum = 0;
                _totalPrice.setText("Total Price: " + _priceSum + "$");
            }
        });

        _addButton.setText("Add Food To Cart");
        _addButton.setBounds(800, 600, 200, 50);
        _addButton.setFocusable(false);
        _addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(_price != -1) {
                    _priceSum = _priceSum + _price;
                    _totalPrice.setText("Total Price: " + _priceSum + "$");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please select a valid item.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        _purchaseButton.setText("Confirm Purchase");
        _purchaseButton.setBounds(1020, 600, 200, 50);
        _purchaseButton.setFocusable(false);
        _purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(_priceSum != 0) {
                    JOptionPane.showMessageDialog(null, "Thank you for your purchase.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();

                    /*
                    PurchasePage _page = new PurchasePage();
                    _page.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            dispose();
                        }
                    });
                    */
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please select atleast an item.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //frame settings
        this.setTitle("Catalogue Page");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1280,720);
        this.setVisible(true);

        //frame content
        this.add(_listScroll);
        this.add(_totalPrice);
        this.add(_backButton);
        this.add(_clearButton);
        this.add(_addButton);
        this.add(_purchaseButton);
    }
}
