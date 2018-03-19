package helper;

import javax.servlet.http.HttpServletRequest;
import data.User;

/*
 *  @author Christian Lindenberg, 235372
 */
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
