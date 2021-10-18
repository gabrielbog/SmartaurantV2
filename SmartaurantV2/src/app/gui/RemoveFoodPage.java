package app.gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.classes.Restaurant;
import app.classes.FoodVegan;
import app.classes.FoodMeat;

public class RemoveFoodPage extends JFrame
{
    //components
    private JList _list;
    private JScrollPane _listScroll;

    private JButton _backButton = new JButton();
    private JButton _removeButton = new JButton();

    //class instances
    private Restaurant _restaurant = Restaurant.getInstance();

    //variables
    private int _index = -1;

    public RemoveFoodPage()
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
                    _index = _list.getSelectedIndex();
            }
        });

        //hand the initial list over to a new list but with scrolling capabilities
        _listScroll = new JScrollPane(_list);
        _listScroll.setBounds(20, 20, 1200, 130);

        //buttons
        _backButton.setText("Go Back");
        _backButton.setBounds(800, 600, 200, 50);
        _backButton.setFocusable(false);
        _backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        _removeButton.setText("Remove Item");
        _removeButton.setBounds(1020, 600, 200, 50);
        _removeButton.setFocusable(false);
        _removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(_index != -1) {
                    JOptionPane.showMessageDialog(null, "Food successfully removed.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    _restaurant.removeFood(_index);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please select a valid item.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //frame settings
        this.setTitle("Remove Food Page Page");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1280,720);
        this.setVisible(true);

        //frame content
        this.add(_listScroll);
        this.add(_backButton);
        this.add(_removeButton);
    }
}