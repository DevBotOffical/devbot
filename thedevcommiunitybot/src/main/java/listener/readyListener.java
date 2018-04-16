package listener;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

import static java.awt.Color.*;

public class readyListener extends ListenerAdapter {

    public void onReady(ReadyEvent event) {

        String out = "\nDer Bot startet auf diesen Servern: \n";

        for (Guild g : event.getJDA().getGuilds()) {
            out += g.getName() + " (" + g.getId() + ") \n";
        }

        System.out.println(out);

        for (Guild g : event.getJDA().getGuilds())
            if (g.getTextChannelsByName("devbot-log", true).size() > 0) {
                g.getTextChannelsByName("devbot-log", true).get(0).sendMessage(new EmbedBuilder().setTitle(null).setDescription(
                        "**Der DevBot ist online! Ihr könnt ihn wieder nutzen.** \n \n __**UPDATE**__ \n \n Neue Commands: \n \n >ban \n >kick \n \n \n:copyright: Luca ")
                        .setColor(blue).build())
                        .queue();

            }



    }

}
