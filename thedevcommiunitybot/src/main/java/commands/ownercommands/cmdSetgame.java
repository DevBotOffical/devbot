package commands.ownercommands;

import commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import static java.awt.Color.orange;
import static java.awt.Color.red;

public class cmdSetgame implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        String[] split = event.getMessage().getContentRaw().split(" : ");
        if (Owners.get(event.getAuthor())) {


            event.getChannel().sendMessage(new EmbedBuilder().setTitle(null).setDescription(
                    "Das Spiel vom Bot wurde geändert. \n \n__**Spiel:**__ _Kommt demnächst..._ \n__**Geändert von:**__ " + event.getAuthor().getName())
                    .setColor(orange).build())
                    .queue();

            event.getJDA().getPresence().setGame(Game.playing(split[1]));



            System.out.println("[INFO] >setgame wurde auseführt!");
            if (split[1].equals("1")) {
                event.getJDA().getPresence().setGame(Game.playing("auf " + event.getJDA().getGuilds().size() + " Servern!" ));


            }


        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
    }

    @Override
    public String help() {
        return null;
    }
}
