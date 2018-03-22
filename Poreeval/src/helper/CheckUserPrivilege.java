package helper;

import javax.servlet.http.HttpServletRequest;
import data.User;

/*
 *  @author Christian Lindenberg, 235372
 */
public class CheckUserPrivilege {
/*
 * Methode, um einen User aus der Session zu holen und dann dessen Privilegien fuer den Zugriff auf die 
 * einzelnen Seiten zu ueberpruefen
 */
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
/*
 * Methode, fuer die Ueberpruefung der Privilegien eines sich bereits in der Session befindlichen Users. 
 */
    public static boolean CheckPrivilege(User user, int requiredPrivilege) {

        try {
            if (user != null && user.getPrivilege() <= requiredPrivilege) {
                return true;
            }

        } catch (Exception exc) {
            // nix
        }

        return false;
    }
}
