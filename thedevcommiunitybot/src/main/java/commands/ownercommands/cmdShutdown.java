package commands.ownercommands;

import commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

import static java.awt.Color.red;
import static java.awt.Color.yellow;

public class cmdShutdown implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(new EmbedBuilder().setTitle(null).setDescription(
                "  :arrow_double_down: Der Bot wurde heruntergefahren   :arrow_double_down:")
                .setColor(red).build())
                .queue();
        System.exit(0);
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
