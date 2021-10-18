package app.classes;

import app.interfaces.IAdminUser;

public class AdminUser implements IAdminUser
{
    //SINGLETON!!!

    //variables
    private static AdminUser _instance = null;
    private static boolean _admin = false;

    //constructors
    private AdminUser(){}

    //get, set
    public boolean is_admin()
    {
        return _admin;
    }

    public void set_admin(boolean _admin)
    {
        if(_admin == true)
            this._admin = _admin;
    }

    //methods
    public static AdminUser getInstance()
    {
        if(_instance == null)
            _instance = new AdminUser();
        return _instance;
    }

    @Override
    public void adminLogIn(String _user, String _pass)
    {
        if(_user.equals(IAdminUser._user) && _pass.equals(IAdminUser._pass))
            _admin = true;
        else
            _admin = false;
    }
}