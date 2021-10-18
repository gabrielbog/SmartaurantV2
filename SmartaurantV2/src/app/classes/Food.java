package app.classes;

import java.util.Objects;

public class Food
{
    //this class is used for storing useful information about the restaurant's food

    //members
    private int _id = 0;
    private String _name = null;
    private int _price = 0;
    private int _weight = 0;
    private int _calories = 0;

    private String _vegetable1 = null;
    private String _vegetable2 = null;

    //constructors
    public Food(int _id, String _name, int _price, int _weight, int _calories,
                String _vegetable1, String _vegetable2)
    {
        //negative values will always be converted to positive ones

        this._id = _id;

        this._name = _name;

        if(_price < 0)
            _price = _price * -1;
        this._price = _price;

        if(_weight < 0)
            _weight = _weight * -1;
        this._weight = _weight;

        if(_calories < 0)
            _calories = _calories * -1;
        this._calories = _calories;

        this._vegetable1 = _vegetable1;
        this._vegetable2 = _vegetable2;
    }

    //get, set, toString methods
    public int get_id()
    {
        return _id;
    }

    public void set_id(int _id)
    {
        this._id = _id;
    }

    public String get_name()
    {
        return _name;
    }

    public void set_name(String _name)
    {
        this._name = _name;
    }

    public int get_price()
    {
        return _price;
    }

    public void set_price(int _price)
    {
        if(_price < 0)
            _price = _price * -1;
        this._price = _price;
    }

    public int get_weight()
    {
        return _weight;
    }

    public void set_weight(int _weight)
    {
        if(_weight < 0)
            _weight = _weight * -1;
        this._weight = _weight;
    }

    public int get_calories()
    {
        return _calories;
    }

    public void set_calories(int _calories)
    {
        if(_calories < 0)
            _calories = _calories * -1;
        this._calories = _calories;
    }

    public String get_vegetable1()
    {
        return _vegetable1;
    }

    public void set_vegetable1(String _vegetable1)
    {
        this._vegetable1 = _vegetable1;
    }

    public String get_vegetable2()
    {
        return _vegetable2;
    }

    public void set_vegetable2(String _vegetable2)
    {
        this._vegetable2 = _vegetable2;
    }

    @Override
    public String toString()
    {
        return "ID: =" + _id +
                ", Name ='" + _name +
                ", Price ='" + _price +
                "$" +
                ", Weight =" + _weight +
                "g" +
                ", Calories =" + _calories +
                "cal" +
                ", Vegetable = " + _vegetable1 +
                ", Vegetable = " + _vegetable2;
    }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Food)
        {
            Food _tmp = (Food)o;
            if(_tmp._id != _id || !_tmp._name.equals(_name) || _tmp._price != _price || _tmp._weight != _weight
                || _tmp._calories != _calories || !_tmp._vegetable1.equals(_vegetable1) || !_tmp._vegetable2.equals(_vegetable2))
                return false;
            return true;
        }
        return false;
    }
}
