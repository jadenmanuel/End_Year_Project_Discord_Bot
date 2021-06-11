package Television.Commands;

import java.util.List;

import Television.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(Main.prefix + "info")) {
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage("Welcome to Multipurpose Bot by Television").queue();
			
		}
		
		if(args[0].equalsIgnoreCase(Main.prefix + "clear")) {
			if(args.length<2) {
				EmbedBuilder typing_error = new EmbedBuilder();
				typing_error.setDescription("use !info to see how to properly use function");
				event.getChannel().sendMessage(typing_error.build()).queue();
				
				
			}
			else {
				try {
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
					event.getChannel().deleteMessages(messages).queue();
					
					EmbedBuilder already_deleted = new EmbedBuilder();
					already_deleted.setDescription("Messages deleted!");
					event.getChannel().sendMessage(already_deleted.build()).queue();
					
					
				}
				catch (IllegalArgumentException e) {
					if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
						EmbedBuilder error = new EmbedBuilder();
						error.setDescription("Many messages chosen. Only up to 100 messages allowed to be cleared. Thanks.");
						event.getChannel().sendMessage(error.build()).queue();
						
						
					}
					else {
						EmbedBuilder error = new EmbedBuilder();
						error.setDescription("These messages are too old. I clear messages that are less than 2 weeks. Try faster next time. Thanks.");
						event.getChannel().sendMessage(error.build()).queue();
						
					}
					
				}
				
				
			}
			
		}
		
		
		
		
	}

}
