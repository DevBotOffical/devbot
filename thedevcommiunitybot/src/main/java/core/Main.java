package core;


import commands.cmdGuilds;
import commands.cmdHelp;
import commands.moderation.cmdBan;
import commands.moderation.cmdKick;
import commands.ownercommands.cmdSetgame;
import commands.ownercommands.cmdShutdown;
import listener.CommandListener;
import listener.readyListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import utils.SECRETS;

import javax.security.auth.login.LoginException;

public class Main {

    static JDABuilder builder;

    public static void main(String[] Args) {

        builder = new JDABuilder(AccountType.BOT);

        builder.setAutoReconnect(true);
        builder.setToken(SECRETS.TOKEN);
        builder.setStatus(OnlineStatus.ONLINE);

        builder.addEventListener(new readyListener());
        builder.addEventListener(new CommandListener());

        addCommands();

        try {
            JDA jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void addCommands () {
        commandHandler.commands.put("help", new cmdHelp());
        commandHandler.commands.put("shutdown", new cmdShutdown());
        commandHandler.commands.put("setgame", new cmdSetgame());
        commandHandler.commands.put("ban", new cmdBan());
        commandHandler.commands.put("kick", new cmdKick());
        commandHandler.commands.put("guilds", new cmdGuilds());
    }

}
