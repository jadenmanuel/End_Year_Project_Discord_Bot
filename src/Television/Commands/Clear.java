package Television.Commands;

import java.util.Arrays;
import java.util.List;

import Television.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		
		//The Welcomes section 
		//if (args[0].equalsIgnoreCase(Main.prefix + "info")) {
			//event.getChannel().sendTyping().queue();
			//event.getChannel().sendMessage("Welcome to Multipurpose Bot by Television.\nAvailable Commands:\n!clear - This command will clear messages that are newer than two weeks(I can only clear 2 to 100 messages). Also when adding the number make sure to add one to the original number you want to delete. That is how I delete messages. \n!anonymous - This command will send semi - anonymous messages").queue();
			
			
		//}
		
		//the clear method/ command
		if(args[0].equalsIgnoreCase(Main.prefix + "clear")) {
			//checks to see if properly used
			if(args.length<2 || args[1].equals("1")) {
				EmbedBuilder typing_error = new EmbedBuilder();
				typing_error.setDescription("use !info to see how to properly use function");
				event.getChannel().sendTyping().queue();
				event.getChannel().sendMessage(typing_error.build()).queue();
				
				
			}
			
			else {
				try {
					//messages are deleted
					final int message_counter = 1;
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1]) + message_counter).complete();

					event.getChannel().deleteMessages(messages).queue();
					
					EmbedBuilder already_deleted = new EmbedBuilder();
					
					event.getChannel().sendTyping().queue();
					already_deleted.setDescription("Messages deleted!");
					event.getChannel().sendMessage(already_deleted.build()).queue();
					
					
				}
				//error are told to user if any
				catch (IllegalArgumentException e) {
					if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
						EmbedBuilder error = new EmbedBuilder();
						error.setDescription("Many messages chosen. Only up to 100 messages allowed to be cleared. Thanks.");
						event.getChannel().sendTyping().queue();
						event.getChannel().sendMessage(error.build()).queue();
						
						
						
					}
					else {
						EmbedBuilder error = new EmbedBuilder();
						error.setDescription("These messages are too old or you have no messages to clear. I clear messages that are less than 2 weeks. Try faster next time. Thanks.");
						event.getChannel().sendMessage(error.build()).queue();
						
						
					}
					
				}
				
				
			}
			
		}
		
		//anonymous command section
		if(args[0].equalsIgnoreCase(Main.prefix + "anonymous")) {
			if(args.length<2) {
				EmbedBuilder typing_error = new EmbedBuilder();
				typing_error.setDescription("Please use !info to see how to use the bot!");
				event.getChannel().sendTyping().queue();
				event.getChannel().sendMessage(typing_error.build()).queue();
				
				
			}
			else {
				String id = event.getMessageId();
				event.getChannel().deleteMessageById(id).queue();
					
				event.getChannel().sendMessage("We are working on your message").queue();
				event.getChannel().sendTyping().queue();
				String new_message = "From Anonymous: \n";
			
				for(int i = 1; i < args.length; i++) {
					new_message = new_message+" "+args[i];
					
					
				}
				
				event.getChannel().sendMessage(new_message).queue();
			}
			}
		
		if(args[0].equalsIgnoreCase(Main.prefix + "quotes")) {
			
			String[] important_quotes = new String[]{"Success is not final; failure is not fatal: It is the courage to continue that counts.",
													 "Don't be afraid to give up the good to go for the great.", 
													 "Successful people do what unsuccessful people are not willing to do. Don't wish it were easier; wish you were better.", 
													 "Success is walking from failure to failure with no loss of enthusiasm." ,
													 "If you really look closely, most overnight successes took a long time.",
													 "The only limit to our realization of tomorrow will be our doubts of today.",
													 "Many of life's failures are people who did not realize how close they were to success when they gave up.",
													"The present is theirs; the future, for which I really worked, is mine.",
													 "I have not failed. I've just found 10,000 ways that won't work. "};
			
			int counter= (int) ((Math.random()*important_quotes.length));
			EmbedBuilder quotes = new EmbedBuilder();
			quotes.setTitle("Quote for You:");
			quotes.setDescription(important_quotes[counter]);
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(quotes.build()).queue();
			

				
			}
			
			
		
		
		
		
		
		
			
		}
		
		
		
		
		
	}
	

