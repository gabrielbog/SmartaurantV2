package app.interfaces;

public interface IAdminUser
{
    //variables
    public static final String _user = "John Doe";
    public static final String _pass = "thisisaverysecurepassword";

    //methods
    public abstract void adminLogIn(String _user, String _pass);
}