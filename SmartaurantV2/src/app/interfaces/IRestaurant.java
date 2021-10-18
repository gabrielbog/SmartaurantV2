package app.interfaces;

import app.classes.Food;

public interface IRestaurant
{
    //members
    public static final String _name = "Kurger Bing";
    public static final String _manager = "Mark Phillips";
    public static final String _contact = "555-1234";
    public static final int _limit = 256;

    //methods
    public abstract int getLatestFood();
    public abstract void loadFood();
    public abstract int removeFood(int i);
}
