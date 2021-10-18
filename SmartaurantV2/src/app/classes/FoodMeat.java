package app.classes;

public class FoodMeat extends Food
{
    //extension of Food class in case it's NOT vegan

    //members
    private String _cheese = null;
    private String _filling = null;
    private boolean _ketchup = false;
    private boolean _mayo = false;

    //constructors
    public FoodMeat(int _id, String _name, int _price, int _weight, int _calories,
                    String _vegetable1, String _vegetable2,
                    String _cheese, String _meat, boolean _ketchup, boolean _mayo)
    {
        //overwrite Food object
        super(_id, _name, _price, _weight, _calories, _vegetable1, _vegetable2);

        this._cheese = _cheese;
        this._filling = _meat;
        this._ketchup = _ketchup;
        this._mayo = _mayo;
    }

    //get, set, equals, toString
    public String get_cheese()
    {
        return _cheese;
    }

    public void set_cheese(String _cheese)
    {
        this._cheese = _cheese;
    }

    public String get_filling()
    {
        return _filling;
    }

    public void set_filling(String _filling)
    {
        this._filling = _filling;
    }

    public boolean is_ketchup()
    {
        return _ketchup;
    }

    public void set_ketchup(boolean _ketchup)
    {
        this._ketchup = _ketchup;
    }

    public boolean is_mayo()
    {
        return _mayo;
    }

    public void set_mayo(boolean _mayo)
    {
        this._mayo = _mayo;
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
                ", Cheese = " + _cheese +
                ", Filling = " + _filling +
                ", Ketchup = " + _ketchup +
                ", Mayo = " + _mayo +
                ", Not Vegan";
    }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof FoodMeat)
        {
            FoodMeat _tmp = (FoodMeat)o;
            if(_tmp.get_id() != get_id() || !_tmp.get_name().equals(get_name()) || _tmp.get_price() != get_price()
                || _tmp.get_weight() != get_weight() || _tmp.get_calories() != get_calories()
                || !_tmp.get_vegetable1().equals(get_vegetable1()) || !_tmp.get_vegetable2().equals(get_vegetable2())
                || !_tmp._cheese.equals(_cheese) || !_tmp._filling.equals(_filling) || _tmp._ketchup != _ketchup
                || _tmp._mayo != _mayo)
                return false;
            return true;
        }
        return false;
    }
}
