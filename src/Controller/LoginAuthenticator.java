package Controller;

import Model.ManageDataObj.UserManager;

/**
 * Created by Gurris on 2016-10-03.
 */
public class LoginAuthenticator {

    private String Username;
    private String Password;

    public LoginAuthenticator(String Username, String Password){
        this.Username = Username;
        this.Password = Password;
    }

    public boolean isAuthentic(){
        UserManager um = new UserManager();
        if(um.AuthenticateUser(Username, Password)){
            return true;
        }
        return false;
    }
}
