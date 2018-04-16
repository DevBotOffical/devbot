package commands.ownercommands;

import net.dv8tion.jda.core.entities.User;
import utils.DATA;

public class Owners {
    public static Boolean get(User user) {
        boolean yes=false;
        if (user.getId().equals(DATA.TheDev)) {
            yes=true;
        }
        return yes;
    }
}