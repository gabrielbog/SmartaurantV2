package app.classes;

public class FoodVegan extends Food
{
    //extension of Food class in case it's vegan

    //members
    private String _fruit1 = null;
    private String _fruit2 = null;
    private boolean _tomatoSauce = false;

    //constructors
    public FoodVegan(int _id, String _name, int _price, int _weight, int _calories,
                     String _vegetable1, String _vegetable2,
                     String _fruit1, String _fruit2, boolean _tomatoSauce)
    {
        //overwrite Food object
        super(_id, _name, _price, _weight, _calories, _vegetable1, _vegetable2);

        this._fruit1 = _fruit1;
        this._fruit2 = _fruit2;
        this._tomatoSauce = _tomatoSauce;
    }

    //get, set, equals, toString methods
    public String get_fruit1()
    {
        return _fruit1;
    }

    public void set_fruit1(String _fruit1)
    {
        this._fruit1 = _fruit1;
    }

    public String get_fruit2()
    {
        return _fruit2;
    }

    public void set_fruit2(String _fruit2)
    {
        this._fruit2 = _fruit2;
    }

    public boolean is_tomatoSauce()
    {
        return _tomatoSauce;
    }

    public void set_tomatoSauce(boolean _tomatoSauce)
    {
        this._tomatoSauce = _tomatoSauce;
    }

    @Override
    public String toString()
    {
        return "ID: =" + get_id() +
                ", Name ='" + get_name() +
                ", Price ='" + get_price() +
                "$" +
                ", Weight =" + get_weight() +
                "g" +
                ", Calories =" + get_calories() +
                "cal" +
                ", Vegetable = " + get_vegetable1() +
                ", Vegetable = " + get_vegetable2() +
                ", Fruit = " + _fruit1 +
                ", Fruit = " + _fruit2 +
                ", Tomato Sauce = " + _tomatoSauce +
                ", Is Vegan";
    }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof FoodVegan)
        {
            FoodVegan _tmp = (FoodVegan)o;
            if(_tmp.get_id() != get_id() || !_tmp.get_name().equals(get_name()) || _tmp.get_price() != get_price()
                    || _tmp.get_weight() != get_weight() || _tmp.get_calories() != get_calories()
                    || !_tmp.get_vegetable1().equals(get_vegetable1()) || !_tmp.get_vegetable2().equals(get_vegetable2())
                    || !_tmp._fruit1.equals(_fruit1) || !_tmp._fruit2.equals(_fruit2)
                    || _tmp._tomatoSauce != _tomatoSauce)
                return false;
            return true;
        }
        return false;
    }
}
