package helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import data.User;

public class CheckUserPrivilege {

    public static boolean CheckPrivilege(HttpServletRequest request,
        int requiredPrivilege) {
        
        try {
            User user = (User) request.getSession().getAttribute("user");

            if (user != null && user.getPrivilege() <= requiredPrivilege) {
                return true;
            }

        } catch (Exception exc) {
            // nix
        }

        return false;
    }
}
