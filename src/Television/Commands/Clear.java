package Television.Commands;

import java.util.List;

import Television.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split(" ");
		
		if (args[0].equalsIgnoreCase(Main.prefix + "info")) {
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage("Welcome to Multipurpose Bot by Television").queue();
			
		}
		
		
	}

}
