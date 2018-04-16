package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import static java.awt.Color.blue;
import static java.awt.Color.yellow;

public class cmdHelp implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(new EmbedBuilder().setTitle(null).setDescription(
                " \n \n __**Commandliste:**__ \n \n ``>help`` Zeigt das Hilfemenü an. \n \n __**Moderation**__\n \n ``>ban`` Bant den angegebenen Spieler. \n ``>kick`` Kickt den angegebenen Spieler. \n \n** Luca arbeitet gerade an neuen Commads. Wer Ideen für einen Command hat meldet ihm die per PN.**")
                .setColor(yellow).build())
                .queue();

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {
        System.out.println("[INFO] Command >help wurde ausgeführt.");
    }

    @Override
    public String help() {
        return null;
    }
}
