package app.classes;

import app.interfaces.IRestaurant;

import java.util.Arrays;
import java.util.Locale;
import java.util.Vector;

public class Restaurant implements IRestaurant
{
    //this class is used for the restaurant details like name, item stock

    //members

    private Object _food[] = new Object[_limit]; //ar fi o idee buna sa fie static
    private boolean _isLoaded = false; //ar fi o idee buna sa fie static
    private int _validFood = 0;//ar fi o idee buna sa fie static

    private static Restaurant _instance = null;

    //constructors
    private Restaurant() {}

    // GET/SET FOOD ON INDEX
    public Object get_food(int i)
    {
        return _food[i];
    }

    public void set_foodVegan(int i, String _name, int _price, int _weight, int _calories,
                              String _vegetable1, String _vegetable2,
                              String _fruit1, String _fruit2, boolean _tomatoSauce)
    {
        _food[i] = new FoodVegan(i, _name, _price, _weight, _calories, _vegetable1, _vegetable2, _fruit1, _fruit2, _tomatoSauce);
    }

    public void set_foodMeat(int i, String _name, int _price, int _weight, int _calories,
                             String _vegetable1, String _vegetable2,
                             String _cheese, String _meat, boolean _ketchup, boolean _mayo)
    {
        _food[i] = new FoodMeat(i, _name, _price, _weight, _calories, _vegetable1, _vegetable2, _cheese, _meat, _ketchup, _mayo);
    }

    public Object[] get_foodVector()
    {
        return _food;
    }

    //methods
    public static Restaurant getInstance()
    {
        if(_instance == null)
            _instance = new Restaurant();
        return _instance;
    }

    public boolean is_isLoaded()
    {
        return _isLoaded;
    }

    public int get_validFood()
    {
        return _validFood;
    }

    public int getLatestFood()
    {
        _validFood = 0;
        while(_food[_validFood] != null)
            ++_validFood;
        return _validFood;
    }

    public void loadFood()
    {
        if(_isLoaded == false)
        {
            _isLoaded = true;
            _validFood = getLatestFood();

            _food[_validFood] = new FoodMeat(_validFood, "Burger", 5, 100, 300,
                                "Tomato", "Pickle",
                                "Cheddar", "Beef", true, true);
            ++_validFood;

            _food[_validFood] = new FoodVegan(_validFood, "Vegan Burger", 8, 100, 200,
                                    "Tomato", "Pickle",
                                    null, null, true);
            ++_validFood;

            _food[_validFood] = new FoodVegan(_validFood, "Caesar Salad", 3, 50, 50,
                                    "Tomato", "Cucumber",
                                    "Pineapple", null, true);
            ++_validFood;

            _food[_validFood] = new FoodMeat(_validFood, "Pizza Quattro Formaggi", 20, 1000, 5000,
                                    null, null,
                                    "Gorgonzola", null, false, false);
            ++_validFood;

            _food[_validFood] = new FoodMeat(_validFood, "Spaghetti Carbonara", 15, 300, 500,
                                    null, null,
                                    "Gorgonzola", null, false, false);
            ++_validFood;

            _food[_validFood] = new FoodMeat(_validFood, "Impossible Wrapper", 10, 200, 600,
                                    "Tomato", "Salad",
                                    "Gorgonzola", "Chicken", true, true);
            ++_validFood;

            _food[_validFood] = new FoodVegan(_validFood, "Vegan Chili", 5, 100, 300,
                                    "Chili", "Tomato",
                                    null, null, true);
            ++_validFood;
        }
    }

    public int removeFood(int i)
    {
        for(int j = i; j < getLatestFood(); ++j)
        {
            _food[j] = _food[j + 1];
            if(_food[j] != null)
            {
                if(_food[j] instanceof Food)
                {
                    if(_food[j] instanceof FoodMeat)
                    {
                        FoodMeat tmp = (FoodMeat)_food[j];
                        tmp.set_id(tmp.get_id());
                        _food[j] = tmp;
                    }

                    else if(_food[j] instanceof FoodVegan)
                    {
                        FoodVegan tmp = (FoodVegan)_food[j];
                        tmp.set_id(tmp.get_id());
                        _food[j] = tmp;
                    }

                    Food tmp = (Food)_food[j];
                    tmp.set_id(tmp.get_id() - 1);
                    _food[j] = tmp;
                }

                else
                {
                    System.out.println("Object Error");
                    return -1;
                }
            }
        }

        return 0;
    }
}
